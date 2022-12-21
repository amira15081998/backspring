package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Publication implements Serializable {
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
