package com.sinfolix.Sai_Samartha.Service;

import com.sinfolix.Sai_Samartha.DTO.UserDTO;
import com.sinfolix.Sai_Samartha.Entities.User;
import com.sinfolix.Sai_Samartha.Repository.UserRepository;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;

public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO saveAdmin(UserDTO user){

        user.setFirstName(user.getFirstName());
        user.setLastName(user.getLastName());
        user.setEmail(user.getEmail());
        user.setUsername(user.getUsername());
        user.setPassword(user.getPassword());
        user.setRoles(Arrays.asList("USER", "ADMIN"));
        userRepository.save(user);
        return user;
    }

    public UserDTO save(UserDTO user) {
        user.setFirstName(user.getFirstName());
        user.setLastName(user.getLastName());
        user.setEmail(user.getEmail());
        user.setUsername(user.getUsername());
        user.setPassword(user.getPassword());
        user.setRoles(Arrays.asList("USER"));
        userRepository.save(user);
        return user;
    }
}
