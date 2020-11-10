package com.praktijk3.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;



@Entity
@Table (name = "team")
public class team {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name ="id")
	private int id;
	
	@Column(name = "name")
	private String name ;

	

	public team(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public team() {
		super();
	}

	public team(String name) {
		super();
		this.name = name;
	}

	

	@Override
	public String toString() {
		return "team [id=" + id + ", name=" + name + "]";
	}

	public int getSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	public team getIndex(int i) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
