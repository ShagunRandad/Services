package com.exam.portal.controller;

import java.io.Serializable;

import jakarta.security.auth.message.AuthStatus;

public record AuthResponseDto(String token) implements Serializable  {
}
