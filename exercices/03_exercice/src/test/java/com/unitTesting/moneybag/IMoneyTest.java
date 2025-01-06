package com.unitTesting.moneybag;

public class IMoneyTest {

  private static Money f12CHF;
  private static Money f14CHF;
  private static Money f7USD;
  private static Money f21USD;
  private static MoneyBag fMB1;
  private static MoneyBag fMB2;

  @BeforeAll
  public static void setUp() {
    f12CHF= new Money(12, "CHF");
    f14CHF= new Money(14, "CHF");
    f7USD= new Money( 7, "USD");
    f21USD= new Money(21, "USD");
    fMB1= new MoneyBag(f12CHF, f7USD);
    fMB2= new MoneyBag(f14CHF, f21USD);
  }

  @Test
  public void testAddMoneyToMoney() {
// [12 CHF] + [7 USD] == {[12 CHF][7 USD]}
    Money bag[] = { f12CHF, f7USD };
    MoneyBag expected = new MoneyBag(bag);
    assertEquals(expected, f12CHF.add(f7USD));
  }

}
