/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio.app.services;

import com.negocio.app.entities.Clothe;
import com.negocio.app.repositories.ClotheRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author David Riaño
 */
@Service
public class ClotheService {
    
    @Autowired
    private ClotheRepository clotheRepository;
    
    public List<Clothe> getAll() {
        return clotheRepository.getAll();
    }
    
    public Clothe getByReference(String reference) {
        return clotheRepository.getByReference(reference).orElse(null);
    }
    
    public Clothe save(Clothe clothe) {
        
        if (clothe.getReference() == null) 
            return clothe;
        
        Optional<Clothe> existeClothe = clotheRepository.getByReference(clothe.getReference());
        
        if (existeClothe.isPresent()) 
            return clothe;
        
        clotheRepository.save(clothe);
        return null;
    }

    
    public Clothe update(Clothe clothe) {
        
          if (clothe.getReference() == null)
            return clothe;
        
        Optional<Clothe> existeClothe = clotheRepository.getByReference(clothe.getReference());
        
        if (existeClothe.isPresent() == false)
            return clothe;

        existeClothe.get().setReference(clothe.getReference());
        existeClothe.get().setCategory(clothe.getCategory());
        if(clothe.getSize()!=null){
            existeClothe.get().setSize(clothe.getSize());
        }
        existeClothe.get().setDescription(clothe.getDescription());
        existeClothe.get().setPrice(clothe.getPrice());
        existeClothe.get().setAvailability(true);
        existeClothe.get().setQuantity(clothe.getQuantity());
        existeClothe.get().setPhotography(clothe.getPhotography());
        clotheRepository.save(existeClothe.get());
        return null;
    }
    
    public void delete(String reference) {
        clotheRepository.delete(reference);
    }
    
}
