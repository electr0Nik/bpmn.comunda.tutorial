package com.github.electr0nik.camunda.purchaseorder.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TaskFinished implements JavaDelegate {

  private final Logger LOGGER = LoggerFactory.getLogger(TaskFinished.class);

  @Override
  public void execute(DelegateExecution execution) throws Exception {
    LOGGER.info("Begin TaskFinished!");

    LOGGER.info("Task Finished!\n vars used: " + execution.getVariableNames());
    execution.getVariables().forEach((key, value) -> LOGGER.info("key: " + key + "\t value: " + value));

    LOGGER.info("End TaskFinished!");
  }

}
