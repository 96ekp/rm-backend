package com.sawlov2code.rmbackend.location.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sawlov2code.rmbackend.restaurant.model.Restaurants;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.List;


@Entity
@Table(name = "locations")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "address")
    private String address;
    @Column(name = "city")
    private String city;
    @Column(name = "province")
    private String province;
    @Column(name = "post_code")
    private String post_code;
    @Column(name = "country")
    private String country;

    @Column(name = "created_at")
    @CreationTimestamp
    private Timestamp created_at;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private Timestamp updated_at;

    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference
    private List<Restaurants> restaurants;

    public Location() {
    }

    public Location(Long id, String address, String city, String province, String post_code, String country, Timestamp created_at, Timestamp updated_at, List<Restaurants> restaurants) {
        this.id = id;
        this.address = address;
        this.city = city;
        this.province = province;
        this.post_code = post_code;
        this.country = country;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.restaurants = restaurants;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getPost_code() {
        return post_code;
    }

    public void setPost_code(String post_code) {
        this.post_code = post_code;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }

    public List<Restaurants> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(List<Restaurants> restaurants) {
        this.restaurants = restaurants;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Location{");
        sb.append("id=").append(id);
        sb.append(", address='").append(address).append('\'');
        sb.append(", city='").append(city).append('\'');
        sb.append(", province='").append(province).append('\'');
        sb.append(", post_code='").append(post_code).append('\'');
        sb.append(", country='").append(country).append('\'');
        sb.append(", created_at=").append(created_at);
        sb.append(", updated_at=").append(updated_at);
        sb.append(", restaurants=").append(restaurants);
        sb.append('}');
        return sb.toString();
    }
}
