package com.example.demo.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Evenement;

@Repository
public interface EvenementRepository extends JpaRepository<Evenement, Long> {
	Evenement findByTitre(String titre);

	Evenement findByDate(Date date);

	Evenement findByLieu(String lieu);
}
