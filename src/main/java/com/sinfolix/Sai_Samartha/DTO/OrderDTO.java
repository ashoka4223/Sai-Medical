package com.sinfolix.Sai_Samartha.DTO;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {

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

    private int userId;
}
