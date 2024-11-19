package com.sinfolix.Sai_Samartha.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @GetMapping("/hello")
    public String greet(){
        return "Hello Ashok";
    }
}
