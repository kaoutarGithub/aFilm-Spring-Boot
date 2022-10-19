package com.nttdata.aflamiSpringBoot.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.nttdata.aflamiSpringBoot.entity.Genre;

@Repository
public interface GenreRepository extends JpaRepository<Genre,Long> {
	Page<Genre> findByLibelleContaining(@RequestParam("libelle") String libelle
			,Pageable pageable);
}
