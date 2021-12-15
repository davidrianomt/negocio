/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio.app.repositories.crud;

import com.negocio.app.entities.Clothe;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author David Riaño
 */
public interface ClotheCrudRepository  extends MongoRepository<Clothe, Integer>{
    public Optional<Clothe> findByReference(String reference);
    public Optional<Clothe> findByPriceLessThanEqual(Integer price);
    public Optional<Clothe> findByDescriptionContainingIgnoreCase(String word);
    public void deleteByReference(String reference);
}
