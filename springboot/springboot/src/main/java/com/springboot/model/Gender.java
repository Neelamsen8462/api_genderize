package com.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "gender")
public class Gender {
	

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
	@Column(name="count")
	private long count;
	
	
	@Column(name="gender")
	private String gender;
	

	@Column(name="name")
	private String name;
	

	@Column(name="probability")
	private double probability;


	public Gender() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Gender(long count, String gender, String name, double probability) {
		super();
		this.count = count;
		this.gender = gender;
		this.name = name;
		this.probability = probability;
	}


	


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public long getCount() {
		return count;
	}


	public void setCount(long count) {
		this.count = count;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getProbability() {
		return probability;
	}


	public void setProbability(double probability) {
		this.probability = probability;
	}
	
	
	
}
