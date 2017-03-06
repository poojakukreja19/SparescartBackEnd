package com.niit.sparescart.dao;

import java.util.List;

import com.niit.sparescart.domain.Category;
import com.niit.sparescart.domain.Product;

public interface ProductDAO {

	    //get all Product
	    public List<Product> getallProducts();
		
		//create Product
		public boolean save(Product product);
		
		//update Product
		public boolean update(Product product);
		
		//delete Product by id
		public boolean deleteById(String id);

		//delete Product
		public boolean deleteProduct(Product product);
		
		//get Product by id
	    public Product getProductByID(String id);
		
	  //get Product by name
	    public Product getProductByName(String name);
		
		

}
