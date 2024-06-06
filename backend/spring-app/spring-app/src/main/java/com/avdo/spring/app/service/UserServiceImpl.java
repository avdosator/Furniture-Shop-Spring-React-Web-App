package com.avdo.spring.app.service;

import com.avdo.spring.app.dto.CreateUserRequest;
import com.avdo.spring.app.entity.User;
import com.avdo.spring.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements  UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public void createUser(CreateUserRequest createUserRequest) {
        User user = UserMapper.mapToUser(createUserRequest);
        userRepository.save(user);
    }

    public static class UserMapper {
        public static User mapToUser(CreateUserRequest createUserRequest) {
            User user = new User();
            user.setUsername(createUserRequest.getUsername());
            user.setFirstname(createUserRequest.getFirstname());
            user.setLastname(createUserRequest.getLastname());
            user.setPassword(createUserRequest.getPassword());
            user.setEmail(createUserRequest.getEmail());
            return user;
        }
    }
}
