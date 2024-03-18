package com.senior.care.senior.care.mapper;

import com.senior.care.senior.care.dto.UserResponse;
import com.senior.care.senior.care.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserResponseMapper {
    UserResponse mapToUserResponse(User user);
}
