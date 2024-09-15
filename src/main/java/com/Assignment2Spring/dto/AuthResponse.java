package com.Assignment2Spring.dto;

import lombok.*;

//This class is used to return jwt token.
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthResponse {
    private String token;
}