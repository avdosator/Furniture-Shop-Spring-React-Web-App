package com.avdo.spring.app.repository.impl;

import com.avdo.spring.app.entity.UserEntity;
import com.avdo.spring.app.repository.UserRepository;
import com.avdo.spring.app.repository.crud.CrudUserRepository;
import com.avdo.spring.app.service.domain.model.User;
import com.avdo.spring.app.service.domain.request.CreateUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.time.LocalDate;

@Repository
public class UserJpaRepository implements UserRepository {

    private final CrudUserRepository crudUserRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserJpaRepository(
            CrudUserRepository crudUserRepository,
            PasswordEncoder passwordEncoder
    ) {
        this.crudUserRepository = crudUserRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User saveUser(CreateUserRequest createUserRequest) {
        UserEntity userEntity = new UserMapper().mapToUserEntity(createUserRequest);
        UserEntity savedUserEntity = crudUserRepository.save(userEntity);
        return savedUserEntity.toDomainModel();
    }

    @Override
    public User findById(Long id) {
        UserEntity userEntity = crudUserRepository.findById(id).orElseThrow();
        return userEntity.toDomainModel();
    }

    @Override
    public User findByUsername(String username) {
        UserEntity userEntity = crudUserRepository.findByUsername(username).orElseThrow();
        return userEntity.toDomainModel();
    }

    private class UserMapper {
        private UserEntity mapToUserEntity(CreateUserRequest createUserRequest) {
            UserEntity userEntity = new UserEntity();
            userEntity.setUsername(createUserRequest.getUsername());
            userEntity.setFirstname(createUserRequest.getFirstname());
            userEntity.setLastname(createUserRequest.getLastname());
            userEntity.setPassword(passwordEncoder.encode(createUserRequest.getPassword()));
            userEntity.setEmail(createUserRequest.getEmail());
            userEntity.setDateCreated(Date.valueOf(LocalDate.now()));
            userEntity.setRole("ROLE_USER");
            return userEntity;
        }
    }
}
