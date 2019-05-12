package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.handler.MappedInterceptor;

import com.example.demo.handler.LogIntercepter;

@SpringBootApplication
public class DemoApplication {

    @Autowired
    private LogIntercepter logIntercepter;
    
    // register intercepter
    @Bean
    public MappedInterceptor accessInterceptor() {
        return new MappedInterceptor(new String[] {"/*"},
        		logIntercepter);
    }
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
