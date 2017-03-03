package com.niit.sparescart.testcase;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.sparescart.dao.CategoryDAO;
import com.niit.sparescart.domain.Category;

import junit.framework.Assert;

public class CategoryTestCase {

	@Autowired
	private static Category category;
	
	@Autowired
	private static CategoryDAO categoryDAO;
	
	@BeforeClass
	public static void init()
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		category = (Category) context.getBean("category");
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}
	
	//TEST CASES
	@SuppressWarnings("deprecation")
	@Test
	public void createCategoryTestCase()
	{
		category.setId("CG05032017");
		category.setName("Electronic Category");
		category.setDescription("This is Mobile");
		
		boolean flag=categoryDAO.save(category);
		
		//COMPARE what you are expecting VS what you are getting from save method
		
		Assert.assertEquals("create category test",true, flag);
		}
	
	@Test
	public void updateCategoryTestCase()
	{
		category.setId("CG02032017");
		category.setName("shoes Category");
		category.setDescription("This is shoes");
		
		boolean flag=categoryDAO.save(category);
		
		//COMPARE what you are expecting VS what you are getting from save method
		
		Assert.assertEquals("updateCategoryTestCase",true, flag);
		}
	
	@Test
	public void deleteTestCase()
	{
        boolean flag=categoryDAO.delete("CG02032017");
        Assert.assertEquals("delete",true, flag);
	}
	
	@Test
	public void deleteCategory()
	{
		category.setId("CG02032017");
		category.setName("Electronic Category");
		category.setDescription("This is Electronic");
        boolean flag=categoryDAO.delete(category);
        Assert.assertEquals("deleteCategoryTestCase",true, flag);
	}
	
	@Test
	public void getCategoryByIDTestCase()
	{
		category=categoryDAO.getCategoryByID("CG05032017");
	   Assert.assertNotNull("getCategoryByID", category);
		//assertEquals("getCategoryByIDTestCase", null, category);
	}
	
	@Test
	public void getCategoryByNameTestCase()
	{
		category=categoryDAO.getCategoryByName("Electronic"
				+ " Category");
	   Assert.assertNotNull("getCategoryByName", category);
	}
	
	@Test
	public void getallCategoriesTestCase()
	{
        int recordsFromDAO =  categoryDAO.getallCategories().size();
		assertEquals("getallCategoriesTestCase", 1, recordsFromDAO);
	}
	
}

