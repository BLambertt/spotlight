package com.exo.spotlight.api.controllers;


import com.exo.spotlight.api.bo.Accommodation;
import com.exo.spotlight.api.repository.AccommodationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/accommodations")
@CrossOrigin(origins = "https://spotlight-back.vercel.app")
public class AccommodationController {

    @Autowired
    private AccommodationRepository accommodationRepository;

    @GetMapping
    public List<Accommodation> getAllAccommodations() {
        return accommodationRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Accommodation> getAccommodationById(@PathVariable Long id) {
        Optional<Accommodation> accommodation = accommodationRepository.findById(id);
        return accommodation.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Accommodation createAccommodation(@RequestBody Accommodation accommodation) {
        return accommodationRepository.save(accommodation);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Accommodation> updateAccommodation(@PathVariable Long id, @RequestBody Accommodation accommodationDetails) {
        Optional<Accommodation> accommodation = accommodationRepository.findById(id);
        if (accommodation.isPresent()) {
            Accommodation updatedAccommodation = accommodation.get();
            updatedAccommodation.setName(accommodationDetails.getName());
            updatedAccommodation.setAddress(accommodationDetails.getAddress());
            updatedAccommodation.setUser(accommodationDetails.getUser());
            return ResponseEntity.ok(accommodationRepository.save(updatedAccommodation));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccommodation(@PathVariable Long id) {
        Optional<Accommodation> accommodation = accommodationRepository.findById(id);
        if (accommodation.isPresent()) {
            accommodationRepository.delete(accommodation.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
