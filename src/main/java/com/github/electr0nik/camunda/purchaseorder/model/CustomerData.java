package com.github.electr0nik.camunda.purchaseorder.model;

import java.util.ArrayList;
import java.util.List;

public class CustomerData {
  protected String firstname;
  protected String lastname;
  protected boolean isVip;
  protected float rating;
  protected List<Address> addresses = new ArrayList<Address>();

  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public boolean isVip() {
    return isVip;
  }

  public void setVip(boolean vip) {
    isVip = vip;
  }

  public float getRating() {
    return rating;
  }

  public void setRating(float rating) {
    this.rating = rating;
  }

  public List<Address> getAddresses() {
    return addresses;
  }

  public void setAddresses(List<Address> addresses) {
    this.addresses = addresses;
  }
}