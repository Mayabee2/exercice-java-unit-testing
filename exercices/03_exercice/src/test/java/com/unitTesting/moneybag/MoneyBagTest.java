//package com.unitTesting.moneybag;
//
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestInstance;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//public class MoneyBagTest {
//
//  private Money f12CHF;
//  private Money f14CHF;
//  private Money f7USD;
//  private Money f21USD;
//  private MoneyBag fMB1;
//  private MoneyBag fMB2;
//  private MoneyBag fMB3;
//
//  @BeforeAll
//  public void setUp() {
//    f12CHF= new Money(12, "CHF");
//    f14CHF= new Money(14, "CHF");
//    f7USD= new Money( 7, "USD");
//    f21USD= new Money(21, "USD");
//    fMB1= new MoneyBag(f12CHF, f7USD);
//    fMB2= new MoneyBag(f14CHF, f21USD);
//    fMB3= new MoneyBag(f14CHF, f21USD);
//  }
//
//  @Test
//  public void testBagEquals() {
//    assertTrue(!fMB1.equals(null));
//    assertEquals(fMB1, fMB1);
//    assertEquals(fMB2, fMB3);
//    assertTrue(!fMB1.equals(f12CHF));
//    assertTrue(!f12CHF.equals(fMB1));
//    assertTrue(!fMB1.equals(fMB2));
//
//    Money m1 = new Money(12, "CHF");
//    Money m2 = new Money(21, "USD");
//
//    MoneyBag bag1 = new MoneyBag(new Money[]{m1, m2});
//    MoneyBag bag2 = new MoneyBag(new Money[]{m2, m1});
//
//    assertEquals(bag1, bag2);
//
//  }
//
//}
