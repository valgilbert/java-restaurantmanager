package com.coding.exercise.restaurantmanager.spring.core.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coding.exercise.restaurantmanager.spring.core.dao.RestaurantTableDao;
import com.coding.exercise.restaurantmanager.spring.core.model.Restaurant;
import com.coding.exercise.restaurantmanager.spring.core.model.RestaurantTable;

@Repository
@Transactional(readOnly = true)
public class RestaurantTableDaoImpl implements RestaurantTableDao {

    @Autowired
    private SessionFactory sessionFactory;

    public List<RestaurantTable> getAllRestaurantTables() {
	Session session = sessionFactory.openSession();
	String hql = "FROM RestaurantTable";
	Query query = session.createQuery(hql);
	List<RestaurantTable> restaurantTables = query.list();
	return restaurantTables;
    }

    @Transactional(readOnly = false)
    public void insertRestaurantTable(RestaurantTable restaurantTable) {
	Session session = sessionFactory.openSession();
	session.save(restaurantTable);
    }

}
