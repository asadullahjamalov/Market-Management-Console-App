package com.company.util.menu;

import java.util.Scanner;

import static com.company.util.operation.ProductUtil.*;

public class ProductMenu {
    public static void showProductMenu() {
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
                    || choice.equals("7") || choice.equals("8") || choice.equals("9"))  {
                switch (choice) {
                    case "1":
                        addProduct();
                        break;
                    case "2":
                        editProduct();
                        break;
                    case "3":
                        removeProduct();
                        break;
                    case "4":
                        changeProductPrice();
                        break;
                    case "5":
                        showAllProducts();
                        break;
                    case "6":
                        showAllProductsBasedOnCategory();
                        break;
                    case "7":
                        showAllProductsBasedOnPriceInterval();
                        break;
                    case "8":
                        searchAllProductsBasedOnName();
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
