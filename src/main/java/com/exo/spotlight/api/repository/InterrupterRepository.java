package com.exo.spotlight.api.repository;

import com.exo.spotlight.api.bo.Interrupter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterrupterRepository extends JpaRepository<Interrupter, Long> {

}

