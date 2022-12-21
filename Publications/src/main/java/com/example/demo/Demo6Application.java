package com.example.demo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Publication;
import com.example.demo.entity.repository.PublicationsRepository;

@SpringBootApplication
@EnableDiscoveryClient
public class Demo6Application implements CommandLineRunner {
	@Autowired
	PublicationsRepository publicationsRepository; 
	public static void main(String[] args) {
		SpringApplication.run(Demo6Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//configuration.exposeIdsFor(Publication.class);
		Publication p1 = new Publication("science", "pub1", "lien1", new Date(), "source");
		Publication p2 = new Publication("informatique", "pub2", "lien2", new Date(), "source2");
		Publication p3 = new Publication("conference", "pub3", "lien3", new Date(), "source3");
		publicationsRepository.save(p1);
		publicationsRepository.save(p2);
		publicationsRepository.save(p3);
	}

}
