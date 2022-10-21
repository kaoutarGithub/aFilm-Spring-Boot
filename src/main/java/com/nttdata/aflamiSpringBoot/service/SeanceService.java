package com.nttdata.aflamiSpringBoot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nttdata.aflamiSpringBoot.entity.Seance;
import com.nttdata.aflamiSpringBoot.repository.SeanceRepository;

@Service
public class SeanceService {
	SeanceRepository seanceRepository;
	public SeanceService(SeanceRepository seanceRepository) {
		this.seanceRepository = seanceRepository;
	}

	public List<Seance> getSeances() {
		return seanceRepository.findAll();
	}
	public Seance getSeance(Long ID) {
		return seanceRepository.findById(ID)
				.orElseThrow(()->new RuntimeException());
	}
	public Seance setSeance(Seance s) {
		return seanceRepository.save(s);
	}
	public void deleteSeance(Long ID) {
		seanceRepository.deleteById(ID);
	}


}
