package service;

import model.Compte;
import model.Operation;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class OperationService {

    private CompteService compteService;

    public OperationService(CompteService compteService) {
        this.compteService = compteService;
    }

    public boolean verser(String code, double montant, String source) {
        return compteService.rechercherCompte(code)
                .map(c -> { c.verser(montant, source); return true; })
                .orElse(false);
    }

    public boolean retirer(String code, double montant, String destination) {
        return compteService.rechercherCompte(code)
                .map(c -> { c.retirer(montant, destination); return true; })
                .orElse(false);
    }

    public boolean effectuerVirement(String codeSource, String codeDest, double montant){

        Optional<Compte> sourceOpt = compteService.rechercherCompte(codeSource);
        Optional<Compte> destOpt = compteService.rechercherCompte(codeDest);

        if (sourceOpt.isPresent() && destOpt.isPresent()){
            Compte source = sourceOpt.get();
            Compte dest = destOpt.get();

            if (source.retirer(montant, "verment vers" + dest.getCode())){
                dest.verser(montant, source.getCode());
                return true ;
            }
        }
        return false ;
    }

    public List<Operation> obtenirOperationsParCompte(String code){

        return compteService.rechercherCompte(code)
                .map(Compte::getListeOperations)
                .orElse(Collections.emptyList());
    }
}
