package com.github.electr0nik.camunda.purchaseorder.model;

import java.util.List;

/**
 * Created by nik on 24.11.15.
 */
public class Meal {

  private String name;

  private List<Ingredient> ingredientList;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Ingredient> getIngredientList() {
    return ingredientList;
  }

  public void setIngredientList(List<Ingredient> ingredientList) {
    this.ingredientList = ingredientList;
  }
}
