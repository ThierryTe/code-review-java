package com.example.demo.controllers;

import com.example.demo.models.Product;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.services.ProductService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ResponseBody
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
    public List<Product> findAll() {
        return (List<Product>) productRepository.findAll();
    }

    @GetMapping("/{id}")
    public Product find(@PathVariable int id) {
        return this.productRepository.findById(id).orElseThrow();
    }

    @PostMapping("/create")
    public Product save(@RequestBody Product product) {
        return this.productRepository.save(product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        this.productRepository.deleteById(id);
    }

    @GetMapping("/inventory")
    public ProductService.Inventory getInventory() {
        return this.productService.getProductsData();
    }
}
