package com.company.base;

import com.company.base.Category;

public class Product {
    private String productName;
    private double productPrice;
    private Category productCategory;
    private int productQuantity;
    private long productNumber;
    private static long productUniqueNumber = 10000;


    public Product(String productName, double productPrice, Category productCategory, int productQuantity) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productCategory = productCategory;
        this.productQuantity = productQuantity;
        productUniqueNumber++;
        productNumber = productUniqueNumber;
    }

    public Product(String productName, double productPrice, Category productCategory, int productQuantity, long productNumber) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productCategory = productCategory;
        this.productQuantity = productQuantity;
        this.productNumber = productNumber;
    }

    public long getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(long productNumber) {
        this.productNumber = productNumber;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public Category getProductCategory() {
        return productCategory;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public String getProductName() {
        return productName;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", productCategory=" + productCategory.name() +
                ", productQuantity=" + productQuantity +
                ", productNumber=" + productNumber +
                '}';
    }
}
