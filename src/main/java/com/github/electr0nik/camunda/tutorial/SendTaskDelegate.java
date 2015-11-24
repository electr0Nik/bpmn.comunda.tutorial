package com.github.electr0nik.camunda.tutorial;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.util.logging.Logger;

public class SendTaskDelegate implements JavaDelegate {

	private final static Logger LOGGER = Logger.getLogger("Einkauf-Service");

	public void execute(DelegateExecution execution) throws Exception {
		execution.getVariables().forEach(
				(key, value) -> LOGGER.info(String.format("awesome shit: \nkey: %s, value: %s", key, value)));
	}

}
