package com.senior.care.senior.care.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record LoginRequest(@NotNull(message="Username is missing") @NotEmpty String username, @NotNull @NotEmpty String password) {
}
