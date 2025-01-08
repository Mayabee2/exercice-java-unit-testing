package com.unitTesting.moneybag;

import java.util.Comparator;
import java.util.Vector;

class MoneyBag implements IMoney{

  private Vector<Money> fMonies = new Vector<Money>();

  MoneyBag(Money m1, Money m2) {
    appendMoney(m1);
    appendMoney(m2);
  }

  MoneyBag(Money[] bag) {
    for (Money money : bag) {
      appendMoney(money);
    }
  }

  private void appendMoney(Money m) {
    if (fMonies.isEmpty()) {
      fMonies.add(m);
    } else {
      int i = 0;
      while ((i < fMonies.size()) && (!(fMonies.get(i).currency().equals(m.currency())))) {
        i++;
      }
      if (i >= fMonies.size()) {
        fMonies.add(m);
      } else {
        fMonies.set(i, new Money(fMonies.get(i).amount() + m.amount(), m.currency()));
      }
    }
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;

    if (obj == null || getClass() != obj.getClass())
      return false;

    MoneyBag other = (MoneyBag) obj;

    if (this.fMonies.size() != other.fMonies.size())
      return false;

    // Tri des listes avant comparaison
    Vector<Money> thisSorted = new Vector<>(fMonies);
    thisSorted.sort(Comparator.comparing(Money::currency));

    Vector<Money> otherSorted = new Vector<>(other.fMonies);
    otherSorted.sort(Comparator.comparing(Money::currency));

    for (int i = 0; i < thisSorted.size(); i++) {
      Money thisMoney = thisSorted.get(i);
      Money otherMoney = otherSorted.get(i);

      if (!thisMoney.equals(otherMoney)) {
        return false;
      }
    }

    return true;
  }

  /* //Version avec instanceof
  @Override
  public IMoney add(IMoney m) {
    if (m instanceof Money) {
      // Ajoute un Money à ce MoneyBag
      Money money = (Money) m;
      MoneyBag result = new MoneyBag(fMonies.toArray(new Money[0]));
      result.appendMoney(money);
      return result;
    } else if (m instanceof MoneyBag) {
      // Fusionne deux MoneyBag
      MoneyBag other = (MoneyBag) m;
      MoneyBag result = new MoneyBag(fMonies.toArray(new Money[0]));
      for (Money money : other.fMonies) {
        result.appendMoney(money);
      }
      return result;
    }

    throw new IllegalArgumentException("Type non pris en charge : " + m.getClass());
  }*/

  @Override
  public IMoney add(IMoney m) {
    return m.addMoneyBag(this); // Délégation à l'argument
  }

  @Override
  public IMoney addMoney(Money m) {
    this.appendMoney(m);
    return this;
  }

  @Override
  public IMoney addMoneyBag(MoneyBag m) {
    // Logique pour fusionner deux MoneyBag
    for (Money money : m.fMonies) {
      this.appendMoney(money);
    }
    return this;
  }

}

