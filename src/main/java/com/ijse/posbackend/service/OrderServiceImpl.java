package com.ijse.posbackend.service;

import com.ijse.posbackend.dto.OrderDTO;
import com.ijse.posbackend.entity.Order;
import com.ijse.posbackend.entity.Product;
import com.ijse.posbackend.repository.OrderRepository;
import com.ijse.posbackend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    @Override
    public Order createOrder(OrderDTO orderDTO){

        Order order = new Order();

        List<Long> products = orderDTO.getProducts();

        Set<Product> productSet = new HashSet<>();


        order.setTotal(0.0);


        for (Long productId : products){
            Product product = productRepository.findById(productId).orElse(null);

            if(product != null && product.getQty() != 0){
                productSet.add(product);
                order.setTotal(order.getTotal()+product.getPrice());


            }
        }
        Double tax = (order.getTotal()/100)*15;

        order.setTax(tax);
        order.setOrderTime(LocalDateTime.now());
        order.setProducts(productSet);


        return orderRepository.save(order);
    }

    @Override
    public Order getOrderById(Long id){
        return orderRepository.findById(id).orElse(null);
    }
}
