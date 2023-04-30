package com.example.ARede.services.user;

import lombok.Data;

@Data
public class CreateUserRequest {
    public String name;
    public String email;
    public String password;
}
