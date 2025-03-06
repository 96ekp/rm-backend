package com.sawlov2code.rmbackend.restaurant.service;

import com.sawlov2code.rmbackend.restaurant.dto.RestaurantDTO;
import com.sawlov2code.rmbackend.restaurant.model.Restaurants;

import java.util.List;

/**
 * Provides methods for managing restaurants.
 */
public interface RestaurantService {
    List<RestaurantDTO> getRestaurants();
    Restaurants create(Restaurants restaurants);
    Restaurants findById(Integer id);
    Restaurants update(Integer id, Restaurants restaurantDetails);
    void delete(Integer id);
    Restaurants getRandomRestaurant();
    void incrementSelectionCount(Long id);


}
