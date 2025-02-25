package com.sawlov2code.rmbackend.controller;

import com.sawlov2code.rmbackend.model.Restaurants;
import com.sawlov2code.rmbackend.service.RestaurantService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
