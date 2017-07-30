package com.coding.exercise.restaurantmanager.spring.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coding.exercise.restaurantmanager.spring.core.dao.RestaurantTableDao;
import com.coding.exercise.restaurantmanager.spring.core.dao.WaiterDao;
import com.coding.exercise.restaurantmanager.spring.core.model.RestaurantTable;
import com.coding.exercise.restaurantmanager.spring.core.model.Waiter;
import com.coding.exercise.restaurantmanager.spring.core.service.WaiterService;

@Service
public class WaiterServiceImpl implements WaiterService {

    @Autowired
    private WaiterDao waiterDao;

    @Autowired
    private RestaurantTableDao restaurantTableDao;

    public List<Waiter> getAllWaiters() {
	List<Waiter> waiters = waiterDao.getAllWaiters();
	return waiters;
    }

    public void insertWaiter(Waiter waiter) {
	waiterDao.insertWaiter(waiter);
    }

}
