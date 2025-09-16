package model;

import java.time.LocalDateTime;
import java.util.UUID;

public abstract class Operation {

    protected String numero;
    protected LocalDateTime date;
    protected double montant;

    public Operation(String numero, LocalDateTime date, double montant) {
        this.numero = UUID.randomUUID().toString();
        this.date = LocalDateTime.now() ;
        this.montant = montant;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    @Override
    public String toString() {
        return String.format("N°: %s, Date: %s, Montant: %.2f€",
                numero.substring(0, 8), date.toString().substring(0, 19), montant);
    }
}

