package com.github.electr0nik.camunda.purchaseorder.delegate.model;

public class SimpleUser {

  private String userName;
  private String password;

  private String email;
  private String firstName;
  private String lastName;

  private String address;

  private String gender;

  private Long loginAttemps = 0L;

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Long getLoginAttemps() {
    return loginAttemps;
  }

  public void setLoginAttemps(Long loginAttemps) {
    this.loginAttemps = loginAttemps;
  }

  @Override
  public String toString() {
    return "SimpleUser{\n\t" + "email='" + email + '\'' + ", firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", gender='"
        + gender + '\'' + ", address='" + address + '\'' + '}';
  }
}
