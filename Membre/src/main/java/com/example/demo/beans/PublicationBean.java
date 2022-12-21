package com.example.demo.beans;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.NonNull;

@Data
public class PublicationBean {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NonNull
	private String type;
	@NonNull
	private String titre;
	@NonNull
	private String lien;
	@NonNull
	@Temporal(TemporalType.DATE)
	private Date date;
	@NonNull
	private String sourcepdf;
}
