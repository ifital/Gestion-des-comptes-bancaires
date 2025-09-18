package model;

public class CompteCourant extends Compte {

    private double decouvert;

    public double getDecouvert() {
        return decouvert;
    }

    public CompteCourant(String code, double decouvert) {
        super(code);
        this.decouvert = decouvert;
    }


    @Override
    public boolean retirer(double montant, String destination) {
        if(solde - montant >= decouvert){
            solde -= montant;
            ajouterOperation(new Retrait(montant, destination));
            return true;
        }
        return false ;
    }

    @Override
    public double calculerInteret() {
        return 0;
    }

    @Override
    public void afficherDetails() {

        System.out.println("==== COMTE COURANT ===");
        System.out.println("CODE " + code);
        System.out.println("solde" +  String.format("%.2f€", solde));
        System.out.println("decouvert "+  String.format("%.2f€", decouvert));
        System.out.println("solde disponible "+  solde + decouvert);
        System.out.println("nombre d opération "+  listeOperations.size());

    }
}

