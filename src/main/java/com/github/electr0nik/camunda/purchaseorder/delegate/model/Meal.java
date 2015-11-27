package com.github.electr0nik.camunda.purchaseorder.delegate.model;

import java.util.List;

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

  @Override
  public String toString() {
    return "Meal{\n\t" +
        "name='" + name + '\'' +
        ", ingredientList=" + ingredientList +
        '}';
  }
}
