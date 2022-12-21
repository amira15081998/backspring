package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.*;

import com.example.demo.entity.Etudiant;

@Repository

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
	List<Etudiant> findByDiplome(String diplome);

}
