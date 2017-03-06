package com.niit.sparescart.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.sparescart.dao.ProductDAO;
import com.niit.sparescart.domain.Product;

@Transactional
@Repository("productDAO")
public class ProductDAOImpl implements ProductDAO{

	@Autowired
	SessionFactory sessionFactory;
	private ProductDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	public List<Product> getallProducts() {
		List<Product> al=new ArrayList<Product>();  
		   sessionFactory.getCurrentSession().createQuery("from Product").list();
			return (al);
	}
	
	public boolean save(Product product) {
    try {
		sessionFactory.getCurrentSession().save(product);
		return true;
	} catch (Exception e) {
		e.printStackTrace();
		return false;
	}
	}
	
	public boolean update(Product product) {
    try {
		sessionFactory.getCurrentSession().update(product);
		return true;
	} catch (Exception e) {
		e.printStackTrace();
		return false;
	}
	}

	public boolean deleteById(String id) {
    try {
		sessionFactory.getCurrentSession().delete(getProductByID(id));
		return true;
	} catch (Exception e) {
		e.printStackTrace();
		return false;
	}
	}

	public boolean deleteProduct(Product product) {
    try {
		sessionFactory.getCurrentSession().delete(product);
		return true;
	} catch (Exception e) {
		e.printStackTrace();
		return false;
	}
	}

	public Product getProductByID(String id) {
    return (Product) sessionFactory.getCurrentSession().get(Product.class, id);
	}

	public Product getProductByName(String name) {
	return (Product) sessionFactory.getCurrentSession().createQuery("from Product where name = '" +name+ "'").uniqueResult();

	}
	

}
