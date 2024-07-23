package com.avdo.spring.app.service;

import com.avdo.spring.app.controller.dto.LoginUserDto;
import com.avdo.spring.app.service.domain.model.User;
import com.avdo.spring.app.service.domain.request.CreateUserRequest;

public interface UserService {

    User createUser(CreateUserRequest createUserRequest);
    User authenticate(LoginUserDto loginUserDto);
    User findById(Long id);
}
