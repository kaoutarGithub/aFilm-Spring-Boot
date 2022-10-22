package com.nttdata.aflamiSpringBoot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.nttdata.aflamiSpringBoot.enums.TypeMedia;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Media {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMedia;
	@Column(nullable = false, length = 254)
	private String media;
	@Column(nullable = false, length = 50)
	@Enumerated(EnumType.STRING)
	private TypeMedia typeMedia;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "FILM_ID")
	private Film film;


}
