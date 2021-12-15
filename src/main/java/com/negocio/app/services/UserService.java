/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio.app.services;

import com.negocio.app.entities.User;
import com.negocio.app.repositories.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    public List<User> getAll() {
        return userRepository.getAll();
    }
    
    public User getById(Integer id) {
        return userRepository.getById(id).orElse(null);
    }
    
    public boolean emailExist(String email) {        
        return userRepository.getEmail(email).isPresent();
    }
    
    public User correctPassword(String email, String password) {
        User user = userRepository.getEmailandPassword(email, password);
        User validacionFallida = new User();
        String name = "NO DEFINIDO";

        if (user == null) {
            // validacionFallida.setName(name);
            // validacionFallida.setEmail(email);
            // validacionFallida.setPassword(password);

            return validacionFallida;
        } else {
            return user;
        }
    }

    
    public Optional<User> save(User user) {
        
        if (user.getId() == null) 
            return Optional.of(user);
        
        Optional<User> existeUser = userRepository.getById(user.getId());
        
        if (existeUser.isPresent()) 
            return Optional.of(user);
        
        userRepository.save(user);
        return Optional.empty();
    }
    
    public User update(User user) {
        
          if (user.getId() == null)
            return user;
        
        Optional<User> existeUser = userRepository.getById(user.getId());
        
        if (existeUser.isPresent() == false)
            return user;

        //existeUser.get().setNombre(user.getNombre());
        //existeUser.get().setCorreo(user.getCorreo());
        //existeUser.get().setEdad(user.getEdad());
        userRepository.save(user);
        return null;
    }
    
    public void delete(Integer id) {
        userRepository.delete(id);
    }

    public User getByMonthBirthtDay(String id) {
        return userRepository.getByMonthBirthDay(id).orElse(null);
    }
    
}