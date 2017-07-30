package com.coding.exercise.restaurantmanager.spring.core.service;

import java.util.List;

import com.coding.exercise.restaurantmanager.spring.core.model.Waiter;

public interface WaiterService {

    public List<Waiter> getAllWaiters();

    public void insertWaiter(Waiter waiter);
}
