package com.unitTesting.crm.domain;

public class User {

  public Long id;
  public String name;
  public String phoneNumber;
  public String role;

  public User(Long id, String name, String phoneNumber, String role) {
    this.id = id;
    this.name = name;
    this.phoneNumber = phoneNumber;
    this.role = role;
  }

}
