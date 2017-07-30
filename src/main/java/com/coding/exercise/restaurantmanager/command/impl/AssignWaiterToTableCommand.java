package com.coding.exercise.restaurantmanager.command.impl;

import com.coding.exercise.restaurantmanager.command.RestaurantCommand;
import com.coding.exercise.restaurantmanager.spring.core.model.RestaurantTable;
import com.coding.exercise.restaurantmanager.spring.core.model.Waiter;

public class AssignWaiterToTableCommand implements RestaurantCommand {

    private RestaurantTable table;
    private Waiter waiter;

    public AssignWaiterToTableCommand(RestaurantTable table, Waiter waiter) {
	super();
	this.table = table;
	this.waiter = waiter;
    }

    public void execute() {
	if (waiter.getRestaurantTables().size() < 4) {
	    table.setWaiter(waiter);
	    waiter.addRestaurantTable(table);
	}
    }

}
