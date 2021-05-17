package com.company.base;

import com.company.util.menu.*;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // Adding products to the Market Stock
        Market.productList.add(new Product("bread", 0.5, Category.BAKERY, 200));
        Market.productList.add(new Product("beef", 12, Category.MEATS, 30));
        Market.productList.add(new Product("toothpaste", 1.2, Category.CLEANING_GOODS, 100));
        Market.productList.add(new Product("cola", 1, Category.DRINKS, 70));
        Market.productList.add(new Product("sirab_water", 0.7, Category.DRINKS, 40));
        Market.productList.add(new Product("cheese", 7.5, Category.DAIRY, 40));

        // Adding Sales
        List<Product> saleProductList1 = new LinkedList<>();
        saleProductList1.add(new Product("fanta", 0.9, Category.DRINKS, 4));
        saleProductList1.add(new Product("pizza", 8, Category.BAKERY, 2));
        Sale sale1 = new Sale(saleProductList1, LocalDate.of(2020, 7, 8));

        List<Product> saleProductList2 = new LinkedList<>();
        saleProductList2.add(new Product("milk", 1.7, Category.DAIRY, 2));
        saleProductList2.add(new Product("cat_food", 4.5, Category.DRINKS, 1));
        Sale sale2 = new Sale(saleProductList2, LocalDate.of(2021, 2, 19));

        Market.saleList.add(sale1);
        Market.saleList.add(sale2);


        MainMenu.showMainMenu();

    }


}
