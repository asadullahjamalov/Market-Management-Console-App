package com.company.base;


import com.company.base.Product;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class Sale {
    private long saleNumber;
    //    private List<SaleItem> saleItem = new LinkedList<>();
    private List<Product> saleProductList = new LinkedList<>();
    private BigDecimal saleAmount;
    private LocalDate saleDate;
    private static int saleUniqueNumber = 100000;

    public Sale() {
    }

    public Sale(List<Product> saleProductList, LocalDate saleDate) {
        this.saleProductList = saleProductList;
        this.saleDate = saleDate;
        saleUniqueNumber++;
        this.saleNumber = saleUniqueNumber;
    }

    public List<Product> getSaleProductList() {
        return saleProductList;
    }

    public long getSaleNumber() {
        return saleNumber;
    }

    public LocalDate getSaleDate() {
        return saleDate;
    }


    public BigDecimal getSaleAmount() {
        saleAmount = new BigDecimal(0);
        for (Product product : this.getSaleProductList()) {
            saleAmount = saleAmount.add(BigDecimal.valueOf(product.getProductPrice()).multiply(
                    BigDecimal.valueOf(product.getProductQuantity())));
        }
        return saleAmount;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "saleNumber=" + saleNumber +
                ", saleProduct=" + saleProductList +
                ", saleDate=" + saleDate +
                '}';
    }
}
