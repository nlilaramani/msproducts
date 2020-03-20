/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecomm.ecapp.controller;

import com.ecomm.ecapp.domain.Product;
import com.ecomm.ecapp.repository.ProductRepo;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author itexps
 */
@RestController
public class ProductController {
    @Autowired
    private ProductRepo productRepo;
    
    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public Iterable<Product> getAllProducts(){
        /*Product p=new Product(1,"TV","TV",500.00);
        List<Product> result=new ArrayList<Product>();
        result.add(p);*/
        //return productRepo.findAll();
        return productRepo.findAll();
        //return null;
    }
    
    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public Product addProduct(@RequestBody Product p){
        productRepo.save(p);
        return p;
    }
    //@PreAuthorize("#oauth2.hasScope('custom_scope')")
    @RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
    public Product updateProduct(@PathVariable(name = "id") int productId,@RequestBody Product p){
        productRepo.save(p);
        return p;
    }
    @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
    public void removeProduct(@PathVariable(name="id") int productId){
        productRepo.deleteById(productId);
    }
    @RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
    public Product getProduct(@PathVariable(name = "id") int productId){
        Optional<Product> p=productRepo.findById(productId);
        return p.get();   
    }
  }
