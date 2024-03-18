package com.senior.care.senior.care.auth;

import com.senior.care.senior.care.config.RootUserConfig;
import com.senior.care.senior.care.entity.Role;
import com.senior.care.senior.care.entity.User;
import com.senior.care.senior.care.repository.RoleRepository;
import com.senior.care.senior.care.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;
import java.util.Optional;


@Component
public class StartupSeed implements CommandLineRunner {
    private static final String[] DEFAULT_ROLES = new String[] {"NURSE", "DOCTOR", "ASSISTANT", "ADMIN", "ROOT"};
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private Argon2PasswordEncoder encoder;
    @Autowired
    private RootUserConfig systemConfig;
    @Autowired
    private RoleRepository roleRepository;

    private User seedRootUser() {
        Optional<User> existingRootUser = userRepository.getUserByUsername(systemConfig.getRootUsername());
        if (existingRootUser.isPresent()) {
            return existingRootUser.get();
        }
        User rootUser = new User();
        rootUser.setUsername(systemConfig.getRootUsername());
        rootUser.setPassword(encoder.encode(systemConfig.getRootPassword()));
        rootUser.setCreatedAt(new Date());
        rootUser.setName(systemConfig.getRootName());
        userRepository.save(rootUser);
        return rootUser;
    }

    private void seedRoles() {
        Arrays.stream(DEFAULT_ROLES).forEach(roleName -> {
            Optional<Role> roleResult = roleRepository.getRoleByName(roleName);
            if (roleResult.isPresent()) {
                return;
            }
            Role role = new Role();
            role.setName(roleName);
            roleRepository.save(role);
        });
    }
    @Override
    public void run(String... args) throws Exception {
        seedRoles();
        User root = seedRootUser();
        Optional<Role> rootRoleResult = roleRepository.getRoleByName("ROOT");
        if (rootRoleResult.isEmpty()) {
            throw new Exception("Missing root role");
        }
        Role rootRole = rootRoleResult.get();
        if (root.getRoles().contains(rootRole)) {
            return;
        }
        root.getRoles().add(rootRole);
        userRepository.save(root);
    }
}
