package com.exo.spotlight.api.repository;

import com.exo.spotlight.api.bo.Accommodation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccommodationRepository extends JpaRepository<Accommodation, Long> {
    // Ajoutez ici des méthodes de requête personnalisées si nécessaire
}
