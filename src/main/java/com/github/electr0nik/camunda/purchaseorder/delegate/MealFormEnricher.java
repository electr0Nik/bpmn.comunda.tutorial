package com.github.electr0nik.camunda.purchaseorder.delegate;

import com.github.electr0nik.camunda.purchaseorder.delegate.form.MealForm;
import com.github.electr0nik.camunda.purchaseorder.service.HelperService;
import com.github.electr0nik.camunda.purchaseorder.service.PropertyLoader;
import com.github.electr0nik.camunda.purchaseorder.service.impl.HelperServiceImpl;
import com.github.electr0nik.camunda.purchaseorder.service.impl.PropertyLoaderImpl;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MealFormEnricher implements JavaDelegate {

  private final Logger LOGGER = LoggerFactory.getLogger(MealFormEnricher.class);

  private final String DEFAULT_PROPERTY_SOURCE = "db/smoke/mock_mealIngredient.properties";

  // @Inject // @Autowired
  private final PropertyLoader propertyLoader = new PropertyLoaderImpl();
  private final HelperService helperService = new HelperServiceImpl();


  @Override
  public void execute(DelegateExecution execution) throws Exception {
    LOGGER.info("Begin MealFormEnricher!");
    MealForm mealForm = (MealForm) execution.getVariable("mealForm");
    
    LOGGER.info("Begin ingredient list population!");
    mealForm.getMealList().forEach(meal ->
        meal.setIngredientList(this.helperService.populateMealIngredients(this.propertyLoader.getPopulatedProperties(DEFAULT_PROPERTY_SOURCE), meal.getName())));
    LOGGER.info("End MealFormEnricher!");
  }
}