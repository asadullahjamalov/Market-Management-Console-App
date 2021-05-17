package com.company.util.operation;

import com.company.base.Market;
import com.company.base.Product;
import com.company.base.Sale;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

public class SaleUtil {
    public static void addSale() {
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

    public static void showAllSales() {
        for (Sale sale : Market.saleList) {
            printSaleDetails(sale);
            System.out.println("---------------");
        }
    }

    public static void showAllSalesBasedOnAmountInterval() {
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

    public static void showSaleDetailsBasedOnSaleNumber() {
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

    public static void showAllSalesBasedOnDate() {
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

    public static void showAllSalesBasedOnDateInterval() {
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

    public static void removeSale() {
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


    public static void returnProductFromSale() {
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

    public static Sale addSaleDetails(Market market) {
        System.out.println("There are following products in the stock of Market");
        ProductUtil.showAllProducts();
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
