package model;

import java.time.LocalDateTime;

public class Versement extends Operation {

    private String source;

    public Versement(String numero, LocalDateTime date, double montant, String source) {
        super(numero, date, montant);
        this.source = source;
    }

    public String getSource() {return source;}

    @Override
    public String toString() {
        return "Versement{" + "source='" + source + '\'' + ", numero='" + numero + '\'' + ", date=" + date + ", montant=" + montant + '}';}
}
