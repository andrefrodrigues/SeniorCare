package com.senior.care.senior.care.auth;

import com.senior.care.senior.care.entity.User;
import com.senior.care.senior.care.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userResult = userRepository.getUserByUsername(username);
        if (userResult.isEmpty()) {
            throw new UsernameNotFoundException("User not found");
        }
        return new com.senior.care.senior.care.auth.UserDetails(userResult.get());
    }
}
