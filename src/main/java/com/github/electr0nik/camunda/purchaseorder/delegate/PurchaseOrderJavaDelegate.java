package com.github.electr0nik.camunda.purchaseorder.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.electr0nik.camunda.purchaseorder.form.MealForm;

/**
 * Created by nik on 24.11.15.
 */
public class PurchaseOrderJavaDelegate implements JavaDelegate {

  private final static Logger LOGGER = LoggerFactory.getLogger(PurchaseOrderJavaDelegate.class);

  @Override
  public void execute(DelegateExecution execution) throws Exception {
    MealForm mealForm = (MealForm) execution.getVariable("mealForm");

    execution.getVariables().forEach((key, value) -> LOGGER.info(String.format("key: %s, value: %s", key, value)));
  }
}
