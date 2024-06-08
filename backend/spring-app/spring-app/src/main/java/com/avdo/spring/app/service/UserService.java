package com.avdo.spring.app.service;

import com.avdo.spring.app.dto.CreateUserRequest;
import com.avdo.spring.app.dto.LoginUserRequest;
import com.avdo.spring.app.entity.User;

public interface UserService {

    void createUser(CreateUserRequest createUserRequest);
    User authenticate(LoginUserRequest loginUserRequest);
}
