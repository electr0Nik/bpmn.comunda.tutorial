package com.github.electr0nik.camunda.purchaseorder.delegate;

import com.github.electr0nik.camunda.purchaseorder.delegate.form.MealForm;
import com.github.electr0nik.camunda.purchaseorder.service.PropertyLoader;
import com.github.electr0nik.camunda.purchaseorder.service.impl.PropertyLoaderImpl;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IngredientPriceEnricher implements JavaDelegate {

  private final Logger LOGGER = LoggerFactory.getLogger(IngredientPriceEnricher.class);

  private final String DEFAULT_PROPERTY_NAME_PREFIX = "default.price.";
  private final String DEFAULT_PROPERTY_SOURCE = "mock_ingredientsPrice.properties";
  private final String DEFAULT_VALUE = "599";
  private final Long DEFAULT_EXTRA_CHARGE = 5L;

  // @Inject // @Autowired
  private final PropertyLoader propertyLoader = new PropertyLoaderImpl();

  @Override
  public void execute(DelegateExecution execution) throws Exception {
    LOGGER.info("Begin IngredientPriceEnricher enrichment!");

    MealForm mealForm = (MealForm) execution.getVariable("mealForm");

    final long[] fullPrice = {0};
    mealForm.getMealList().forEach(
        meal -> meal.getIngredientList().forEach(
            it -> {
              final Long tmpValue = Long.valueOf(this.propertyLoader.getPopulatedProperties(DEFAULT_PROPERTY_SOURCE).getProperty(
                  DEFAULT_PROPERTY_NAME_PREFIX + it.getName(), DEFAULT_VALUE));
              Long tmpAmount;
              try {
                tmpAmount = Long.parseLong(it.getAmount());
              } catch (NumberFormatException nfe) {
                LOGGER.warn(nfe.getMessage(), nfe);
                tmpAmount = 1L;
              }
              it.setPriceInCent(tmpAmount * tmpValue + (((tmpAmount * tmpValue) * DEFAULT_EXTRA_CHARGE) / 100));
              fullPrice[0] += it.getPriceInCent();
            }));

    execution.setVariable("fullPrice", fullPrice[0]);

    LOGGER.info("end enrichment!");
  }

}