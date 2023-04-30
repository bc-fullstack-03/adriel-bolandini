package com.example.ARede.services.user;

import com.example.ARede.data.UserRepository;
import com.example.ARede.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository _userRepository;

    @Async
    public String createUser(CreateUserRequest request) {
        var user = new User(request.name, request.email, request.password);

        try {
            _userRepository.save(user);
        } catch (Exception e) {
            return "Erro ao salvar o usuário!\n"+e;
        }

        return user.getId().toString();
    }
}
