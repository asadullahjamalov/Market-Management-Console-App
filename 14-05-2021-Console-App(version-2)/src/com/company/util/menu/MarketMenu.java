package com.company.util.menu;

import com.company.base.Market;

import java.util.Scanner;

public class MarketMenu {

    public void showMainMenu() {


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

    Market myMarket = new Market();

    public void showProductMenu() {
        OUT:
        while (true) {
            System.out.println("------------------------------");
            System.out.println("Choose one of the choices in the Product Menu: ");
            System.out.println("1)Add new product");
            System.out.println("2)Edit product ");
            System.out.println("3)Remove product");
            System.out.println("4)Change price of product");
            System.out.println("5)Show all products");
            System.out.println("6)Show products based on category");
            System.out.println("7)Show products based on price interval");
            System.out.println("8)Show products based on name");
            System.out.println("9)Return to the Main Menu");
            System.out.println("Enter your choice: ");

            Scanner scanner = new Scanner(System.in);
            String choice = scanner.nextLine();

            if (choice.equals("1") || choice.equals("2") || choice.equals("3")
                    || choice.equals("4") || choice.equals("5") || choice.equals("6")
                    || choice.equals("7") || choice.equals("8") || choice.equals("9")) {
                switch (choice) {
                    case "1":
                        myMarket.addProduct();
                        break;
                    case "2":
                        myMarket.editProduct();
                        break;
                    case "3":
                        myMarket.removeProduct();
                        break;
                    case "4":
                        myMarket.changeProductPrice();
                        break;
                    case "5":
                        myMarket.showAllProducts();
                        break;
                    case "6":
                        myMarket.showAllProductsBasedOnCategory();
                        break;
                    case "7":
                        myMarket.showAllProductsBasedOnPriceInterval();
                        break;
                    case "8":
                        myMarket.searchAllProductsBasedOnName();
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


    public void showSaleMenu() {
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
                        myMarket.addSale();
                        break;
                    case "2":
                        myMarket.returnProductFromSale();
                        break;
                    case "3":
                        myMarket.removeSale();
                        break;
                    case "4":
                        myMarket.showAllSales();
                        break;
                    case "5":
                        myMarket.showAllSalesBasedOnDateInterval();
                        break;
                    case "6":
                        myMarket.showAllSalesBasedOnAmountInterval();
                        break;
                    case "7":
                        myMarket.showAllSalesBasedOnDate();
                        break;
                    case "8":
                        myMarket.showSaleDetailsBasedOnSaleNumber();
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
