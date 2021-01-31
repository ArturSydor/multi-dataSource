package com.practice.multi_datasource_with_actuator_api.repository.warehouse;

import com.practice.multi_datasource_with_actuator_api.repository.warehouse.entity.ItemsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemsRepository extends JpaRepository<ItemsEntity, Long> {
}
