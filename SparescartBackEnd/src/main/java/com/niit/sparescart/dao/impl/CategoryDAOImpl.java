package com.niit.sparescart.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.sparescart.dao.CategoryDAO;
import com.niit.sparescart.domain.Category;

@Transactional
@Repository("categoryDAO")  //its case sensitive
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	SessionFactory sessionFactory;

	private CategoryDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<Category> getallCategories() {
		// select * from category -SQL query -mention the table name
		// from Category -HQL -MENTION Domain class name not table name

		// convert the hibernate query into db specific language
		//creating variable of list & pass from list
		
		List<Category> al=new ArrayList<Category>();  
	   sessionFactory.getCurrentSession().createQuery("from category").list();
		return (al);
	}

	public boolean save(Category category) {

		try {
			sessionFactory.getCurrentSession().save(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
 

	public boolean update(Category category) {
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(String id) {
		try {
			sessionFactory.getCurrentSession().delete(getCategoryByID(id));
			return true;
		} catch (Exception e) {
			e.printStackTrace(); // it will display the error in eclipse console
			// package ,class, method line number from which place you are
			// calling
			return false;
		}

	}

	public boolean delete(Category category) {
		try {
			sessionFactory.getCurrentSession().delete(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Category getCategoryByID(String id) {

		return (Category)  sessionFactory.getCurrentSession().get(Category.class, id);
		

		// select * from category where id= 'mobile'
		// return (Category)
		// sessionFactory.getCurrentSession().get(Category.class,id);

		// return (Category)
		// sessionFactory.getCurrentSession().createQuery("from Category where
		// id = '"+id +"'").list().get(0);
		//return (Category) sessionFactory.getCurrentSession().createQuery("from Category where id = '" + id + "'").uniqueResult();
		

	}

	public Category getCategoryByName(String name) {

		//return (Category) sessionFactory.getCurrentSession().createQuery("from Category where name = '" + name + "'").list().get(0);
        System.out.println("getstringname"+name);
		return (Category) sessionFactory.getCurrentSession().createQuery("from Category where name = '" +name+ "'").uniqueResult();
		
	}

}
