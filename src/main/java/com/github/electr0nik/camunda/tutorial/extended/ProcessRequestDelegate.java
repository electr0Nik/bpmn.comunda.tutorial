package com.github.electr0nik.camunda.tutorial.extended;

import java.util.logging.Logger;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class ProcessRequestDelegate implements JavaDelegate {
  private final static Logger LOGGER = Logger.getLogger("LOAN-REQUESTS");

  public void execute(DelegateExecution execution) throws Exception {
    execution.getVariables().forEach((key, value) -> {
      LOGGER.info("Processing request by key: '" + key + "' and value: " + value);
    });
  }

}