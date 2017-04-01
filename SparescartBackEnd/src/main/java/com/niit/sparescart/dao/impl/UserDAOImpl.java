package com.niit.sparescart.dao.impl;

//import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.sparescart.dao.UserDAO;
import com.niit.sparescart.domain.User;

@Transactional
@Repository("userDAO")
public class UserDAOImpl implements UserDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	private Session getSession()
	{
		return sessionFactory.getCurrentSession(); //indirectly calling this method
	}
	
	public List<User> list() {
    return sessionFactory.getCurrentSession().createQuery("from User").list();	//user is a domain object not table name	
	}
	
	public User getUserByID(String id) {
	return  (User) sessionFactory.getCurrentSession().get(User.class, id);
	}
	
	public boolean save(User user) {
     try {
		getSession().save(user);
		return true;
	} catch (Exception e) {
		e.printStackTrace();
		return false;
	}
	}
	public boolean update(User user) {
		try {
			getSession().update(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean validate(String id, String password) {
     //select * from user where id= 'niit' and password ='niit'
		String hql="from User where id =  '" +id+ "' and password = '"+password+"'";
		if(getSession().createQuery(hql).uniqueResult()  ==null) // no row exist on return null
		{
			return false;
		}
		return true;
		}
	}

