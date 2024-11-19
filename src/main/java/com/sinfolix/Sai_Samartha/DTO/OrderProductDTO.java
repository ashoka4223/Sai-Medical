package com.sinfolix.Sai_Samartha.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.core.annotation.Order;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderProductDTO {

    private Order order;
    private ProductCatalogueDTO productCatalogueDTO;
    private int quantity;

}
