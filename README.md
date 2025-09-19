# Gestion des Comptes Bancaires - Java Console

## 📌 Description du projet
Ce projet est une application console en Java qui permet de gérer des comptes bancaires.  
Elle permet de créer différents types de comptes, effectuer des opérations financières (versement, retrait, virement), consulter le solde et l’historique des opérations, ainsi que de générer des statistiques globales sur les comptes.

L’objectif est de pratiquer la programmation orientée objet, la gestion des exceptions, l’utilisation de collections (`HashMap`, `List`) et la validation des entrées utilisateur en console.

---

## 🏗 Structure du projet

Gestion des comptes bancaires/
├── src/
│ ├── model/
│ │ ├── Compte.java
│ │ ├── CompteCourant.java
│ │ ├── CompteEpargne.java
│ │ ├── Operation.java
│ │ ├── Versement.java
│ │ └── Retrait.java
│ ├── service/
│ │ ├── CompteService.java
│ │ └── OperationService.java
│ ├── ui/
│ │ └── MenuBancaire.java
│ └── util/
│ ├── InputUtil.java
│ └── ValidationUtil.java
└── Main.java

---

## ⚙️ Fonctionnalités

### 1. Gestion des comptes
- Créer un compte courant ou un compte épargne.
- Chaque compte a un code unique (`CPT-XXXXX`), un solde initial de 0 et des informations spécifiques :
  - **Compte courant** : découvert autorisé.
  - **Compte épargne** : taux d’intérêt.

### 2. Opérations bancaires
- **Versement** : ajouter de l’argent sur un compte.
- **Retrait** : retirer de l’argent d’un compte.
- **Virement** : transférer de l’argent entre deux comptes.
- Validation des codes de comptes et des montants positifs.

### 3. Consultation
- Consulter le solde d’un compte.
- Consulter l’historique des opérations d’un compte.
- Lister tous les comptes avec leurs détails.

### 4. Statistiques globales
- Nombre total de comptes.
- Nombre de comptes courants et épargne.
- Solde total de tous les comptes.
- Intérêts totaux générés par les comptes épargne.

---

## 🛠 Technologies utilisées
- **Java 8** (compatibilité avec Optional, Scanner, Collections)
- **Collections Java** : `HashMap` pour stocker les comptes, `List` pour les opérations.
- **Console/CLI** pour l’interaction utilisateur.

---

## 🚀 Instructions pour exécuter le projet

1. **Cloner le dépôt** ou copier les fichiers dans un projet IntelliJ IDEA ou Eclipse.
2. **Compiler le projet** :
```bash
java -jar BanqueApp.jar
