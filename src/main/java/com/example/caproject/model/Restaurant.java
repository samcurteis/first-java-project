package com.example.caproject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "RESTAURANTS")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    public Restaurant() {
    }


 public Restaurant(String name, String cuisine, String address) {
    this.name = name;
    this.cuisine = cuisine;
    this.address = address;
  }
}
