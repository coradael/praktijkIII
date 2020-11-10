package com.praktijk3;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import java.util.Random;

import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.autoconfigure.SpringBootApplication;


//
//import java.util.TimeZone;
//
//import javax.annotation.PostConstruct;
//
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import org.slf4j.LoggerFactory;
//
//
//
//
@SpringBootApplication
@EntityScan(basePackageClasses = { 
		Praktijk3Application.class,
		Jsr310JpaConverters.class 
})
//public class Praktijk3Application {
//	
//	@PostConstruct
//	void init() {
//		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
//	}
//
//	
//
//} 

public class Praktijk3Application implements CommandLineRunner { 
	
	private static Logger log = LoggerFactory.getLogger(Praktijk3Application.class);
	
	@PostConstruct
	void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}
	public static void main(String[] args) {
		SpringApplication.run(Praktijk3Application.class, args);		
			
		Random random = new Random();

        //Generate numbers between 0 and 100
        int firstRandomValue = random.nextInt(5);
        int secondRandomValue = random.nextInt(5);

        //Print the generated random values
        System.out.println("First int: " + firstRandomValue);
        System.out.println("Second int: " + secondRandomValue);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Hola Marinda y Noémie");
		System.out.println("Hola nuevamnete");
		
		log.info("Hola Marinda y Noémie");
		log.warn("Hola Elí tu puedes no te desanimes ");
		
	} 
	
	
	
} 


