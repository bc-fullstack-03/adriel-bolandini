package com.example.ARede.services.user;

public interface IUserService {
    String createUser(CreateUserRequest request);
    FindUserResponse findUserByEmail(String email);
}
