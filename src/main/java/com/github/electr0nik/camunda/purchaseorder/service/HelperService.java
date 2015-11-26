package com.github.electr0nik.camunda.purchaseorder.service;

import com.github.electr0nik.camunda.purchaseorder.delegate.form.MealForm;
import com.github.electr0nik.camunda.purchaseorder.delegate.model.Ingredient;
import com.github.electr0nik.camunda.purchaseorder.delegate.model.SimpleUser;

import java.util.List;
import java.util.Properties;

public interface HelperService {
  List<Ingredient> populateMealIngredients(final Properties properties, final String mealName);

  SimpleUser getPopulatedSimpleSimpleUser(final String username, final String decodedPassword);

  void persistOrder(final MealForm mealForm, final SimpleUser user);
}
