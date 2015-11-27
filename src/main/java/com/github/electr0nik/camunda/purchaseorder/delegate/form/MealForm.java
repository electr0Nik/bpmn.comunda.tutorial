package com.github.electr0nik.camunda.purchaseorder.delegate.form;

import com.github.electr0nik.camunda.purchaseorder.delegate.model.Meal;

import java.util.List;

public class MealForm {
  private List<Meal> mealList;

  public List<Meal> getMealList() {
    return mealList;
  }

  public void setMealList(List<Meal> mealList) {
    this.mealList = mealList;
  }

  @Override
  public String toString() {
    return "MealForm{\n\t" +
        "mealList=" + mealList +
        '}';
  }
}
