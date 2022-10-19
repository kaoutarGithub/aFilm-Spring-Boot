package com.nttdata.aflamiSpringBoot.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Nationalite extends AbstractModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8329745813776714891L;
	
	@Column(nullable = false,length = 50)
	private String libelle;
	
	@OneToMany(mappedBy = "nationalite",fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Film> films;
	
	@OneToMany(mappedBy = "nationalite",fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Personne> personnes;
	

}
