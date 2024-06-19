package com.exo.spotlight.api.repository;

import com.exo.spotlight.api.bo.Accommodation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccommodationRepository extends JpaRepository<Accommodation, Long> {
    @Query("SELECT a FROM Accommodation a WHERE a.user.id = :userId")
    List<Accommodation> findByUserId(@Param("userId") Long userId);
}
