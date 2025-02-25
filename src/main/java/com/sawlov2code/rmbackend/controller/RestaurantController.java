package com.sawlov2code.rmbackend.controller;

import com.sawlov2code.rmbackend.exception.RestaurantIsEmptyException;
import com.sawlov2code.rmbackend.exception.RestaurantAlreadyExistsException;
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
        List<Restaurants> restaurantList = restaurantService.getRestaurants();
        if (restaurantList.isEmpty()) {
            throw new RestaurantIsEmptyException("No restaurant available in Database");
        }
        return restaurantService.getRestaurants();
    }

    @PostMapping
    public Restaurants createRestaurant(@RequestBody Restaurants restaurants) {
        if (restaurants.getRestaurantName() == null || restaurants.getRestaurantName().isEmpty()) {
            throw new RestaurantAlreadyExistsException("Restaurant name cannot be empty");
        }
        if (restaurantService.getRestaurants().stream()
                .anyMatch(restaurant -> restaurant.getRestaurantName()
                        .equalsIgnoreCase(restaurants.getRestaurantName()))) {
            throw new RestaurantAlreadyExistsException("Restaurant name already exists");
        } else {
            return restaurantService.save(restaurants);
        }

    }


}
