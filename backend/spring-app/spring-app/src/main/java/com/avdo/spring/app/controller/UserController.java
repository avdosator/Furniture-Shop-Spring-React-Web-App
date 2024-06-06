package com.avdo.spring.app.controller;

import com.avdo.spring.app.dto.CreateUserRequest;
import com.avdo.spring.app.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/users")
    ResponseEntity<?> createUser (@Valid @RequestBody CreateUserRequest createUserRequest) {
        try {
            return new ResponseEntity<>(this.userService.createUser(userDto), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(this.errorMapper.createErrorMap(e), HttpStatus.BAD_REQUEST);
        }
    }

}
