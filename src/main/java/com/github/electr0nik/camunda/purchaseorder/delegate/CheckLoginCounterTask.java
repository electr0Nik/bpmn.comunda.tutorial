package com.github.electr0nik.camunda.purchaseorder.delegate;

import com.github.electr0nik.camunda.purchaseorder.service.PropertyLoader;
import com.github.electr0nik.camunda.purchaseorder.service.impl.PropertyLoaderImpl;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CheckLoginCounterTask implements JavaDelegate {

  private final Logger LOGGER = LoggerFactory.getLogger(IngredientPriceEnricher.class);

  private final String DEFAULT_PROPERTY_SOURCE = "db/smoke/mock_usercredentials.properties";
  private final String DEFAULT_PROPERTY_CREDENTIALS_PREFIX = "user.credentials.";

  // @Inject // @Autowired
  private final PropertyLoader propertyLoader = new PropertyLoaderImpl();

  @Override
  public void execute(DelegateExecution execution) throws Exception {
    LOGGER.info("Begin ExternalLoginBlackBoxCheckLoginCounter!");

    final Long loginCounter = execution.getVariable("loginCounter") != null ? (long) execution.getVariable("loginCounter") : 2;
    LOGGER.info("counter: " + loginCounter);

    execution.setVariable("isLoginSuccess", false);
    execution.setVariable("loginCounter", loginCounter);

    LOGGER.info("end ExternalLoginBlackBoxCheckLoginCounter!");
  }

}
