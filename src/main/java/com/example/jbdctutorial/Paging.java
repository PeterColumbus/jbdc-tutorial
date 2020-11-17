package com.example.jbdctutorial;

import java.util.List;

import com.example.jbdctutorial.entity.Customer;

public class Paging {
	int current;
	int max_page;
	int max_data;
	List<Customer> customer;
	
	public Paging(int current, int max_page, int max_data, List<Customer> datas1) {
		this.current = current;
		this.max_page = max_page;
		this.max_data = max_data;
		this.customer = datas1;
	}
	
	public int getCurrent_page() {
		return current;
	}

	public int getMax_page() {
		return max_page;
	}

	public int getMax_data() {
		return max_data;
	}

	public List<Customer> getCustomer_data() {
		return customer;
	}
	 
	
}
