package com.niit.sparescart.dao;

import java.util.List;

import com.niit.sparescart.domain.Mycart;

public interface MyCartDAO {
	
	public List<Mycart> list(String userid);
	
	public boolean save(Mycart myCart);
	
	public boolean update(Mycart myCart);
	
	public boolean delete(Mycart myCart);
	
	public Long getTotalAmount(String id);

	
	
		
	

}
