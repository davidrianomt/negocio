/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio.app.services;

import com.negocio.app.entities.Order;
import com.negocio.app.repositories.OrderRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author David Riaño
 */
@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    
    public List<Order> getAll() {
        return orderRepository.getAll();
    }
    
    public List<Order> getAllByZone(String zone){
        return orderRepository.getAllByZone(zone);
    }
    
    
    public List<Order> getAllBySalesman(Integer id){
        return orderRepository.getAllBySalesman(id);
    }
    
    public List<Order> getAllByRegisterDayAndSalesmanId(String registerDay, Integer id) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(registerDay);
        return orderRepository.getAllByRegisterDayAndSalesmanId(date, id);
    }
    
    public List<Order> getAllByStatusAndSalesmanId(String status, Integer id) {
        return orderRepository.getAllByStatusAndSalesmanId(status, id);
    }
    
    public Order getById(Integer id) {
        return orderRepository.getById(id).orElse(null);
    }
      
    public Optional<Order> save(Order order) {
        
        if (order.getId() == null) 
            return Optional.of(order);
        
        Optional<Order> existeOrder = orderRepository.getById(order.getId());
        
        if (existeOrder.isPresent()) 
            return Optional.of(order);
        
        orderRepository.save(order);
        return Optional.empty();
    }
    
    public Order update(Order order) {
        
          if (order.getId() == null)
            return order;
        
        Optional<Order> existeOrder = orderRepository.getById(order.getId());
        
        if (existeOrder.isPresent() == false)
            return order;

        orderRepository.save(order);
        return null;
    }
    
    public void delete(Integer id) {
        orderRepository.delete(id);
    }
}
