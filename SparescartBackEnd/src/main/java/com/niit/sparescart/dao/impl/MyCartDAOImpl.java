package com.niit.sparescart.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.sparescart.dao.MyCartDAO;
import com.niit.sparescart.domain.Mycart;

@Transactional
@Repository("myCartDAO")
public class MyCartDAOImpl implements MyCartDAO  {
	
	@Autowired
	SessionFactory sessionFactory;
	private MyCartDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	public List<Mycart> list(String userid) {
    List<Mycart> al=new ArrayList<Mycart>();
	  return sessionFactory.getCurrentSession().createQuery("from MyCart").list();
	}
	
	public boolean save(Mycart myCart) {
		try {
			sessionFactory.getCurrentSession().save(myCart);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		}	
	
	public boolean update(Mycart myCart) {
		try {
			sessionFactory.getCurrentSession().update(myCart);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		}	
	
	public boolean delete(Mycart myCart) {
		try {
			sessionFactory.getCurrentSession().delete(myCart);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		}

	public Long getTotalAmount(String id) {
    String hql = "select sum(price*quantity) from MyCart where userId=" + "'" + " and status = " + "'N'";
    Query query = sessionFactory.getCurrentSession().createQuery(hql);
    return (Long) query.uniqueResult();
	}

}
