package com.github.electr0nik.camunda.purchaseorder.delegate.model;

public class Ingredient {

  private String name;
  private String amount;
  private Long priceInCent;

  private Boolean isAtHome = false;


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAmount() {
    return amount;
  }

  public void setAmount(String amount) {
    this.amount = amount;
  }

  public Long getPriceInCent() {
    return priceInCent;
  }

  public void setPriceInCent(Long priceInCent) {
    this.priceInCent = priceInCent;
  }

  public Boolean getAtHome() {
    return isAtHome;
  }

  public void setAtHome(Boolean atHome) {
    isAtHome = atHome;
  }

  @Override
  public String toString() {
    return "Ingredient{\n\t" +
        "name='" + name + '\'' +
        ", amount='" + amount + '\'' +
        ", priceInCent=" + priceInCent +
        ", isAtHome=" + isAtHome +
        '}';
  }
}
