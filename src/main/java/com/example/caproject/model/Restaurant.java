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
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;

import java.util.List;

@Entity
@NoArgsConstructor
@Table(name = "RESTAURANTS")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy="restaurant", orphanRemoval = true, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<DiningReview> DiningReviews;


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
