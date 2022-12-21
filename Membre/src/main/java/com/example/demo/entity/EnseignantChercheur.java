package com.example.demo.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@DiscriminatorValue("ens")
public class EnseignantChercheur extends Membre implements Serializable {
	private String grade;
	private String etablissement;
	@JsonIgnore
	@OneToMany(mappedBy="encadrant")
	private Collection<Etudiant> etudiants;

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getEtablissement() {
		return etablissement;
	}

	public void setEtablissement(String etablissement) {
		this.etablissement = etablissement;
	}

	public EnseignantChercheur() {
		super();
	}

	public EnseignantChercheur(String cin, String nom, String prénom, Date date, byte[] photo, String cv, String email,
			String password, String grade, String etablissement, Collection<Etudiant> etudiants) {
		super(cin, nom, prénom, date, photo, cv, email, password);
		this.grade = grade;
		this.etablissement = etablissement;
		this.etudiants = etudiants;
	}

	public EnseignantChercheur(String grade, String etablissement, Collection<Etudiant> etudiants) {
		super();
		this.grade = grade;
		this.etablissement = etablissement;
		this.etudiants = etudiants;
	}
	

}
