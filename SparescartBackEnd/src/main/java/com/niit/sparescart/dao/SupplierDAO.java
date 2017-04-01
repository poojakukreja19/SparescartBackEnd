package com.niit.sparescart.dao;

import java.util.List;

import com.niit.sparescart.domain.Supplier;

public interface SupplierDAO {
	
	       //get all Supplier
		    public List<Supplier> list();
			
			//create new Supplier
			public boolean save(Supplier supplier);
			
			//update Supplier
			public boolean update(Supplier supplier);
			
			//get Supplier by id
		    public Supplier getSupplierByID(String id);

			public boolean deleteById(String id);

			
			

}
