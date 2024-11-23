package com.weddingplanner.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.util.List;

@Getter
@Setter
@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String contact;
    private double budget;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Event> events;


}

