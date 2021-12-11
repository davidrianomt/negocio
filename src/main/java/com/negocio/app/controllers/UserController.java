/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio.app.controllers;

import com.negocio.app.entities.User;
import com.negocio.app.services.UserService;
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
@RequestMapping("/api/user")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable("id") Integer id) {
        return userService.getById(id);
    }

    @PostMapping("/new")
    public ResponseEntity<User> save(@RequestBody User user) {
        Optional<User> p = userService.save(user);
        return new ResponseEntity(p, HttpStatus.CREATED);
    }

    @GetMapping("/emailexist/{email}")
    public boolean emailExist(@PathVariable String email) {
        return userService.emailExist(email);
    }

    @GetMapping("/{email}/{password}")
    public User emailPassword(@PathVariable("email") String email, @PathVariable("password") String password) {
        return userService.correctPassword(email, password);
    }

    @PutMapping("/update")
    public ResponseEntity<User> update(@RequestBody User user) {
        User p = userService.update(user);
        return new ResponseEntity(p, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        userService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
