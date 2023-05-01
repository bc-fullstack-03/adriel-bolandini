package com.example.ARede.entities;

import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;
import java.util.UUID;

@Data
public class User {

    private UUID id;
    private String name;
    @Indexed(unique = true)
    private String email;
    private String password;

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.setId();
    }

    public UUID getId() {
        return id;
    }

    protected void setId() {
        this.id = UUID.randomUUID();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
