package com.niit.sparescart.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity // directly access from database
@Component  //create the instance of particular class
public class User {
	
               //particular value is int ,long ,number for auto generated
	@Id
	private String id;
	private String name;
	private String password;
	private String mail;
	private String contact;
	private char role;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
	this.mail = mail;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public char getRole() {
		return role;
	}
	public void setRole(char role) {
		this.role = role;
	}

}
