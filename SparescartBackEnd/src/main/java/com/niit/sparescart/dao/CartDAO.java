package com.niit.sparescart.dao;


	import java.util.List;

import com.niit.sparescart.domain.Cart;


	public interface CartDAO {
		
		
		public boolean savecart(Cart cart);
		
		public List<Cart> getallorders();
		
		public boolean deletecart(Cart cart);
		
		public boolean updatecart(Cart cart);
		
		public Cart getcartById(String id);

}
