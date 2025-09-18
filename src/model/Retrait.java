package model;

import java.time.LocalDateTime;


public class Retrait extends Operation {
    public String getDestination() {
        return destination;
    }

    private String destination;

    public Retrait(String numero, LocalDateTime date, double montant, String destination) {
        super(numero, date, montant);
        this.destination = destination;
    }

}
