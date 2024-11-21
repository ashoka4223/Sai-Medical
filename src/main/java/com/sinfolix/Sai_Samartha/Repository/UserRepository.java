package com.sinfolix.Sai_Samartha.Repository;

import com.sinfolix.Sai_Samartha.DTO.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserDTO, Integer> {

}
