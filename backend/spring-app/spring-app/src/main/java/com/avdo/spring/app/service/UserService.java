package com.avdo.spring.app.service;

import com.avdo.spring.app.controller.dto.CreateUserDto;
import com.avdo.spring.app.controller.dto.LoginUserRequest;
import com.avdo.spring.app.entity.UserEntity;
import com.avdo.spring.app.service.domain.model.User;
import com.avdo.spring.app.service.domain.request.CreateUserRequest;

public interface UserService {

    User createUser(CreateUserRequest createUserRequest);
    User authenticate(LoginUserRequest loginUserRequest);
    User findById(Long id);
}
