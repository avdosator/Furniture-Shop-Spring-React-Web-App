package com.avdo.spring.app.service.impl;

import com.avdo.spring.app.controller.dto.LoginUserDto;
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
    public User authenticate(LoginUserDto loginUserDto) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginUserDto.getUsername(),
                        loginUserDto.getPassword()));

        return userRepository.findByUsername(loginUserDto.getUsername());
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id);
    }
}
