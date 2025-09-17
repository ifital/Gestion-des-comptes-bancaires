package model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class Retrait extends Operation {

    private String destination;

    public Retrait(String numero, LocalDateTime date, double montant, String destination) {
        super(numero, date, montant);
        this.destination = destination;
    }

}
