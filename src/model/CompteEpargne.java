package model;

public class CompteEpargne extends Compte{

    public double getTauxInteret() {
        return tauxInteret;
    }

    private double tauxInteret;

    public CompteEpargne(String code, double tauxInteret) {
        super(code);
        this.tauxInteret = tauxInteret;
    }


    @Override
    public boolean retirer(double montant, String destination) {
        if (montant > solde){
            solde -= montant;
            ajouterOperation(new Retrait(montant, destination));
            return true;
        }
        return false;
    }

    @Override
    public double calculerInteret() {
        return solde * (tauxInteret/100);
    }

    @Override
    public void afficherDetails() {
        System.out.println("=== COMPTE EPARGNE ===");
        System.out.println("solde" +  String.format("%.2f€", solde));
        System.out.println("tauxInteret "+   tauxInteret + "%");
        System.out.println("Interet calculé "+  String.format("%.2f€", calculerInteret()) );
        System.out.println("nombre d opération "+  listeOperations.size());

    }
}
