package com.example.demo.controllers;

import com.example.demo.dto.InventoryItemDto;
import com.example.demo.models.Product;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository productRepository;

    private final ProductService productService;

    public ProductController(ProductRepository productRepository, ProductService productService) {
        this.productRepository = productRepository;
        this.productService = productService;
    }

    @GetMapping("/")
    public ResponseEntity<Iterable<Product>> findAll() {
        return ResponseEntity.ok(productRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> find(@PathVariable int id) {
        return ResponseEntity.of(this.productRepository.findById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<Product> save(@RequestBody Product product) {
        return new ResponseEntity<Product>(productService.saveProduct(product),HttpStatus.CREATED);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        productService.deleteProduct(id);
        this.productRepository.deleteById(id);
        return new ResponseEntity<String>("Deleted",HttpStatus.OK);
    }

    @GetMapping("/inventory")
    public ResponseEntity<List<InventoryItemDto>> getInventory() {
        return ResponseEntity.ok(this.productService.getProductsData());
    }
}
