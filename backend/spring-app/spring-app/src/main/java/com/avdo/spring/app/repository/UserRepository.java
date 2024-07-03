package com.avdo.spring.app.repository;

import com.avdo.spring.app.service.domain.model.User;
import com.avdo.spring.app.service.domain.request.CreateUserRequest;

public interface UserRepository {

    User saveUser(CreateUserRequest createUserRequest);
}
