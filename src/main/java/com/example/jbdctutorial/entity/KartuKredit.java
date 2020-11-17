package com.example.jbdctutorial.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class KartuKredit {
	private int idkartu;
	private String name;
	private String jenis;
	private String date;
	private int limitt;
	private int idowner;
	
	public KartuKredit(
			@JsonProperty("idkartu") int idkartu, 
			@JsonProperty("name") String name, 
			@JsonProperty("jenis") String jenis, 
			@JsonProperty("date") String date, 
			@JsonProperty("limit") int limitt, 
			@JsonProperty("idowner") int idowner) {
		this.idkartu = idkartu;
		this.name = name;
		this.jenis = jenis;
		this.date = date;
		this.limitt = limitt;
		this.idowner = idowner;
	}

	public int getIdkartu() {
		return idkartu;
	}

	public String getName() {
		return name;
	}

	public String getJenis() {
		return jenis;
	}

	public String getDate() {
		return date;
	}

	public int getLimit() {
		return limitt;
	}

	public int getIdowner() {
		return idowner;
	}

	@Override
	public String toString() {
		return "KartuKredit{" +
                "idkartu=" + idkartu +
                ", name='" + name + '\'' +
                ", jenis='" + jenis + '\'' +
                ", date='" + date + '\'' +
                ", limitt=" + limitt +
                ", idowner=" + idowner +
                '}';
	}
	
	
	
}
