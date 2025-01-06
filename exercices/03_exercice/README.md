# 📝 Exercice 2 - TDD 

Nous allons écrire un programme qui résout le problème de la représentation arithmétique avec plusieurs devises.
L'addition arithmétique entre deux objets de même devise est triviale, il suffit d'ajouter les deux montants.
De simples nombres suffisent ; les devises peuvent être ignorées. Les choses deviennent intéressantes une
fois plusieurs devises impliquées. On ne peut pas simplement convertir une devise en une autre pour effectuer des opérations arithmétiques puisqu'il n'y a pas un unique taux de change.

Dans cet exercice, nous allons aborder le démarche du Test Driven Development (TDD). 
Pour rappel, le TDD consiste à rédiger les tests unitaires avant même d'écrire le code. Ces tests définissent le comportement attendu des fonctions. Une fois le code implémenté, les tests permettent de valider son bon fonctionnement.

## 🛠️ Instructions

Suivez les étapes ci-dessous pour implémenter les différents tests et fonctions.


## 🐾 Étapes

### 🪙 1. Classe Money
Commençons simplement avec une classe `Money` pour représenter une valeur pour une devise
donnée. Cette classe est capable d'ajouter deux valeurs ayant la même devise (méthode add).

1. Parcourez le squelette de la classe `Money` et notez que la méthode `add` n'a pas encore été implémentée. 
La classe de test `MoneyTest` existe déjà, avec une méthode `testSimpleAdd` qui doit tester le comportement de la méthode `add` de la classe `Money`.
Lancez ce test. Pour l'instant, logiquement il ne fonctionne pas. Implémentez la méthode `add`.


2. Relancez le test pour valider le fonctionnement de la méthode que vous venez d'écrire. Que se passe-t-il ? Comment l'expliquez vous ?


3. Dans la classe `MoneyTest`, ajoutez une méthode `testEquals` qui teste l'égalité sur l'objet `Money`. Lancez le test.


4. Surcharger la méthode `equals` de la classe `Money` pour passer ce test avec succès.


5. **Refactorisation des tests** : si ce n'est pas déjà fait, utilisez l'annotation `@BeforeAll` afin de mutualiser la partie création de données des deux tests. 

### 2. 💰 Classe MoneyBag
Maintenant que la classe `Money` semble fonctionner pour une unique devise, nous allons prendre en charge
des devises multiples. Pour cela, introduisons la classe `MoneyBag` permettant d'agréger des valeurs de différentes devises.

1. Par soucis de simplicité, la classe `MoneyBag` a été en partie implémentée pour vous. Parcourez la classe pour en comprendre le fonctionnement.


2. De la même manière, une première méthode a été implémentée pour vous dans la classe `MoneyBagTest`. Lancez-là et vérifiez qu'elle échoue. A partir de cette méthode de test, écrire la méthode `equals` de la classe `MoneyBag` pour éviter les mêmes erreurs que `Money` dans la partie précédente. Vérifiez que le test réussisse.

### 3. 🤝 Intégration des classes `Money` et `MoneyBag`

Maintenant que `MoneyBag` est créée, nous pouvons corriger la méthode `add` de la classe Money : vous pouvez remplacer la méthode `add` par sa version commentée.
Cependant cette méthode ne va pas compiler à cause d'un problème de typage. Avec l'introduction de MoneyBag, nous avons 2 types pour représenter les monnaies. Afin de rendre cette distinction invisible au
code client, introduisons une interface IMoney. 

1. Faites en sorte que `Money` et `MoneyBag` implémentent cette interface.


2. Afin de vraiment cacher les 2 types aux utilisateurs, il convient de prendre en charge toutes les combinaisons arithmétiques possibles entre `Money` et `MoneyBag`.
Nous allons commencer par définir un nouveau jeu de tests. Observez la méthode `testMixedSimpleAdd` dans la classe `IMoneyTest`. En suivant le même schéma, écrivez les méthodes de tests suivantes :
- `testAddMoneyBagToMoney` : pour ajouter un `MoneyBag` à un simple `Money`
- `testAddMoneyToMoneyBag` : pour ajouter un simple `Money` à un `MoneyBag`
- `testAddMoneyBagToMoneyBag` : pour ajouter deux `MoneyBag`


3. Les cas de test étant définis, nous pouvons commencer à implémenter les différentes combinaisons de `Money` et `MoneyBag`. 
Une solution est l'utilisation d'un appel supplémentaire pour découvrir le type d'argument à gérer. 
Nous appelons une méthode sur l'argument avec le nom de la méthode originale suivi du nom de la classe du récepteur. 
Les méthodes add de Money et MoneyBag deviennent :

class Money implements IMoney {
//...
public IMoney add(IMoney m) {
return m.addMoney(this);
}
//...
}

import java.util.Vector;
class MoneyBag implements IMoney {
//...
public IMoney add(IMoney m) {
return m.addMoneyBag(this);
}
//...

Modifiez `IMoney`, `Money` et `MoneyBag` afin que cela compile et que les tests unitaires soient passés.


### 🚀 Comment exécuter les tests
Lancez Maven dans le terminal pour exécuter les tests :

```bash
mvn clean test
```

## ✅ Critères de validation :

