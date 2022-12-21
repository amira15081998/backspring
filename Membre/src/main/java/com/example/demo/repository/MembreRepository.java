package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Etudiant;
import com.example.demo.entity.Membre;

@Repository
public interface MembreRepository extends JpaRepository<Membre, Long> {

	Membre findByCin(String cin);

	List<Membre> findByNomStartingWith(String caractere);

	Membre findByEmail(String email);

	List<Membre> findByNom(String nom);

	List<Etudiant> findByDiplome(String diplome);

}
