package com.nttdata.aflamiSpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.aflamiSpringBoot.entity.Nationalite;

@Repository
public interface NationaliteRepository extends JpaRepository<Nationalite,Long> {

}
