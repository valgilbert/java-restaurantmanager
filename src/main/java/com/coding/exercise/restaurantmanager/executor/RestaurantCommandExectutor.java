package com.coding.exercise.restaurantmanager.executor;

import com.coding.exercise.restaurantmanager.command.RestaurantCommand;

public class RestaurantCommandExectutor {

    public enum RestaurantCommandEnum {
	ASSIGN_TO_TABLE, MANAGER_VIEW, WAITER_VIEW;
    }

    public void executeTableCommand(final RestaurantCommand cmd) {
	cmd.execute();
    }
}
