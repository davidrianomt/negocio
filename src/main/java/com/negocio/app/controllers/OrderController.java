/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio.app.controllers;

import com.negocio.app.entities.Order;
import com.negocio.app.services.OrderService;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author David Riaño
 */

@RestController
@RequestMapping("/api/order")
@CrossOrigin(origins = "*")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/all")
    public List<Order> getAll() {
        return orderService.getAll();
    }
    
    @GetMapping("/zona/{zone}")
    public List<Order> getAllByZone(@PathVariable String zone){
        return orderService.getAllByZone(zone);
    }
    
    @GetMapping("/salesman/{id}")
    public List<Order> getAllBySalesman(@PathVariable Integer id){
        return orderService.getAllBySalesman(id);
    }
    
    @GetMapping("/date/{registerDay}/{id}")
    public List<Order> getAllByRegisterDayAndSalesmanId(@PathVariable("registerDay") String registerDay,@PathVariable("id") Integer id){
        return orderService.getAllByRegisterDayAndSalesmanId(registerDay, id);
    }
    
    @GetMapping("/state/{status}/{id}")
    public List<Order> getAllByStatusAndSalesmanId(@PathVariable String status,@PathVariable Integer id) {
        return orderService.getAllByStatusAndSalesmanId(status, id);
    }

    @GetMapping("/{id}")
    public Order getById(@PathVariable Integer id) {
        return orderService.getById(id);
    }
        
    @PostMapping("/new")
    public ResponseEntity<Order> save(@RequestBody Order order) {
        Optional<Order> p = orderService.save(order);
        return new ResponseEntity(p, HttpStatus.CREATED);
    }
    
    @PutMapping("/update")
    public ResponseEntity<Order> update(@RequestBody Order order) {
        Order p = orderService.update(order);
        return new ResponseEntity(p, HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        orderService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
