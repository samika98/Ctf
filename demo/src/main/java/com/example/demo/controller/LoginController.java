package com.example.demo.controller;


import com.example.demo.entities.Config;
import com.example.demo.entities.User;
import com.example.demo.repository.ConfigRepository;
import com.example.demo.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/ctf")
@Slf4j
public class LoginController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ConfigRepository configRepository;

    @PostMapping(value = "/createUser/{userName}/{password}")
    public boolean createUser(@PathVariable("userName") String userName, @PathVariable("password") String password){
        if(userName.isEmpty() || password.isEmpty()){
            return false;
        }
        log.info("Got data to create user for userName : {} and password : {} ", userName, password);
        //encrypt password, always encrypt your passwords kids!
        String hashedPassword = DigestUtils.sha256Hex(password);

        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);

        //check if user already exists
        //TODO : add error message for existing user
        User existingUser = userRepository.findByUserName(userName);
        if(!Objects.isNull(existingUser)) {
            return false;
        }
        userRepository.save(user);
        return true;
    }

    @PostMapping(value = "/getUserPassword/{userName}")
    public String getConfig(@PathVariable("userName") String userName){
        User existingUser = userRepository.findByUserName(userName);
        if(Objects.nonNull(userName)){
            return existingUser.getPassword();
        }
        return "invalid userName";
    }

    @GetMapping(value = "/getAllConfigs")
    public List<Config> getConfig(){
        log.info("Fetching all configurations for the application");
        return configRepository.findAll();
    }

    @GetMapping(value = "/postConfig")
    public List<Config> postConfig(){
        log.info("Fetching all configurations for the application");
        Config config = new Config();
        config.setConfigName("Swagger url");
        config.setConfigLocation("http://localhost:9090/swagger-ui.html");
        configRepository.save(config);
        config = new Config();
        config.setConfigName("flag name");
        config.setConfigLocation("thisIsTheFlag");
        configRepository.save(config);
        return configRepository.findAll();
    }




}
