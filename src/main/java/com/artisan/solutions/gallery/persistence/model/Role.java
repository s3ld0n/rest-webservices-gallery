package com.artisan.solutions.gallery.persistence.model;

import lombok.Data;

import javax.persistence.*;

@Data

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;
}
