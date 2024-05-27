package com.exo.spotlight.api.repository;

import com.exo.spotlight.api.bo.Light;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LightRepository extends JpaRepository<Light, Long> {

}

