package com.practice.multi_datasource_with_actuator_api.controller;

import com.practice.multi_datasource_with_actuator_api.repository.warehouse.ItemsRepository;
import com.practice.multi_datasource_with_actuator_api.repository.warehouse.entity.ItemsEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
public class ItemsController {

    private final ItemsRepository itemsRepository;

    @GetMapping
    public List<ItemsEntity> getAll() {
        return itemsRepository.findAll();
    }

}
