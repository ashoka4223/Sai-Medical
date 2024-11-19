package com.sinfolix.Sai_Samartha.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {

    private String customerName;
    private String customerEmail;
    private String customerAddress;
    private LocalDate orderDate;
    private LocalDate modified_time;
    private int status;
    private boolean isPrescriptionBased;
    private boolean reviewed;
}
