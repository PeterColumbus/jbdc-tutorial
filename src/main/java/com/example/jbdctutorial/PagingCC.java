package com.example.jbdctutorial;

import java.util.List;

import com.example.jbdctutorial.entity.KartuKredit;

public class PagingCC {
	int current;
	int max_page;
	int max_data;
	List<KartuKredit> cc;
	public PagingCC(int current, int max_page, int max_data, List<KartuKredit> cc) {
		this.current = current;
		this.max_page = max_page;
		this.max_data = max_data;
		this.cc = cc;
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
	public List<KartuKredit> getCC_data() {
		return cc;
	}
	
	
}
