/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio.app.repositories.crud;

import com.negocio.app.entities.Order;
import java.util.Date;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author David Riaño
 */
public interface OrderCrudRepository  extends MongoRepository<Order, Integer>{
    public List<Order> findAllBySalesManZone(String zone);
    public List<Order> findAllBySalesManId(Integer id);
    public List<Order> findAllByRegisterDayAndSalesManId(Date registerDay, Integer id);
    public List<Order> findAllByStatusAndSalesManId(String status, Integer id);
}
