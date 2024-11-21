package com.sinfolix.Sai_Samartha.DTO;
import com.sinfolix.Sai_Samartha.Entities.ProductCatalogue;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderProductDTO {

    private OrderDTO order;
    private ProductCatalogue productCatalogue;
    private int quantity;

}
