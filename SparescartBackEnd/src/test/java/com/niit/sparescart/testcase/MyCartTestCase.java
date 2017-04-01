package com.niit.sparescart.testcase;

import org.junit.Test;

import java.util.Date;
import java.util.Set;

import org.junit.BeforeClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.niit.sparescart.dao.MyCartDAO;
import com.niit.sparescart.domain.Mycart;
import com.niit.sparescart.domain.User;
import com.niit.sparescart.domain.Product;


import junit.framework.Assert;


public class MyCartTestCase {
		@Autowired
		private static AnnotationConfigApplicationContext context;
		
		@Autowired
		private static Mycart myCart;
		
		@Autowired
		private static MyCartDAO myCartDAO;
		
		@BeforeClass
		public static void initialize()
		{
			context = new AnnotationConfigApplicationContext();
			context.scan("com.niit");
			context.refresh();
		
			myCart = (Mycart)context.getBean("myCart");
			myCartDAO = (MyCartDAO)context.getBean("myCartDAO");
		}
		
		@SuppressWarnings("deprecation")
		@Test
		 public void createMyCartTestCase()
		 {
			System.out.println("Mycart");
			myCart.setPrice("3456");;
			myCart.setStatus('A'); 
			myCart.setQuantity(4);
			myCart.setAdded_date(new Date());
			boolean flag =myCartDAO.save(myCart);
			Assert.assertEquals("createMyCartTestCase", true,flag);
			}
		
	}


