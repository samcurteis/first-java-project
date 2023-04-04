package com.example.caproject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.ManyToOne;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import javax.persistence.FetchType;

@Entity
@NoArgsConstructor
@Table(name = "DINING_REVIEWS")
public class DiningReview{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "SUBMITTED_BY")
    @Getter
    @Setter
    private String submittedBy;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurantId")
    @Getter
    @Setter
    private Restaurant restaurant;

    @Column(name = "PEANUT_SCORE")
    @Getter
    @Setter
    private int peanutScore;

    @Column(name = "EGG_SCORE")
    @Getter
    @Setter
    private int eggScore;

    @Column(name = "DAIRY_SCORE")
    @Getter
    @Setter
    private int dairyScore;

    @Column(name = "COMMENTARY")
    @Getter
    @Setter
    private int commentary;

}
