/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio.app.repositories.crud;

import com.negocio.app.entities.User;
import java.util.Optional;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author David Riaño
 */
public interface UserCrudRepository extends CrudRepository<User, Integer>{
    @Query
    public Optional<User> findByEmail(String email);   

    public User findByEmailAndPassword(String email, String password);

    public Optional<User> findByMonthBirthtDay(String id);
}
