package com.nttdata.aflamiSpringBoot.entity;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
	
	@Column(name = "date_projection")
	private Date dateProjection;
	
	@Column(name = "date_debut")
	private Time dateDebuT;
	
	@Column(name = "date_fin")
	private Time dateFin;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "SALLE_ID")
	private Salle salle;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "FILM_ID")
	private Film film;
	

}
