package com.sawlov2code.rmbackend.restaurant.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sawlov2code.rmbackend.location.model.Location;
import com.sawlov2code.rmbackend.menu.model.Menu;
import com.sawlov2code.rmbackend.user.model.Users;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "restaurant", indexes = {
        @Index(name = "idx_restaurants_name", columnList = "restaurant_name"),
        @Index(name = "idx_restaurants_location", columnList = "location_id")
})
public class Restaurants {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "location_id")
    private Location location;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Menu> menus;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "user_id")
    private Users user;

    @Column(name = "restaurant_name")
    private String restaurantName;

    @Column(name = "selectedamount")
    private Integer selectedAmount;
    @Column(name = "imageurl")
    private String imageUrl;

    @Column(name = "created_at")
    @CreationTimestamp
    private Timestamp createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private Timestamp updatedAt;

    public Restaurants() {
    }

    public Restaurants(Long id, Location location, List<Menu> menus, Users user, String restaurantName, Integer selectedAmount, String imageUrl, Timestamp createdAt, Timestamp updatedAt) {
        this.id = id;
        this.location = location;
        this.menus = menus;
        this.user = user;
        this.restaurantName = restaurantName;
        this.selectedAmount = selectedAmount;
        this.imageUrl = imageUrl;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Restaurants{");
        sb.append("id=").append(id);
        sb.append(", location=").append(location);
        sb.append(", menus=").append(menus);
        sb.append(", user=").append(user);
        sb.append(", restaurantName='").append(restaurantName).append('\'');
        sb.append(", selectedAmount=").append(selectedAmount);
        sb.append(", imageUrl='").append(imageUrl).append('\'');
        sb.append(", createdAt=").append(createdAt);
        sb.append(", updatedAt=").append(updatedAt);
        sb.append('}');
        return sb.toString();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users owner) {
        this.user = owner;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
}
