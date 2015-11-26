package com.github.electr0nik.camunda.purchaseorder.delegate.form;

import java.util.List;

import com.github.electr0nik.camunda.purchaseorder.delegate.model.Meal;

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
