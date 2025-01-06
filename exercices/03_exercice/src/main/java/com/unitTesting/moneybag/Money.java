package com.unitTesting.moneybag;

class Money {
  private int fAmount;
  private String fCurrency;

  public Money(int amount, String currency) {
    fAmount = amount;
    fCurrency = currency;
  }

  public int amount() {
    return fAmount;
  }

  public String currency() {
    return fCurrency;
  }

  public Money add(Money m) {
    return null;
    // TODO : Méthode à implémenter
  }

  //========================= Troisième partie ============================

  /* TODO : Cette méthode est réservée à la partie 3
  public Money add(Money m) {
    if (m.currency().equals(currency()))
      return new Money(amount() + m.amount(), currency());
    return new MoneyBag(this, m);
  }
  */

}
