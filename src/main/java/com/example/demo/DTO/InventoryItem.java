package com.example.demo.DTO;

public class InventoryItem {
    private final String pName;
    private int qty;
    private float totalPrice;
    public String productBarcodes;

    public InventoryItem(String pName, float totalPrice, int qty, String productBarcodes) {
        this.pName = pName;
        this.totalPrice = totalPrice;
        this.qty = qty;
        this.productBarcodes = productBarcodes;
    }


    public String getpName() {
        return pName;
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
}