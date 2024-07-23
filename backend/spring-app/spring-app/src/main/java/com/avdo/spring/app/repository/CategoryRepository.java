package com.avdo.spring.app.repository;

import com.avdo.spring.app.service.domain.model.Category;
import com.avdo.spring.app.service.domain.request.CreateCategoryRequest;

import java.util.List;

public interface CategoryRepository {

    Category createCategory(CreateCategoryRequest createCategoryRequest);
    List<Category> findAllCategories();
    Category findCategoryByName(String name);
}
