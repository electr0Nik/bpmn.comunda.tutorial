package com.github.electr0nik.camunda.purchaseorder.form;

import com.github.electr0nik.camunda.purchaseorder.model.Meal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nik on 25.11.15.
 */
public class MealForm {
  private List<Meal> mealList;

  

  public List<Meal> getMealList() {
    return mealList;
  }

  public void setMealList(List<Meal> mealList) {
    this.mealList = mealList;
  }
}
