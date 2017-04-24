package com.niit.sparescart.dao;

import java.util.List;

import com.niit.sparescart.domain.Category;
import com.niit.sparescart.domain.User;

public interface UserDAO {
	
	//get all user
		public List<User> list();
		
		//get user by id
	    public User getUserByID(String id);
		
		//create new user
		public boolean save(User user);
		
		//update user
		public boolean update(User user);
		
		public boolean validate(String id, String password);
		
		
		
		//delete user by id----its not require
		//public boolean deleteById(String id);

		//delete user
		//public boolean deleteUser(User user);
		
	  //get user by name
	   // public User getUserByName(String name);
		
		


}
