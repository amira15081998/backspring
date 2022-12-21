package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@DiscriminatorValue("etd")

public class Etudiant extends Membre implements Serializable {
	@Temporal(TemporalType.DATE)
	private Date dateinscription;
	private String diplome;

	public Date getDateinscription() {
		return dateinscription;
	}

	public void setDateinscription(Date dateinscription) {
		this.dateinscription = dateinscription;
	}

	public String getDiplome() {
		return diplome;
	}

	public void setDiplome(String diplome) {
		this.diplome = diplome;
	}

	public EnseignantChercheur getEncadrant() {
		return encadrant;
	}

	public void setEncadrant(EnseignantChercheur encadrant) {
		this.encadrant = encadrant;
	}

	public Etudiant() {
		super();
	}

	@ManyToOne
	private EnseignantChercheur encadrant;

	public Etudiant(String cin, String nom, String prénom, Date date, byte[] photo, String cv, String email,
			String password, Date dateinscription, String diplome, EnseignantChercheur encadrant) {
		super(cin, nom, prénom, date, photo, cv, email, password);
		this.dateinscription = dateinscription;
		this.diplome = diplome;
		this.encadrant = encadrant;
	}

	public Etudiant(Date dateinscription, String diplome, EnseignantChercheur encadrant) {
		super();
		this.dateinscription = dateinscription;
		this.diplome = diplome;
		this.encadrant = encadrant;
	}
	
	
}
