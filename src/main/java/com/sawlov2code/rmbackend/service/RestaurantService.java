package com.sawlov2code.rmbackend.service;

import com.sawlov2code.rmbackend.model.Restaurants;

import java.util.List;

public interface RestaurantService {
    List<Restaurants> getRestaurants();
    Restaurants save(Restaurants restaurants);


}
