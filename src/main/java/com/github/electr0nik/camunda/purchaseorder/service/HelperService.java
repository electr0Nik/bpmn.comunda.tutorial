package com.github.electr0nik.camunda.purchaseorder.service;

import com.github.electr0nik.camunda.purchaseorder.delegate.model.Ingredient;

import java.util.List;
import java.util.Properties;

/**
 * Created by nik on 26.11.15.
 */
public interface HelperService {
  List<Ingredient> populateMealIngredients(final Properties properties, final String mealName);
}
