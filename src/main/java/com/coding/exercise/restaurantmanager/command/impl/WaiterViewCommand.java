package com.coding.exercise.restaurantmanager.command.impl;

import com.coding.exercise.restaurantmanager.command.RestaurantCommand;
import com.coding.exercise.restaurantmanager.spring.core.model.Waiter;

public class WaiterViewCommand implements RestaurantCommand {

    private Waiter waiter;

    public WaiterViewCommand(Waiter waiter) {
	super();
	this.waiter = waiter;
    }

    public void execute() {
	System.out.print(waiter.getFirstName() + ": ");
	waiter.getRestaurantTables().forEach(
		table -> System.out.print(table.getTableName() + ", "));
	System.out.println();
    }
}
