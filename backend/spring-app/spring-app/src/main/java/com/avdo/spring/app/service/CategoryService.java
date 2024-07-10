package com.avdo.spring.app.service;

import com.avdo.spring.app.service.domain.model.Category;
import com.avdo.spring.app.service.domain.request.CreateCategoryRequest;

import java.util.List;

public interface CategoryService {

    List<Category> findAllCategories();
    Category createCategory(CreateCategoryRequest createCategoryRequest);
    Category findCategoryByName(String name);
}
