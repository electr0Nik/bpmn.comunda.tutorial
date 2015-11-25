package com.github.electr0nik.camunda.purchaseorder.delegate;

import com.github.electr0nik.camunda.purchaseorder.model.Meal;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by nik on 24.11.15.
 */
public class MealObjectEnricher implements JavaDelegate {

  private final static Logger LOGGER = LoggerFactory.getLogger(MealObjectEnricher.class);
  private final static Properties properties = new Properties();

  private final static String DEFAULT_PROPERTY_NAME_PREFIX = "default.price.";
  private final static String DEFAULT_PROPERTY_SOURCE = "Web-INF/mock_ingredientsPrice.properties";
  private final static String DEFAULT_VALUE = "599";
  private final static Long DEFAULT_EXTRA_CHARGE = 5L;

  @Override
  public void execute(DelegateExecution execution) throws Exception {
    LOGGER.info("Begin enrichment!");

    this.populatedProperties(DEFAULT_PROPERTY_SOURCE);

    Meal mealForm = (Meal) execution.getVariable("meal");
    mealForm.getIngredientList().forEach(it -> {
      final Long tmpValue = Long.valueOf(properties.getProperty(DEFAULT_PROPERTY_NAME_PREFIX + it.getName(), DEFAULT_VALUE));
      Long tmpAmount;
      try {
        tmpAmount = Long.parseLong(it.getAmount());
      } catch (NumberFormatException nfe) {
        LOGGER.error(nfe.getMessage(), nfe);
        tmpAmount = 1L;
      }
      it.setPriceInCent(tmpAmount * tmpValue + (((tmpAmount * tmpValue) * DEFAULT_EXTRA_CHARGE) / 100));
    });

    LOGGER.info("end enrichment!");
  }

  private void populatedProperties(final String propertySource) {
    LOGGER.info("Begin populatedProperties!");
    // get resource from classpath.. we need this in web-environment
    final InputStream input = this.getClass().getClassLoader().getResourceAsStream(propertySource);
    // load a properties file
    try {
      properties.load(input);
    } catch (IOException e) {
      LOGGER.error(e.getMessage(), e);
    }
    properties.stringPropertyNames().forEach(propName -> {
      LOGGER.info(String.format("set properties: \nkey: %s \tvalue: %s ", propName, properties.getProperty(propName)));
    });
  }
}