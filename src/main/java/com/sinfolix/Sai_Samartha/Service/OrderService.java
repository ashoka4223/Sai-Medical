package com.sinfolix.Sai_Samartha.Service;

import com.sinfolix.Sai_Samartha.DTO.OrderDTO;
import com.sinfolix.Sai_Samartha.DTO.OrderProductDTO;
import com.sinfolix.Sai_Samartha.Entities.Order;
import com.sinfolix.Sai_Samartha.Entities.OrderProduct;
import com.sinfolix.Sai_Samartha.Exceptions.ResourceNotFoundException;
import com.sinfolix.Sai_Samartha.Repository.OrderProductRepository;
import com.sinfolix.Sai_Samartha.Repository.OrderRepository;
import com.sinfolix.Sai_Samartha.Repository.ProductCatalogueRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public  class OrderService {
    @Autowired
    private OrderProductRepository orderProductRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductCatalogueRepo productCatalogueRepo;


    public OrderDTO createOrder(OrderDTO orderDTO, List<OrderProductDTO> orderProductDTOList) {
        Order order = new Order();
//        Set order Properties
        order.setCustomerName(orderDTO.getCustomerName());
        order.setCustomerEmail(orderDTO.getCustomerEmail());
        order.setCustomerAddress(orderDTO.getCustomerAddress());
        order.setOrderDate(orderDTO.getOrderDate());
        order.setModified_time(orderDTO.getModified_time());
        order.setStatus(orderDTO.getStatus());

        Order savedOrder = orderRepository.save(order);

        for (OrderProductDTO orderProductDTO : orderProductDTOList) {
            OrderProduct orderProduct = new OrderProduct();
            orderProduct.setOrder(savedOrder);
            orderProduct.setProductCatalogue(productCatalogueRepo.findById(orderProductDTO.getProductCatalogue().getId()).orElseThrow(() -> new ResourceNotFoundException("Product Catalogue", "ID ", orderProductDTO.getProductCatalogue().getId())));
            orderProduct.setQuantity(orderProductDTO.getQuantity());
            orderProductRepository.save(orderProduct);
        }
        return OrderToOrderDTO(savedOrder);
    }



    // Return all the product ordered by specific customer

    public List<Order> getOrderListByCustomerEmail(String customerEmail) {
        return orderRepository.findByCustomerEmail(customerEmail);
    }

    // Return order by ID

    public OrderDTO getOrderById(int orderId) {
        return null;
    }

    //  Return all the placed orders
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    private OrderDTO OrderToOrderDTO(Order order) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setCustomerName(order.getCustomerName());
        orderDTO.setCustomerEmail(order.getCustomerEmail());
        orderDTO.setCustomerAddress(order.getCustomerAddress());
        orderDTO.setOrderDate(order.getOrderDate());
        orderDTO.setModified_time(order.getModified_time());
        orderDTO.setStatus(order.getStatus());
        return orderDTO;

    }
}

