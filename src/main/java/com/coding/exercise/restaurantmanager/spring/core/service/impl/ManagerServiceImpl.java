package com.coding.exercise.restaurantmanager.spring.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coding.exercise.restaurantmanager.spring.core.dao.ManagerDao;
import com.coding.exercise.restaurantmanager.spring.core.model.Manager;
import com.coding.exercise.restaurantmanager.spring.core.service.ManagerService;

@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private ManagerDao managerDao;

    public List<Manager> getAllManagers() {
	List<Manager> managers = managerDao.getAllManagers();
	return managers;
    }

    public void insertManager(Manager Manager) {
	managerDao.insertManager(Manager);
    }

}
