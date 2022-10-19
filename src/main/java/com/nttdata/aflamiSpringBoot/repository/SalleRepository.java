package com.nttdata.aflamiSpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.aflamiSpringBoot.entity.Salle;

@Repository
public interface SalleRepository extends JpaRepository<Salle,Long> {

}
