package com.company.base;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;


public class Market implements IMarketable {
    public static List<Product> productList = new LinkedList<>();
    public static List<Product> soldProductList = new LinkedList<>();
    public List<Product> soldProductListNonStatic = new LinkedList<>();
    //    public static List<Product> saleItemList = new LinkedList<>();
    public static List<Sale> saleList = new LinkedList<>();
//    public static List<Sale> removedSaleList = new LinkedList<>();
//    public static List<Sale> returnedProductList = new LinkedList<>();


    public void addProduct() {
        Product product = addProductDetails();
        Market.productList.add(product);
    }

    public void editProduct() {
        showAllProducts();
        System.out.println("Enter the number (code) of product to edit: ");
        Scanner scanner = new Scanner(System.in);
        long productNumber = scanner.nextLong();
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

    public void removeProduct() {
        showAllProducts();
        System.out.println("Enter the number (code) of product to remove: ");
        Scanner scanner = new Scanner(System.in);
        long productNumber = scanner.nextLong();
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

    public void showAllProducts() {
        for (Product product : Market.productList) {
            System.out.println(product.toString());
        }
    }

    public void showAllProductsBasedOnCategory() {
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

    public void showAllProductsBasedOnPriceInterval() {
        System.out.println("Enter minimum product price");
        Scanner scanner2 = new Scanner(System.in);
        double productPriceMin = scanner2.nextDouble();
        while (productPriceMin <= 0) {
            System.out.println("Product price can not be negative or zero");
            System.out.println("Enter minimum product price: ");
            productPriceMin = scanner2.nextDouble();
        }

        System.out.println("Enter maximum product price");
        Scanner scanner1 = new Scanner(System.in);
        double productPriceMax = scanner1.nextDouble();
        while (productPriceMax <= 0) {
            System.out.println("Product price can not be negative or zero");
            System.out.println("Enter maximum product price: ");
            productPriceMax = scanner1.nextDouble();
        }
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

    public void searchAllProductsBasedOnName() {
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

    public void changeProductPrice() {
        showAllProducts();
        System.out.println("Enter the number (code) of product to change price: ");
        Scanner scanner = new Scanner(System.in);
        long productNumber = scanner.nextLong();
        int count = 0;
        for (Product product : Market.productList) {
            count++;
            if (product.getProductNumber() == productNumber) {
                count--;
                System.out.println("Enter new price of product");
                Scanner scanner2 = new Scanner(System.in);
                double productPrice = scanner2.nextDouble();
                while (productPrice <= 0) {
                    System.out.println("Product prize can not be negative or zero");
                    System.out.println("Enter new price of product: ");
                    productPrice = scanner2.nextDouble();
                }
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

        System.out.println("Enter product price");
        Scanner scanner2 = new Scanner(System.in);
        double productPrice = scanner2.nextDouble();
        while (productPrice <= 0) {
            System.out.println("Product prize can not be negative or zero");
            System.out.println("Enter product price: ");
            productPrice = scanner2.nextDouble();
        }

        Category productCategory = categorySelector();

        System.out.println("Enter product quantity");
        Scanner scanner4 = new Scanner(System.in);
        int productQuantity = scanner4.nextInt();
        while (productQuantity <= 0) {
            System.out.println("Product quantity can not be negative or zero ");
            System.out.println("Enter product quantity");
            productQuantity = scanner4.nextInt();
        }
        Product product = new Product(productName, productPrice, productCategory, productQuantity);
        return product;
    }

//    public static void sortProductList() {
//        Collections.sort(Market.productList, new Comparator<Product>() {
//            @Override
//            public int compare(Product p1, Product p2) {
//                return (int) (p1.getProductNumber() - p2.getProductNumber());
//            }
//        });
//    }


    public void addSale() {
        Market market = new Market();
        Sale sale = addSaleDetails(market);
        while (true) {
            System.out.println("----------------------------");
            System.out.println("Do you want to add more products to the sale?");
            System.out.println("If yes, click 'y' or 'Y' " +
                    ",if no, click any other key (enter key is enough) to continue");
            Scanner scanner3 = new Scanner(System.in);
            String answer = scanner3.nextLine();
            if ("y".equalsIgnoreCase(answer)) {
                sale = addSaleDetails(market);
            } else {
                break;
            }
        }
        if (sale.getSaleProductList().size() > 0) {
            Market.saleList.add(sale);
            System.out.println("Sale added");
        }

    }

    public void showAllSales() {
        for (Sale sale : Market.saleList) {
            printSaleDetails(sale);
            System.out.println("---------------");
        }
    }

    public void showAllSalesBasedOnAmountInterval() {
        System.out.println("Enter minimum sale amount (in AZN)");
        Scanner scanner1 = new Scanner(System.in);
        double saleAmountMin = scanner1.nextDouble();
        while (saleAmountMin <= 0) {
            System.out.println("Sale amount can not be negative or zero");
            System.out.println("Enter minimum sale amount (in AZN)");
            saleAmountMin = scanner1.nextDouble();
        }

        System.out.println("Enter maximum sale amount (in AZN)");
        Scanner scanner2 = new Scanner(System.in);
        double saleAmountMax = scanner2.nextDouble();
        while (saleAmountMax <= 0) {
            System.out.println("Sale amount can not be negative or zero");
            System.out.println("Enter maximum sale amount (in AZN)");
            saleAmountMax = scanner2.nextDouble();
        }

        BigDecimal saleAmountMaxBigDecimal = BigDecimal.valueOf(saleAmountMax);
        BigDecimal saleAmountMinBigDecimal = BigDecimal.valueOf(saleAmountMin);

        if (saleAmountMax >= saleAmountMin) {
            int count = 0;
            for (Sale sale : Market.saleList) {
                count++;
                if (sale.getSaleAmount().compareTo(saleAmountMaxBigDecimal) <= 0
                        && sale.getSaleAmount().compareTo(saleAmountMinBigDecimal) >= 0) {
                    count--;
                    printSaleDetails(sale);
                    System.out.println("---------------");
                } else if (Market.saleList.size() == count) {
                    System.out.println("There is not any sale in this (" + saleAmountMin + " - " + saleAmountMax +
                            " AZN) interval");
                }
            }
        } else {
            System.out.println("Maximum price can not be less than minimum price");
        }

    }

    public void showSaleDetailsBasedOnSaleNumber() {
        System.out.println("Sales are ");
        for (Sale sale : Market.saleList) {
            System.out.println("Sale Number " + sale.getSaleNumber());
        }
        System.out.println("Enter the Sale Number ");
        Scanner scanner = new Scanner(System.in);
        long saleNumber = scanner.nextLong();
        int count = 0;
        for (Sale sale : Market.saleList) {
            count++;
            if (sale.getSaleNumber() == saleNumber) {
                count--;
                printSaleDetails(sale);
                break;
            } else if (Market.saleList.size() == count) {
                System.out.println("There is not such sale with this number");
            }
        }
    }

    public void showAllSalesBasedOnDate() {
        LocalDate date = addDateDetails();
        int count = 0;
        for (Sale sale : Market.saleList) {
            count++;
            if (sale.getSaleDate().equals(date)) {
                count--;
                printSaleDetails(sale);
                System.out.println("---------------");
            } else if (Market.saleList.size() == count) {
                System.out.println("There is not any sale in this (" + date +
                        ") date");
            }
        }

    }

    public void showAllSalesBasedOnDateInterval() {
        System.out.println("Enter the details of starting year");
        LocalDate firstDate = addDateDetails();
        System.out.println("Enter the details of stopping year");
        LocalDate lastDate = addDateDetails();

        int count = 0;
        if (firstDate.isBefore(lastDate)) {
            for (Sale sale : Market.saleList) {
                count++;
                for (LocalDate date = firstDate; date.isBefore(lastDate.plusDays(1)); date = date.plusDays(1)) {
                    if (sale.getSaleDate().equals(date)) {
                        count--;
                        printSaleDetails(sale);
                        System.out.println("---------------");
                    }
                }
                if (Market.saleList.size() == count) {
                    System.out.println("There is not any sale in this (from " + firstDate + "to" + lastDate +
                            ") date interval ");
                }
            }
        }
    }

    public void removeSale() {
        showAllSales();
        System.out.println("Enter the number (code) of sale to remove: ");
        Scanner scanner = new Scanner(System.in);
        long saleNumber = scanner.nextLong();
        int count = 0;
        long removedSaleNumber = 0;
        Sale removedSale = new Sale();
        for (Sale sale : Market.saleList) {
            count++;
            if (sale.getSaleNumber() == saleNumber) {
                count--;
                removedSaleNumber = saleNumber;
                removedSale = sale;
                Market.saleList.remove(sale);
                System.out.println("Sale was removed, successfully");
                break;
            } else if (Market.saleList.size() == count) {
                System.out.println("There is not such sale with this number (code)");
            }
        }
        if (removedSaleNumber == saleNumber) {
            returnToProductList(removedSale.getSaleProductList());
        }
    }


    public void returnProductFromSale() {
        showAllSales();
        System.out.println("Enter the number (code) of sale to return: ");
        Scanner scanner = new Scanner(System.in);
        long saleNumber = scanner.nextLong();
        int count = 0;
        long removedSaleNumber = 0;
        Sale removedSale = new Sale();
        for (Sale sale : Market.saleList) {
            count++;
            if (sale.getSaleNumber() == saleNumber) {
                count--;
                removedSaleNumber = saleNumber;
                removedSale = sale;
                System.out.println("***************************");
                printSaleDetails(removedSale);
                System.out.println("Enter the number (code) of product to return:");
                Scanner scanner2 = new Scanner(System.in);
                long returnedProductNumber = scanner2.nextLong();
                int count1 = 0;
                for (Product product : sale.getSaleProductList()) {
                    count1++;
                    if (product.getProductNumber() == returnedProductNumber) {
                        count1--;
                        sale.getSaleProductList().remove(product);
                        Market.productList.add(product);
                        stabilizeProductList();
                        System.out.println("Product was returned, successfully");
                        break;
                    } else if (sale.getSaleProductList().size() == count1) {
                        System.out.println("There is not such product with this number (code) in this sale");
                    }
                }
                break;
            } else if (Market.saleList.size() == count) {
                System.out.println("There is not such sale with this number (code)");
            }
        }


    }


//Helper Methods

    public Sale addSaleDetails(Market market) {
        System.out.println("There are following products in the stock of Market");
        showAllProducts();
        System.out.println("Enter the number (code) of product to buy: ");
        Scanner scanner = new Scanner(System.in);
        long productNumber = scanner.nextLong();
        System.out.println("Enter the quantity of product to buy: ");
        Scanner scanner2 = new Scanner(System.in);
        int saleQuantity = scanner.nextInt();
        int count = 0;
        for (Product product : Market.productList) {
            count++;
            if (product.getProductNumber() == productNumber && product.getProductQuantity() >= saleQuantity) {
                Product editedProduct = new Product(product.getProductName(), product.getProductPrice()
                        , product.getProductCategory(), product.getProductQuantity() - saleQuantity,
                        product.getProductNumber());
                Market.productList.add(editedProduct);
                Market.productList.remove(product);
                Product soldProduct = new Product(product.getProductName(), product.getProductPrice()
                        , product.getProductCategory(), saleQuantity, product.getProductNumber());
                market.soldProductListNonStatic.add(soldProduct);
                Market.soldProductList.add(soldProduct);
                Collections.sort(Market.productList, new Comparator<Product>() {
                    @Override
                    public int compare(Product p1, Product p2) {
                        return (int) (p1.getProductNumber() - p2.getProductNumber());
                    }
                });
                System.out.println("Product was added to sale, successfully");
                break;
            } else if (Market.productList.size() == count) {
                System.out.println("There is not such product (/amount of product) in the stock");
            }
        }
        Sale sale = new Sale(market.soldProductListNonStatic, LocalDate.now());
        return sale;
    }

    public static void printSaleDetails(Sale sale) {
        System.out.println("Sale Date is " + sale.getSaleDate());
        System.out.println("Sale Amount is " + sale.getSaleAmount());
        System.out.println("Sale Number is " + sale.getSaleNumber());
        for (Product product : sale.getSaleProductList()) {
            System.out.println(product.toString());
        }
    }

    public static LocalDate addDateDetails() {
        while (true) {
            System.out.println("---------------------");
            System.out.println("Enter the Sale Year ");
            Scanner scanner1 = new Scanner(System.in);
            int saleYear = scanner1.nextInt();

            System.out.println("Enter the Sale Month ");
            Scanner scanner2 = new Scanner(System.in);
            int saleMonth = scanner2.nextInt();

            System.out.println("Enter the Sale Day ");
            Scanner scanner3 = new Scanner(System.in);
            int saleDay = scanner3.nextInt();

            if (saleYear <= LocalDate.now().getYear() && saleMonth <= 12
                    && saleMonth >= 1 && saleDay >= 1 && saleDay <= 31 &&
                    LocalDate.of(saleYear, saleMonth, saleDay).isBefore(LocalDate.now().plusDays(1))) {
                return LocalDate.of(saleYear, saleMonth, saleDay);
            } else {
                System.out.println("You entered something wrong");
                System.out.println("Please, enter correct date format");
            }
        }
    }

    public static void returnToProductList(List<Product> returnedProductList) {
        for (Product product : returnedProductList) {
            Market.productList.add(product);
        }
        stabilizeProductList();
    }


    public static void stabilizeProductList() {
        sortProductList();
        for (int i = 1; i < Market.productList.size(); i++) {
            if (Market.productList.get(i).getProductNumber() == Market.productList.get(i - 1).getProductNumber()) {
                Product correctedProduct = new Product(Market.productList.get(i - 1).getProductName(),
                        Market.productList.get(i - 1).getProductPrice(), Market.productList.get(i - 1).getProductCategory(),
                        Market.productList.get(i - 1).getProductQuantity() + Market.productList.get(i).getProductQuantity(),
                        Market.productList.get(i - 1).getProductNumber());
                Market.productList.add(i + 1, correctedProduct);
                Market.productList.remove(Market.productList.get(i));
                Market.productList.remove(Market.productList.get(i - 1));
                continue;
            }
        }
        sortProductList();
    }

    public static void sortProductList() {
        Collections.sort(Market.productList, new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                return (int) (p1.getProductNumber() - p2.getProductNumber());
            }
        });
    }


}
