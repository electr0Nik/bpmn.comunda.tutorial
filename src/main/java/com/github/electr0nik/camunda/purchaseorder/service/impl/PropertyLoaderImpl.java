package com.github.electr0nik.camunda.purchaseorder.service.impl;

import com.github.electr0nik.camunda.purchaseorder.service.PropertyLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

// @Service
public class PropertyLoaderImpl implements PropertyLoader {

  private final static Logger LOGGER = LoggerFactory.getLogger(PropertyLoaderImpl.class);

  private final Properties properties;

  // @Inject//Autowired
  public PropertyLoaderImpl(/* final Properties properties */) {
    this.properties = new Properties();
  }

  @Override
  public Properties getPopulatedProperties(final String propertySource) {
    // get resource from classpath... we need this in web-environment
    final InputStream input = this.getClass().getClassLoader().getResourceAsStream(propertySource);
    // load a properties file
    try {
      properties.load(input);
    } catch (IOException e) {
      LOGGER.error("catch: " + e.getMessage(), e);
    }
    return properties;
  }

}
