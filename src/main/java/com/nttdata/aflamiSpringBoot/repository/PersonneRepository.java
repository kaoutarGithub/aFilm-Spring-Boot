package com.nttdata.aflamiSpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.aflamiSpringBoot.entity.Personne;

@Repository
public interface PersonneRepository extends JpaRepository<Personne,Long> {

}
