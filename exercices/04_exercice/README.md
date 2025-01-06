# 📝 Exercice 3 - TU + Mocking ~ 20 minutes

## 🎯 Objectifs
Dans cet exercice, vous travaillerez avec une petite application de gestion de comptes clients, _crm_. Il s'agit d'une application simplifiée, avec un nombre limité de fonctionnalités.

🔍 **Note** : Cette application n'utilise pas de réelle base de données, il vous sera donc demandé de _"mocker"_ les composants non contrôlés dans vos tests.

## 📏 Architecture

Parcourez les classes déjà créées sous **src/main/java** pour prendre connaissance du fonctionnement de l'application:
- La classe `User` représente un utilisateur et les différents attributs qui lui sont associés.


- C'est dans la classe `UserService` que se trouve toute la logique métier (fonctionnalités) de notre application. Pour l'instant, deux méthodes sont implémentées
  - `getUserName` qui permet de retrouver le nom d'un utilisateur à partir de son identifiant (on fournit l'identifiant de l'utilisateur et son nom est récupéré depuis la base de données)
  - `createNewUser` qui permet d'inscrire un nouvel utilisateur en base de donnée.


- La classe `UserRepository` est responsable des interactions avec la base de données. En effet, dans une architecture bien conçue, chaque composant est responsable d'une seule préoccupation spécifique. Pour la classe de service `UserService`, il s'agit de gérer la logique métier de l'application (vérifier les règles ou lever une exception, par exemple si le numéro de téléphone fourni correspond à celui d'un utilisateur déjà existant). `UserService` délègue ainsi à `UserRepository` chaque opérations d'accès à la base de données (en lecture, écriture). Les méthodes de `UserRepository` ne sont pas implémentées car nous allons simuler les lectures/écritures en base. 


- Plusieurs exceptions peuvent être levées si les paramètres en entrée des méthodes ne respectent pas certaines règles. Ces exceptions sont regroupées sous le package **exception**. Inutile de s'attarder sur l'implémentation de ces classes.


## 🛠️ Étapes

### 1. Implémentation des tests unitaires dans `UserServiceTest`

- Dans `UserServiceTest`, un setup est déjà présent pour écrire des tests unitaires sur différentes fonctions de `UserService`.
- Vous trouverez des squelettes de tests à compléter avec une description de ce qui est attendu.
- Utilisez ces indications et Continue pour rédiger les tests unitaires nécessaires.
- N'oubliez pas de simuler (_mock_) les appels à `userRepository`.
- Lancez les tests et assurez-vous qu'ils passent avec succès.

### 2. Ajout de la fonctionnalité `deleteUser` dans `UserService`

- Nous souhaitons ajouter une méthode `void deleteUser(Long id)` qui respecte les règles suivantes :
  - Si aucun utilisateur n'est associé à cet identifiant, aucune action n'est effectuée.
  - Si l'utilisateur existe et a le rôle Admin, l'opération doit échouer en renvoyant une exception `NotAllowedException` avec le message _"You cannot delete an admin user"_.
  - La méthode `deleteUser(id)` dans `UserRepository` ainsi que l'exception existent déjà.
  - Une fois cette méthode implémentée, rédigez les tests unitaires pour couvrir ces cas dans `UserServiceTest`.


## ✅ Critères de validation :

- Les tests unitaires rédigés passent avec succès.
- Les tests couvrent les différentes règles, y compris la vérification de l'unicité du numéro de téléphone.

### 💡 Conseils pour Mockito :

Utilisez cette cheatsheet pour vous aider à mocker certains comportements courants :

```java
// Simuler un retour pour une recherche par ID
when(userRepository.findById(1L)).thenReturn(new User(...));

// Vérifier si une fonction est appelée un certain nombre de fois
verify(userRepository, times(n)).findById(1L);

// Vérifier que la fonction n'est jamais appelée
verify(userRepository, never()).deleteUser(1L);

// Vérifier la valeur d'un argument d'entrée
verify(userRepository).save(argThat(user -> user.getName().equals("John")));

// Vérifier que deux objets sont égaux
assertEquals(expected, actual);

// Récupérer une exception attendue
assertThrows(ExpectedException.class, () -> {
    // Code qui doit déclencher une exception
});
