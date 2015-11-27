package com.github.electr0nik.camunda.purchaseorder.service;

import com.github.electr0nik.camunda.purchaseorder.delegate.form.MealForm;
import com.github.electr0nik.camunda.purchaseorder.delegate.model.SimpleUser;
import com.github.electr0nik.camunda.purchaseorder.service.impl.HelperServiceImpl;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by nik on 27.11.15.
 */
public class HelperServiceTest {

  private final HelperService helperService = new HelperServiceImpl();

  @Test
  public void testPersistOrder() throws Exception {
    final MealForm mealForm = new MealForm();
    mealForm.setMealList(new ArrayList<>());
    final SimpleUser user = new SimpleUser();
    user.setAddress("random address!");
    user.setEmail("test@test.de");
    user.setFirstName("max");
    user.setGender("male");
    user.setLastName("Muster");

    helperService.persistOrder(mealForm, user);
  }
}