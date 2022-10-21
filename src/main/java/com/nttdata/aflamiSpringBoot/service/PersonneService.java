package com.nttdata.aflamiSpringBoot.service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;

import com.nttdata.aflamiSpringBoot.entity.Film;
import com.nttdata.aflamiSpringBoot.entity.Personne;
import com.nttdata.aflamiSpringBoot.repository.PersonneRepository;

@Service @Transactional
public class PersonneService {
	PersonneRepository personneRepository;
	public PersonneService(PersonneRepository personneRepository) {
		this.personneRepository=personneRepository;
	}
	
	public List<Personne> getList(){
		return personneRepository.findAll();
	}
	public Personne getPersonne(Long ID) {
		return personneRepository.findById(ID)
				.orElse(new Personne());
	}
	public Personne save(Personne personne) {
		return personneRepository.save(personne);
	}
	
	/*
	 * public Personne save(Personne personne) { if(personne.getPhoto() != null) {
	 * personne.setPhoto(personne.getPhoto()); } else {
	 * personne.setPhoto("/thumbnail/d32084d9-f300-475b-9134-b1fb94cd036elogin.png")
	 * ; } return personneRepository.save(personne); }
	 */
	public void delete(Long ID) {
		personneRepository.deleteById(ID);
	}
	public List<Film> getFilmsRealise(Long ID){
		
		Personne personne=getPersonne(ID);
		Hibernate.initialize(personne.getFilmsRealises());
		return personne.getFilmsRealises();
	}

}
