package com.senior.care.senior.care.controller;

import com.senior.care.senior.care.helpers.CurrentUserFacade;
import com.senior.care.senior.care.dto.UserResponse;
import com.senior.care.senior.care.entity.User;
import com.senior.care.senior.care.mapper.UserResponseMapper;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/me")
public class UserController {
    @Autowired
    UserResponseMapper userResponseMapper;
    @Autowired
    CurrentUserFacade currentUserFacade;

    @GetMapping
    public UserResponse getCurrentUserInformation(@AuthenticationPrincipal UserDetails userDetails) {
        User user = currentUserFacade.getCurrentUser();
        return userResponseMapper.mapToUserResponse(user);
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String adminTest() {
        return "admin test";
    }

    @GetMapping("/doctor")
    @PreAuthorize("hasRole('ROLE_DOCTOR')")
    public String doctorTest() {
        return "doctor test";
    }
}
