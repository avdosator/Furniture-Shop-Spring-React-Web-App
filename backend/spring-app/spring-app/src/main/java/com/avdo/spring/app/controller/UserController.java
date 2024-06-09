package com.avdo.spring.app.controller;

import com.avdo.spring.app.dto.CreateUserRequest;
import com.avdo.spring.app.dto.LoginUserRequest;
import com.avdo.spring.app.entity.User;
import com.avdo.spring.app.service.JwtService;
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
    private final JwtService jwtService;

    @Autowired
    public UserController(UserService userService, JwtService jwtService) {

        this.userService = userService;
        this.jwtService = jwtService;
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
    public ResponseEntity<?> loginUser(@Valid @RequestBody LoginUserRequest loginUserRequest) {
        User authenticatedUser = userService.authenticate(loginUserRequest);
        String jwtToken = jwtService.generateToken(authenticatedUser);
        return ResponseEntity.ok().build();
    }

}
