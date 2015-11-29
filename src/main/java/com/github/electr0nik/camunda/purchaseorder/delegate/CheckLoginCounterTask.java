package com.github.electr0nik.camunda.purchaseorder.delegate;

import com.github.electr0nik.camunda.purchaseorder.delegate.model.SimpleUser;
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

    SimpleUser user = (SimpleUser) execution.getVariable("simpleUser");
    LOGGER.info("counter: " + user.getLoginAttemps());

    final String expectedUsername = this.propertyLoader.getPopulatedProperties(DEFAULT_PROPERTY_SOURCE).getProperty(DEFAULT_PROPERTY_CREDENTIALS_PREFIX + "username");
    final String password = this.propertyLoader.getPopulatedProperties(DEFAULT_PROPERTY_SOURCE).getProperty(DEFAULT_PROPERTY_CREDENTIALS_PREFIX + "password");

    final Boolean isLoginSuccess;
    final Long loginFailCounter;
    if (user.getUserName().equals(expectedUsername) && user.getPassword().equals(password)) {
      isLoginSuccess = true;
      loginFailCounter = 0L;
    } else {
      isLoginSuccess = false;
      loginFailCounter = user.getLoginAttemps() + 1;
    }
    user.setLoginAttemps(loginFailCounter);

    execution.setVariable("isLoginSuccess", isLoginSuccess);
    execution.setVariable("loginCounter", user.getLoginAttemps());

    LOGGER.info("end ExternalLoginBlackBoxCheckLoginCounter!");
  }

}
