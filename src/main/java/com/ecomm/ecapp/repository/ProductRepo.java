/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecomm.ecapp.repository;

import com.ecomm.ecapp.domain.Product;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author itexps
 */
public interface ProductRepo extends CrudRepository<Product,Integer> {
    
}
