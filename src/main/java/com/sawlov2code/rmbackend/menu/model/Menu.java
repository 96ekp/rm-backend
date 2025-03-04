package com.sawlov2code.rmbackend.menu.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;


@Entity
@Table(name = "menus")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "menu_name")
    private String menu_name;
    @Column(name = "imageurl")
    private String imageUrl;
    @Column(name = "ai_generated")
    private Boolean ai_generated;

    @Column(name = "created_at")
    @CreationTimestamp
    private Timestamp created_at;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private Timestamp updated_at;

    public Menu() {
    }

    public Menu(Long id, String menu_name, String imageUrl, Boolean ai_generated, Timestamp created_at, Timestamp updated_at) {
        this.id = id;
        this.menu_name = menu_name;
        this.imageUrl = imageUrl;
        this.ai_generated = ai_generated;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMenu_name() {
        return menu_name;
    }

    public void setMenu_name(String menu_name) {
        this.menu_name = menu_name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Boolean getAi_generated() {
        return ai_generated;
    }

    public void setAi_generated(Boolean ai_generated) {
        this.ai_generated = ai_generated;
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
}
