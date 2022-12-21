package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.PublicationMembreIds;
import com.example.demo.entity.Publication_Membre;



public interface MemberPubRepository extends JpaRepository<Publication_Membre, PublicationMembreIds> {
	@Query("select m from Publication_Membre m where auteur_id=:x")
	List<Publication_Membre> findpubId(@Param("x") Long autId);
	//param mouch mel feign
}
