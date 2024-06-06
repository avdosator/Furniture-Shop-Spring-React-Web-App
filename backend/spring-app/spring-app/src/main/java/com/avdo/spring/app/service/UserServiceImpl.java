package com.avdo.spring.app.service;

import com.avdo.spring.app.dto.CreateUserRequest;
import com.avdo.spring.app.entity.User;
import com.avdo.spring.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements  UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void createUser(CreateUserRequest createUserRequest) {
        User user = new UserMapper().mapToUser(createUserRequest);
        userRepository.save(user);
    }

    public  class UserMapper {
        public User mapToUser(CreateUserRequest createUserRequest) {
            User user = new User();
            user.setUsername(createUserRequest.getUsername());
            user.setFirstname(createUserRequest.getFirstname());
            user.setLastname(createUserRequest.getLastname());
            user.setPassword(passwordEncoder.encode(createUserRequest.getPassword()));
            user.setEmail(createUserRequest.getEmail());
            return user;
        }
    }
}
