package model;

public class CompteCourant extends Compte {

    private double decouvert;

    public CompteCourant(String code, double decouvert) {
        super(code);
        this.decouvert = decouvert;
    }




}

