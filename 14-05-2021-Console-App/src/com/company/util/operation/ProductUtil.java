package com.company.util.operation;

import com.company.base.Category;
import com.company.base.Market;
import com.company.base.Product;

import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class ProductUtil {

    public static void addProduct() {
        Product product = addProductDetails();
        Market.productList.add(product);
    }

    public static void editProduct() {
        showAllProducts();
        long productNumber = getLong("Number (code) of product");
        int count = 0;
        for (Product product : Market.productList) {
            count++;
            if (product.getProductNumber() == productNumber) {
                count--;
                Product editedProduct = addProductDetails();
                long olderProductNumber = product.getProductNumber();
                editedProduct.setProductNumber(olderProductNumber);
                Market.productList.add(editedProduct);
                Market.productList.remove(product);
                sortProductList();
                break;
            } else if (Market.productList.size() == count) {
                System.out.println("There is not such product with this number (code)");
            }
        }

    }

    public static void removeProduct() {
        showAllProducts();
        long productNumber = getLong("Number (code) of product");
        int count = 0;
        for (Product product : Market.productList) {
            count++;
            if (product.getProductNumber() == productNumber) {
                count--;
                Market.productList.remove(product);
                System.out.println("Product removed successfully");
                break;
            } else if (Market.productList.size() == count) {
                System.out.println("There is not such product with this number (code)");
            }
        }
    }

    public static void showAllProducts() {
        for (Product product : Market.productList) {
            System.out.println(product.toString());
        }
    }

    public static void showAllProductsBasedOnCategory() {
        Category productCategory = categorySelector();
        int count = 0;
        for (Product product : Market.productList) {
            count++;
            if (product.getProductCategory() == productCategory) {
                count--;
                System.out.println(product.toString());
            } else if (Market.productList.size() == count) {
                System.out.println("There is not any product in this (" + productCategory.name() +
                        ") category");
            }
        }
    }

    public static void showAllProductsBasedOnPriceInterval() {
        double productPriceMin = getDouble("Minimum Price");
        double productPriceMax = getDouble("Maximum Price");
        if (productPriceMax >= productPriceMin) {
            int count = 0;
            for (Product product : Market.productList) {
                count++;
                if (product.getProductPrice() <= productPriceMax && product.getProductPrice() >= productPriceMin) {
                    count--;
                    System.out.println(product.toString());
                } else if (Market.productList.size() == count) {
                    System.out.println("There is not any product in this (" + productPriceMin + " - " + productPriceMax +
                            " AZN) interval");
                }
            }
        } else {
            System.out.println("Maximum prize can not be less than minimum price");
        }


    }

    public static void searchAllProductsBasedOnName() {
        System.out.println("Enter the name of product");
        Scanner scanner1 = new Scanner(System.in);
        String productName = scanner1.nextLine();

        int count = 0;
        for (Product product : Market.productList) {
            count++;
            if (product.getProductName().contains(productName)) {
                count--;
                System.out.println(product.toString());
            } else if (Market.productList.size() == count) {
                System.out.println("There is not any product with this '" + productName +
                        "' name part");
            }
        }
    }

    public static void changeProductPrice() {
        showAllProducts();
        long productNumber = getLong("Number (code) of product");

        int count = 0;
        for (Product product : Market.productList) {
            count++;
            if (product.getProductNumber() == productNumber) {
                count--;
                double productPrice = getDouble("Price");
                Product editedProduct = new Product(product.getProductName(), productPrice,
                        product.getProductCategory(), product.getProductQuantity());
                long olderProductNumber = product.getProductNumber();
                editedProduct.setProductNumber(olderProductNumber);
                Market.productList.add(editedProduct);
                Market.productList.remove(product);
                sortProductList();
                break;
            } else if (Market.productList.size() == count) {
                System.out.println("There is not such product with this number (code)");
            }
        }
    }


    // Helper Methods

    public static Category categorySelector() {
        System.out.println("Choose product category");
        System.out.println("1)" + Category.BAKERY.name());
        System.out.println("2)" + Category.SNACKS.name());
        System.out.println("3)" + Category.DAIRY.name());
        System.out.println("4)" + Category.DRINKS.name());
        System.out.println("5)" + Category.FRUITS.name());
        System.out.println("6)" + Category.MEATS.name());
        System.out.println("7)" + Category.HEALTHCARE.name());
        System.out.println("8)" + Category.CLEANING_GOODS.name());
        System.out.println("9)" + Category.PET_CARE.name());
        Scanner scanner3 = new Scanner(System.in);
        String categoryNumber = scanner3.nextLine();
        while (!(categoryNumber.equals("1") || categoryNumber.equals("2") || categoryNumber.equals("3")
                || categoryNumber.equals("4") || categoryNumber.equals("5") || categoryNumber.equals("6")
                || categoryNumber.equals("7") || categoryNumber.equals("8") || categoryNumber.equals("9"))) {
            System.out.println("There is not such choice," +
                    " please enter between 1-9");
            categoryNumber = scanner3.nextLine();
        }
        Category productCategory = Category.BAKERY;
        switch (categoryNumber) {
            case "1":
                productCategory = Category.BAKERY;
                break;
            case "2":
                productCategory = Category.SNACKS;
                break;
            case "3":
                productCategory = Category.DAIRY;
                break;
            case "4":
                productCategory = Category.DRINKS;
                break;
            case "5":
                productCategory = Category.FRUITS;
                break;
            case "6":
                productCategory = Category.MEATS;
                break;
            case "7":
                productCategory = Category.HEALTHCARE;
                break;
            case "8":
                productCategory = Category.CLEANING_GOODS;
                break;
            case "9":
                productCategory = Category.PET_CARE;
                break;
        }
        return productCategory;
    }

    public static Product addProductDetails() {
        System.out.println("Enter product name");
        Scanner scanner1 = new Scanner(System.in);
        String productName = scanner1.nextLine();

        double productPrice = getDouble("Price");

        Category productCategory = categorySelector();

        int productQuantity = getInteger("Quantity");

        Product product = new Product(productName, productPrice, productCategory, productQuantity);
        return product;
    }

    public static void sortProductList() {
        Collections.sort(Market.productList, new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                return (int) (p1.getProductNumber() - p2.getProductNumber());
            }
        });
    }

    public static double getDouble(String info) {
        System.out.println("[Hint - " + info + " should be entered by numbers]");
        System.out.println("Enter " + info + ":");
        while (true) {
            String str = new Scanner(System.in).next();
            if (str.matches("([0-9]+[.]?[0-9]*)")) {
                return Double.parseDouble(str);
            } else {
                System.out.println("Please enter corresponding " + info);
            }
        }
    }

    public static int getInteger(String info) {
        System.out.println("[Hint - " + info + " should be entered by numbers]");
        System.out.println("Enter " + info + ":");
        while (true) {
            String str = new Scanner(System.in).next();
            if (str.matches("([0-9]+)")) {
                return Integer.parseInt(str);
            } else {
                System.out.println("Please enter corresponding " + info);
            }
        }
    }

    public static long getLong(String info) {
        System.out.println("[Hint - " + info + " should be entered by numbers]");
        System.out.println("Enter " + info + ":");
        while (true) {
            String str = new Scanner(System.in).next();
            if (str.matches("([0-9]+)")) {
                return Long.parseLong(str);
            } else {
                System.out.println("Please enter corresponding " + info);
            }
        }
    }


}
