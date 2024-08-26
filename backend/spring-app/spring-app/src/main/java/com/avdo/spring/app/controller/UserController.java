package com.avdo.spring.app.controller;

import com.avdo.spring.app.controller.dto.CreateUserDto;
import com.avdo.spring.app.controller.dto.LoginUserDto;
import com.avdo.spring.app.service.JwtService;
import com.avdo.spring.app.service.UserService;
import com.avdo.spring.app.service.domain.model.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class UserController {

    private final UserService userService;
    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;

    @Autowired
    public UserController(UserService userService, JwtService jwtService, UserDetailsService userDetailsService) {
        this.userService = userService;
        this.jwtService = jwtService;
        this.userDetailsService = userDetailsService;
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
            return userService.createUser(createUserDto);
        }
    }

    // endpoint for logging in
    @PostMapping("/login")
    public LoginResponse loginUser(@Valid @RequestBody LoginUserDto loginUserDto) {
        User authenticatedUser = userService.authenticate(loginUserDto);
        String jwtToken = jwtService.generateToken(userDetailsService.loadUserByUsername(authenticatedUser.getUsername()));
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(jwtToken);
        loginResponse.setExpiresIn(jwtService.getExpirationTime());
        return loginResponse;
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
