package com.unitTesting.stringhelper;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringHelperTest {


  // =================== Méthode isPalindrome ===================
  @Test
  public void testIsPalindrome_WithPalindrome() {
    assertTrue(StringHelper.isPalindrome("radar"));
  }

  @Test
  public void testIsPalindrome_WithNonPalindrome() {
    assertFalse(StringHelper.isPalindrome("hello"));
  }

  @Test
  public void testIsPalindrome_WithEmptyString() {
    assertTrue(StringHelper.isPalindrome(""));
  }

  @Test
  public void testIsPalindrome_WithSingleCharacter() {
    assertTrue(StringHelper.isPalindrome("a"));
  }

  @Test
  public void testIsPalindrome_WithNullString() {
    assertTrue(StringHelper.isPalindrome(null));
  }


  // =================== Méthode isAnagram
  @Test
  public void testIsAnagram_WithAnagramStrings() {
    assertTrue(StringHelper.isAnagram("listen", "silent"));
  }

  @Test
  public void testIsAnagram_WithNonAnagramStrings() {
    assertFalse(StringHelper.isAnagram("hello", "world"));
  }

  @Test
  public void testIsAnagram_WithDifferentLengthStrings() {
    assertFalse(StringHelper.isAnagram("hello", "helloo"));
  }

  @Test
  public void testIsAnagram_WithAnagramSentence() {
    assertTrue(StringHelper.isAnagram("a gentleman", "elegant man"));
  }

  @Test
  public void testIsAnagram_WithNullStrings() {
    assertFalse(StringHelper.isAnagram(null, "test"), "Les chaînes nulles ne peuvent pas être des anagrammes");
    assertFalse(StringHelper.isAnagram("test", null), "Les chaînes nulles ne peuvent pas être des anagrammes");
    assertFalse(StringHelper.isAnagram(null, null), "Les chaînes nulles ne peuvent pas être des anagrammes");
  }


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
