package com.avdo.spring.app.service.impl;

import com.avdo.spring.app.repository.CategoryRepository;
import com.avdo.spring.app.service.CategoryService;
import com.avdo.spring.app.service.domain.model.Category;
import com.avdo.spring.app.service.domain.request.CreateCategoryRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category createCategory(CreateCategoryRequest createCategoryRequest) {
        return categoryRepository.createCategory(createCategoryRequest);
    }

    @Override
    public List<Category> findAllCategories() {
        return categoryRepository.findAllCategories();
    }

    @Override
    public Category findCategoryByName(String name) {
        return categoryRepository.findCategoryByName(name);
    }
}
