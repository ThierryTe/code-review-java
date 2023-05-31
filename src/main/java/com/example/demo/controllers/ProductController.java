package com.example.demo.controllers;

import com.example.demo.dto.InventoryItemDto;
import com.example.demo.dto.ProductDto;
import com.example.demo.models.Product;
import com.example.demo.services.ProductService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public ResponseEntity<Iterable<Product>> findAll() {
        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> find(@PathVariable int id) {
        return ResponseEntity.of(productService.findById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<Product> createNewProduct(@RequestBody Product product) {
        var createdEntity = productService.createNewProduct(product);
        return ResponseEntity.ok(createdEntity);

    }

    @PostMapping("/update/{id}")
    public ResponseEntity<Product> updateExistingProduct(@PathVariable(name="id") int productId, @RequestBody @Valid ProductDto product) {
        var updatedEntity = productService.updateExistingProduct(productId, product);
        return ResponseEntity.ok(updatedEntity);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        productService.deleteProductBy(id);
        return ResponseEntity.ok("Deleted");
    }

    @GetMapping("/inventory")
    public ResponseEntity<List<InventoryItemDto>> getInventoryList() {
        return ResponseEntity.ok(this.productService.getInventoryList());
    }
}
