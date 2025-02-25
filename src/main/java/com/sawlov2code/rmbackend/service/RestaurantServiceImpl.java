package com.sawlov2code.rmbackend.service;

import com.sawlov2code.rmbackend.dao.RestaurantRepository;
import com.sawlov2code.rmbackend.model.Restaurants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    private final Logger logger = LoggerFactory.getLogger(RestaurantServiceImpl.class);
    private final RestaurantRepository restaurantRepository;

    public RestaurantServiceImpl(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public List<Restaurants> getRestaurants() {
        List<Restaurants> restaurants = restaurantRepository.findAll();
        logger.info("Returning {} restaurants", restaurants.size());
        return restaurants;
    }
}
