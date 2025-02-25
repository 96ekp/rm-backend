package com.sawlov2code.rmbackend.controller;

import com.sawlov2code.rmbackend.exception.RestaurantIsEmptyException;
import com.sawlov2code.rmbackend.exception.RestaurantAlreadyExistsException;
import com.sawlov2code.rmbackend.model.Restaurants;
import com.sawlov2code.rmbackend.service.RestaurantService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


class RestaurantControllerTest {

    @InjectMocks
    private RestaurantController restaurantController;

    @Mock
    private RestaurantService restaurantService;


    private Restaurants existingRestaurant;
    private Restaurants newRestaurant;


    @BeforeEach
    void setUpBeforeEach() {
        MockitoAnnotations.openMocks(this);

        existingRestaurant = new Restaurants();
        existingRestaurant.setRestaurantName("Existing Restaurant");

        newRestaurant = new Restaurants();
        newRestaurant.setRestaurantName("New Restaurant");
    }

    @Test
    void createRestaurant_ShouldThrowException_WhenRestaurantNameIsEmpty() {
        Restaurants restaurant = new Restaurants();
        restaurant.setRestaurantName("");

        assertThrows(RestaurantAlreadyExistsException.class, () -> {
            restaurantController.createRestaurant(restaurant);
        });
    }

    @Test
    void createRestaurant_ShouldThrowException_WhenRestaurantNameAlreadyExists() {
        when(restaurantService.getRestaurants()).thenReturn(List.of(existingRestaurant));

        assertThrows(RestaurantAlreadyExistsException.class, () -> {
            restaurantController.createRestaurant(existingRestaurant);
        });
    }

    @Test
    void createRestaurant_ShouldSaveRestaurant_WhenValidRestaurant() {
        when(restaurantService.save(any(Restaurants.class))).thenReturn(newRestaurant);

        Restaurants savedRestaurant = restaurantController.createRestaurant(newRestaurant);

        assertEquals("New Restaurant", savedRestaurant.getRestaurantName());
    }

    @Test
    void getRestaurants_ShouldThrowException_WhenNoRestaurantsAvailable() {
        when(restaurantService.getRestaurants()).thenReturn(Collections.emptyList());

        assertThrows(RestaurantIsEmptyException.class, () -> {
            restaurantController.getRestaurants();
        });
    }
}
