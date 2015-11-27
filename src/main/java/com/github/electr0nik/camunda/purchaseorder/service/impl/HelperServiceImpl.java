package com.github.electr0nik.camunda.purchaseorder.service.impl;

import com.github.electr0nik.camunda.purchaseorder.delegate.form.MealForm;
import com.github.electr0nik.camunda.purchaseorder.delegate.model.Ingredient;
import com.github.electr0nik.camunda.purchaseorder.delegate.model.SimpleUser;
import com.github.electr0nik.camunda.purchaseorder.service.HelperService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

public class HelperServiceImpl implements HelperService {
  private final Logger LOGGER = LoggerFactory.getLogger(HelperServiceImpl.class);
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

  /**
   * i am just to lazy to create another smoke properties, therefore, just create a simple user object and return it
   *
   * @param username
   * @param decodedPassword
   * @return
   */
  @Override
  public SimpleUser getPopulatedSimpleSimpleUser(final String username, final String decodedPassword) {
    // return this.repository.load(username, decodedPassword);
    final SimpleUser user = new SimpleUser();
    user.setEmail("test@test.de");
    user.setFirstName("Rambo");
    user.setGender("Male");
    user.setLastName("Matrix");
    user.setAddress("Musterstr. 12, 12345 Musterstadt");
    LOGGER.info("User was loaded!" + user);
    return user;
  }

  @Override
  public void persistOrder(final MealForm mealForm, final SimpleUser user) {
    final String fileName = "order" + new Date().getTime() + ".txt";
    BufferedWriter output = null;
    try {
      File file = new File("C:\\work\\orders\\" + fileName);
      output = new BufferedWriter(new FileWriter(file));
      output.write(mealForm.toString() + "\n\n" + user.toString());
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (output != null)
        try {
          output.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
    }

  }
}
