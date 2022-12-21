package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.EnseignantChercheur;
import com.example.demo.entity.Etudiant;
import com.example.demo.entity.Membre;
import com.example.demo.service.IMembreService;

@RestController
public class MemberController {
	@Autowired
	IMembreService membreservice;

	@GetMapping(value = "/membres")
	public List<Membre> findMembres() {
		return membreservice.findAll();
	}

	@GetMapping(value = "/membre/{id}")
	public Membre findOneMemberById(@PathVariable Long id) {
		return membreservice.findMember(id);
	}

	@GetMapping(value = "/membre/search/cin")
	public Membre findOneMemberByCin(@RequestParam String cin) {
		return membreservice.findByCin(cin);
	}

	@GetMapping(value = "/membre/search/email")
	public Membre findOneMemberByEmail(@RequestParam String email) {
		return membreservice.findByEmail(email);
	}

	@PostMapping(value = "/membres/enseignant")
	public Membre addMembre(@RequestBody EnseignantChercheur m) {
		return membreservice.addMembre(m);
	}

	@PostMapping(value = "/membres/etudiant")
	public Membre addMembre(@RequestBody Etudiant e) {
		return membreservice.addMembre(e);
	}

	@DeleteMapping(value = "/membres/{id}")
	public void deleteMembre(@PathVariable Long id) {

		membreservice.deleteMembre(id);

	}

	@PutMapping(value = "/membres/etudiant/{id}")
	public Membre updatemembre(@PathVariable Long id, @RequestBody Etudiant p) {

		p.setId(id);
		return membreservice.updateMembre(p);

	}

	@PutMapping(value = "/membres/enseignant/{id}")
	public Membre updateMembre(@PathVariable Long id, @RequestBody EnseignantChercheur p) {

		p.setId(id);
		return membreservice.updateMembre(p);

	}
	@GetMapping("/fullmember/{id}")
	public Membre findAFullMember(@PathVariable(name="id") Long id)
	{

	Membre mbr=membreservice.findMember(id);
	mbr.setPubs(membreservice.findPublicationparauteur(id));

	return mbr;
	}
}
