package com.aitesting.stringhelper;

import org.junit.Assert;
import org.junit.Test;

public class StringHelperTest {

  @Test
  public void isPalindromeTest() {
    // TODO:: Implémenter les tests
  }

  @Test
  public void isAnagramTest() {
    // TODO:: Implémenter les tests
  }

  @Test
  public void toCamelCaseTest() {
    // cas simples
    Assertions.assertEquals("HelloWorld", StringHelper.toCamelCase("hello world"));
    Assertions.assertEquals("JavaProgramming", StringHelper.toCamelCase("java programming"));

    // cas un mot
    Assertions.assertEquals("Hello", StringHelper.toCamelCase("hello"));
    Assertions.assertEquals("World", StringHelper.toCamelCase("WORLD"));

    // cas avec cases différentes
    Assertions.assertEquals("HelloWorld", StringHelper.toCamelCase("Hello World"));
    Assertions.assertEquals("JavaProgramming", StringHelper.toCamelCase("JAVA programming"));

    // cas avec espaces
    Assertions.assertEquals("HelloWorld", StringHelper.toCamelCase("   hello   world   "));

    // cas de bord
    Assertions.assertNull(StringHelper.toCamelCase(null));
    Assertions.assertEquals("", StringHelper.toCamelCase(""));  }
}
