package com.niit.sparescart.domain;


	import javax.persistence.Entity;
	import javax.persistence.FetchType;
	import javax.persistence.ForeignKey;
	import javax.persistence.Id;
	import javax.persistence.JoinColumn;
	import javax.persistence.OneToOne;

	import org.springframework.stereotype.Component;

	@Entity
	@Component
	public class Cart {

		@Id
		private String id;
		@OneToOne(fetch=FetchType.LAZY)
		@JoinColumn(name="User_Id",nullable=false,foreignKey=@ForeignKey(name="cart_user_FK"))
		private User user;
	    
	   
		public User getUser() {
			return user;
		}
		public void setUser(User user) {
			this.user = user;
		}
		private String customerName;
	    private String customerAddress;
	    private String customerEmail;
	    private int customerPhone;
	    
	    
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		
		public String getCustomerName() {
			return customerName;
		}
		public void setCustomerName(String customerName) {
			this.customerName = customerName;
		}
		public String getCustomerAddress() {
			return customerAddress;
		}
		public void setCustomerAddress(String customerAddress) {
			this.customerAddress = customerAddress;
		}
		public String getCustomerEmail() {
			return customerEmail;
		}
		public void setCustomerEmail(String customerEmail) {
			this.customerEmail = customerEmail;
		}
		public int getCustomerPhone() {
			return customerPhone;
		}
		public void setCustomerPhone(int customerPhone) {
			this.customerPhone = customerPhone;
		}
	}



