package com.example.demo.services;

import com.example.demo.dto.InventoryItemDto;
import com.example.demo.dto.ProductDto;
import com.example.demo.models.Product;
import com.example.demo.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

import java.util.*;


@Service
@Validated
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public List<InventoryItemDto> getInventoryList() {

        Map<String, InventoryItemDto> inventory = new TreeMap<>();//order by key asc

        productRepository.findAll()
                .forEach(p -> {
                    String key = p.getNom().toLowerCase();
                    if (inventory.containsKey(key)) {
                        InventoryItemDto inventoryItemDto = inventory.get(key);

                        inventoryItemDto.updateQty(inventoryItemDto.getQty());
                        inventoryItemDto.updateTotalPrice(inventory.get(key).getTotalPrice());
                        inventoryItemDto.appendBarcodes(inventory.get(key).getProductBarcodes());
                    } else {
                        inventory.put(key, new InventoryItemDto(p.getNom(), p.getPrice(), p.getQuantity(), p.getBarcode()));
                    }
                });

        return inventory.values().stream().toList();
    }

    @Override
    public Product createNewProduct(Product product) {
        product.setNom(product.getNom().trim());
        return productRepository.save(product);
    }

    @Override
    public void deleteProductBy(int id) {
        this.productRepository.deleteById(id);
    }

    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public Product updateExistingProduct(int productId, @Valid ProductDto productDto) {
        Product Product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Product not found"));

        Product.setNom(productDto.getNom());
        Product.setQuantity(productDto.getQuantity());
        Product.setBarcode(productDto.getBarcode());
        Product.setPrice(productDto.getPrice());
        Product.setState(productDto.getState());

        return Product;
    }

}


