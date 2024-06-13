package com.avdo.spring.app.service;

import com.avdo.spring.app.dto.CreateCategoryRequest;
import com.avdo.spring.app.entity.Category;
import com.avdo.spring.app.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void createCategory(CreateCategoryRequest createCategoryRequest) {
        Category category = new Category();
        categoryRepository.save(category);
    }

    public List<Category> findAllCategories() {
        return categoryRepository.findAll();
    }

    public Category findCategoryByName(String name) {
        Category category = categoryRepository.findCategoryByName(name)
                .orElseThrow();
    }
}
