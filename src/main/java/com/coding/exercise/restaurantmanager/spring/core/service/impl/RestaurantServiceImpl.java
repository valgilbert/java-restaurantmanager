package com.coding.exercise.restaurantmanager.spring.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coding.exercise.restaurantmanager.spring.core.dao.RestaurantDao;
import com.coding.exercise.restaurantmanager.spring.core.model.Restaurant;
import com.coding.exercise.restaurantmanager.spring.core.service.RestaurantService;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantDao restaurantDao;

    public List<Restaurant> getAllRestaurants() {
	List<Restaurant> restaurants = restaurantDao.getAllRestaurants();
	return restaurants;
    }

    public void insertRestaurant(Restaurant restaurant) {
	restaurantDao.insertRestaurant(restaurant);
    }

}
