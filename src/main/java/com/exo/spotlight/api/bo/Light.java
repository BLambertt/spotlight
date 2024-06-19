package com.exo.spotlight.api.bo;



import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table

public class Light {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "room_id")
    @JsonBackReference
    private Room room;

    @ManyToMany
    @JoinTable(
            name = "light_interrupter",
            joinColumns = @JoinColumn(name = "light_id"),
            inverseJoinColumns = @JoinColumn(name = "interrupter_id")
    )
    @JsonManagedReference("light-interrupter")
    private Set<Interrupter> interrupters;

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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Set<Interrupter> getInterrupters() {
        return interrupters;
    }

    public void setInterrupters(Set<Interrupter> interrupters) {
        this.interrupters = interrupters;
    }
}

