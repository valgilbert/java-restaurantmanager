package com.coding.exercise.restaurantmanager.spring.core.dao;

import java.util.List;

import com.coding.exercise.restaurantmanager.spring.core.model.RestaurantTable;

public interface RestaurantTableDao {

    public List<RestaurantTable> getAllRestaurantTables();

    public void insertRestaurantTable(RestaurantTable restaurantTable);
}
