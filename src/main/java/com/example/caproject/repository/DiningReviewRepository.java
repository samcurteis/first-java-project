package com.example.caproject.repository;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.caproject.model.User;

@Repository
public interface DiningReviewRepository extends CrudRepository<DiningReview, Integer> {
}
