package com.avdo.spring.app.utils;

import com.avdo.spring.app.config.security.CustomUserDetails;
import com.avdo.spring.app.service.domain.model.User;
import org.springframework.security.core.context.SecurityContextHolder;

public class UserUtils {

    public static User getCurrentUser() {
        CustomUserDetails customUserDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return customUserDetails.getUser();
    }
}
