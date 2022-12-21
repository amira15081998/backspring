package com.example.demo.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Publication_Membre {
	@EmbeddedId
	private PublicationMembreIds id;
	@ManyToOne
	@MapsId("auteur_id")
	private Membre auteur;
}
