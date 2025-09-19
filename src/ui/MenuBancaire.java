package ui;

import model.Compte;
import model.Operation;
import model.CompteCourant;
import model.CompteEpargne;
import service.CompteService;
import service.OperationService;
import util.InputUtil;
import util.ValidationUtil;

import java.util.List;
import java.util.Optional;

public class MenuBancaire {

    private CompteService compteService;
    private OperationService operationService;
    private boolean continuer;

    public MenuBancaire(CompteService compteService, OperationService operationService) {
        this.compteService = compteService;
        this.operationService = operationService;
        this.continuer = true;
    }

    public void demarrer(){
        System.out.println("=== BIENVENUE DANS LE SYSTÈME BANCAIRE ===\n");
        while (continuer) {
            afficherMenu();
            int choix = InputUtil.lireEntier("Votre choix : ");
            traiterChoix(choix);
            System.out.println("\n" + repeat("=", 50) + "\n"); // ✅ corrigé
        }

        System.out.println("Merci d'avoir utilisé notre système bancaire !");
        InputUtil.fermerScanner();
    }

    private void afficherMenu() {
        System.out.println("=== MENU PRINCIPAL ===");
        System.out.println("1. Créer un compte");
        System.out.println("2. Effectuer un versement");
        System.out.println("3. Effectuer un retrait");
        System.out.println("4. Effectuer un virement");
        System.out.println("5. Consulter le solde d'un compte");
        System.out.println("6. Consulter les opérations d'un compte");
        System.out.println("7. Lister tous les comptes");
        System.out.println("8. Statistiques globales");
        System.out.println("0. Quitter");
        System.out.println("========================");
    }

    private void traiterChoix(int choix) {
        try {
            switch (choix) {
                case 1: creerCompte(); break;
                case 2: effectuerVersement(); break;
                case 3: effectuerRetrait(); break;
                case 4: effectuerVirement(); break;
                case 5: consulterSolde(); break;
                case 6: consulterOperations(); break;
                case 7: listerComptes(); break;
                case 8: afficherStatistiques(); break;
                case 0: continuer = false; break;
                default: System.out.println("Choix invalide. Veuillez réessayer.");
            }
        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }

    private void creerCompte() {
        System.out.println("=== CRÉATION DE COMPTE ===");
        System.out.println("1. Compte Courant");
        System.out.println("2. Compte Épargne");

        int type = InputUtil.lireEntier("Type de compte : ");
        String code;

        switch (type) {
            case 1:
                double decouvert = InputUtil.lireDouble("Montant du découvert autorisé : ");
                code = compteService.creerCompteCourant(decouvert);
                System.out.println("Compte courant créé avec succès !");
                System.out.println("Code du compte : " + code);
                break;
            case 2:
                double taux = InputUtil.lireDouble("Taux d'intérêt (%) : ");
                code = compteService.creerCompteEpargne(taux);
                System.out.println("Compte épargne créé avec succès !");
                System.out.println("Code du compte : " + code);
                break;
            default:
                System.out.println("Type de compte invalide.");
        }
    }

    private void effectuerVersement() {
        System.out.println("=== VERSEMENT ===");
        String code = InputUtil.lireChaineNonVide("Code du compte : ");

        if (!ValidationUtil.validerCodeCompte(code)) {
            System.out.println("Format de code invalide (format requis: CPT-XXXXX)");
            return;
        }

        double montant = InputUtil.lireDouble("Montant à verser : ");
        String source = InputUtil.lireChaineNonVide("Source du versement : ");

        if (operationService.verser(code, montant, source)) {
            System.out.println("Versement effectué avec succès !");
        } else {
            System.out.println("Erreur : Compte non trouvé.");
        }
    }

    private void effectuerRetrait() {
        System.out.println("=== RETRAIT ===");
        String code = InputUtil.lireChaineNonVide("Code du compte : ");

        if (!ValidationUtil.validerCodeCompte(code)) {
            System.out.println("Format de code invalide (format requis: CPT-XXXXX)");
            return;
        }

        double montant = InputUtil.lireDouble("Montant à retirer : ");
        String destination = InputUtil.lireChaineNonVide("Destination du retrait : ");

        if (operationService.retirer(code, montant, destination)) {
            System.out.println("Retrait effectué avec succès !");
        } else {
            System.out.println("Erreur : Retrait impossible (solde insuffisant ou compte non trouvé).");
        }
    }

    private void effectuerVirement() {
        System.out.println("=== VIREMENT ===");
        String codeSource = InputUtil.lireChaineNonVide("Code du compte source : ");
        String codeDestination = InputUtil.lireChaineNonVide("Code du compte destination : ");
        double montant = InputUtil.lireDouble("Montant à verser1 : ");

        if (!ValidationUtil.validerCodeCompte(codeSource) ||
                !ValidationUtil.validerCodeCompte(codeDestination)) {
            System.out.println("Format de code invalide (format requis: CPT-XXXXX)");
            return;
        }

        if (codeSource.equals(codeDestination)) {
            System.out.println("Erreur : Les comptes source et destination doivent être différents.");
            return;
        }


        if (operationService.effectuerVirement(codeSource, codeDestination, montant)) {
            System.out.println("Virement effectué avec succès !");
        } else {
            System.out.println("Erreur : Virement impossible (solde insuffisant ou compte non trouvé).");
        }
    }

    private void consulterSolde() {
        System.out.println("=== CONSULTATION SOLDE ===");
        String code = InputUtil.lireChaineNonVide("Code du compte : ");

        Optional<Compte> compte = compteService.rechercherCompte(code);
        if (compte.isPresent()) {
            compte.get().afficherDetails();
        } else {
            System.out.println("Compte introuvable.");
        }
    }

    private void consulterOperations() {
        System.out.println("=== HISTORIQUE DES OPÉRATIONS ===");
        String code = InputUtil.lireChaineNonVide("Code du compte : ");

        List<Operation> operations = operationService.obtenirOperationsParCompte(code);
        if (operations.isEmpty()) {
            System.out.println("Aucune opération trouvée pour ce compte.");
        } else {
            System.out.println("Nombre d'opérations : " + operations.size());
            System.out.println();
            operations.forEach(System.out::println);
        }
    }

    private void listerComptes() {
        System.out.println("=== LISTE DES COMPTES ===");
        List<Compte> comptes = compteService.listerTousLesComptes();

        if (comptes.isEmpty()) {
            System.out.println("Aucun compte créé.");
        } else {
            comptes.forEach(Compte::afficherDetails);
            System.out.println();
        }
    }

    private void afficherStatistiques() {
        System.out.println("=== STATISTIQUES GLOBALES ===");
        List<Compte> tous = compteService.listerTousLesComptes();
        List<Compte> courants = compteService.filtrerComptesParType(CompteCourant.class);
        List<Compte> epargnes = compteService.filtrerComptesParType(CompteEpargne.class);

        System.out.println("Nombre total de comptes : " + tous.size());
        System.out.println("Comptes courants : " + courants.size());
        System.out.println("Comptes épargne : " + epargnes.size());
        System.out.println("Solde total : " + String.format("%.2f€", compteService.calculerSoldeTotal()));

        double interetsTotal = epargnes.stream()
                .mapToDouble(Compte::calculerInteret)
                .sum();
        System.out.println("Intérêts totaux (comptes épargne) : " + String.format("%.2f€", interetsTotal));
    }

    private static String repeat(String s, int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(s);
        }
        return sb.toString();
    }
}
