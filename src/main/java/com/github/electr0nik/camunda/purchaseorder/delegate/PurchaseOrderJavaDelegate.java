package com.github.electr0nik.camunda.purchaseorder.delegate;

import com.github.electr0nik.camunda.purchaseorder.model.Meal;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.util.logging.Logger;

/**
 * Created by nik on 24.11.15.
 */
public class PurchaseOrderJavaDelegate implements JavaDelegate {

  private final static Logger LOGGER = Logger.getLogger(PurchaseOrderJavaDelegate.class.getName());

  @Override
  public void execute(DelegateExecution execution) throws Exception {
    Meal mealForm = (Meal) execution.getVariable("meal");

    execution.getVariables().forEach((key, value) -> LOGGER.info(String.format("key: %s, value: %s", key, value)));
  }
}
