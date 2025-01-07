//package com.unitTesting.moneybag;
//
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestInstance;
//
//import static org.junit.jupiter.api.Assertions.assertFalse;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//public class MoneyTest {
//
//  private Money m12CHF;
//  private Money m14CHF;
//
//  @BeforeAll
//  public void setup() {
//    m12CHF = new Money(12, "CHF");
//    m14CHF = new Money(14, "CHF");
//  }
//
//  @Test
//  public void testSimpleAdd() {
//    Money expected = new Money(26, "CHF"); // création des données
//    Money result = m12CHF.add(m14CHF); // exécution de la méthode testée
//    assertTrue(expected.equals(result)); // comparaison
//  }
//
//  @Test
//  public void testEquals() {
//    assertTrue(m12CHF.equals(m12CHF), "Un objet doit être égal à lui-même");
//
//    Money money2 = new Money(12, "CHF");
//    assertTrue(m12CHF.equals(money2), "Deux objets avec les mêmes valeurs doivent être égaux");
//
//    Money money3 = new Money(10, "CHF");
//    assertFalse(m12CHF.equals(money3), "Deux objets avec des montants différents ne doivent pas être égaux");
//
//    Money money4 = new Money(12, "EUR");
//    assertFalse(m12CHF.equals(money4), "Deux objets avec des devises différentes ne doivent pas être égaux");
//
//    assertFalse(m12CHF.equals(null), "Un objet ne doit pas être égal à null");
//  }
//
//}
