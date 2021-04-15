package com.example.demo.domain.services;

import com.example.demo.domain.entities.UserEntity;
import com.example.demo.domain.repositories.UserRepository;
import com.example.demo.domain.ustils.CacheManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CacheManager cacheManager;

    public List<UserEntity> findAll(){
        return userRepository.findAll();
    }

    public UserEntity findByName(String name){
        return userRepository.findByName(name);
    }

    public String login(String name, String password){
        if ( findByName(name).getPassword().equals(password)){
            String token = generateToken(name);

            cacheManager.setValue("user:token", token);
            return token;
        }
        return null;
    }

    public String logOut(String token){
        if(cacheManager.getValue("user:token").equals(token)){
            cacheManager.deleteValue(token);
            return "ok";
        }
        return null;
    }

    protected String generateToken(String userName){
        String token = userName + RandomStringUtils.randomAlphabetic(5);
        return token;
    }
}
