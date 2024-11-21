//package com.sinfolix.Sai_Samartha.Service;
//
//
//import com.sinfolix.Sai_Samartha.DTO.UserDTO;
//import com.sinfolix.Sai_Samartha.Repository.UserRepository;
//import org.springframework.stereotype.Service;
//
//import java.util.Collections;
//
//@Service
//public class CustomUserDetailsServiceImpl implements UserDetailsService {
//
//    private final UserRepository userRepository;
//
//    public CustomUserDetailsServiceImpl(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        UserDTO user = userRepository.findByUsername(username).orElseThrow(()-> new UsernameNotFoundException("User not found with username "+ username));
//
//        return new org.springframework.security.core.userdetails.User(
//                user.getUsername(),
//                user.getPassword(),
//                Collections.singletonList(new SimpleGrantedAuthority(user.getRoles()))
//        );
//    }
//}
