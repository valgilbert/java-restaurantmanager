package com.coding.exercise.restaurantmanager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.coding.exercise.restaurantmanager.command.impl.AssignWaiterToTableCommand;
import com.coding.exercise.restaurantmanager.command.impl.ManagerViewCommand;
import com.coding.exercise.restaurantmanager.command.impl.WaiterViewCommand;
import com.coding.exercise.restaurantmanager.executor.RestaurantCommandExectutor;
import com.coding.exercise.restaurantmanager.spring.core.model.Manager;
import com.coding.exercise.restaurantmanager.spring.core.model.Restaurant;
import com.coding.exercise.restaurantmanager.spring.core.model.RestaurantTable;
import com.coding.exercise.restaurantmanager.spring.core.model.Waiter;
import com.coding.exercise.restaurantmanager.spring.core.service.ManagerService;
import com.coding.exercise.restaurantmanager.spring.core.service.RestaurantService;
import com.coding.exercise.restaurantmanager.spring.core.service.RestaurantTableService;
import com.coding.exercise.restaurantmanager.spring.core.service.WaiterService;

public class RestaurantManagerMain {

    public static void main(String[] args) {
	ApplicationContext context = new ClassPathXmlApplicationContext(
		"/META-INF/spring/app-context.xml");
	WaiterService waiterService = context.getBean("waiterServiceImpl",
		WaiterService.class);

	ManagerService managerService = context.getBean("managerServiceImpl",
		ManagerService.class);

	RestaurantService restaurantService = context.getBean(
		"restaurantServiceImpl", RestaurantService.class);

	RestaurantTableService restaurantTableService = context.getBean(
		"restaurantTableServiceImpl", RestaurantTableService.class);

	Waiter waiter = new Waiter("Jill");

	RestaurantTable table1 = new RestaurantTable("Table 1");
	table1.setWaiter(waiter);

	RestaurantTable table2 = new RestaurantTable("Table 2");
	table2.setWaiter(waiter);
	waiterService.insertWaiter(waiter);

	
	RestaurantCommandExectutor executor = new RestaurantCommandExectutor();

	List<Waiter> waiterList = new ArrayList<Waiter>();
	for (int i = 1; i <= 8; i++) {
	    waiterList.add(new Waiter("Waiter" + i));
	}

	List<RestaurantTable> tableList1 = new ArrayList<RestaurantTable>();
	for (int i = 1; i <= 20; i++) {
	    tableList1.add(new RestaurantTable("Table1_" + i));
	}

	List<RestaurantTable> tableList2 = new ArrayList<RestaurantTable>();
	for (int i = 1; i <= 20; i++) {
	    tableList2.add(new RestaurantTable("Table2_" + i));
	}

	Restaurant rest1 = new Restaurant("Restaurant 1");

	Restaurant rest2 = new Restaurant("Restaurant 2");

	Manager manager = new Manager("Manager");

	manager.addRestaurant(rest1);
	manager.addRestaurant(rest2);

	executor.executeTableCommand(new AssignWaiterToTableCommand(tableList1
		.get(0), waiterList.get(0)));
	executor.executeTableCommand(new AssignWaiterToTableCommand(tableList1
		.get(1), waiterList.get(1)));
	executor.executeTableCommand(new AssignWaiterToTableCommand(tableList2
		.get(0), waiterList.get(2)));
	executor.executeTableCommand(new AssignWaiterToTableCommand(tableList2
		.get(1), waiterList.get(3)));
	executor.executeTableCommand(new AssignWaiterToTableCommand(tableList1
		.get(2), waiterList.get(0)));

	executor.executeTableCommand(new ManagerViewCommand(manager));
	executor.executeTableCommand(new WaiterViewCommand(waiterList.get(0)));
	executor.executeTableCommand(new WaiterViewCommand(waiterList.get(1)));
	executor.executeTableCommand(new WaiterViewCommand(waiterList.get(2)));
	executor.executeTableCommand(new WaiterViewCommand(waiterList.get(3)));
    }
}
