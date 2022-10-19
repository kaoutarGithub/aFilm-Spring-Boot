package com.nttdata.aflamiSpringBoot.repository;

import com.nttdata.aflamiSpringBoot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
}
