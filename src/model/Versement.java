package model;

import java.time.LocalDateTime;

public class Versement extends Operation {

    private String source;

    public String getSource() {
        return source;
    }

    public Versement(String numero, LocalDateTime date, double montant, String source) {
        super(numero, date, montant);
        this.source = source;
    }

}
