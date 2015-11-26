package com.github.electr0nik.camunda.purchaseorder.service.impl;

import com.github.electr0nik.camunda.purchaseorder.delegate.model.Ingredient;
import com.github.electr0nik.camunda.purchaseorder.service.HelperService;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by nik on 26.11.15.
 */
public class HelperServiceImpl implements HelperService {
  private final String DEFAULT_PROPERTY_MEAL_OBJECT_PREFIX = "object.Meal.";

  /**
   * highly speculative!
   * wouldn't use this in production!
   *
   * @param properties
   * @param mealName
   * @return
   */
  @Override
  public List<Ingredient> populateMealIngredients(final Properties properties, final String mealName) {
    final List<Ingredient> ingredientList = new ArrayList<>();
    final Ingredient[] ingredient = {null};
    properties.stringPropertyNames().stream()
        .filter(prop -> prop.startsWith(DEFAULT_PROPERTY_MEAL_OBJECT_PREFIX + mealName + ".Ingredient."))
        .sorted(String::compareToIgnoreCase)
        .forEach(it -> {
          // since we 'sorted' the list, amount should come first
          if (it.contains("amount")) {
            ingredient[0] = new Ingredient();
            ingredient[0].setAmount(properties.getProperty(it));
          }
          // we expect ingredient is not null!
          if (it.contains("name")) {
            ingredient[0].setName(properties.getProperty(it));
            ingredientList.add(ingredient[0]);
          }
        });
    return ingredientList;
  }
}
