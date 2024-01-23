package com.ijse.posbackend.controller;

import com.ijse.posbackend.dto.UserPwDTO;
import com.ijse.posbackend.entity.User;
import com.ijse.posbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity <List<User>> getAllUsers(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUsers());


    }

    @PostMapping("/users")
    public ResponseEntity<?> createUser(@RequestBody User user){

        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(user));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to create the user");
        }
    }

    @PutMapping("/users/{id}/change-password")
    public ResponseEntity<?> changeUserPassword(@PathVariable Long id,@RequestBody UserPwDTO userPwDTO){

        try {
            return ResponseEntity.status(HttpStatus.OK).body(userService.changUserPassword(id,userPwDTO));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to change password");
        }
    }

}
