package com.example.ARede.api;

import com.example.ARede.services.user.CreateUserRequest;
import com.example.ARede.services.user.FindUserResponse;
import com.example.ARede.services.user.IUserService;
import com.example.ARede.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    private IUserService _userService;

    private UserValidator _userValidators;

    @PostMapping()
    public ResponseEntity<String> createUser(@RequestBody CreateUserRequest request){
        UserValidator _userValidators = new UserValidator();
        boolean validUser = _userValidators.createValidator(request);
       if (!validUser){
            return ResponseEntity.badRequest().body(_userValidators.toString());
        }

        var response = _userService.createUser(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<FindUserResponse> getUser(String email) {
            return ResponseEntity.ok().body(_userService.findUserByEmail(email));
    }
}
