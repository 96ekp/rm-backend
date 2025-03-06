package com.sawlov2code.rmbackend.restaurant.service;

import com.sawlov2code.rmbackend.exception.RestaurantNotFoundException;
import com.sawlov2code.rmbackend.restaurant.dto.RestaurantDTO;
import com.sawlov2code.rmbackend.restaurant.dao.RestaurantRepository;
import com.sawlov2code.rmbackend.restaurant.model.Restaurants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.sawlov2code.rmbackend.menu.model.Menu;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    private final Logger logger = LoggerFactory.getLogger(RestaurantServiceImpl.class);
    private final RestaurantRepository restaurantRepository;

    public RestaurantServiceImpl(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public List<RestaurantDTO> getRestaurants() {
        List<Restaurants> restaurants = restaurantRepository.findAll();
        logger.info("Returning {} restaurants", restaurants.size());
        return restaurants.stream().map(this::convertToDTO).collect(Collectors.toList());
    }


    @Override
    @Transactional
    public Restaurants create(Restaurants restaurants) {
        return restaurantRepository.save(restaurants);
    }

    @Override
    public Restaurants findById(Integer id) {
     Optional<Restaurants> restaurant = restaurantRepository.findById(id);
        if(restaurant.isPresent()){
            return  restaurant.get();
        }else{
            throw new RestaurantNotFoundException("Restaurants not found with id: " + id);
        }
    }


    @Override
    @Transactional
    public Restaurants update(Integer id, Restaurants restaurantDetails) {
        Optional<Restaurants> existRestaurant = restaurantRepository.findById(id);
        if(existRestaurant.isPresent()){
            Restaurants restaurant = existRestaurant.get();
            restaurant.setRestaurantName(restaurantDetails.getRestaurantName());
            restaurant.setImageUrl(restaurantDetails.getImageUrl());
            restaurant.setLocation(restaurantDetails.getLocation());
            return restaurantRepository.save(restaurant);
        }else{
            throw new RestaurantNotFoundException("Restaurants not found with id: " + id);
        }
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Restaurants restaurant = findById(id);
        restaurantRepository.delete(restaurant);
    }

    @Override
    public Restaurants getRandomRestaurant() {
        return restaurantRepository.findRandomRestaurant();
    }


    @Override
    public void incrementSelectionCount(Long id) {
        Restaurants restaurant = findById(Math.toIntExact(id));
        restaurant.setSelectedAmount(restaurant.getSelectedAmount() + 1);
        restaurantRepository.save(restaurant);

    }


    private RestaurantDTO convertToDTO(Restaurants restaurant) {
        RestaurantDTO dto = new RestaurantDTO();
        dto.setId(restaurant.getId());
        dto.setLocationId(restaurant.getLocation() != null ? restaurant.getLocation().getId() : null);
        dto.setMenuIds(restaurant.getMenus().stream().map(Menu::getId).collect(Collectors.toList()));
        dto.setUserId(restaurant.getUser() != null ? restaurant.getUser().getId() : null);
        dto.setRestaurantName(restaurant.getRestaurantName());
        dto.setSelectedAmount(restaurant.getSelectedAmount());
        dto.setImageUrl(restaurant.getImageUrl());
        dto.setCreatedAt(restaurant.getCreatedAt());
        dto.setUpdatedAt(restaurant.getUpdatedAt());
        return dto;
    }


}
