package com.nttdata.aflamiSpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.aflamiSpringBoot.entity.Seance;

@Repository
public interface SeanceRepository extends JpaRepository<Seance,Long> {
	
}
