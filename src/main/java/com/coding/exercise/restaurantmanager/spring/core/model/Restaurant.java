package com.coding.exercise.restaurantmanager.spring.core.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "RESTAURANT_INFO")
public class Restaurant {

    @Id
    @Column(name = "RESTAURANT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "RESTAURANT_NAME")
    private String restaurantName;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "restaurant")
    private Set<RestaurantTable> restaurantTables = new HashSet<RestaurantTable>(
	    0);

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MANAGER_ID")
    private Manager manager;

    public Restaurant(String restaurantName) {
	this.restaurantName = restaurantName;
    }

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public String getName() {
	return restaurantName;
    }

    public void setName(String restaurantName) {
	this.restaurantName = restaurantName;
    }

    public String getRestaurantName() {
	return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
	this.restaurantName = restaurantName;
    }

    public Set<RestaurantTable> getRestaurantTables() {
	return restaurantTables;
    }

    public void addRestaurantTable(RestaurantTable table) {
	this.restaurantTables.add(table);
    }

    public Manager getManager() {
	return manager;
    }

    public void setManager(Manager manager) {
	this.manager = manager;
    }

    public void setRestaurantTables(Set<RestaurantTable> restaurantTables) {
	this.restaurantTables = restaurantTables;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj) {
	    return true;
	}
	Restaurant person = (Restaurant) obj;
	if (restaurantName != null ? !restaurantName
		.equals(person.restaurantName) : person.restaurantName != null) {
	    return false;
	} else {
	    return true;
	}
    }

    @Override
    public String toString() {
	return "Restaurant [id=" + id + ", name=" + restaurantName + " "
		+ restaurantName + "]";
    }
}
