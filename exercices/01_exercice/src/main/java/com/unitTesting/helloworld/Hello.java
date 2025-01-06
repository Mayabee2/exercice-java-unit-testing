package com.unitTesting.helloworld;

public class Hello {

  public String message(String prenom) {
    if(prenom == null) {
      throw new IllegalArgumentException("prenom cannot be null");
    }

    return "Hello " + prenom + " !";
  }
}
