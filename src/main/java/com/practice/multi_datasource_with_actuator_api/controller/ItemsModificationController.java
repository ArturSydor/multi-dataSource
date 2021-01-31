package com.practice.multi_datasource_with_actuator_api.controller;

import com.practice.multi_datasource_with_actuator_api.repository.statistic.ItemsModificationsRepository;
import com.practice.multi_datasource_with_actuator_api.repository.statistic.entity.ItemsModificationsEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@RestController
@RequestMapping("/items/statistic")
@RequiredArgsConstructor
public class ItemsModificationController {

    private final ItemsModificationsRepository modificationsRepository;

    @GetMapping
    public List<ItemsModificationsEntity> getAll() {
        return modificationsRepository.findAll();
    }

}
