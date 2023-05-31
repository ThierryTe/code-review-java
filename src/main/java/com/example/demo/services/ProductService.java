package com.example.demo.services;

import com.example.demo.dto.InventoryItemDto;
import com.example.demo.models.Product;

import java.util.List;


public interface ProductService {

    public List<InventoryItemDto> getProductsData();

    public Product saveProduct(Product product);

    public void deleteProduct(int id);
}