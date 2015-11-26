package com.github.electr0nik.camunda.purchaseorder.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by nik on 27.11.15.
 */
public class MessageEmployee implements JavaDelegate {

  private final Logger LOGGER = LoggerFactory.getLogger(MessageEmployee.class);

  @Override
  public void execute(DelegateExecution execution) throws Exception {
    LOGGER.info("Begin MessageEmployee!");

    LOGGER.info("Send message by Jabber oder Email to employee and force him to buy this stuff!!!!!!");

    LOGGER.info("End MessageEmployee!");
  }
}
