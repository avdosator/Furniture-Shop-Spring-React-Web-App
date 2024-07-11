package com.avdo.spring.app.controller;

import com.avdo.spring.app.controller.dto.CreateProductDto;
import com.avdo.spring.app.entity.ProductEntity;
import com.avdo.spring.app.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<ProductEntity> createProduct(@Valid @RequestBody CreateProductDto createProductDto,
                                                       BindingResult result) {
        if (result.hasErrors()) {
            List<String> errors = result.getAllErrors()
                    .stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .toList();
            throw new RuntimeException(errors.toString());
        } else {
            ProductEntity product = productService.createProduct(createProductDto);
            return ResponseEntity.ok(product);
        }
    }

    // endpoint for fetching all products
    @GetMapping("/products")
    public ResponseEntity<List<ProductEntity>> getAllProducts() {
        List<ProductEntity> products = productService.findAllProducts();
        if (products.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(products);
    }

    // endpoint for fetching product by id
    @GetMapping("/products/{id}")
    public ResponseEntity<ProductEntity> getProductById(@PathVariable Long id) {
        ProductEntity product = productService.findById(id);
        if (product != null) {
            return ResponseEntity.ok(product);
        }
        return ResponseEntity.notFound().build();
    }

    // endpoint for fetching products from given category
    @GetMapping("/products/category/{category}")
    public ResponseEntity<List<ProductEntity>> getSameCategoryProducts(@PathVariable String category) {
        List<ProductEntity> products = productService.findSameCategoryProducts(category);
        if (products.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(products);
    }
}
