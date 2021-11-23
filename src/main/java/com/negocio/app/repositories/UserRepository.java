/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio.app.repositories;

import com.negocio.app.entities.User;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.negocio.app.repositories.crud.UserCrudRepository;

/**
 *
 * @author David Riaño
 */
@Repository
public class UserRepository {
    
    @Autowired
    private UserCrudRepository userCrudrepository;
    
    /**
     * Consultar
    */
    public List<User> getAll(){
        return (List<User>) userCrudrepository.findAll();
    }
    
    //Buscar registro por Id
    public Optional<User> getUser(int id){
        return userCrudrepository.findById(id);
    }
    
    /**
     * Registrar
     */
    public User save(User user){
        return userCrudrepository.save(user);
    }
    
    /**
     * Eliminar
     */
    public void delete(User user){
        userCrudrepository.delete(user);
    }
    
    public User getUser(String email){
        return userCrudrepository.findAllByEmail(email);
    }
}
