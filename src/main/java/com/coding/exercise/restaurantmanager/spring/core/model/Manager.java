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
@Table(name = "MANAGER_INFO")
public class Manager {

    @Id
    @Column(name = "MANAGER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "manager")
    private Set<Restaurant> restaurants = new HashSet<Restaurant>(0);

    public Manager(String firstName) {
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

    public Set<Restaurant> getRestaurants() {
	return restaurants;
    }

    public void setRestaurants(Set<Restaurant> restaurants) {
	this.restaurants = restaurants;
    }

    public void addRestaurant(Restaurant restaurant) {
	this.restaurants.add(restaurant);
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj) {
	    return true;
	}
	Manager person = (Manager) obj;
	if (firstName != null ? !firstName.equals(person.firstName)
		: person.firstName != null) {
	    return false;
	} else {
	    return true;
	}
    }

    @Override
    public String toString() {
	return "Manager [id=" + id + ", name=" + firstName + "]";
    }
}
