package com.avdo.spring.app.repository;

import com.avdo.spring.app.entity.CategoryEntity;
import com.avdo.spring.app.service.domain.model.Category;
import com.avdo.spring.app.service.domain.request.CreateCategoryRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository {

    Category createCategory(CreateCategoryRequest createCategoryRequest);
    List<Category> findAllCategories();
    Category findCategoryByName(String name);
}
