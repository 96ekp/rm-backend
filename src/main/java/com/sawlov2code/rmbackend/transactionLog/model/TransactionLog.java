package com.sawlov2code.rmbackend.transactionLog.model;


import com.sawlov2code.rmbackend.menu.model.Menu;
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
@Table(name = "transaction_log")
public class TransactionLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "menu_id")
    private Menu menu;

    @Column(name = "response")
    private String response;

    @Column(name = "created_at")
    @CreationTimestamp
    private Timestamp created_at;

    public TransactionLog() {
    }

    public TransactionLog(Long id, Menu menu, String response, Timestamp created_at) {
        this.id = id;
        this.menu = menu;
        this.response = response;
        this.created_at = created_at;
    }
}
