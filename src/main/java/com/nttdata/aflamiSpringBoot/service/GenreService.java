package com.nttdata.aflamiSpringBoot.service;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nttdata.aflamiSpringBoot.entity.Genre;
import com.nttdata.aflamiSpringBoot.repository.GenreRepository;

@Service
public class GenreService {
	GenreRepository genreRepository;

	public GenreService(GenreRepository genreRepository) {
		this.genreRepository = genreRepository;
	}

	public List<Genre> getList() {
		return genreRepository.findAll();
	}
	public List<Genre> getFilteredList(String filter){
		return genreRepository.findByLibelleContaining(filter, Pageable.ofSize(50))
				.getContent();
	}
	public Genre getGenre(Long ID) {
		return genreRepository.findById(ID).orElse(new Genre());
	}
	public Genre save(Genre genre) {
		return genreRepository.save(genre);
	}
	public void delete(Long ID) {
		genreRepository.deleteById(ID);
	}

}
