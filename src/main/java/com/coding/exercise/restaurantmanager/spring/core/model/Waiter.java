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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "WAITER_INFO")
public class Waiter {

    @Id
    @Column(name = "WAITER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "waiter")
    private Set<RestaurantTable> restaurantTables = new HashSet<RestaurantTable>(
	    0);

    public Waiter(String firstName) {
	this.firstName = firstName;
    }

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public String getFirstName() {
	return firstName;
    }

    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }

    public Set<RestaurantTable> getRestaurantTables() {
	return this.restaurantTables;
    }

    public void setRestaurantTables(Set<RestaurantTable> assignedTables) {
	this.restaurantTables = assignedTables;
    }

    public void addRestaurantTable(RestaurantTable table) {
	this.restaurantTables.add(table);
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj) {
	    return true;
	}
	Waiter person = (Waiter) obj;
	if (firstName != null ? !firstName.equals(person.firstName)
		: person.firstName != null) {
	    return false;
	} else {
	    return true;
	}
    }

    @Override
    public String toString() {
	return "Waiter [id=" + id + ", firstName=" + firstName
		+ ", restaurantTables=" + restaurantTables + "]";
    }

}
