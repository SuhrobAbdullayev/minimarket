package com.minimarket.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.CurrentTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
public class Customers implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "created_date")
    @CurrentTimestamp
    private LocalDateTime createdDate;

}
