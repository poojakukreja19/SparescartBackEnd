package com.niit.sparescart.testcase;


	import static org.junit.Assert.*;

	import java.sql.Date;
	import java.util.List;
	import junit.framework.Assert;

	import org.junit.Before;
	import org.junit.Test;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.sparescart.dao.CartDAO;
import com.niit.sparescart.dao.OderDetailDAO;
import com.niit.sparescart.dao.ProductDAO;
import com.niit.sparescart.domain.Cart;
import com.niit.sparescart.domain.OrderDetail;
import com.niit.sparescart.domain.Product;

	
	public class OrderDetailTestCase {

	@Autowired
	public OrderDetail orderDetail;
	@Autowired
	public OderDetailDAO orderDetailDAO;

	@Autowired
	public Cart cart;

	@Autowired
	public CartDAO cartDAO;

	@Autowired
	public Product product;

	@Autowired
	public ProductDAO productDAO;


			@Before
			public void init()
			{
				AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
				context.scan("com.niit");
				context.refresh();
				orderDetail=(OrderDetail)context.getBean("orderDetail");
				orderDetailDAO=(OderDetailDAO) context.getBean("orderDetailDAO");
				cart=(Cart)context.getBean("cart");
				cartDAO=(CartDAO) context.getBean("cartDAO");
				product=(Product) context.getBean("product");
				productDAO=(ProductDAO) context.getBean("productDAO");
				
				
			}
			
			@Test
			public void saveorderdetail()
			{
				
				orderDetail.setId(0);
				System.out.println("id");
				orderDetail.setOrderDate(new Date(0));
				orderDetail.setAmount((float) 789.25);
				orderDetail.setPrice((float) 500.25);
				orderDetail.setQuantity(2);
			product=productDAO.getProductByID("2");	
				cart=cartDAO.getcartById("niit");
			orderDetail.setProduct(product);
				
				orderDetail.setCart(cart);
				boolean flag=orderDetailDAO.saveorderDetail(orderDetail);
				Assert.assertEquals("saveorderdetail",true,flag);
			}
//			@Test
//    		public void updateorderDetail()
//   		{
//				orderDetail.setId(105);
//				orderDetail.setOrderDate(new Date(0));
//				orderDetail.setAmount((float) 789.25);
//				orderDetail.setPrice((float) 45.25);
//				orderDetail.setQuantity(4);
//				orderDetail.setProduct(product);
//				orderDetail.setCart(cart);
//				boolean flag=orderDetailDAO.updateorderDetail(orderDetail);
//				Assert.assertEquals("updateorderDetail",true,flag);
//			}
			
//			
//			@Test
//			public  void deleteorderDetail()
//			{
//				boolean flag=orderDetailDAO.deleteorderDetail(orderDetail);
//				Assert.assertEquals("deleteorderdetail",true,flag);
//
//			}
//			
//			@Test
//		public void getorderDetail()
//			{
//			List<OderDetailDAO> flag=orderDetailDAO.getorderlist(orderDetail);
//			Assert.assertEquals("getorderdetaillist",true,flag);
//		}

	}


