package com.example.demo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Publication;
import com.example.demo.entity.repository.PublicationsRepository;

@Service
public class PublicationImpl implements IPublicationsService {
	@Autowired
	PublicationsRepository publicationsRepository;

	@Override
	public Publication addPublication(Publication p) {
		publicationsRepository.save(p);
		return p;
	}

	@Override
	public void deletePublication(Long id) {
		publicationsRepository.deleteById(id);

	}

	@Override
	public Publication updatePublication(Publication p) {
		return publicationsRepository.saveAndFlush(p);
	}

	@Override
	public Publication findPublication(Long id) {
		Publication p = (Publication) publicationsRepository.findById(id).get();
		return p;
	}

	@Override
	public List<Publication> findAll() {
		return publicationsRepository.findAll();
	}

	@Override
	public Publication findByType(String type) {

		return (Publication) publicationsRepository.findByType(type);
	}

	@Override
	public Publication findByTitre(String titre) {
		return (Publication) publicationsRepository.findByTitre(titre);
	}

	@Override
	public List<Publication> findByLien(String lien) {
		return publicationsRepository.findByLien(lien);
	}

	@Override
	public List<Publication> findByDate(Date date) {
		return publicationsRepository.findByDate(date);
	}

}
