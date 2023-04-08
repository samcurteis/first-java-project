package com.example.caproject.controller;

import com.example.caproject.model.DiningReview;
import com.example.caproject.repository.DiningReviewRepository;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.Optional;

@RestController
@RequestMapping("/diningReviews")
public class DiningReviewController {

    private final DiningReviewRepository diningReviewRepository;

    public DiningReviewController(DiningReviewRepository diningReviewRepo) {
        this.diningReviewRepository = diningReviewRepo;
    }

    @GetMapping()
    public Iterable<DiningReview> getAllDiningReviews() {
        return this.diningReviewRepository.findAll();
    }

    @PostMapping()
    public DiningReview createNewDiningReview(@RequestBody DiningReview diningReview) {
        DiningReview newDiningReview = this.diningReviewRepository.save(diningReview);
        return newDiningReview;
    }

    @PutMapping("/{id}")
    public DiningReview editDiningReview(@PathVariable int id, @RequestBody DiningReview diningReview) {
        Optional<DiningReview> diningReviewOptional = this.diningReviewRepository.findById(id);
        if (!diningReviewOptional.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        DiningReview diningReviewToUpdate = diningReviewOptional.get();
        DiningReview updatedDiningReview = this.diningReviewRepository.save(diningReviewToUpdate);
        return updatedDiningReview;
    };

    @DeleteMapping("/{id}")
    public DiningReview deleteDiningReview(@PathVariable int id) {
        Optional<DiningReview> diningReviewOptional = this.diningReviewRepository.findById(id);
        if (!diningReviewOptional.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "DiningReview with that id does not exist.");
        } else {
            this.diningReviewRepository.deleteById(id);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "DiningReview successfully deleted.");
        }
    }

}
