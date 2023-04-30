package com.example.ARede.validator;

import com.example.ARede.services.user.CreateUserRequest;

import java.util.ArrayList;

public class UserValidator{
    private ArrayList<String> errors = new ArrayList<>();


    public boolean validator (CreateUserRequest request) {
        if (request.email==null || request.email.length()<3 || !request.email.contains("@")){
            this.errors.add("Insira um e-mail válido");
        }

        if (request.name==null  || request.name.length() <3){
            this.errors.add("Insira um nome válido");
        }

        if (request.password==null  || request.password.length() <3){
            this.errors.add("Insira uma senha válida");
        }

        if (!errors.isEmpty()){
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return "UserValidator{" +
                "errors=" + errors +
                '}';
    }
}
