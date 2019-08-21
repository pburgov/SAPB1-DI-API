package com.pburgov.sapb1.model;

public class SalesOrderLine {

    private String itemCode;
    private Double price;
    private Double quantity;

    public SalesOrderLine() {
    }

    public SalesOrderLine( String itemCode, Double price, Double quantity ) {
        this.itemCode = itemCode;
        this.price = price;
        this.quantity = quantity;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode( String itemCode ) {
        this.itemCode = itemCode;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice( Double price ) {
        this.price = price;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity( Double quantity ) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "SalesOrderLines [itemCode=" + itemCode + ", price=" + price + ", quantity=" + quantity + "]";
    }

}
