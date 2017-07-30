package com.coding.exercise.restaurantmanager.spring.core.service;

import java.util.List;

import com.coding.exercise.restaurantmanager.spring.core.model.RestaurantTable;

public interface RestaurantTableService {

    public List<RestaurantTable> getAllRestaurantTables();

    public void insertRestaurantTable(RestaurantTable restaurantTable);
}
