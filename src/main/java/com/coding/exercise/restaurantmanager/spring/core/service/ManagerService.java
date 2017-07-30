package com.coding.exercise.restaurantmanager.spring.core.service;

import java.util.List;

import com.coding.exercise.restaurantmanager.spring.core.model.Manager;

public interface ManagerService {

    public List<Manager> getAllManagers();

    public void insertManager(Manager manager);
}
