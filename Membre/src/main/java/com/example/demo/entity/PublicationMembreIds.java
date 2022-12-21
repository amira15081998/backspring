package com.example.demo.entity;

import javax.persistence.Embeddable;

import lombok.*;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PublicationMembreIds implements java.io.Serializable {
//clé composite
	private Long publication_id;
	private Long auteur_id;
}
