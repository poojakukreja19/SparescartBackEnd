package com.niit.sparescart.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Mycart implements Serializable {
	
	private static final long SerialVersionUID = 1L;
	
	public static long getSerialversionuid() {
		return SerialVersionUID;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id", insertable = false, updatable = true)
	private long id;
	private String price;
	private char status;
	private int quantity;	
	private Date added_date;
	//private Set<User> user;
    //private Set<Product> product;
	
    @Temporal(TemporalType.DATE)
    @Column(name = "added_date")
	public Date getAdded_date() {
		return added_date;
	}
	public void setAdded_date(Date added_date) {
		this.added_date = added_date;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public char getStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status = status;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
//	@OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "user_id")
//	public Set<User> getUser() {
//		return user;
//	}
//	public void setUser(Set<User> user) {
//		this.user = user;
//	}
//	@OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "product_id")
//	public Set<Product> getProduct() {
//		return product;
//	}
//	public void setProduct(Set<Product> product) {
//		this.product = product;
//	}
//	
	
	

	
	
	
	

}
