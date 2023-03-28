package com.example.caproject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@NoArgsConstructor
@Table(name = "RESTAURANTS")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NAME")
    @Getter
    @Setter
    private String name;

    @Column(name = "CUISINE")
    @Getter
    @Setter
    private String cuisine;

    @Column(name = "ADDRESS")
    @Getter
    @Setter
    private String address;

}
