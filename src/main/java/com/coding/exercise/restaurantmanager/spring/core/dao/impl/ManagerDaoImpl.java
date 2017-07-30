package com.coding.exercise.restaurantmanager.spring.core.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coding.exercise.restaurantmanager.spring.core.dao.ManagerDao;
import com.coding.exercise.restaurantmanager.spring.core.model.Manager;

@Repository
@Transactional(readOnly = true)
public class ManagerDaoImpl implements ManagerDao {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Manager> getAllManagers() {
	Session session = sessionFactory.openSession();
	String hql = "FROM Manager";
	Query query = session.createQuery(hql);
	List<Manager> Managers = query.list();
	return Managers;
    }

    @Transactional(readOnly = false)
    public void insertManager(Manager manager) {
	Session session = sessionFactory.openSession();
	session.save(manager);
    }

}
