package com.example.demo.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.*;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.example.demo.beans.PublicationBean;

@Entity
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name= "type_mbr", discriminatorType = DiscriminatorType.STRING,length = 3)
public abstract class Membre implements Serializable {
	public Membre() {
		super();
	}

	public Membre(String cin, String nom, String prénom, Date date, byte[] photo, String cv, String email,
			String password) {
		super();
		this.cin = cin;
		this.nom = nom;
		this.prénom = prénom;
		this.date = date;
		this.photo = photo;
		this.cv = cv;
		this.email = email;
		this.password = password;
	}
	@Transient
	Collection<PublicationBean> pubs;
	public Collection<PublicationBean> getPubs() {
		return pubs;
	}

	public void setPubs(Collection<PublicationBean> pubs) {
		this.pubs = pubs;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String cin;
	private String nom;
	private String prénom;
	@Temporal(TemporalType.DATE)
	private Date date;
	@Lob
	private byte[] photo;
	private String cv;
	private String email;
	private String password;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrénom() {
		return prénom;
	}

	public void setPrénom(String prénom) {
		this.prénom = prénom;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public String getCv() {
		return cv;
	}

	public void setCv(String cv) {
		this.cv = cv;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

}
