package com.example.demo.dto;

public class InventoryItemDto {
    private String pName;
    private int qty;
    private float totalPrice;
    public String productBarcodes;

    public InventoryItemDto() {
    }

    public InventoryItemDto(String pName, float totalPrice, int qty, String productBarcodes) {
        this.pName = pName;
        this.totalPrice = totalPrice;
        this.qty = qty;
        this.productBarcodes = productBarcodes;
    }


    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getProductBarcodes() {
        return productBarcodes;
    }

    public void setProductBarcodes(String productBarcodes) {
        this.productBarcodes = productBarcodes;
    }

    public void updateQty(int qty) {
        this.qty += qty;
    }

    public void updateTotalPrice(float totalPrice) {
        this.totalPrice += totalPrice;
    }

    public void appendBarcodes(String productBarcodes) {
        if (this.productBarcodes == null)
            this.productBarcodes = productBarcodes;
        else
            this.productBarcodes += "," + productBarcodes;
    }
}