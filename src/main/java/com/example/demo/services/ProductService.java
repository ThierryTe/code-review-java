package com.example.demo.services;

import com.example.demo.dto.InventoryItemDto;
import com.example.demo.dto.ProductDto;
import com.example.demo.models.Product;

import java.util.List;
import java.util.Optional;


public interface ProductService {

    public List<InventoryItemDto> getInventoryList();

    public Product createNewProduct(Product product);

    public void deleteProductBy(int id);

    Iterable<Product> findAll();

    Optional<Product> findById(int id);

    Product updateExistingProduct(int productId, ProductDto product);
}