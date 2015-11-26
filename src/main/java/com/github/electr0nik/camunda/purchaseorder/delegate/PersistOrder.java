package com.github.electr0nik.camunda.purchaseorder.delegate;

import com.github.electr0nik.camunda.purchaseorder.delegate.form.MealForm;
import com.github.electr0nik.camunda.purchaseorder.delegate.model.SimpleUser;
import com.github.electr0nik.camunda.purchaseorder.service.HelperService;
import com.github.electr0nik.camunda.purchaseorder.service.impl.HelperServiceImpl;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by nik on 27.11.15.
 */
public class PersistOrder implements JavaDelegate {

  private final Logger LOGGER = LoggerFactory.getLogger(PersistOrder.class);


  private final HelperService helperService = new HelperServiceImpl();

  @Override
  public void execute(DelegateExecution execution) throws Exception {
    LOGGER.info("Begin PersistOrder!");

    final MealForm mealForm = (MealForm) execution.getVariable("mealForm");
    final SimpleUser user = (SimpleUser) execution.getVariable("simpleUser");

    LOGGER.info("Since we have no Database, we could write order to filesystem!");

    this.helperService.persistOrder(mealForm, user);

    LOGGER.info("End PersistOrder!");
  }
}
