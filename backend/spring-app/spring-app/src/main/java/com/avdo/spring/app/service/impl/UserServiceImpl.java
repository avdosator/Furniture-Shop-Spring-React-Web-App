package com.avdo.spring.app.service.impl;

import com.avdo.spring.app.controller.dto.LoginUserRequest;
import com.avdo.spring.app.repository.UserRepository;
import com.avdo.spring.app.service.UserService;
import com.avdo.spring.app.service.domain.model.User;
import com.avdo.spring.app.service.domain.request.CreateUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;


    @Autowired
    public UserServiceImpl(
            UserRepository userRepository,
            AuthenticationManager authenticationManager
    ) {
        this.userRepository = userRepository;
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

    @Override
    public User findById(Long id) {
        return userRepository.findById(id);
    }
}
