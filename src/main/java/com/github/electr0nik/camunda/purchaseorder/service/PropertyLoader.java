package com.github.electr0nik.camunda.purchaseorder.service;

import java.util.Properties;

public interface PropertyLoader {
  Properties getPopulatedProperties(final String propertySource);
}
