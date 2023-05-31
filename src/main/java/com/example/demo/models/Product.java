package com.example.demo.models;

import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;


@Entity
/*@Table(name = "products", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"nom"})
})*/
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(unique=true)
    @NotBlank
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
