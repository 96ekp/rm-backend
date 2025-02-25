package com.sawlov2code.rmbackend.dao;

import com.sawlov2code.rmbackend.model.Restaurants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurants, Integer> {
}
