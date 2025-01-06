package com.aitesting.stringhelper;

import java.util.Arrays;

public class StringHelper {
  public static boolean isPalindrome(String str) {
    if (str == null || str.length() <= 1) {
      return true;
    }
    if (str.charAt(0) != str.charAt(str.length() - 1)) {
      return false;
    }
    return isPalindrome(str.substring(1, str.length() - 1));
  }

  public static boolean isAnagram(String str1, String str2) {
    if (str1 == null || str2 == null || str1.length() != str2.length()) {
      return false;
    }
    char[] a1 = str1.toCharArray();
    char[] a2 = str2.toCharArray();
    Arrays.sort(a1);
    Arrays.sort(a2);
    return Arrays.equals(a1, a2);
  }

  public String toCamelCase(String input) {
    if (input == null || input.isBlank()) {
      return input;
    }

    String[] words = input.strip().toLowerCase().split("\\s+");
    StringBuilder camelCase = new StringBuilder();

    // Parcour les mots et mets la première lettre en majuscule
    for (String word : words) {
      if (!word.isBlank()) {
        camelCase.append(Character.toUpperCase(word.charAt(0)))
                .append(word.substring(1));
      }
    }

    return camelCase.toString();
  }


}