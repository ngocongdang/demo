package com.example.demo.app.Controllers;

import com.example.demo.app.dtos.UserDTO;
import com.example.demo.domain.entities.UserEntity;
import com.example.demo.domain.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public ResponseEntity<List<UserEntity>> hehe(){
        return ResponseEntity.ok(userService.findAll());
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserDTO userDTO){
        return ResponseEntity.ok(userService.login(userDTO.getName(),userDTO.getPassword()));
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logOut(@RequestHeader String token){
        return ResponseEntity.ok(userService.logOut(token));
    }
}
