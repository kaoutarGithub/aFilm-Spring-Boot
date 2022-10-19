package com.nttdata.aflamiSpringBoot.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.nttdata.aflamiSpringBoot.entity.Salle;
import com.nttdata.aflamiSpringBoot.entity.Seance;
import com.nttdata.aflamiSpringBoot.repository.SalleRepository;

@Service
@Transactional
public class SalleService {
	SalleRepository salleRepository;

	public SalleService(SalleRepository salleRepository) {
		this.salleRepository = salleRepository;
	}

	public List<Salle> getSalles() {
		return salleRepository.findAll();
	}


	public Salle getSalle(Long ID) {
		return salleRepository.findById(ID)
				.orElseThrow(()->new RuntimeException());
	}
	public Salle setSalle(Salle s) {
		return salleRepository.save(s);
	}
	public void deleteSalle(Long ID) {
		salleRepository.deleteById(ID);
	}
	public List<Seance> getSeancesBySalle(Long ID){
		return getSalle(ID).getSeances();
	}
	
}
