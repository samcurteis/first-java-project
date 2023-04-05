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
@Table(name = "ADMIN_REVIEW_ACTION")
public class AdminReviewAction{

    @Column(name = "IS_REVIEW_ACCEPTED")
    @Getter
    @Setter
    private Boolean isReviewAccepted;
}
