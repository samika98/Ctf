package com.example.demo.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;
@Getter
@Setter
@Document(collection = "User")
public class User {

    @Id
    String userId;

    String userName;

    String password;

}
