package com.sawlov2code.rmbackend.restaurant.controller;

import com.sawlov2code.rmbackend.exception.RestaurantIsEmptyException;
import com.sawlov2code.rmbackend.restaurant.dto.RestaurantDTO;
import com.sawlov2code.rmbackend.restaurant.model.Restaurants;
import com.sawlov2code.rmbackend.restaurant.service.RestaurantService;
import com.sawlov2code.rmbackend.exception.RestaurantAlreadyExistsException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/restaurants")
public class RestaurantController {

    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping
    public List<RestaurantDTO> getRestaurants() {
        List<RestaurantDTO> restaurantList = restaurantService.getRestaurants();
        if (restaurantList.isEmpty()) {
            throw new RestaurantIsEmptyException("No restaurant available in Database");
        }
        return restaurantService.getRestaurants();
    }

    @PostMapping
    public Restaurants createRestaurant(@RequestBody Restaurants restaurants) {
        if (restaurants.getRestaurantName()== null || restaurants.getRestaurantName().isEmpty()) {
            throw new RestaurantAlreadyExistsException("Restaurants name cannot be empty");
        }
        if (restaurantService.getRestaurants().stream()
                .anyMatch(restaurant -> restaurant.getRestaurantName()
                        .equalsIgnoreCase(restaurants.getRestaurantName()))) {
            throw new RestaurantAlreadyExistsException("Restaurants name already exists");
        } else {
            return restaurantService.create(restaurants);
        }
    }

    @GetMapping("/{id}")
    public Restaurants getRestaurantById(@PathVariable Integer id) {
        return restaurantService.findById(id);
    }


    @PutMapping("/{id}")
    public Restaurants updateRestaurant(@PathVariable Integer id, @RequestBody Restaurants restaurantDetails) {
        return restaurantService.update(id, restaurantDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteRestaurant(@PathVariable Integer id) {
        restaurantService.delete(id);
    }


    @GetMapping("/random")
    public String getRandomRestaurant() {
        Restaurants randomRestaurant = restaurantService.getRandomRestaurant();
        restaurantService.incrementSelectionCount(randomRestaurant.getId());
        return randomRestaurant.getRestaurantName();
    }

}
