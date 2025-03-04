package com.sawlov2code.rmbackend.restaurant.service;

import com.sawlov2code.rmbackend.restaurant.model.Restaurants;

import java.util.List;

/**
 * Provides methods for managing restaurants.
 */
public interface RestaurantService {
    List<Restaurants> getRestaurants();
    Restaurants create(Restaurants restaurants);
//    Restaurants findById(Integer id);
//    Restaurants update(Integer id, Restaurants restaurantDetails);


}
