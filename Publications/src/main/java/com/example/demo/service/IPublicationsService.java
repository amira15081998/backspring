package com.example.demo.service;

import java.util.Date;
import java.util.List;

import com.example.demo.entity.Publication;

public interface IPublicationsService {
	// Crud
	public Publication addPublication(Publication p);

	public void deletePublication(Long id);

	public Publication updatePublication(Publication p);

	public Publication findPublication(Long id);

	public List<Publication> findAll();

	// Filtrage par propriété
	public Publication findByType(String type);

	public Publication findByTitre(String titre);

	public List<Publication> findByLien(String lien);

	public List<Publication> findByDate(Date date);

}
