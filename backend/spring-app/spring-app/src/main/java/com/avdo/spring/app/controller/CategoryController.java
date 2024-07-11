package com.avdo.spring.app.controller;

import com.avdo.spring.app.controller.dto.CreateCategoryDto;
import com.avdo.spring.app.service.CategoryService;
import com.avdo.spring.app.service.domain.model.Category;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
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
    public Category createCategory(
            @Valid @RequestBody CreateCategoryDto createCategoryDto,
            BindingResult result) {

        if (result.hasErrors()) {
            List<String> errors = result.getAllErrors()
                    .stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .toList();
            throw new RuntimeException(errors.toString());
        }
        return categoryService.createCategory(createCategoryDto);
    }

    // endpoint for fetching all categories
    @GetMapping("/categories")
    public List<Category> findAllCategories() {
        List<Category> categories = categoryService.findAllCategories();
        if (categories.isEmpty()) {
            return Collections.emptyList();
        }
        return categories;
    }

    // endpoint for getting category by name
    @GetMapping("/categories/{name}")
    public Category findCategoryByName(@PathVariable String name) {
        return categoryService.findCategoryByName(name);
    }

}
