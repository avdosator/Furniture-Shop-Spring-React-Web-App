package com.avdo.spring.app.service;

import com.avdo.spring.app.dto.CreateUserRequest;
import com.avdo.spring.app.dto.LoginUserRequest;
import com.avdo.spring.app.entity.User;
import com.avdo.spring.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;

@Service
public class UserServiceImpl implements  UserService {

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
    public void createUser(CreateUserRequest createUserRequest) {
        User user = new UserMapper().mapToUser(createUserRequest);
        userRepository.save(user);
    }

    @Override
    public User authenticate(LoginUserRequest loginUserRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginUserRequest.getUsername(),
                        loginUserRequest.getPassword()));

        return userRepository.findByUsername(loginUserRequest.getUsername()).orElseThrow();
    }

    private class UserMapper {
        private User mapToUser(CreateUserRequest createUserRequest) {
            User user = new User();
            user.setUsername(createUserRequest.getUsername());
            user.setFirstname(createUserRequest.getFirstname());
            user.setLastname(createUserRequest.getLastname());
            user.setPassword(passwordEncoder.encode(createUserRequest.getPassword()));
            user.setEmail(createUserRequest.getEmail());
            user.setDateCreated(Date.valueOf(LocalDate.now()));
            user.setRole("ROLE_USER");
            return user;
        }
    }


    // maybe this will be deleted
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User don't exist!"));
    }
}
