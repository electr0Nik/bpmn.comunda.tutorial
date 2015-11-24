package com.github.electr0nik.camunda.purchaseorder.delegate;

import com.github.electr0nik.camunda.purchaseorder.form.MealForm;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

/**
 * Created by nik on 24.11.15.
 */
public class PurchaseOrderJavaDelegate implements JavaDelegate {


  @Override
  public void execute(DelegateExecution execution) throws Exception {
    MealForm mealForm = (MealForm) execution.getVariable("mealForm");
  }
}
