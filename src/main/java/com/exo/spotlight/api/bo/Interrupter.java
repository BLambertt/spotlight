package com.exo.spotlight.api.bo;



import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table

public class Interrupter {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "interrupters")
    private Set<Light> lights;

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Light> getLights() {
        return lights;
    }

    public void setLights(Set<Light> lights) {
        this.lights = lights;
    }
}
