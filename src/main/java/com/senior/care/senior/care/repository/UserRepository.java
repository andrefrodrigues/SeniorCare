package com.senior.care.senior.care.repository;

import com.senior.care.senior.care.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    @Query("SELECT u FROM User u JOIN FETCH u.roles r WHERE u.username = :username")
    Optional<User> getUserByUsername(@Param("username") String username);
}
