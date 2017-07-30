package com.coding.exercise.restaurantmanager.spring.core.service;

import java.util.List;

import com.coding.exercise.restaurantmanager.spring.core.model.Restaurant;

public interface RestaurantService {

    public List<Restaurant> getAllRestaurants();

    public void insertRestaurant(Restaurant restaurant);
}
