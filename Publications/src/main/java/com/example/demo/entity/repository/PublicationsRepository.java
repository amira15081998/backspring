package com.example.demo.entity.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Publication;

@Repository
public interface PublicationsRepository extends JpaRepository<Publication, Long> {
	List<Publication> findByTitre(String titre);

	List<Publication> findByType(String type);
	
	List<Publication> findByLien(String lien);
	
	List<Publication> findByDate(Date date);
	

}
