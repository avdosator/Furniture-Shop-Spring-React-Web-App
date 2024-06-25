package com.avdo.spring.app.service;

import com.avdo.spring.app.controller.dto.CreateUserRequest;
import com.avdo.spring.app.controller.dto.LoginUserRequest;
import com.avdo.spring.app.entity.User;

public interface UserService {

    User createUser(CreateUserRequest createUserRequest);
    User authenticate(LoginUserRequest loginUserRequest);
}
