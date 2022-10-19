package com.nttdata.aflamiSpringBoot.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Salle extends AbstractModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4555692060440159448L;

	@Column(nullable = false,length = 40)
	private int numero;
	
	@Column(nullable = false,length = 50)
	private int capacite;
	
	@Column(name = "added_date",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",
			insertable = false,updatable = false)
	private Date addedDate;
	
	@OneToMany(mappedBy = "salle")
	@JsonIgnore
	private List<Seance> seances;
	

}
