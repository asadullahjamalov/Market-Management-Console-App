package com.company.base;

import com.company.base.Product;

public class SaleItem {

    private Product saleItemProduct;
    private long saleItemNumber;
    private int saleItemQuantity;


    public SaleItem(Product saleItemProduct, int saleItemQuantity) {
        this.saleItemProduct = saleItemProduct;
        this.saleItemQuantity = saleItemQuantity;
    }


}
