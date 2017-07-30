package com.coding.exercise.restaurantmanager.spring.core.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DBUtils {

    @Autowired
    private DataSource dataSource;

    @PostConstruct
    public void initialize() {
	try {
	    Connection connection = dataSource.getConnection();
	    Statement statement = connection.createStatement();

	    statement.execute("DROP TABLE IF EXISTS WAITER_INFO");
	    statement.executeUpdate("CREATE TABLE WAITER_INFO("
		    + "WAITER_ID INTEGER Primary key, "
		    + "FIRST_NAME varchar(30) not null)");

	    statement.execute("DROP TABLE IF EXISTS RESTAURANT_TABLE_INFO");
	    statement.executeUpdate("CREATE TABLE RESTAURANT_TABLE_INFO("
		    + "TABLE_ID INTEGER Primary key, "
		    + "TABLE_NAME varchar(30) not null, "
		    + "RESTAURANT_ID INTEGER," + "WAITER_ID INTEGER)");

	    statement.execute("DROP TABLE IF EXISTS RESTAURANT_INFO");
	    statement.executeUpdate("CREATE TABLE RESTAURANT_INFO("
		    + "RESTAURANT_ID INTEGER Primary key, "
		    + "RESTAURANT_NAME varchar(30) not null,"
		    + "MANAGER_ID INTEGER)");

	    statement.execute("DROP TABLE IF EXISTS MANAGER_INFO");
	    statement.executeUpdate("CREATE TABLE MANAGER_INFO("
		    + "MANAGER_ID INTEGER Primary key, "
		    + "FIRST_NAME varchar(30) not null)");

	    statement.close();
	    connection.close();
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }
}
