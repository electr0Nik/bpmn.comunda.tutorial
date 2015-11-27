package com.github.electr0nik.camunda.purchaseorder.delegate;

import com.github.electr0nik.camunda.purchaseorder.delegate.model.SimpleUser;
import com.github.electr0nik.camunda.purchaseorder.service.HelperService;
import com.github.electr0nik.camunda.purchaseorder.service.impl.HelperServiceImpl;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleUserEnricher implements JavaDelegate {

  private final Logger LOGGER = LoggerFactory.getLogger(SimpleUserEnricher.class);

  private final HelperService helperService = new HelperServiceImpl();

  @Override
  public void execute(DelegateExecution execution) throws Exception {
    LOGGER.info("Begin SimpleUserEnricher!");

    SimpleUser user = (SimpleUser) execution.getVariable("simpleUser");
    // update user
    execution.setVariable("simpleUser", this.helperService.getPopulatedSimpleSimpleUser(user.getUserName(), user.getPassword()));

    LOGGER.info("End SimpleUserEnricher!");
  }
}
