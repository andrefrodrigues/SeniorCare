package com.senior.care.senior.care.helpers;

import com.senior.care.senior.care.entity.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
@Component
public class CurrentUserFacade {
    public UserDetails getCurrentUserDetails() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (UserDetails) authentication.getPrincipal();
    }

    public User getCurrentUser() {
        UserDetails userDetails = getCurrentUserDetails();
        return ((com.senior.care.senior.care.auth.UserDetails) userDetails).getUser();
    }
}
