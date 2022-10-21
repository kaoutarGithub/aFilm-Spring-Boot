package com.nttdata.aflamiSpringBoot.entity;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Seance extends AbstractModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5970978952680800668L;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "date_projection")
	private Date dateProjection;
	
	@Temporal(TemporalType.TIME)
	@DateTimeFormat(pattern = "HH:mm")
	@Column(name = "heure_debut")
	private Date  heuredebut;
	
	@Temporal(TemporalType.TIME)
	@DateTimeFormat(pattern = "HH:mm")
	@Column(name = "heure_fin")
	private Date  	heureFin;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "SALLE_ID")
	private Salle salle;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "FILM_ID")
	private Film film;
	

}
