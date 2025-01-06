package com.unitTesting.stringhelper;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class StringHelperTest {


  // =================== Méthode isPalindrome ===================
  // TODO : implémenter ces tests

  // =================== Méthode isAnagram
  // TODO : implémenter ces tests


  // =================== Méthode toCamelCase ===================

  @Test
  public void testToCamelCase_WithSingleWord() {
    assertEquals("Hello", new StringHelper().toCamelCase("hello"));
  }

  @Test
  public void testToCamelCase_WithSingleWord_UpperCase() {
    assertEquals("World", new StringHelper().toCamelCase("WORLD"));
  }

  @Test
  public void testToCamelCase_WithMultipleWords() {
    assertEquals("HelloWorld", new StringHelper().toCamelCase("hello world"));
  }

  @Test
  public void testToCamelCase_WithMultipleWords_UpperAndLowerCases() {
    assertEquals("JavaProgramming", new StringHelper().toCamelCase("JAVA programming"));
  }

  @Test
  public void testToCamelCase_WithSpaces() {
    assertEquals("HelloWorld", new StringHelper().toCamelCase("   hello world   "));
  }

  @Test
  public void testToCamelCase_WithEmptyString() {
    assertEquals("", new StringHelper().toCamelCase(""), "Une chaîne vide doit retourner une chaîne vide");
  }

  @Test
  public void testToCamelCase_WithNullString() {
    assertNull(new StringHelper().toCamelCase(null), "Une chaîne null doit retourner null");
  }

}
