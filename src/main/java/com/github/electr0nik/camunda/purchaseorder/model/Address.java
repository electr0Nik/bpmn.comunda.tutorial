package com.github.electr0nik.camunda.purchaseorder.model;

/**
 * Created by nik on 24.11.15.
 */
public class Address {
  protected String street;
  protected String zipCode;
  protected String city;
  protected String country;

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public String getZipCode() {
    return zipCode;
  }

  public void setZipCode(String zipCode) {
    this.zipCode = zipCode;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }
}
