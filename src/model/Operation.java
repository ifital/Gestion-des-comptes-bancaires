package model;

import java.time.LocalDateTime;
import java.util.UUID;

public abstract class Operation {
    protected String numero;
    protected LocalDateTime date;
    protected double montant;

    // Constructeur simple
    public Operation(double montant) {
        this.numero = UUID.randomUUID().toString();
        this.date = LocalDateTime.now();
        this.montant = montant;
    }

    // Getters
    public String getNumero() { return numero; }
    public LocalDateTime getDate() { return date; }
    public double getMontant() { return montant; }

    @Override
    public String toString() {
        return String.format("N°: %s, Date: %s, Montant: %.2f€",
                numero.substring(0, 8), date.toString().substring(0, 19), montant);
    }
}
