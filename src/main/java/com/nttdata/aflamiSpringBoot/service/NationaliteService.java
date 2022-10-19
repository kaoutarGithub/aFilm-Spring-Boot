package com.nttdata.aflamiSpringBoot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nttdata.aflamiSpringBoot.entity.Nationalite;
import com.nttdata.aflamiSpringBoot.repository.NationaliteRepository;

@Service
public class NationaliteService {
	NationaliteRepository nationaliteRepository;
	public NationaliteService(NationaliteRepository nationaliteRepository) {
		this.nationaliteRepository=nationaliteRepository;
	}
	
	public List<Nationalite> getList(){
		return nationaliteRepository.findAll();
	}
	public Nationalite getNationalite(Long ID) {
		return nationaliteRepository.findById(ID)
				.orElse(new Nationalite());
	}
	public Nationalite save(Nationalite nationalite) {
		return nationaliteRepository.save(nationalite);
	}
	public void delete(Long ID) {
		nationaliteRepository.deleteById(ID);
	}

}
