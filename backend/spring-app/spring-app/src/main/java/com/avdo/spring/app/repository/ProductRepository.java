package com.avdo.spring.app.repository;

import com.avdo.spring.app.entity.Category;
import com.avdo.spring.app.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByCategory(Category category);
}
