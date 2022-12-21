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

import com.example.demo.entity.Outil;
import com.example.demo.service.IOutilService;

@RestController
public class OutilController {
	@Autowired
	IOutilService outilservice;

	@GetMapping(value = "/outils")
	public List<Outil> findOutil() {
		return outilservice.findAll();
	}

	@GetMapping(value = "/outil/{id}")
	public Outil findOutilById(@PathVariable Long id) {
		return outilservice.findOutil(id);
	}

	@GetMapping(value = "/outil/search/date")
	public List<Outil> findEvenementByDate(@RequestParam Date date) {
		return outilservice.findByDate(date);
	}

	@GetMapping(value = "/outil/search/source")
	public List<Outil> findEvenementByLieu(@RequestParam String source) {
		return outilservice.findBySource(source);
	}

	@PostMapping(value = "/outil")
	public Outil addOutil(@RequestBody Outil o) {
		return outilservice.addOutil(o);
	}

	@DeleteMapping(value = "/outil/{id}")
	public void deleteOutil(@PathVariable Long id) {
		outilservice.deleteOutil(id);
	}

	@PutMapping(value = "/outil/{id}")
	public Outil updateevenement(@PathVariable Long id, @RequestBody Outil o) {
		o.setId(id);
		return outilservice.updateOutil(o);

	}
}
