package com.avdo.spring.app.controller;

import com.avdo.spring.app.controller.dto.CreateCategoryDto;
import com.avdo.spring.app.entity.CategoryEntity;
import com.avdo.spring.app.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    // endpoint for creating category (created for testing)
    @PostMapping("/categories")
    public ResponseEntity<CategoryEntity> createCategory(
            @Valid @RequestBody CreateCategoryDto createCategoryDto,
            BindingResult result) {

        if (result.hasErrors()) {
            List<String> errors = result.getAllErrors()
                    .stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .toList();
            throw new RuntimeException(errors.toString());
        } else {
            CategoryEntity categoryEntity = categoryService.createCategory(createCategoryDto);
            return ResponseEntity.ok(categoryEntity);
        }
    }

    // endpoint for fetching all categories
    @GetMapping("/categories")
    public ResponseEntity<List<CategoryEntity>> findAllCategories() {
        List<CategoryEntity> categories = categoryService.findAllCategories();
        if (categories.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(categories);
    }

    // endpoint for getting category by name
    @GetMapping("/categories/{name}")
    public ResponseEntity<CategoryEntity> findCategoryByName(@PathVariable String name) {
        CategoryEntity categoryEntity = categoryService.findCategoryByName(name);
        if (categoryEntity == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(categoryEntity);
    }

}
