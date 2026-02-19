package com.tothenew.jpaassignment.entities.tableperclass;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Instrument {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // must use AUTO for TABLE_PER_CLASS
    private Long id;

    private String name;
    private String brand;

    // getters & setters
}






