package com.avdo.spring.app.service;

import com.avdo.spring.app.controller.dto.CreateCategoryRequestDto;
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

    public Category createCategory(CreateCategoryRequestDto createCategoryRequestDto) {
        Category category = new Category();
        category.setName(createCategoryRequestDto.getName());
        return categoryRepository.save(category);
    }

    public List<Category> findAllCategories() {
        return categoryRepository.findAll();
    }

    public Category findCategoryByName(String name) {
        return categoryRepository.findCategoryByName(name)
                .orElseThrow();
    }
}
