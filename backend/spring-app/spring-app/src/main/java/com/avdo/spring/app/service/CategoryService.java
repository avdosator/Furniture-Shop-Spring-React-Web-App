package com.avdo.spring.app.service;

import com.avdo.spring.app.dto.CreateCategoryRequest;
import com.avdo.spring.app.entity.Category;
import com.avdo.spring.app.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void createCategory(CreateCategoryRequest createCategoryRequest) {
        Category category = new Category();
        category.setName(createCategoryRequest.getName());
        categoryRepository.save(category);
    }

    public List<Category> findAllCategories() {
        return categoryRepository.findAll();
    }

    public Category findCategoryByName(String name) {
        return categoryRepository.findCategoryByName(name)
                .orElseThrow();
    }
}
