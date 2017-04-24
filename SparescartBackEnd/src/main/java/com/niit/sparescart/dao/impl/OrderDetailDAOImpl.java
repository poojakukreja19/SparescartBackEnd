package com.niit.sparescart.dao.impl;

	import java.util.List;

	import javax.transaction.Transactional;

	import org.hibernate.SessionFactory;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Repository;

import com.niit.sparescart.dao.OderDetailDAO;
import com.niit.sparescart.domain.OrderDetail;
import com.niit.sparescart.domain.Product;

	

	@Transactional
	@Repository("orderDetailDAO")
	public class OrderDetailDAOImpl implements OderDetailDAO {
		
		@Autowired
		private SessionFactory sessionFactory;
		
		public OrderDetailDAOImpl(SessionFactory sessionFactory)
		{
			this.sessionFactory=sessionFactory;
		}
  
		public boolean saveorderDetail(OrderDetail orderDetail) {
			sessionFactory.getCurrentSession().save(orderDetail);
			return true;
		}

		public boolean updateorderDetail(OrderDetail orderDetail) {
			sessionFactory.getCurrentSession().update(orderDetail);
			return true;
		}
		public boolean deleteorderDetail(OrderDetail orderDetail) {
			sessionFactory.getCurrentSession().delete(orderDetail);
			return true;	}

//		public List<OderDetailDAO> getorderlist(OrderDetail orderDetail) {
//			return sessionFactory.getCurrentSession().createQuery("from orderDetail").list();
//		}

		public List<OrderDetail> getorderDetailbyID(String id) {
			return (List<OrderDetail>) sessionFactory.getCurrentSession().createQuery("from OrderDetail where cart_id= '"+id +"'").list();
       
		}

		public boolean deleteorderDetailById(int id) {
			try {
				sessionFactory.getCurrentSession().delete(getorderDetailbyID(id));
				return true;
			} catch (Exception e) {
				e.printStackTrace(); 
				return false;
			}

		}

		public OrderDetail getorderDetailbyID(int id) {
		    return (OrderDetail) sessionFactory.getCurrentSession().get(OrderDetail.class, id);

		}
	}

	
