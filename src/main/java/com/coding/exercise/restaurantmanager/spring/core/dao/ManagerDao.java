package com.coding.exercise.restaurantmanager.spring.core.dao;

import java.util.List;

import com.coding.exercise.restaurantmanager.spring.core.model.Manager;

public interface ManagerDao {

    public List<Manager> getAllManagers();

    public void insertManager(Manager manager);
}
