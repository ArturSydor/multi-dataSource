package com.practice.multi_datasource_with_actuator_api.repository.warehouse.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "items")
public class ItemsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "quantity")
    private Long quantity;

}
