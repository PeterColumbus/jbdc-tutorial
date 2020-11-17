package com.example.jbdctutorial.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Customer {
	private long id;
	private String name;
	private String gender;
	private String address;
	private String email;
	private String phone;
	private boolean priority;
	
	public Customer(
			@JsonProperty("id") long id, 
			@JsonProperty("name") String name, 
			@JsonProperty("gender") String gender, 
			@JsonProperty("address") String address, 
			@JsonProperty("email") String email, 
			@JsonProperty("phone") String phone, 
			@JsonProperty("priority") boolean priority) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.address = address;
		this.email = email;
		this.phone = phone;
		this.priority = priority;
	}
	
	public long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getGender() {
		return gender;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public boolean getPriority() {
		return priority;
	}
	
	@Override
	public String toString() {
		return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", priority=" + priority +
                '}';
	}
	
	
	
}
