package com.sawlov2code.rmbackend.controller;

import com.sawlov2code.rmbackend.exception.RestaurantNameEmptyException;
import com.sawlov2code.rmbackend.model.Restaurants;
import com.sawlov2code.rmbackend.service.RestaurantService;
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
    public List<Restaurants> getRestaurants() {
        return restaurantService.getRestaurants();
    }

    @PostMapping
    public Restaurants createRestaurant(@RequestBody Restaurants restaurants) {
        if (restaurants.getRestaurantName() == null || restaurants.getRestaurantName().isEmpty()) {
            throw new RestaurantNameEmptyException("Restaurant name cannot be empty");
        }
        return restaurantService.save(restaurants);

    }


}
