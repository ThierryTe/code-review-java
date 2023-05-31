package com.example.demo.dto;

import com.example.demo.models.State;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class ProductDto {
    @NotEmpty
    private String nom;
    @Min(1)
    private float price;

    @Min(0)
    private int quantity;
    private String barcode;

    @Nullable
    public State getState() {
        return state;
    }

    public void setState(@Nullable State state) {
        this.state = state;
    }

    @Nullable
    @Enumerated(EnumType.STRING)
    private State state;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
