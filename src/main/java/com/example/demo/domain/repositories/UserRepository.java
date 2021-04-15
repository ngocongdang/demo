package com.example.demo.domain.repositories;

import com.example.demo.domain.entities.UserEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<UserEntity, ObjectId> {

    UserEntity findByName(String name);
}
