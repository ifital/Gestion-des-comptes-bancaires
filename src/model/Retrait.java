package model;

import java.time.LocalDateTime;

public class Retrait extends Operation {

    private String destination;

    public Retrait(String numero, LocalDateTime date, double montant, String destination) {
        super(numero, date, montant);
        this.destination = destination;
    }

    public String getDestination() {return destination;}

    @Override
    public String toString() {
        return "Retrait{" + "destination='" + destination + '\'' + ", numero='" + numero + '\'' + ", date=" + date + ", montant=" + montant + '}';
    }

}
