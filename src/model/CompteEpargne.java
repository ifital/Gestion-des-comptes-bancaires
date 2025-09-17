package model;

public class CompteEpargne extends Compte{

    private double tauxInteret;

    public CompteEpargne(String code, double tauxInteret) {
        super(code);
        this.tauxInteret = tauxInteret;
    }


    @Override
    public boolean retirer(double montant, String destination) {
        return false;
    }

    @Override
    public double calculerInteret() {
        return 0;
    }

    @Override
    public void afficherDetails() {

    }
}
