package com.practice.multi_datasource_with_actuator_api.repository.statistic.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "items_modifications")
public class ItemsModificationsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "action", nullable = false)
    private ActionType action;

}
