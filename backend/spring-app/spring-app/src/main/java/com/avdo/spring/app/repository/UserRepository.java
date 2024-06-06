package com.avdo.spring.app.repository;

import com.avdo.spring.app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
