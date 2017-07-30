package com.coding.exercise.restaurantmanager.spring.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coding.exercise.restaurantmanager.spring.core.dao.RestaurantTableDao;
import com.coding.exercise.restaurantmanager.spring.core.model.RestaurantTable;
import com.coding.exercise.restaurantmanager.spring.core.service.RestaurantTableService;

@Service
public class RestaurantTableServiceImpl implements RestaurantTableService {

    @Autowired
    private RestaurantTableDao restaurantTableDao;

    public List<RestaurantTable> getAllRestaurantTables() {
	List<RestaurantTable> restaurants = restaurantTableDao
		.getAllRestaurantTables();
	return restaurants;
    }

    public void insertRestaurantTable(RestaurantTable restaurantTable) {
	restaurantTableDao.insertRestaurantTable(restaurantTable);
    }

}
