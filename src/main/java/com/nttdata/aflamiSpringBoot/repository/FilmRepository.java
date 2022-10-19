package com.nttdata.aflamiSpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.aflamiSpringBoot.entity.Film;

@Repository
public interface FilmRepository extends JpaRepository<Film,Long> {

}
