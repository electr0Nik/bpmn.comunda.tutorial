package com.github.electr0nik.camunda.purchaseorder.service;

import java.util.Properties;

/**
 * Created by nik on 25.11.15.
 */
public interface PropertyLoader {
  Properties getPopulatedProperties(final String propertySource);
}
