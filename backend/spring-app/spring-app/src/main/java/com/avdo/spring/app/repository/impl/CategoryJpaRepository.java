package com.avdo.spring.app.repository.impl;

import com.avdo.spring.app.repository.crud.CrudCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryJpaRepository {

    private final CrudCategoryRepository crudCategoryRepository;

    @Autowired
    public CategoryJpaRepository(CrudCategoryRepository crudCategoryRepository) {
        this.crudCategoryRepository = crudCategoryRepository;
    }
}
