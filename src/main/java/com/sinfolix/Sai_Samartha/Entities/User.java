package com.sinfolix.Sai_Samartha.Entities;

import com.sinfolix.Sai_Samartha.DTO.OrderDTO;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;
    private List<String> roles = new ArrayList<>();
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orders = new ArrayList<>();

    public void addOrder(Order order) {
        orders.add(order);
        order.setUser(this); // Establish bidirectional relationship
    }

    public void removeOrder(Order order) {
        orders.remove(order);
        order.setUser(null); // Break bidirectional relationship
    }


}
