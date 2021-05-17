package com.company.util.menu;

import java.util.Scanner;

import static com.company.util.menu.ProductMenu.showProductMenu;
import static com.company.util.menu.SaleMenu.showSaleMenu;


public class MainMenu {

    public static void showMainMenu() {
        OUT:
        while (true) {
            System.out.println("Choose one of the choices in the Main Menu: ");
            System.out.println("1)Product Menu (Operations on Products)");
            System.out.println("2)Sale Menu (Operations on Sales)");
            System.out.println("3)Exit");
            System.out.println("Enter your choice: ");

            Scanner scanner = new Scanner(System.in);
            String choice = scanner.nextLine();

            if (choice.equals("1") || choice.equals("2") || choice.equals("3")) {
                switch (choice) {
                    case "1":
                        showProductMenu();
                        break;
                    case "2":
                        showSaleMenu();
                        break;
                    case "3":
                        break OUT;
                }
            } else {
                System.out.println("There is not such choice," +
                        " please enter between 1-3");
                continue;
            }


        }

    }

}
