package com.practice.multi_datasource_with_actuator_api.repository.statistic.entity;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public enum ActionType {

    CREATED,

    UPDATED,

    DELETED

}
