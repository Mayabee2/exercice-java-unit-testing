package com.unitTesting.moneybag;

interface IMoney {
  IMoney add(IMoney m); // Méthode principale
  IMoney addMoney(Money m); // Pour gérer un Money
  IMoney addMoneyBag(MoneyBag m); // Pour gérer un MoneyBag
}
