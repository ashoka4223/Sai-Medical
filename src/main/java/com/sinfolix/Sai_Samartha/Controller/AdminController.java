package com.sinfolix.Sai_Samartha.Controller;

import com.sinfolix.Sai_Samartha.DTO.UserDTO;
import com.sinfolix.Sai_Samartha.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/admin")
public class AdminController {

    private UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("create")
    public ResponseEntity<UserDTO> addAdmin(@RequestBody UserDTO user){
        userService.saveAdmin(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
}
