package com.sawlov2code.rmbackend.restaurant.controller;

import com.sawlov2code.rmbackend.exception.RestaurantIsEmptyException;
import com.sawlov2code.rmbackend.restaurant.dto.RestaurantDTO;
import com.sawlov2code.rmbackend.restaurant.model.Restaurants;
import com.sawlov2code.rmbackend.restaurant.service.RestaurantService;
import com.sawlov2code.rmbackend.exception.RestaurantAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public List<RestaurantDTO> getRestaurants() {
        List<RestaurantDTO> restaurantList = restaurantService.getRestaurants();
        if (restaurantList.isEmpty()) {
            throw new RestaurantIsEmptyException("No restaurant available in Database");
        }
        return restaurantService.getRestaurants();
    }

    @PostMapping
    public ResponseEntity<String> createRestaurant(@RequestBody Restaurants restaurants) {
        if (restaurants.getRestaurantName() == null || restaurants.getRestaurantName().isEmpty()) {
            throw new RestaurantAlreadyExistsException("Restaurants name cannot be empty");
        }
        if (restaurantService.getRestaurants().stream()
                .anyMatch(restaurant -> restaurant.getRestaurantName()
                        .equalsIgnoreCase(restaurants.getRestaurantName()))) {
            throw new RestaurantAlreadyExistsException("Restaurants name already exists");
        } else {
            Restaurants createdRestaurant = restaurantService.create(restaurants);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Restaurant id " + createdRestaurant.getId() + " created successfully!");
        }
    }

    @GetMapping("/{id}")
    public Restaurants getRestaurantById(@PathVariable Integer id) {
        return restaurantService.findById(id);
    }


   @PutMapping("/{id}")
   public ResponseEntity<String> updateRestaurant(@PathVariable Integer id, @RequestBody Restaurants restaurantDetails) {
       restaurantService.update(id, restaurantDetails);
       return ResponseEntity.ok("Restaurant id {" + id + "} update successfully!");
   }

   @DeleteMapping("/{id}")
   public ResponseEntity<String> deleteRestaurant(@PathVariable Integer id) {
       restaurantService.delete(id);
       return ResponseEntity.ok("Restaurant id {" + id + "} delete successfully!");
   }


@GetMapping("/random")
public ResponseEntity<String> getRandomRestaurant() {
    Restaurants randomRestaurant = restaurantService.getRandomRestaurant();
    restaurantService.incrementSelectionCount(randomRestaurant.getId());
    return ResponseEntity.ok("Random selected: " + randomRestaurant.getRestaurantName());
}

}
