package com.niit.sparescart.dao;


	import java.util.List;

import com.niit.sparescart.domain.OrderDetail;
import com.niit.sparescart.domain.Product;


	public interface OderDetailDAO {
		
		public boolean saveorderDetail(OrderDetail orderDetail);
		
		public boolean updateorderDetail(OrderDetail orderDetail);
		
		public boolean deleteorderDetail(OrderDetail orderDetail);
		
		public boolean deleteorderDetailById(int id);	    

		public List<OrderDetail> getorderDetailbyID(String id);
		
		public OrderDetail getorderDetailbyID(int id);

		
		//public List<OderDetailDAO> getorderlist(OrderDetail orderDetail);

	}


