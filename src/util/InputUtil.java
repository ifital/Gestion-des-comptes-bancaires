package util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputUtil {

    private static Scanner scanner = new Scanner(System.in);

    public static int LireEntier(String message){

        while (true){
            try{
                System.out.println(message);
                return scanner.nextInt();
            }catch (InputMismatchException e){
                System.out.println("Erreur : Veuillez saisir un nombre entier valide");
                scanner.nextLine();
            }
        }
    }

    public  static double LireDouble(String message){
        while (true) {
            try {
                System.out.print(message);
                double value = scanner.nextDouble();
                if (ValidationUtil.validerMontantPositif(value)) return value;
                System.out.println("Erreur : Le montant doit être positif.");
            } catch (InputMismatchException e) {
                System.out.println("Erreur : Veuillez saisir un nombre valide.");
                scanner.nextLine();
            }
        }
    }

    public static String lireChaine(String message) {
        System.out.print(message);
        scanner.nextLine();
        return scanner.nextLine();
    }

    public static String lireChaineNonVide(String message) {
        String input;
        do {
            input = lireChaine(message);
            if (!ValidationUtil.validerChaineNonVide(input))
                System.out.println("Erreur : La saisie ne peut pas être vide.");
        } while (!ValidationUtil.validerChaineNonVide(input));
        return input.trim();
    }

    public static void fermerScanner() { scanner.close(); }
}

