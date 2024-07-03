package com.avdo.spring.app.controller;

import com.avdo.spring.app.controller.dto.CreateUserDto;
import com.avdo.spring.app.controller.dto.LoginUserRequest;
import com.avdo.spring.app.entity.UserEntity;
import com.avdo.spring.app.service.JwtService;
import com.avdo.spring.app.service.UserService;
import com.avdo.spring.app.service.domain.model.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
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

    // endpoint for creating user
    @PostMapping("/users")
    public User createUser(@Valid @RequestBody CreateUserDto createUserDto, BindingResult result) {
        if (result.hasErrors()) {
            // If there are validation errors, construct a custom error response
            List<String> errors = result.getAllErrors()
                    .stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .toList();
            throw new RuntimeException(errors.toString());
        } else {
            // If data is valid, proceed with user creation
            User user = userService.createUser(createUserDto);
            return user;
        }
    }

    // endpoint for logging in
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> loginUser(@Valid @RequestBody LoginUserRequest loginUserRequest) {
        UserEntity authenticatedUserEntity = userService.authenticate(loginUserRequest);
        String jwtToken = jwtService.generateToken(authenticatedUserEntity);
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(jwtToken);
        loginResponse.setExpiresIn(jwtService.getExpirationTime());
        return ResponseEntity.ok(loginResponse);
    }

    // endpoints for testing
    @GetMapping("/users")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<String> testUserRole() {
        return ResponseEntity.ok("This is a protected route, you should see it only if you are logged in and have role USER");
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> testAdminRole() {
        return ResponseEntity.ok("This is a protected route, you should see it only if you are logged in and have role ADMIN");
    }

    @GetMapping("/adminoruser")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public ResponseEntity<String> testRoles() {
        return ResponseEntity.ok("This is a protected route, you should see it only if you are logged in and have role ADMIN or USER");
    }

}
