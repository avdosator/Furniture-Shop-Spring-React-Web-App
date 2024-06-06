package com.avdo.spring_app.repository;

import com.avdo.spring_app.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
}
