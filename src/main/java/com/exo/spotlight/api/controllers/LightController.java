package com.exo.spotlight.api.controllers;


import com.exo.spotlight.api.bo.Light;
import com.exo.spotlight.api.repository.LightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/lights")
@CrossOrigin(origins = "https://spotlight-back.vercel.app")
public class LightController {

    @Autowired
    private LightRepository lightRepository;

    @GetMapping
    public List<Light> getAllLights() {
        return lightRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Light> getLightById(@PathVariable Long id) {
        Optional<Light> light = lightRepository.findById(id);
        return light.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Light createLight(@RequestBody Light light) {
        return lightRepository.save(light);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Light> updateLight(@PathVariable Long id, @RequestBody Light lightDetails) {
        Optional<Light> light = lightRepository.findById(id);
        if (light.isPresent()) {
            Light updatedLight = light.get();
            updatedLight.setName(lightDetails.getName());
            updatedLight.setStatus(lightDetails.isStatus());
            updatedLight.setRoom(lightDetails.getRoom());
            updatedLight.setInterrupters(lightDetails.getInterrupters());
            return ResponseEntity.ok(lightRepository.save(updatedLight));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLight(@PathVariable Long id) {
        Optional<Light> light = lightRepository.findById(id);
        if (light.isPresent()) {
            lightRepository.delete(light.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
