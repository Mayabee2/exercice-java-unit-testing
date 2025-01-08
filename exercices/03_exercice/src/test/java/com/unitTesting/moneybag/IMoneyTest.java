package com.unitTesting.moneybag;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class IMoneyTest {

  private Money f12CHF;
  private Money f14CHF;
  private Money f7USD;
  private Money f21USD;
  private MoneyBag fMB1;
  private MoneyBag fMB2;

  @BeforeAll
  public void setUp() {
    f12CHF = new Money(12, "CHF");
    f14CHF = new Money(14, "CHF");
    f7USD = new Money(7, "USD");
    f21USD = new Money(21, "USD");
    fMB1 = new MoneyBag(f12CHF, f7USD);
    fMB2 = new MoneyBag(f14CHF, f21USD);
  }

  @Test
  public void testAddMoneyToMoney() {
    // [12 CHF] + [7 USD] == {[12 CHF][7 USD]}
    Money bag[] = {f12CHF, f7USD};
    MoneyBag expected = new MoneyBag(bag);
    IMoney actual = f12CHF.add(f7USD);
    assertEquals(actual, f12CHF.add(f7USD));
  }

  @Test
  public void testAddMoneyBagToMoneyBag() {
    // {[12 CHF][7 USD]} + {[14 CHF][21 USD]} == {[26 CHF][28 USD]}
    Money[] bag = {new Money(26, "CHF"), new Money(28, "USD")};
    MoneyBag expected = new MoneyBag(bag);
    IMoney actual = fMB1.add(fMB2);
    assertTrue(actual.equals(expected));
  }

  @Test
  public void testAddMoneyBagToMoney() {
    // [12 CHF] + {[14 CHF][21 USD]} == {[26 CHF][21 USD]}
    Money[] bag = {new Money(26, "CHF"), f21USD};
    MoneyBag expected = new MoneyBag(bag);
    IMoney actual = f12CHF.add(fMB2);
    assertTrue(actual.equals(expected));
  }

  @Test
  public void testAddMoneyToMoneyBag() {
    // {[12 CHF][7 USD]} + [14 CHF] == {[26 CHF][7 USD]}
    Money[] bag = {new Money(26, "CHF"), f7USD};
    MoneyBag expected = new MoneyBag(bag);
    assertTrue(fMB1.add(f14CHF).equals(expected));
  }
}
