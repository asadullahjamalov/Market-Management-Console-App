package com.company.base;

import java.util.LinkedList;
import java.util.List;

/**
 * Documentation for Market Management Console App
 * <p>
 * Market Management Console App consists of three main packages: base, util.menu, util.operation.
 * <p>
 * There are four classes and one enum in base package: Product, Sale, Market, Main classes and Category enum.
 * Product class consists of five fields:
 *  <ul>
 *   <li>productName,</li>
 *   <li>productPrice,</li>
 *   <li>productCategory,</li>
 *   <li>productQuantity.</li>
 *   <li>productNumber.</li>
 *  </ul>
 * <p>
 * Sale class consists of five fields:
 * <ul>
 *  <li>saleNumber,</li>
 *  <li>saleProductList,</li>
 *  <li>saleDate,</li>
 *  <li>saleAmount. (I gave BigDecimal type to this field, because here we need accurate result)</li>
 *  </ul>
 * <p>
 * Market class consists of Sale and Product lists to save data.
 * Main class have main method to initialize Market Management Console App
 * Category enum consists of product categories: BAKERY, DRINKS, SNACKS,
 * MEATS, DAIRY, FRUITS, CLEANING_GOODS, HEALTHCARE, PET_CARE
 * <p>
 * There are three classes in util.menu package: MainMenu, ProductMenu, SaleMenu classes.
 * <ul>
 *  <li>MainMenu class represents the initial menu of Market Management Console App.</li>
 *  <li>ProductMenu provides links to the product related operations.</li>
 *  <li>SaleMenu provides links to the sale related operations.</li>
 *  </ul>
 * <p>
 * <p>
 * util.operation package has two most important classes which are doing all the operations in this app.
 *
 * <ul>
 *  <li>ProductUtil class:
 *  <ul>
 *  <li>addProduct(),</li>
 *  <li>editProduct(),</li>
 *  <li>removeProduct(),</li>
 *  <li>showAllProducts(),</li>
 *  <li>showAllProductsBasedOnCategory(),</li>
 *  <li>showAllProductsBasedOnPriceInterval(),</li>
 *  <li>changeProductPrice(), (not required by client, but added by me for making app user-friendly)</li>
 *  <li>searchAllProductsBasedOnName().</li>
 *  </ul>
 *  </li>
 *  <li>SaleUtil class:<ul>
 *  <li>addSale(),</li>
 *  <li>showAllSales(),</li>
 *  <li>showAllSalesBasedOnAmountInterval(),</li>
 *  <li>showSaleDetailsBasedOnSaleNumber(),</li>
 *  <li>showAllSalesBasedOnDate(),</li>
 *  <li>showAllSalesBasedOnDateInterval(),</li>
 *  <li>removeSale(),</li>
 *  <li>returnProductFromSale().</li>
 *  </ul>
 *  </li>
 * </ul>
 *
 * <p>
 * Lastly, I want to highlight the differences between my application and requested one:
 *  <ul>
 *   <li>There was one required class SaleItem which consists of only duplicate information (don't considering
 *  saleItemNumber (kind of ID)) fields (productQuantity and saleItemQuantity represents the same meaning).
 *  That is why, for decreasing complexity, I omit SaleItem class, and include List<Product> saleProductList
 *  instead of List<SaleItem> saleItemList in Sale class.</li>
 *   <li>I add one method (changeProductPrice) to the product operations. I think, this operation is
 *   one of the useful operations in real life.</li>
 *   <li>I also added Return to Main Menu option in ProductMenu and SaleMenu to provide
 *   convenience and make Market Management Console App more user-friendly.</li>
 *  </ul>
 */

public class Market {
    public static List<Product> productList = new LinkedList<>();
    public static List<Product> soldProductList = new LinkedList<>();
    public List<Product> soldProductListNonStatic = new LinkedList<>();
    //    public static List<Product> saleItemList = new LinkedList<>();
    public static List<Sale> saleList = new LinkedList<>();
//    public static List<Sale> removedSaleList = new LinkedList<>();
//    public static List<Sale> returnedProductList = new LinkedList<>();

}
