package model;

import java.time.LocalDateTime;
import java.util.UUID;

public abstract class Operation {

    protected String numero;
    protected LocalDateTime date;
    protected double montant;


    public String getNumero() {
        return numero;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public double getMontant() {
        return montant;
    }

    public Operation(String numero, LocalDateTime date, double montant) {
        this.numero = UUID.randomUUID().toString();
        this.date = LocalDateTime.now() ;
        this.montant = montant;
    }

}

