package com.sawlov2code.rmbackend.restaurant.model;

import com.sawlov2code.rmbackend.owner.model.Location;
import com.sawlov2code.rmbackend.menu.model.Menu;
import com.sawlov2code.rmbackend.owner.model.Owner;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
@Entity
@Table(name = "restaurant")
public class Restaurants {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    @ManyToOne
    @JoinColumn(name = "menu_id")
    private Menu menu;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Owner owner;

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

    public Restaurants(Long id, Location location, Menu menu, Owner owner, String restaurantName, Integer selectedAmount, String imageUrl, Timestamp createdAt, Timestamp updatedAt) {
        this.id = id;
        this.location = location;
        this.menu = menu;
        this.owner = owner;
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
        sb.append(", menu=").append(menu);
        sb.append(", owner=").append(owner);
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

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
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
