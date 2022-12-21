package com.example.demo.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Publication;
import com.example.demo.service.IPublicationsService;

@RestController
public class PublicationController {
	@Autowired
	IPublicationsService publicationsservice;

	@GetMapping(value = "/publications")
	public List<Publication> findPublication() {
		return publicationsservice.findAll();
	}

	@GetMapping(value = "/publication/{id}")
	public Publication findPublicationById(@PathVariable Long id) {
		return publicationsservice.findPublication(id);
	}

	@GetMapping(value = "/publication/search/titre")
	public Publication findPublicationByTitre(@RequestParam String titre) {
		return publicationsservice.findByTitre(titre);
	}

	@GetMapping(value = "/publication/search/type")
	public Publication findPublicationByType(@RequestParam String type) {
		return publicationsservice.findByType(type);
	}

	@GetMapping(value = "/publication/search/date")
	public List<Publication> findPublicationByDate(@RequestParam Date date) {
		return publicationsservice.findByDate(date);
	}

	@GetMapping(value = "/publication/search/lien")
	public List<Publication> findPublicationByLien(@RequestParam String lien) {
		return publicationsservice.findByLien(lien);
	}

	@PostMapping(value = "publication")
	public Publication addPublication(@RequestBody Publication p) {
		return publicationsservice.addPublication(p);
	}

	@DeleteMapping(value = "/publication/{id}")
	public void deletePublication(@PathVariable Long id) {
		publicationsservice.deletePublication(id);

	}

	@PutMapping(value = "/publication/{id}")
	public Publication updatePublication(@PathVariable Long id, @RequestBody Publication p) {
		p.setId(id);
		return publicationsservice.updatePublication(p);

	}
}
