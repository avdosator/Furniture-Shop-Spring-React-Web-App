package com.avdo.spring.app.repository;

import com.avdo.spring.app.entity.Category;
import com.avdo.spring.app.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByCategory_Name(String category);
}
