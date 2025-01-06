# 📝 Exercice 1- Tests Unitaires plus avancés

## 🎯 Objectif
Dans la classe `StringHelper`, nous avons trois fonctions utilitaires à tester:

- **🔍 isPalindrome** : Cette fonction prend une chaîne de caractères en entrée et détermine si elle est un palindrome. Pour rappel, un palindrome est un mot, une phrase ou une expression qui se lit de la même manière de gauche à droite ou inversement, par exemple : _"radar"_.
- **🔄 isAnagram** : Cette fonction prend en entrée deux chaînes de caractères et vérifie si elles contiennent les mêmes caractères, par exemple : _"niche"_ et _"chien"_.
- **🐪 toCamelCase** : Cette fonction transforme une phrase en une chaîne de caractères au format camelCase. Par exemple, _"Je mange une pomme"_ devient _"JeMangeUnePomme"_.

Votre objectif est d'écrire des tests unitaires pour chaque méthode afin de couvrir divers cas de figure, qu'ils soient valides ou non.

## 🛠️ Instructions

1. Implémentez les tests unitaires dans la classe `StringHelperTest` pour les trois méthodes mentionnées.
2. Assurez-vous de tester plusieurs cas pour chaque méthode, en couvrant les situations possibles. Un exemple est déjà fourni pour vous aider à démarrer.
3. Vérifiez que tous les tests unitaires dans `StringHelperTest` passent avec succès.


### 🚀 Comment exécuter les tests
Lancez Maven dans le terminal pour exécuter les tests :

```bash
mvn clean test
```

## ✅ Critères de validation
- Tous les tests unitaires écrits réussissent.
- Les cas de bord (par exemple, une chaîne null, une chaîne vide, etc.) sont bien couverts.
