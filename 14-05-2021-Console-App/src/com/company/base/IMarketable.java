package com.company.base;

public interface IMarketable {
    void addProduct();

    void editProduct();

    void removeProduct();

    void showAllProducts();

    void showAllProductsBasedOnCategory();

    void showAllProductsBasedOnPriceInterval();

    void searchAllProductsBasedOnName();

    void addSale();

    void showAllSales();

    void showAllSalesBasedOnAmountInterval();

    void showSaleDetailsBasedOnSaleNumber();

    void showAllSalesBasedOnDate();

    void showAllSalesBasedOnDateInterval();

    void removeSale();

    void returnProductFromSale();

}
