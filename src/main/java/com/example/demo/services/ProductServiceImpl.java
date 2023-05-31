package com.example.demo.services;

import com.example.demo.dto.InventoryItemDto;
import com.example.demo.models.Product;
import com.example.demo.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    private static final int QUANTITY = 1;
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public List<InventoryItemDto> getProductsData() {

        Map<String, InventoryItemDto> inventory = new TreeMap<>();

        productRepository.findAll().forEach( p -> {
            String key = p.getNom().toLowerCase();
            if (inventory.containsKey(key)){

                InventoryItemDto inventoryItemDto = new InventoryItemDto();

                inventoryItemDto.setpName(key);
                inventoryItemDto.setQty(inventory.get(key).getQty() + QUANTITY);
                inventoryItemDto.setTotalPrice(p.getPrice() + inventory.get(key).getTotalPrice());

                List<String> barcodes = new ArrayList<>();
                barcodes.add(p.getBarcode());

                barcodes.add(inventory.get(key).productBarcodes);
                inventoryItemDto.setProductBarcodes(barcodes.stream().collect(Collectors.joining(",")));
            }
            else {
            inventory.put(key, new InventoryItemDto(p.getNom(), p.getPrice(), QUANTITY, p.getBarcode()));
        }
        });

        return inventory.values().stream().toList();
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(int id) {
        this.productRepository.deleteById(id);
    }

}


