package com.praktijk3.payload;

import javax.persistence.Column;
import javax.persistence.Lob;
import javax.validation.constraints.NotBlank;

public class spelerResponse  {
    
	private int id;
    
	private String name ;
    
	private String achternaam ;
    
	private String positie;
    
	private int nummer;
	
	

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


	public String getAchternaam() {
		return achternaam;
	}


	public void setAchternaam(String achternaam) {
		this.achternaam = achternaam;
	}


	public String getPositie() {
		return positie;
	}


	public void setPositie(String positie) {
		this.positie = positie;
	}


	public int getNummer() {
		return nummer;
	}


	public void setNummer(int nummer) {
		this.nummer = nummer;
	}

	

}
