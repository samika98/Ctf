package com.example.demo.repository;

import com.example.demo.entities.Config;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfigRepository extends MongoRepository<Config, String>{

}
