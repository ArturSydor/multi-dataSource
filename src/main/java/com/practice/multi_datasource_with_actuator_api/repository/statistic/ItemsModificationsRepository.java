package com.practice.multi_datasource_with_actuator_api.repository.statistic;

import com.practice.multi_datasource_with_actuator_api.repository.statistic.entity.ItemsModificationsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemsModificationsRepository extends JpaRepository<ItemsModificationsEntity, Long> {
}
