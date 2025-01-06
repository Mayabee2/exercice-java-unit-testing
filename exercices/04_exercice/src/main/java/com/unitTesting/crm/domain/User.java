package com.unitTesting.crm.domain;

import com.unitTesting.crm.enums.RoleEnum;

public class User

  private Long id;
  private String name;
  private String phoneNumber;
  private String role;

  public User(Long id, String name, String phoneNumber, String role) {
    this.id = id;
    this.name = name;
    this.phoneNumber = phoneNumber;
    this.role = role;
  }

}
