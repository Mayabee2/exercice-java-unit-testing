package com.unitTesting.helloworld;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HelloTest {

  private static Hello helloObject;

  @BeforeAll
  public static void setup() {
    helloObject = new Hello();
  }

  @Disabled
  @Test
  public void testMessageWithNull_ReturnsDefaultMessage() {
    String result = helloObject.message(null);
    assertNotNull(result);
    assertEquals("Hello World !", result);
  }

  @Test
  public void testMessage_WhenPrenomIsNull_ThrowsIllegalArgumentException() {
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
      helloObject.message(null);
    });
    assertEquals("prenom cannot be null", exception.getMessage());
  }

  @Test
  public void testMessageWithName_ReturnsPersonalizedMessage() {
    String result = helloObject.message("John");
    assertNotNull(result);
    assertEquals("Hello John !", result);
    assertNotEquals("Hello World !", result);
  }
}
