package com.github.electr0nik.camunda.purchaseorder.delegate;

import com.github.electr0nik.camunda.purchaseorder.model.Meal;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by nik on 24.11.15.
 */
public class MealObjectEnricher implements JavaDelegate {

  private final static Logger LOGGER = Logger.getLogger(MealObjectEnricher.class.getName());
  private final static Properties properties = new Properties();

  private final static String DEFAULT_PROPERTY_NAME_PREFIX = "default.price.";
  private final static String DEFAULT_PROPERTY_SOURCE = "mock_ingredientsPrice.properties";
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
        LOGGER.log(Level.SEVERE, "an exception was thrown", nfe);
        tmpAmount = 1L;
      }
      it.setPriceInCent(tmpAmount * tmpValue + (((tmpAmount * tmpValue) * DEFAULT_EXTRA_CHARGE) / 100));
    });

    LOGGER.info("end enrichment!");
  }

  private void populatedProperties(final String propertySource) throws IOException {
    final InputStream input = new FileInputStream(propertySource);
    // load a properties file
    properties.load(input);
    properties.stringPropertyNames().forEach(propName -> {
      LOGGER.info(String.format("set properties: \nkey: %s \tvalue: %s ", propName, properties.getProperty(propName)));
    });
  }
}