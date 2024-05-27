package com.exo.spotlight.api.controllers;


import com.exo.spotlight.api.bo.Interrupter;
import com.exo.spotlight.api.repository.InterrupterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/interrupters")
public class InterrupterController {

    @Autowired
    private InterrupterRepository interrupterRepository;

    @GetMapping
    public List<Interrupter> getAllInterrupters() {
        return interrupterRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Interrupter> getInterrupterById(@PathVariable Long id) {
        Optional<Interrupter> interrupter = interrupterRepository.findById(id);
        return interrupter.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Interrupter createInterrupter(@RequestBody Interrupter interrupter) {
        return interrupterRepository.save(interrupter);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Interrupter> updateInterrupter(@PathVariable Long id, @RequestBody Interrupter interrupterDetails) {
        Optional<Interrupter> interrupter = interrupterRepository.findById(id);
        if (interrupter.isPresent()) {
            Interrupter updatedInterrupter = interrupter.get();
            updatedInterrupter.setName(interrupterDetails.getName());
            updatedInterrupter.setLights(interrupterDetails.getLights());
            return ResponseEntity.ok(interrupterRepository.save(updatedInterrupter));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInterrupter(@PathVariable Long id) {
        Optional<Interrupter> interrupter = interrupterRepository.findById(id);
        if (interrupter.isPresent()) {
            interrupterRepository.delete(interrupter.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
