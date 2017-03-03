package com.niit.sparescart.dao;

import java.util.List;

import com.niit.sparescart.domain.Category;

public interface CategoryDAO {
	
	//get all category
	public List<Category> getallCategories();
	
	//create category
	public boolean save(Category category);
	
	//update category
	public boolean update(Category category);
	
	//delete category by id
	public boolean delete(String id);

	//delete category
	public boolean delete(Category category);
	
	//get category by id
    public Category getCategoryByID(String id);
	
  //get category by name
    public Category getCategoryByName(String name);
	
	

}
