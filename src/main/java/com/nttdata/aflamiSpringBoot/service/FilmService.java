package com.nttdata.aflamiSpringBoot.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.nttdata.aflamiSpringBoot.entity.Film;
import com.nttdata.aflamiSpringBoot.repository.FilmRepository;

@Service
public class FilmService extends AbstractService<Film> {
	FilmRepository filmRepository;
	public FilmService(FilmRepository filmRepository) {
		this.filmRepository=filmRepository;
	}
	
	@Override
	protected JpaRepository<Film, Long> getRepository() {
		return filmRepository;
	}

}
