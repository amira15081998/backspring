package com.example.demo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.Evenement;
import com.example.demo.repository.EvenementRepository;

@SpringBootApplication
public class Demo5Application implements CommandLineRunner {
	@Autowired
	EvenementRepository evenementRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(Demo5Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Evenement ev1= new Evenement("ev1", new Date(), "Amphi1");
		evenementRepository.save(ev1);
	}

}
