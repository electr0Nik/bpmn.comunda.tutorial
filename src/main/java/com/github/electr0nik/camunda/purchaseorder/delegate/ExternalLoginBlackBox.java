package com.github.electr0nik.camunda.purchaseorder.delegate;

import com.github.electr0nik.camunda.purchaseorder.service.PropertyLoader;
import com.github.electr0nik.camunda.purchaseorder.service.impl.PropertyLoaderImpl;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExternalLoginBlackBox implements JavaDelegate {

  private final Logger LOGGER = LoggerFactory.getLogger(IngredientPriceEnricher.class);

  private final String DEFAULT_PROPERTY_SOURCE = "db/smoke/mock_usercredentials.properties";
  private final String DEFAULT_PROPERTY_CREDENTIALS_PREFIX = "user.credentials.";

  // @Inject // @Autowired
  private final PropertyLoader propertyLoader = new PropertyLoaderImpl();

  @Override
  public void execute(DelegateExecution execution) throws Exception {
    LOGGER.info("Begin ExternalLoginBlackBox!");
    final String expectedUsername = this.propertyLoader.getPopulatedProperties(DEFAULT_PROPERTY_SOURCE).getProperty(DEFAULT_PROPERTY_CREDENTIALS_PREFIX + "username");
    final String password = this.propertyLoader.getPopulatedProperties(DEFAULT_PROPERTY_SOURCE).getProperty(DEFAULT_PROPERTY_CREDENTIALS_PREFIX + "password");

    execution.getVariables().forEach((key, value) -> LOGGER.info("ExternalLoginBlackBox\nkey: " + key + "\t value: " + value));
    final Long loginCounter = execution.getVariable("loginCounter") != null ? (long) execution.getVariable("loginCounter") : 0;

    execution.setVariable("isLoginSuccess", false);
    execution.setVariable("loginCounter", loginCounter + 1);

    LOGGER.info("end ExternalLoginBlackBox!");
  }

}
