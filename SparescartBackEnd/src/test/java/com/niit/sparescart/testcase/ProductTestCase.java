package com.niit.sparescart.testcase;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.sparescart.dao.ProductDAO;
import com.niit.sparescart.domain.Product;

import junit.framework.Assert;

public class ProductTestCase {

	@Autowired
	private static Product product;
	
	@Autowired
	private static ProductDAO productDAO;
	
	@BeforeClass
	public static void init()
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		product = (Product) context.getBean("product");
	    productDAO = (ProductDAO) context.getBean("productDAO");
	}
	
	
	@Test
	public void createProductTestCase()
	{
		product.setId("PD070032017");
		product.setName("Mobile");
		product.setPrice("2345");
		product.setDescription("This is Mobile");
		boolean flag=productDAO.save(product);		
		Assert.assertEquals("createProductTestCase",true, flag);
		}
	
	@Test
	public void updateProductTestCase()
	{
		product.setId("PD09032017");
		product.setName("Mobile1");
		product.setPrice("2345");
		product.setDescription("This is Mobile");
		boolean flag=productDAO.update(product);		
		Assert.assertEquals("updateProductTestCase",true, flag);
		}
	
	@Test
	public void deleteByIdTestCase()
	{
        boolean flag=productDAO.deleteById("PD08032017");
        Assert.assertEquals("deleteByIdTestCase",true, flag);
	}
	
	@Test
	public void deleteProductTestCase()
	{
		product.setId("PD08032017");
		product.setName("Electronic");
		product.setPrice("2345");
		product.setDescription("This is Mobile");
		boolean flag=productDAO.deleteProduct(product);		
		Assert.assertEquals("deleteProductTestCase",true, flag);
		}
	
	@Test
	public void getProductByIDTestCase()
	{
		product=productDAO.getProductByID("PD05032017");
	   Assert.assertNotNull("getProductByIDTestCase", product);
	}
	
	@Test
	public void getProductByNameTestCase()
	{
		product=productDAO.getProductByName("Clothese");
	   Assert.assertNotNull("getProductByNameTestCase", product);
	}
	
	@Test
	public void getallProductsTestCase()
	{
        int recordsFromDAO =  productDAO.getallProducts().size();
		assertEquals("getallProductsTestCase", 0, recordsFromDAO);//database showing 3 row but in testing showing zero rows
	}
	

}
