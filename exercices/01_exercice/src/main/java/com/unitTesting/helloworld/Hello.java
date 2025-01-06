package com.unitTesting.helloworld;

public class Hello {

  public String message(String prenom) {
    if(prenom == null) {
      return "Hello World ! ";
    }

    return "Hello " + prenom + " !";
  }
}
