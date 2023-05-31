package com.example.demo.services;

import com.example.demo.DTO.InventoryItem;
import com.example.demo.models.Product;
import com.example.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getProductsData() {
        List<Product> products = (List<Product>) productRepository.findAll();

        Map<String, Map<String, Object>> inventory = new HashMap<>();

        for (Product product : products) {
            String key = product.getNom().toLowerCase();
            if (inventory.containsKey(key)) {
                Map<String, Object> productInfo = inventory.get(key);
                int quantity = (int) productInfo.get("quantity") + 1;
                float totalPrice = (float) productInfo.get("totalPrice") + product.getPrice();
                List<String> barcodes = (List<String>) productInfo.get("barcodes");
                barcodes.add(product.getBarcode());

                productInfo.put("quantity", quantity);
                productInfo.put("totalPrice", totalPrice);
                productInfo.put("barcodes", barcodes);
            } else {
                Map<String, Object> productInfo = new HashMap<>();
                productInfo.put("quantity", 1);
                productInfo.put("totalPrice", product.getPrice());
                productInfo.put("barcodes", new ArrayList<>(Collections.singletonList(product.getBarcode())));

                inventory.put(key, productInfo);
            }
        }

        return (List<Product>) inventory;
    }

}


