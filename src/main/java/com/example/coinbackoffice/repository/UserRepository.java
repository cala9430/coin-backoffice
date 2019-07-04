package com.example.coinbackoffice.repository;

import com.example.coinbackoffice.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository  extends MongoRepository<User, String> {
}
