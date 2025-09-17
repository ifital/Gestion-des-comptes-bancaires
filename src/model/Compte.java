package model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public abstract class Compte {
    protected String code;
    protected double solde;
    protected List<Operation> listeOperations;

    public Compte(String code) {
        this.code = code;
        this.solde = 0.0;
        this.listeOperations = new ArrayList<>();
    }

    public abstract boolean retirer(double montant, String destination);
    public abstract double calculerInteret();
    public abstract void afficherDetails();

    public void ajouterOperation(Operation operation){
        this.listeOperations.add(operation);
    }
}