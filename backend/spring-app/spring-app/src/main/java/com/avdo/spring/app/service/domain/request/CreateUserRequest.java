package com.avdo.spring.app.service.domain.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CreateUserRequest {

    protected final String firstname;

    protected final String lastname;

    protected final String username;

    protected final String email;

    protected final String password;
}
