package model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class Versement extends Operation {

    private String source;

    public Versement(String numero, LocalDateTime date, double montant, String source) {
        super(numero, date, montant);
        this.source = source;
    }

}
