package com.avdo.spring.app.service.impl;

import com.avdo.spring.app.controller.dto.CreateUserDto;
import com.avdo.spring.app.controller.dto.LoginUserRequest;
import com.avdo.spring.app.entity.UserEntity;
import com.avdo.spring.app.repository.UserRepository;
import com.avdo.spring.app.repository.crud.CrudUserRepository;
import com.avdo.spring.app.service.UserService;
import com.avdo.spring.app.service.domain.model.User;
import com.avdo.spring.app.service.domain.request.CreateUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;


    @Autowired
    public UserServiceImpl(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            AuthenticationManager authenticationManager
    ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public User createUser(CreateUserRequest createUserRequest) {
        return userRepository.saveUser(createUserRequest);
    }

    @Override
    public User authenticate(LoginUserRequest loginUserRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginUserRequest.getUsername(),
                        loginUserRequest.getPassword()));

        return userRepository.findByUsername(loginUserRequest.getUsername());
    }


    public UserEntity findById(Long id) {
        return crudUserRepository.findById(id).orElseThrow(() -> new RuntimeException("User don't exist!"));
    }
}
