package com.example.demo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Evenement;
import com.example.demo.repository.EvenementRepository;

@Service
public class EvenementImpl implements IEvenementService {
	@Autowired
	EvenementRepository evenementRepository;

	@Override
	public Evenement addEvenement(Evenement e) {
		evenementRepository.save(e);
		return e;
	}

	@Override
	public void deleteEvenement(Long id) {
		evenementRepository.deleteById(id);
	}

	@Override
	public Evenement updateEvenement(Evenement e) {
		return evenementRepository.saveAndFlush(e);
	}

	@Override
	public Evenement findEvenement(Long id) {
		Evenement ev = (Evenement) evenementRepository.findById(id).get();
		return ev;
	}

	@Override
	public List<Evenement> findAll() {
		return evenementRepository.findAll();
	}

	@Override
	public Evenement findByTitre(String titre) {
		return evenementRepository.findByTitre(titre);
	}

	@Override
	public Evenement findByDate(Date date) {
		return evenementRepository.findByDate(date);
	}

	@Override
	public Evenement findByLieu(String lieu) {
		return evenementRepository.findByLieu(lieu);
	}

}
