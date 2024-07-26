package com.avdo.spring.app.repository.crud;

import com.avdo.spring.app.repository.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CrudCategoryRepository extends JpaRepository<CategoryEntity, Long> {
    Optional<CategoryEntity> findCategoryEntityByName(String name);
}
