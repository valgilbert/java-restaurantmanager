package com.coding.exercise.restaurantmanager.spring.core.dao;

import java.util.List;

import com.coding.exercise.restaurantmanager.spring.core.model.Restaurant;

public interface RestaurantDao {

    public List<Restaurant> getAllRestaurants();

    public void insertRestaurant(Restaurant restaurant);
}
