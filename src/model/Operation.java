package model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@ToString
public abstract class Operation {

    protected String numero;
    protected LocalDateTime date;
    protected double montant;

    public Operation(String numero, LocalDateTime date, double montant) {
        this.numero = UUID.randomUUID().toString();
        this.date = LocalDateTime.now() ;
        this.montant = montant;
    }

}

