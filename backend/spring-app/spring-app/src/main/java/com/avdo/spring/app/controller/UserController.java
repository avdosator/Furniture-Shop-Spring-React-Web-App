package com.avdo.spring.app.controller;

import com.avdo.spring.app.dto.CreateUserRequest;
import com.avdo.spring.app.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.context.support.DefaultMessageSourceResolvable;


@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public ResponseEntity<?> createUser(@Valid @RequestBody CreateUserRequest createUserRequest, BindingResult result) {
        if (result.hasErrors()) {
            // If there are validation errors, construct a custom error response
            List<String> errors = result.getAllErrors()
                    .stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.toList());
            return ResponseEntity.badRequest().body(errors);
        } else {
            // If data is valid, proceed with user creation
            userService.createUser(createUserRequest);
            return ResponseEntity.ok().build();
        }
    }

    @PostMapping("/login")
    public String loginUser() {
        return "You are logged in";
    }

}
