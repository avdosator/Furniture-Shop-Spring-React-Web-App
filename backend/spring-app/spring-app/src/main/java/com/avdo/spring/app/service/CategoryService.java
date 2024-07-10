package com.avdo.spring.app.service;

import com.avdo.spring.app.controller.dto.CreateCategoryDto;
import com.avdo.spring.app.entity.CategoryEntity;
import com.avdo.spring.app.service.domain.request.CreateCategoryRequest;

import java.util.List;

public interface CategoryService {

    List<CategoryEntity> findAllCategories();
    CategoryEntity createCategory(CreateCategoryRequest createCategoryRequest);
    CategoryEntity findCategoryByName(String name);
}
