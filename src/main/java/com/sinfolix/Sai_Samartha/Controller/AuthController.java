package com.sinfolix.Sai_Samartha.Controller;

import com.sinfolix.Sai_Samartha.DTO.UserDTO;
import com.sinfolix.Sai_Samartha.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class AuthController{

   @Autowired
   private UserService userService;

    @GetMapping("/hello")
    public String greet(){
        return "Hello Ashok";
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody UserDTO user) {
        user.setPassword(user.getPassword());
        user.setRoles(List.of("USER"));
        user.setFirstName(user.getFirstName());
        user.setLastName(user.getLastName());
        user.setEmail(user.getEmail());
        userService.save(user);
        return "User registered successfully";
    }
}
