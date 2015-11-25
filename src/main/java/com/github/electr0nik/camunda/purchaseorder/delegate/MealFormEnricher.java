package com.github.electr0nik.camunda.purchaseorder.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.electr0nik.camunda.purchaseorder.form.MealForm;

/**
 * Created by nik on 24.11.15.
 */
public class MealFormEnricher implements JavaDelegate {

  private final static Logger LOGGER = LoggerFactory.getLogger(MealFormEnricher.class);

  @Override
  public void execute(DelegateExecution execution) throws Exception {
    LOGGER.info("Begin enrichment!");
    MealForm mealForm = (MealForm) execution.getVariable("mealForm");
    mealForm.getMealList().forEach(it -> {
      LOGGER.info("name: " + it.getName());
    });
    LOGGER.info("end enrichment!");
  }
}