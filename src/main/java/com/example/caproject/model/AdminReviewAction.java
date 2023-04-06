package com.example.caproject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Column;

@Entity
@NoArgsConstructor
@Table(name = "ADMIN_REVIEW_ACTION")
public class AdminReviewAction{

    @Column(name = "IS_REVIEW_ACCEPTED")
    @Getter
    @Setter
    private Boolean isReviewAccepted;
}
