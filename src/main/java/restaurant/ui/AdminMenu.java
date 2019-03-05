package restaurant.ui;

import org.apache.log4j.Logger;
import restaurant.service.Service;

import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.System.exit;

public class AdminMenu {
    private static final Logger logger = Logger.getLogger(AdminMenu.class);
    private final String password = "www";
    private Menu menu = new Menu();
    private Service service = Service.getInstance();
    private Scanner scanner = new Scanner(System.in);


    public void displayMenu() {
        check();
        menu.format("ADMIN MENU:", "1: Create Item",
                "2: Items",
                "3: Update Item", "4: Delete Item",
                "5: Menu",
                "0: Exit","SELECT OPTION:");
        options();
    }

    private void options() {
        Integer index = 3;
        try {
            while (true) {
                switch (scanner.nextInt()) {
                    case 1:
                        service.read(index);
                        break;
                    case 2:

                        break;
                    case 3:
                        break;
                    case 4:

                        break;
                    case 5:
                        new Menu().displayMenu();
                    case 0:
                        exit(0);
                    default:
                        logger.warn("Illegal argument");
                        displayMenu();
                }
            }
        } catch (InputMismatchException e) {
            logger.warn("Number format expected");
            displayMenu();
        }
    }


    private void check () {
        menu.format("Enter password:");
        if ((scanner.nextLine()).equals(password)) {
            return;
        } else {
            logger.info("Invalid password");
            new Menu().displayMenu();
        }
    }
}