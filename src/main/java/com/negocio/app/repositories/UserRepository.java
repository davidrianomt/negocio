/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio.app.repositories;

import com.negocio.app.entities.User;
import com.negocio.app.repositories.crud.UserCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author David Riaño
 */
@Repository
public class UserRepository {
    
    @Autowired
    private UserCrudRepository userCRUD ;
    
    public List<User> getAll() {
        return (List<User>) userCRUD.findAll();
    }
    
    public Optional<User> getById(Integer id) {
        return userCRUD.findById(id);
    }
    public Optional<User> getByMonthBirthDay(String id) {
        return userCRUD.findByMonthBirthtDay(id);
    }
    public Optional<User> getEmail(String email) {
        return userCRUD.findByEmail(email);
    }
    
    public User save(User user) {
        return userCRUD.save(user);
    }
    
    public void delete(Integer id) {
        userCRUD.deleteById(id);
    }

    public User getEmailandPassword(String email, String password) {
        return userCRUD.findByEmailAndPassword(email, password);
    }
    
}