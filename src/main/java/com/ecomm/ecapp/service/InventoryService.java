/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecomm.ecapp.service;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Service;

/**
 *
 * @author itexps
 */
@Service
public class InventoryService implements MessageListener{

   @Override
    public void onMessage(Message msg, byte[] bytes) {
        System.out.println("Received Message:"+msg.toString());
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
