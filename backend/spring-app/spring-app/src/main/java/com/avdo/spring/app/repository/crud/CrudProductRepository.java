package com.avdo.spring.app.repository.crud;

import com.avdo.spring.app.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CrudProductRepository extends JpaRepository<ProductEntity, Long> {

    List<ProductEntity> findByCategoryEntity_Name(String category);
}
