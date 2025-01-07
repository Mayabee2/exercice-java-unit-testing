package com.unitTesting.moneybag;

import java.util.Objects;

class Money implements IMoney{
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

  /*public Money add(Money m) {
    return new Money(amount() + m.amount(), currency());
  }*/

  @Override
  public boolean equals(Object money) {
    if (this == money) {
      return true;
    }
    if (money == null || getClass() != money.getClass()) {
      return false;
    }
    Money moneyInstance = (Money) money;
    return fAmount == moneyInstance.fAmount && Objects.equals(fCurrency, moneyInstance.fCurrency);
  }

  //========================= Troisième partie ============================

  /* Version avec instanceof
  @Override
  public IMoney add(IMoney m) {
    if (m instanceof Money) {
      Money other = (Money) m;
      if (this.currency().equals(other.currency())) {
        // Addition de deux montants avec la même devise
        return new Money(this.amount() + other.amount(), this.currency());
      } else {
        // Retourne un MoneyBag si les devises sont différentes
        return new MoneyBag(new Money[]{this, other});
      }
    } else if (m instanceof MoneyBag) {
      return ((MoneyBag) m).add(this);
    }

    throw new IllegalArgumentException("Type non pris en charge : " + m.getClass());
  }*/

  @Override
  public IMoney add(IMoney m) {
    return m.addMoney(this); // Délégation à l'argument
  }

  @Override
  public IMoney addMoney(Money m) {
    // Logique pour additionner deux Money
    return new Money(this.amount + m.amount, this.currency);
  }

  @Override
  public IMoney addMoneyBag(MoneyBag m) {
    // Logique pour ajouter un Money à un MoneyBag
    return m.addMoney(this); // Délégation inversée
  }

}
