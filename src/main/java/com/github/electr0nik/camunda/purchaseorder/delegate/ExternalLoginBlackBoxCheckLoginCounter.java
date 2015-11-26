package com.github.electr0nik.camunda.purchaseorder.delegate;

import com.github.electr0nik.camunda.purchaseorder.service.PropertyLoader;
import com.github.electr0nik.camunda.purchaseorder.service.impl.PropertyLoaderImpl;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by nik on 26.11.15.
 */
public class ExternalLoginBlackBoxCheckLoginCounter implements JavaDelegate {

  private final Logger LOGGER = LoggerFactory.getLogger(IngredientPriceEnricher.class);

  private final String DEFAULT_PROPERTY_SOURCE = "db/smoke/mock_usercredentials.properties";
  private final String DEFAULT_PROPERTY_CREDENTIALS_PREFIX = "user.credentials.";

  // @Inject // @Autowired
  private final PropertyLoader propertyLoader = new PropertyLoaderImpl();

  @Override
  public void execute(DelegateExecution execution) throws Exception {
    LOGGER.info("Begin Login!");

    execution.getVariables().forEach((key, value) -> LOGGER.info("key: " + key + "\t value: " + value));
    final Long loginCounter = execution.getVariable("loginCounter") != null ? (long) execution.getVariable("loginCounter") : 1;

    execution.setVariable("isLoginSuccess", false);
    execution.setVariable("loginCounter", loginCounter + 1);

    LOGGER.info("end Login!");
  }

}
