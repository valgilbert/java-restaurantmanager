package com.coding.exercise.restaurantmanager.spring.core.dao;

import java.util.List;

import com.coding.exercise.restaurantmanager.spring.core.model.Waiter;

public interface WaiterDao {

    public List<Waiter> getAllWaiters();

    public void insertWaiter(Waiter waiter);
}
