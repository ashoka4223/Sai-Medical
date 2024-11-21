package com.sinfolix.Sai_Samartha.Controller;


import com.sinfolix.Sai_Samartha.DTO.OrderDTO;
import com.sinfolix.Sai_Samartha.DTO.OrderProductDTO;
import com.sinfolix.Sai_Samartha.DTO.OrderRequestDTO;
import com.sinfolix.Sai_Samartha.ENUM.StatusEnum;
import com.sinfolix.Sai_Samartha.Entities.Order;
import com.sinfolix.Sai_Samartha.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
@CrossOrigin(origins = "/**")
// API Endpoint for Orders
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/")
    public ResponseEntity<OrderDTO> createOrder(@RequestBody OrderRequestDTO orderRequestDTO) {
        System.out.println("Product controller called ");
        OrderDTO order = new OrderDTO();
        // map orderRequestDTO to Order
        order.setCustomerAddress(orderRequestDTO.getCustomerAddress());
        order.setCustomerEmail(orderRequestDTO.getCustomerEmail());
        order.setCustomerName(orderRequestDTO.getCustomerName());
        order.setOrderDate(LocalDate.now());
        order.setStatus(StatusEnum.ORDER_PLACED.getStatus());
        order.setModified_time(LocalDate.now());

        List<OrderProductDTO> orderProductDTOList = new ArrayList<>();
        for (OrderProductDTO orderProductDTO : orderRequestDTO.getOrderProductDTOList()) {
            OrderProductDTO newOrderProductDTO = new OrderProductDTO();
            newOrderProductDTO.setProductCatalogue(orderProductDTO.getProductCatalogue());
            newOrderProductDTO.setQuantity(orderProductDTO.getQuantity());
            orderProductDTOList.add(newOrderProductDTO);
        }
        OrderDTO savedOrder = orderService.createOrder(order, orderProductDTOList);
        return new ResponseEntity<>(savedOrder, HttpStatus.CREATED);


    }

    @GetMapping("/{email}")
    public List<Order> getOrderListByCustomerEmail(@PathVariable String email) {
        return orderService.getOrderListByCustomerEmail(email);
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<Order> getAllPlacedOrders() {
        return orderService.getAllOrders();
    }
}

