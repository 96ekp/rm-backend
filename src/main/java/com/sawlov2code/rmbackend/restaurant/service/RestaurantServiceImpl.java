package com.sawlov2code.rmbackend.restaurant.service;

import com.sawlov2code.rmbackend.restaurant.dao.RestaurantRepository;
import com.sawlov2code.rmbackend.restaurant.model.Restaurants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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


    @Override
    @Transactional
    public Restaurants create(Restaurants restaurants) {
        return restaurantRepository.save(restaurants);
    }

//    @Override
//    public Restaurants findById(Integer id) {
//     Optional<Restaurants> restaurant = restaurantRepository.findById(id);
//        if(restaurant.isPresent()){
//            return  restaurant.get();
//        }else{
//            throw new RestaurantNotFoundException("Restaurants not found with id: " + id);
//        }
//    }


//    @Override
//    @Transactional
//    public Restaurants update(Integer id, Restaurants restaurantDetails) {
//        Optional<Restaurants> existRestaurant = restaurantRepository.findById(id);
//        if(existRestaurant.isPresent()){
//            Restaurants restaurant = existRestaurant.get();
//            restaurant.setRestaurantName(restaurantDetails.getRestaurantName());
//            restaurant.setImageUrl(restaurantDetails.getImageUrl());
//            restaurant.setLocation(restaurantDetails.getLocation());
//            return restaurantRepository.save(restaurant);
//        }else{
//            throw new RestaurantNotFoundException("Restaurants not found with id: " + id);
//        }
//    }


}
