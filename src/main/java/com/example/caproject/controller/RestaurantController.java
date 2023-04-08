package com.example.caproject.controller;

import com.example.caproject.model.Restaurant;
import com.example.caproject.repository.RestaurantRepository;
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
@RequestMapping("/restaurants")
public class RestaurantController {

    private final RestaurantRepository restaurantRepository;

    public RestaurantController(RestaurantRepository restaurantRepo) {
        this.restaurantRepository = restaurantRepo;
    }

    @GetMapping()
    public Iterable<Restaurant> getAllRestaurants() {
        return this.restaurantRepository.findAll();
    }

    @PostMapping()
    public Restaurant createNewRestaurant(@RequestBody Restaurant restaurant) {
        Restaurant newRestaurant = this.restaurantRepository.save(restaurant);
        return newRestaurant;
    }

    @PutMapping("/{id}")
    public Restaurant editRestaurant(@PathVariable int id, @RequestBody Restaurant restaurant) {
        Optional<Restaurant> restaurantOptional = this.restaurantRepository.findById(id);
        if (!restaurantOptional.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        Restaurant restaurantToUpdate = restaurantOptional.get();
        Restaurant updatedRestaurant = this.restaurantRepository.save(restaurantToUpdate);
        return updatedRestaurant;
    };

    @DeleteMapping("/{id}")
    public Restaurant deleteRestaurant(@PathVariable int id) {
        Optional<Restaurant> restaurantOptional = this.restaurantRepository.findById(id);
        if (!restaurantOptional.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Restaurant with that id does not exist.");
        } else {
            this.restaurantRepository.deleteById(id);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Restaurant successfully deleted.");
        }
    }

}
