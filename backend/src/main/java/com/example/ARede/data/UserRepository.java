package com.example.ARede.data;

import com.example.ARede.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface UserRepository extends MongoRepository<User, UUID> {

}
