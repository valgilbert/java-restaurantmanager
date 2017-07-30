package com.coding.exercise.restaurantmanager.spring.core.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coding.exercise.restaurantmanager.spring.core.dao.RestaurantDao;
import com.coding.exercise.restaurantmanager.spring.core.model.Restaurant;

@Repository
@Transactional(readOnly = true)
public class RestaurantDaoImpl implements RestaurantDao {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Restaurant> getAllRestaurants() {
	Session session = sessionFactory.openSession();
	String hql = "FROM Restaurant";
	Query query = session.createQuery(hql);
	List<Restaurant> restaurants = query.list();
	return restaurants;
    }

    @Transactional(readOnly = false)
    public void insertRestaurant(Restaurant restaurant) {
	Session session = sessionFactory.openSession();
	session.save(restaurant);
    }

}
