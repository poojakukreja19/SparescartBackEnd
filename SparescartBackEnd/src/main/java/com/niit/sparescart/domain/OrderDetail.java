package com.niit.sparescart.domain;

	import java.util.Date;

	import javax.persistence.Entity;
	import javax.persistence.FetchType;
	import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
	import javax.persistence.JoinColumn;
	import javax.persistence.ManyToOne;

	import org.springframework.stereotype.Component;

	@Entity
	@Component
	public class OrderDetail {
		
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private int id;
		@ManyToOne(fetch=FetchType.LAZY)
		@JoinColumn(name="Cart_Id",nullable=false,
		foreignKey = @ForeignKey (name="Orderdetail_cart_FK"))
		private Cart cart;
		
		@ManyToOne(fetch=FetchType.LAZY)
		@JoinColumn(name="Product_Id",nullable=false,foreignKey=@ForeignKey(name="Orderdetail_product_FK"))
		private Product product;
		private int quantity;
		private Date orderDate;
		private float price;
		private float amount;

		
		
		public Date getOrderDate() {
			return orderDate;
		}
		public void setOrderDate(Date orderDate) {
			this.orderDate = orderDate;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}	

		public Cart getCart() {
			return cart;
		}
		public void setCart(Cart cart) {
			this.cart = cart;
		}
		public Product getProduct() {
			return product;
		}
		public void setProduct(Product product) {
			this.product = product;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		public float getPrice() {
			return price;
		}
		public void setPrice(float price) {
			this.price = price;
		}
		public float getAmount() {
			return amount;
		}
		public void setAmount(float amount) {
			this.amount = amount;
		}
		
	} 