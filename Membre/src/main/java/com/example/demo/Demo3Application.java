package com.example.demo;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.example.demo.beans.PublicationBean;
import com.example.demo.entity.EnseignantChercheur;
import com.example.demo.entity.Etudiant;
import com.example.demo.entity.Membre;
import com.example.demo.proxy.PublicationProxyService;
import com.example.demo.repository.MemberPubRepository;
import com.example.demo.repository.MembreRepository;
import com.example.demo.service.IMembreService;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class Demo3Application implements CommandLineRunner {
	@Autowired
	MembreRepository membreRepository;
	@Autowired
	IMembreService membreService;
	@Autowired
	PublicationProxyService pubproxy;
	@Autowired
	MemberPubRepository memberpubrep;
	
	public static void main(String[] args) {
		SpringApplication.run(Demo3Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// ajout de 2 enseignant
		EnseignantChercheur ens1 = new EnseignantChercheur("00000", "kmar", "sellami", new Date(), null, "cv", "email",
				"123456", "maitre de conf", "enis", null);
		membreRepository.save(ens1);
		EnseignantChercheur ens2 = new EnseignantChercheur("00001", "ahmed", "sellami", new Date(), null, "cv2",
				"email2", "", "maitre de conf", "enis", null);
		membreRepository.save(ens2);
		// ajout de 2 etudiants
		Etudiant e1 = new Etudiant("11113453", "Ahmed", "Miledi", new Date(), null, "cv1", "ahmed@mail.com", "123",
				new Date(), "diplome1", ens1);
		Etudiant e2 = new Etudiant("11110000", "Zakaria", "prénom", new Date(), null, "cv2", "zakaria@mail.com", "456",
				new Date(), "diplome2", ens2);
		membreRepository.save(e1);
		membreRepository.save(e2);
		// delete
		//membreRepository.deleteById(1L);
		// lister les membres
		// List<Membre> mbrs = membreRepository.findAll();
		// for (Membre membre : mbrs) {
		// System.out.println(membre.getNom() + "" + membre + membre.getPrénom()); }
		// update etudiant1
		// e1.setEmail("ahmed.miled@gmail.com");
		// membreRepository.save(e1);

		// Update a Member
		//Membre m = membreService.findMember(1L);
		//m.setCv("cv11.pdf");
		//membreService.updateMembre(m);
		// Delete a Member
		//membreService.deleteMembre(2L);
		PublicationBean pub= pubproxy.findpublicationById(1L);
		System.out.println(pub);
		membreService.affecterauteurTopublication(1L,1L);
		membreService.affecterauteurTopublication(1L,2L);
		membreService.affecterauteurTopublication(2L,2L);
		membreService.affecterauteurTopublication(2L,3L);
	}

}
