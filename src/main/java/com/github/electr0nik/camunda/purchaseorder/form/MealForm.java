package com.github.electr0nik.camunda.purchaseorder.form;

import com.github.electr0nik.camunda.purchaseorder.model.Meal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nik on 25.11.15.
 */
public class MealForm {
  private List<Meal> mealList;

  public MealForm() {
    this.mealList = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      this.mealList.add(new Meal());
    }
  }

  public List<Meal> getMealList() {
    return mealList;
  }

  public void setMealList(List<Meal> mealList) {
    this.mealList = mealList;
  }
}
