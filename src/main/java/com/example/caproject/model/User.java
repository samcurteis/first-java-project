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
@Table(name = "USERS")
public class Users{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "USER_NAME")
    @Getter
    @Setter
    private String userName;
    
    @Column(name = "CITY")
    @Getter
    @Setter
    private String city;
    
    @Column(name = "STATE")
    @Getter
    @Setter
    private String state;

    @Column(name = "ZIPCODE")
    @Getter
    @Setter
    private String zipcode;
    
    @Column(name = "IS_INTERESTED_IN_PEANUT_ALLERGIES")
    @Getter
    @Setter
    private Boolean isInterestedInPeanutAllergies;
    
    @Column(name = "IS_INTERESTED_IN_EGG_ALLERGIES")
    @Getter
    @Setter
    private Boolean isInterestedInEggAllergies;
    
    @Column(name = "IS_INTERESTED_IN_DAIRY_ALLERGIES")
    @Getter
    @Setter
    private Boolean isInterestedInDairyAllergies;
}
