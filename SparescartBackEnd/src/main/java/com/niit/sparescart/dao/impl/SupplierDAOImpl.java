package com.niit.sparescart.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.sparescart.dao.SupplierDAO;
import com.niit.sparescart.domain.Supplier;
import com.niit.sparescart.domain.User;

@Transactional
@Repository("supplierDAO")
public class SupplierDAOImpl implements SupplierDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	private Session getSession()
	{
	return sessionFactory.getCurrentSession();
	}
	
	public List<Supplier> list() {
	return sessionFactory.getCurrentSession().createQuery("from Supplier").list();	
	}
	
	public boolean save(Supplier supplier) {
    try {
		getSession().save(supplier);
		return true;
	} catch (Exception e) {
		e.printStackTrace();
		return false;
	}
	}
	
	public boolean update(Supplier supplier) {
    try {
		getSession().update(supplier);
		return true;
	} catch (Exception e) {
		e.printStackTrace();
		return false;
	}
	}
	public Supplier getSupplierByID(String id) {
    return (Supplier) sessionFactory.getCurrentSession().get(Supplier.class, id);
	}

	public boolean deleteById(String id) {
		try {
			sessionFactory.getCurrentSession().delete(getSupplierByID(id));
			return true;
		} catch (Exception e) {
			e.printStackTrace(); 
			return false;
		}

	}



}
