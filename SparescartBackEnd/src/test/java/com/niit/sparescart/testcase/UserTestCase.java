package com.niit.sparescart.testcase;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.sparescart.dao.UserDAO;
import com.niit.sparescart.domain.User;

import junit.framework.Assert;

public class UserTestCase {

	@Autowired
	private static AnnotationConfigApplicationContext context;
	
	@Autowired
	private static User user;
	
	@Autowired 
	private static UserDAO userDAO;
	
	@BeforeClass
	public static void initialize()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
	
		user = (User)context.getBean("user");
		userDAO = (UserDAO)context.getBean("userDAO");
	}
	 
	@Test
	 public void createUserTestCase()
		{
			user.setId("US01032017");
			user.setName("pooja");
            user.setPassword("pooja");	
            user.setMail("pooja@gmail.com");
            user.setContact("9876543210");
            user.setRole("Role_Admin");
			boolean flag=userDAO.save(user);			
			Assert.assertEquals("createUserTestCase",true, flag);
        }
	@Test
	public void updateUserTestCase()
	{
		user.setId("US01032017");
		user.setName("niit1");
        user.setPassword("niit2");	
        user.setMail("niit@gmail.com");
        user.setContact("9876543210");
        user.setRole("Role_Customer");
		boolean flag=userDAO.update(user);			
		Assert.assertEquals("updateUserTestCase",true, flag);
    }
	
	 
}
