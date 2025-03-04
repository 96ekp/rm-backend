package com.sawlov2code.rmbackend.owner.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;


@Setter
@Getter
@Data
@Entity
@Table(name = "menus")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "menu_name")
    private String menu_name;
    @Column(name = "image_url")
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
}
