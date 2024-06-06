package com.avdo.spring.app.service;

import com.avdo.spring.app.dto.CreateUserRequest;
import com.avdo.spring.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    void createUser(CreateUserRequest createUserRequest);
}
