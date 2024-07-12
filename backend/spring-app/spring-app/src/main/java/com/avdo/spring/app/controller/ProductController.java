package com.avdo.spring.app.controller;

import com.avdo.spring.app.controller.dto.CreateProductDto;
import com.avdo.spring.app.entity.ProductEntity;
import com.avdo.spring.app.service.ProductService;
import com.avdo.spring.app.service.domain.model.Product;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // endpoint for creating a product
    @PostMapping("/products")
    public Product createProduct(@Valid @RequestBody CreateProductDto createProductDto,
                                 BindingResult result) {
        System.out.println("In ProductController");
        if (result.hasErrors()) {
            List<String> errors = result.getAllErrors()
                    .stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .toList();
            throw new RuntimeException(errors.toString());
        } else {
            return productService.createProduct(createProductDto);
        }
    }

    // endpoint for fetching all products
    @GetMapping("/products")
    public List<Product> getAllProducts() {
        List<Product> products = productService.findAllProducts();
        if (products.isEmpty()) {
            return Collections.emptyList();
        }
        return products;
    }

    // endpoint for fetching product by id
    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable Long id) {
        Product product = productService.findById(id);
        if (product != null) {
            return product;
        }
        // is this ok for now?
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found");
    }

    // endpoint for fetching products from given category
    @GetMapping("/products/category/{category}")
    public List<Product> getSameCategoryProducts(@PathVariable String category) {
        List<Product> products = productService.findSameCategoryProducts(category);
        if (products.isEmpty()) {
            return Collections.emptyList();
        }
        return products;
    }
}
