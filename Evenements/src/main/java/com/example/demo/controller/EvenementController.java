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

import com.example.demo.entity.Evenement;
import com.example.demo.service.IEvenementService;

@RestController
public class EvenementController {
	@Autowired
	IEvenementService evenementservice;

	@GetMapping(value = "/evenements")
	public List<Evenement> findEvenement() {
		return evenementservice.findAll();
	}

	@GetMapping(value = "/evenement/{id}")
	public Evenement findEvenementById(@PathVariable Long id) {
		return evenementservice.findEvenement(id);
	}

	@GetMapping(value = "/evenement/search/titre")
	public Evenement findEvenementByTitre(@RequestParam String titre) {
		return evenementservice.findByTitre(titre);
	}

	@GetMapping(value = "/evenement/search/date")
	public Evenement findEvenementByDate(@RequestParam Date date) {
		return evenementservice.findByDate(date);
	}

	@GetMapping(value = "/evenement/search/lieu")
	public Evenement findEvenementByLieu(@RequestParam String lieu) {
		return evenementservice.findByLieu(lieu);
	}

	@PostMapping(value = "/evenement")
	public Evenement addEvenement(@RequestBody Evenement e) {
		return evenementservice.addEvenement(e);
	}

	@DeleteMapping(value = "/evenement/{id}")
	public void deleteEvenement(@PathVariable Long id) {
		evenementservice.deleteEvenement(id);

	}

	@PutMapping(value = "/evenement/{id}")
	public Evenement updateEvenement(@PathVariable Long id, @RequestBody Evenement e) {

		e.setId(id);
		return evenementservice.updateEvenement(e);

	}

}
