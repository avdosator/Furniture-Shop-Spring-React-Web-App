package com.avdo.spring.app.controller;

import com.avdo.spring.app.dto.CreateCategoryRequest;
import com.avdo.spring.app.entity.Category;
import com.avdo.spring.app.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/database")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/categories")
    public ResponseEntity<String> createCategory(
            @Valid @RequestBody CreateCategoryRequest createCategoryRequest,
            BindingResult result) {

        if (result.hasErrors()) {
            List<String> errors = result.getAllErrors()
                    .stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .toList();
            return ResponseEntity.badRequest().body(errors.toString());
        } else {
            categoryService.createCategory(createCategoryRequest);
            String successMessage = "Successfully created category " + createCategoryRequest.getName();
            return ResponseEntity.status(HttpStatus.CREATED).body(successMessage);
        }
    }
}
