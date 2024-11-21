package com.sinfolix.Sai_Samartha.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String customerName;
    private String customerEmail;
    private String customerAddress;
    private LocalDate orderDate;
    private LocalDate modified_time;
    private int status;
    private boolean isPrescriptionBased;
    private boolean reviewed;

    @ManyToOne
    @JoinColumn(referencedColumnName = "user_id")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
