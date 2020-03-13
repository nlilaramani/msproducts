/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecomm.ecapp;

import com.ecomm.ecapp.service.InventoryService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

/**
 *
 * @author itexps
 */
@Configuration
public class Config {
    @Bean
    MessageListenerAdapter messageListener() { 
        return new MessageListenerAdapter(new InventoryService());
    }
    
    @Bean
    RedisMessageListenerContainer redisContainer() {
        RedisMessageListenerContainer container 
        = new RedisMessageListenerContainer(); 
        container.setConnectionFactory(redisConnectionFactory()); 
        container.addMessageListener(messageListener(), topic()); 
        return container; 
    }
    @Bean
    public LettuceConnectionFactory redisConnectionFactory() {

        return new LettuceConnectionFactory(new RedisStandaloneConfiguration("localhost", 6379));
    }
    @Bean
    ChannelTopic topic() {
        return new ChannelTopic("messageQueue");
    }
    /*private RedisConnectionFactory jedisConnectionFactory() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
}
