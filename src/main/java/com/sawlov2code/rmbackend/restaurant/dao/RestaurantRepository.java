package com.sawlov2code.rmbackend.restaurant.dao;

import com.sawlov2code.rmbackend.restaurant.model.Restaurants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurants, Integer> {
    @Query(value = "SELECT * FROM restaurant ORDER BY RANDOM() LIMIT 1", nativeQuery = true)
    Restaurants findRandomRestaurant();
}
