package com.sawlov2code.rmbackend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "restaurants")
public class Restaurants {

    @SequenceGenerator(name = "restaurant_sequence",
    sequenceName = "restaurant_sequence",
    allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "restaurant_sequence")
    @Id
    @Column(name = "id", updatable = false)
    private Integer id;

    @Column(name = "restaurant_name", nullable = false, unique = true)
    private String restaurantName;

    @Column(name = "selected_amount", nullable = false)
    private Integer selectedAmount = 0;

    public Restaurants() {
    }

    public Restaurants(Integer id, String restaurantName, Integer selectedAmount) {
        this.id = id;
        this.restaurantName = restaurantName;
        this.selectedAmount = selectedAmount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public Integer getSelectedAmount() {
        return selectedAmount;
    }

    public void setSelectedAmount(Integer selectedAmount) {
        this.selectedAmount = selectedAmount;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Restaurants{");
        sb.append("id=").append(id);
        sb.append(", restaurantName='").append(restaurantName).append('\'');
        sb.append(", selectedAmount=").append(selectedAmount);
        sb.append('}');
        return sb.toString();
    }
}
