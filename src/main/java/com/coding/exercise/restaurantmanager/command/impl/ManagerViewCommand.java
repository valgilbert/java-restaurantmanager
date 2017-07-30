package com.coding.exercise.restaurantmanager.command.impl;

import com.coding.exercise.restaurantmanager.command.RestaurantCommand;
import com.coding.exercise.restaurantmanager.spring.core.model.Manager;
import com.coding.exercise.restaurantmanager.spring.core.model.Restaurant;
import com.coding.exercise.restaurantmanager.spring.core.model.RestaurantTable;

public class ManagerViewCommand implements RestaurantCommand {

    private Manager manager;

    public ManagerViewCommand(Manager manager) {
	super();
	this.manager = manager;
    }

    public void execute() {
	String waiterName = null;
	for (Restaurant restaurant : manager.getRestaurants()) {
	    for (RestaurantTable table : restaurant.getRestaurantTables()) {
		waiterName = (table.getWaiter() == null) ? "Unassigned" : table
			.getWaiter().getFirstName();
		System.out.println(table.getTableName() + ": " + waiterName);
	    }
	}
    }
}
