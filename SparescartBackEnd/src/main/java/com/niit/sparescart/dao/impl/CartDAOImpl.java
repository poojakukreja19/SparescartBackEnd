package com.niit.sparescart.dao.impl;


	import java.util.List;

	import javax.transaction.Transactional;

	import org.hibernate.SessionFactory;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Repository;

import com.niit.sparescart.dao.CartDAO;
import com.niit.sparescart.domain.Cart;


	@Transactional
	@Repository("cartDAO")
	public class CartDAOImpl  implements CartDAO{
		
		@Autowired
		private SessionFactory sessionFactory;
		
		public CartDAOImpl(SessionFactory sessionFactory)
		{
			this.sessionFactory=sessionFactory;
		}
		
		

		public List<Cart> getallorders() {
		return sessionFactory.getCurrentSession().createQuery("from Cart").list();
		}

		public boolean savecart(Cart cart) {
			sessionFactory.getCurrentSession().save(cart);
			return true;
						
		}
         
		public boolean deletecart(Cart cart) {
			sessionFactory.getCurrentSession().delete(cart);
			return true;
		}
		
		public boolean updatecart(Cart cart) {
			sessionFactory.getCurrentSession().update(cart);
			return true;
		}

		public Cart getcartById(String id) {
			//return (Cart) sessionFactory.getCurrentSession().createQuery("from cart where id ='"+id+"'").uniqueResult();
     	String hql="from Cart where id =  '" +id+ "'";
     	Cart c = (Cart)sessionFactory.getCurrentSession().createQuery(hql).uniqueResult();
			if( c ==null) // no row exist on return null
			{
				return null;
			}
			return c;
			}
		}

	

