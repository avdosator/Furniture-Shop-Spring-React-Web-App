package com.avdo.spring.app.repository.impl;

import com.avdo.spring.app.entity.CategoryEntity;
import com.avdo.spring.app.repository.CategoryRepository;
import com.avdo.spring.app.repository.crud.CrudCategoryRepository;
import com.avdo.spring.app.service.domain.model.Category;
import com.avdo.spring.app.service.domain.request.CreateCategoryRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryJpaRepository implements CategoryRepository {

    private final CrudCategoryRepository crudCategoryRepository;

    @Autowired
    public CategoryJpaRepository(CrudCategoryRepository crudCategoryRepository) {
        this.crudCategoryRepository = crudCategoryRepository;
    }

    @Override
    public Category createCategory(CreateCategoryRequest createCategoryRequest) {
        CategoryEntity category = new CategoryEntity();
        category.setName(createCategoryRequest.getName());
        return crudCategoryRepository.save(category).toDomainModel();
    }

    @Override
    public List<Category> findAllCategories() {
        List<CategoryEntity> categoryEntities = crudCategoryRepository.findAll();
        List<Category> categories = new ArrayList<>();
        for (CategoryEntity categoryEntity : categoryEntities) {
            categories.add(categoryEntity.toDomainModel());
        }
        return categories;
    }

    @Override
    public Category findCategoryByName(String name) {
        CategoryEntity categoryEntity = crudCategoryRepository.findCategoryEntityByName(name).orElseThrow();
        return categoryEntity.toDomainModel();
    }
}
