package com.coding.exercise.restaurantmanager.spring.core.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "RESTAURANT_TABLE_INFO")
public class RestaurantTable {

    @Id
    @Column(name = "TABLE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "TABLE_NAME")
    private String tableName;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "WAITER_ID")
    private Waiter waiter;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "RESTAURANT_ID")
    private Restaurant restaurant;

    public RestaurantTable(String tableName) {
	this.tableName = tableName;
    }

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public String getTableName() {
	return tableName;
    }

    public void setTableName(String tableName) {
	this.tableName = tableName;
    }

    public void setWaiter(Waiter waiter) {
	this.waiter = waiter;
    }

    public Waiter getWaiter() {
	return this.waiter;
    }

    public Restaurant getRestaurant() {
	return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
	this.restaurant = restaurant;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj) {
	    return true;
	}
	RestaurantTable person = (RestaurantTable) obj;
	if (tableName != null ? !tableName.equals(person.tableName)
		: person.tableName != null) {
	    return false;
	} else {
	    return true;
	}
    }

    @Override
    public String toString() {
	return "RestaurantTable [id=" + id + ", tableName=" + tableName
		+ ", waiter=" + waiter + "]";
    }

}
