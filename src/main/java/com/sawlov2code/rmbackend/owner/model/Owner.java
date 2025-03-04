package com.sawlov2code.rmbackend.owner.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Data
@Setter
@Getter
@Entity
@Table(name = "owners")
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "username")
    private String username;
    @Column (name="password")
    private String password;
    @Column(name = "role")
    private String role;
    @Column(name = "created_at")
    @CreationTimestamp
    private Timestamp created_at;

    @Column(name = "updated_at")
    @CreationTimestamp
    private Timestamp updated_at;

    public Owner() {
    }
    public Owner(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }
}
