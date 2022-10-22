package com.nttdata.aflamiSpringBoot.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Film extends AbstractModel {/**
	 * 
	 */
	private static final long serialVersionUID = -3069653192725569123L;
	
	@Column(nullable = false,length = 100)
	private String title;
	
	@Column(nullable = false)
	private int duree;
	
	@Column(nullable = false)
	private int annee;
	
	@Column(nullable = true,length = 100)
	private String photo;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "GENRE_ID")
	private Genre genre;
	
	@OneToMany(mappedBy = "film",fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Seance> seances;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "NATIONALITE_ID")
	private Nationalite nationalite;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
		name = "FILM_ACTEUR",
		joinColumns =@JoinColumn(name="FILM_ID",referencedColumnName = "ID"),
		inverseJoinColumns = @JoinColumn(name="ACTEUR_ID",referencedColumnName = "ID")
	)
	@JsonIgnore
	private List<Personne> acteurs;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "REALISATEUR_ID")
	@JsonIgnore
	private Personne realisateur;
	
	@OneToMany(mappedBy = "film", cascade = {CascadeType.ALL})
	@JsonIgnore
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Media> medias;

}
