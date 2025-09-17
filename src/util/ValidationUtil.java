package util;

import java.util.Stack;
import java.util.regex.Pattern;

public class ValidationUtil {

    private static final Pattern CODE_Pattern = Pattern.compile("CPT-\\d{5}");

    public static boolean ValiderCodeCompte(String code){
        return code != null && CODE_Pattern.matcher(code).matches();
    }

    public static boolean validerMontantPositif(double montant){
        return montant > 0 ;
    }

    public static boolean validerChaineNonVide(String chaine){
            return chaine != null && !chaine.trim().isEmpty();
    }

    public  static String GenererCodeCompte(int numero){
        return String.format("CPT-05d" + numero);
    }
}
