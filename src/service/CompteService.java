package service;

import model.Compte;
import model.CompteCourant;
import model.CompteEpargne;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class CompteService {

    private HashMap<String, Compte> comptes = new HashMap<>();

    public String CreerCompteCourant(double decouvert){
        CompteCourant c = new CompteCourant(decouvert);
        comptes.put(c.getCode(), c);
        return c.getCode();
    }

    public String creerCompteEpargne(double taux){
        CompteEpargne c = new CompteEpargne(taux);
        comptes.put(c.getCode(), c);
        return c.getCode();
    }

    public Optional<Compte> rechercherCompte(String code){
        return Optional.ofNullable(comptes.get(code));
    }

    public List<Compte> ListerTousLesComptes(){
        return new ArrayList<>(comptes.values());
    }

    public <T extends Compte> List<Compte> filtrerComptesParType(Class<T> type){
        List<Compte> result = new ArrayList<>();
        for (Compte c : comptes.values()){
            if (type.isInstance(c)){
                result.add(c);
            }
        }
        return result;
    }

    public double calculerSoldeTotal(){
        return comptes.values().stream().mapToDouble(Compte::getSolde).sum();
    }




}

