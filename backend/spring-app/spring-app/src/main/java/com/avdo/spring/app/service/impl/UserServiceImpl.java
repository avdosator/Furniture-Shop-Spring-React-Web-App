package com.avdo.spring.app.service.impl;

import com.avdo.spring.app.controller.dto.CreateUserDto;
import com.avdo.spring.app.controller.dto.LoginUserRequest;
import com.avdo.spring.app.entity.UserEntity;
import com.avdo.spring.app.repository.crud.CrudUserRepository;
import com.avdo.spring.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;

@Service
public class UserServiceImpl implements UserService {

    private final CrudUserRepository crudUserRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;


    @Autowired
    public UserServiceImpl(
            CrudUserRepository crudUserRepository,
            PasswordEncoder passwordEncoder,
            AuthenticationManager authenticationManager
    ) {
        this.crudUserRepository = crudUserRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public UserEntity createUser(CreateUserDto createUserDto) {
        UserEntity userEntity = new UserMapper().mapToUser(createUserDto);
        return crudUserRepository.save(userEntity);
    }

    @Override
    public UserEntity authenticate(LoginUserRequest loginUserRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginUserRequest.getUsername(),
                        loginUserRequest.getPassword()));

        return crudUserRepository.findByUsername(loginUserRequest.getUsername()).orElseThrow();
    }

    private class UserMapper {
        private UserEntity mapToUser(CreateUserDto createUserDto) {
            UserEntity userEntity = new UserEntity();
            userEntity.setUsername(createUserDto.getUsername());
            userEntity.setFirstname(createUserDto.getFirstname());
            userEntity.setLastname(createUserDto.getLastname());
            userEntity.setPassword(passwordEncoder.encode(createUserDto.getPassword()));
            userEntity.setEmail(createUserDto.getEmail());
            userEntity.setDateCreated(Date.valueOf(LocalDate.now()));
            userEntity.setRole("ROLE_USER");
            return userEntity;
        }
    }

    public UserEntity findById(Long id) {
        return crudUserRepository.findById(id).orElseThrow(() -> new RuntimeException("User don't exist!"));
    }
}
