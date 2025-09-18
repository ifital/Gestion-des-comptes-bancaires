import ui.MenuBancaire;
import service.CompteService;
import service.OperationService;

public class Main {
    public static void main(String[] args) {
        CompteService compteService = new CompteService();
        OperationService operationService = new OperationService(compteService);

        MenuBancaire menu = new MenuBancaire(compteService, operationService);
        menu.demarrer();
    }
}

