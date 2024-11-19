package com.sinfolix.Sai_Samartha.Entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String customerName;
    private String customerEmail;
    private String customerAddress;
    private LocalDate orderDate;
    private LocalDate modified_time;
    private int status;
    private boolean isPrescriptionBased;
    private boolean reviewed;
}
