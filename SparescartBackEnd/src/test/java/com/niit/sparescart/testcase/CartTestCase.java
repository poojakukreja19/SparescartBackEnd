package com.niit.sparescart.testcase;

import static org.junit.Assert.*;

import org.junit.Test;
import junit.framework.Assert;


	import java.util.List;

	import org.junit.Before;
	import org.junit.Test;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.sparescart.dao.CartDAO;
import com.niit.sparescart.dao.UserDAO;
import com.niit.sparescart.domain.Cart;
import com.niit.sparescart.domain.User;

	
	/**
	 * @author smile
	 *
	 */
	public class CartTestCase {

		@Autowired
		private  Cart cart;

		@Autowired
		private CartDAO cartDAO;
		
		@Autowired
		public User user;
		
		@Autowired
		public UserDAO userDAO;
		
		
		@Before
		public void init()
		{
			AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
			context.scan("com.niit");
			context.refresh();
			cart=(Cart) context.getBean("cart");
			cartDAO=(CartDAO)context.getBean("cartDAO");
			user=(User) context.getBean("user");
			userDAO=(UserDAO) context.getBean("userDAO");
			
		}
		
		@Test
		public void addcartTestcase()
		{
			cart.setId("106");
			cart.setCustomerName("latita");
			cart.setCustomerEmail("radha@gmail.com");
			cart.setCustomerAddress("Sonipat");
			cart.setCustomerPhone(785121234);
			user=userDAO.getUserByID("pooja");
			cart.setUser(user);
			boolean flag=cartDAO.savecart(cart);
			Assert.assertEquals("cartordertestcase",true,flag);
		}
	
		
	@Test
			public void updatecartTestcase()
			{																									
					cart.setId("106");
					cart.setCustomerName("Usha");
					cart.setCustomerEmail("usha@gmail.com");
					cart.setCustomerAddress("sonipat");
					cart.setCustomerPhone(78745237);
					user=userDAO.getUserByID("niit");
					boolean flag=cartDAO.updatecart(cart);
					Assert.assertEquals("udatecarttestcase",true,flag);
			}
//	@Test
//	public void deletecartTestcase()
//	{
//		boolean flag=cartDAO.deletecart(cart);
//		user=userDAO.getUserByID("3");
//		Assert.assertEquals("removecarttestcase",true,flag);
//		
//	}
//	
//	@Test
//	public void getallorderTestcase()
//	{
//		List<Cart> flag=cartDAO.getallorders();
//		Assert.assertEquals("orderlisttestcase",true,flag);
//	}
//
//	@Test
//	public void getlistbyidTestcase()
//	{
//		cart=cartDAO.getorderbyid("100");
//		Assert.assertEquals("getlistbyid",true);
//	}
//}
	}

				