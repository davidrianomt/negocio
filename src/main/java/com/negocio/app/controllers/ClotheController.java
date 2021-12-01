package com.negocio.app.controllers;

import com.negocio.app.entities.Clothe;
import com.negocio.app.services.ClotheService;
import java.util.List;
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author David Riaño
 */
@RestController
@RequestMapping("/api/clothe")
@CrossOrigin(origins = "*")
public class ClotheController {
    
    @Autowired
    private ClotheService clotheService;

    @GetMapping("/all")
    public List<Clothe> getAll() {
        return clotheService.getAll();
    }

    //@GetMapping("/{reference}")
    //public Clothe getByReference(@PathVariable String reference) {
    //    return clotheService.getByReference(id);
    //}
    
    @PostMapping("/new")
    public ResponseEntity<Clothe> save(@RequestBody Clothe clothe) {
        Clothe p = clotheService.save(clothe);
        return new ResponseEntity(p, HttpStatus.CREATED);
    }
    

    @PutMapping("/update")
    public ResponseEntity<Clothe> update(@RequestBody Clothe clothe) {
        Clothe p = clotheService.update(clothe);
        return new ResponseEntity(p, HttpStatus.CREATED);
    }


    @DeleteMapping("/{reference}")
    public ResponseEntity delete(@PathVariable String reference) {
        clotheService.delete(reference);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
    
}
