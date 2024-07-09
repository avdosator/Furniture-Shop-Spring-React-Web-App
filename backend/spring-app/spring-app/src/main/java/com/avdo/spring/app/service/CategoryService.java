package com.avdo.spring.app.service;

import com.avdo.spring.app.controller.dto.CreateCategoryDto;
import com.avdo.spring.app.entity.CategoryEntity;
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

    public CategoryEntity createCategory(CreateCategoryDto createCategoryDto) {
        CategoryEntity category = new CategoryEntity();
        category.setName(createCategoryDto.getName());
        return categoryRepository.save(category);
    }

    public List<CategoryEntity> findAllCategories() {
        return categoryRepository.findAll();
    }

    public CategoryEntity findCategoryByName(String name) {
        return categoryRepository.findCategoryByName(name)
                .orElseThrow();
    }
}
