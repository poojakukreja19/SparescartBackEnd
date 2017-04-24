package com.niit.sparescart.testcase;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.sparescart.dao.SupplierDAO;
import com.niit.sparescart.domain.Supplier;

import junit.framework.Assert;

public class SupplierTestCase {

	@Autowired
	private static AnnotationConfigApplicationContext context;
	
	@Autowired
	private static Supplier supplier;
	
	@Autowired
	private static SupplierDAO supplierDAO;
	
	@BeforeClass
	public static void initialize()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		supplier = (Supplier)context.getBean("supplier");
		supplierDAO = (SupplierDAO)context.getBean("supplierDAO");
	}

	@Test
	 public void createSupplierTestCase()
	 {
		supplier.setId("2032017");
		supplier.setName("pro pvtltd");
		supplier.setAddress("faridabad");
		supplier.setContact("0987654321");
		boolean flag = supplierDAO.save(supplier);
		Assert.assertEquals("createSupplierTestCase",true, flag);
	 }	
	@Test
	 public void updateSupplierTestCase()
	 {
		supplier.setId("SU007032017");
		supplier.setName("company pvt ltd");
		supplier.setAddress("haryana");
		supplier.setContact("0987654321");
		boolean flag = supplierDAO.update(supplier);
		Assert.assertEquals("updateSupplierTestCase",true, flag);
	 }
	
	@Test
	public void getSupplierByIDTestCase()
	{
		supplier=supplierDAO.getSupplierByID("SU05032017");
	   Assert.assertNotNull("getSupplierByID", supplier);
	}
	
	@Test
	public void getallSupplierTestCase()
	{
    int recordsFromDAO =  supplierDAO.list().size();
		assertEquals("getallSupplierTestCase", 8, recordsFromDAO);
	}
	
	@Test
	public void deleteByIdTestCase()
	{
		boolean flag=supplierDAO.deleteById("SU05032017");
    Assert.assertEquals("delete",true, flag);
	}
	

}
