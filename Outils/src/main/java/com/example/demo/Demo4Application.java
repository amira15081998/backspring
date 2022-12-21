package com.example.demo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.Outil;
import com.example.demo.repository.OutilsRepository;
import com.example.demo.service.IOutilService;

@SpringBootApplication
public class Demo4Application implements CommandLineRunner {
	@Autowired
	OutilsRepository outilsRepository;
	@Autowired
	IOutilService outilService;

	public static void main(String[] args) {
		SpringApplication.run(Demo4Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
Outil O1 = new Outil (new Date(), "ENS1");
outilsRepository.save(O1);
	}

}
