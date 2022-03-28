package com.example.demo.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;
@Getter
@Setter
@Document(collection = "Config")
public class Config {

    @Id
    String configId;

    String configName;

    String configLocation;

}
