package com.sinfolix.Sai_Samartha.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequestDTO {

    private String customerName;
    private String customerEmail;
    private String customerAddress;
    private List<OrderProductDTO> orderProductDTOList;

}
