package com.company.util.menu;

import java.util.Scanner;

import static com.company.util.operation.SaleUtil.*;

public class SaleMenu {

    public static void showSaleMenu() {
        OUT:
        while (true) {
            System.out.println("------------------------------");
            System.out.println("Choose one of the choices in the Sale Menu: ");
            System.out.println("1)Add new sale");
            System.out.println("2)Return product from sale");
            System.out.println("3)Remove sale");
            System.out.println("4)Show all sales");
            System.out.println("5)Show sales based on date interval");
            System.out.println("6)Show sales based on amount interval (in AZN)");
            System.out.println("7)Show sales based on date");
            System.out.println("8)Show sale details based on the sale number");
            System.out.println("9)Return to the Main Menu");
            System.out.println("Enter your choice: ");

            Scanner scanner = new Scanner(System.in);
            String choice = scanner.nextLine();

            if (choice.equals("1") || choice.equals("2") || choice.equals("3")
                    || choice.equals("4") || choice.equals("5") || choice.equals("6")
                    || choice.equals("7") || choice.equals("8") || choice.equals("9")) {
                switch (choice) {
                    case "1":
                        addSale();
                        break;
                    case "2":
                        returnProductFromSale();
                        break;
                    case "3":
                        removeSale();
                        break;
                    case "4":
                        showAllSales();
                        break;
                    case "5":
                        showAllSalesBasedOnDateInterval();
                        break;
                    case "6":
                        showAllSalesBasedOnAmountInterval();
                        break;
                    case "7":
                        showAllSalesBasedOnDate();
                        break;
                    case "8":
                        showSaleDetailsBasedOnSaleNumber();
                        break;
                    case "9":
                        break OUT;
                }
            } else {
                System.out.println("There is not such choice," +
                        " please enter between 1-9");
                continue;

            }
        }
    }
}