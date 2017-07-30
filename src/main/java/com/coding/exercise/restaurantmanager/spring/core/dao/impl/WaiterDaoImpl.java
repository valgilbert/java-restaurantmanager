package com.coding.exercise.restaurantmanager.spring.core.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coding.exercise.restaurantmanager.spring.core.dao.WaiterDao;
import com.coding.exercise.restaurantmanager.spring.core.model.Waiter;

@Repository
@Transactional(readOnly = true)
public class WaiterDaoImpl implements WaiterDao {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Waiter> getAllWaiters() {
	Session session = sessionFactory.openSession();
	String hql = "FROM Waiter";
	Query query = session.createQuery(hql);
	List<Waiter> waiters = query.list();
	return waiters;
    }

    @Transactional(readOnly = false)
    public void insertWaiter(Waiter waiter) {
	Session session = sessionFactory.openSession();
	session.save(waiter);
    }

}
