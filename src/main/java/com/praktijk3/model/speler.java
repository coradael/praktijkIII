package com.praktijk3.model;


import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;


@Entity
@Table (name = "speler")
public class speler {

		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name ="id")
		private int id;
	    
	    @Size(max = 40)
		private String name ;
	    
		private String achternaam ;
	    
		private String positie;
	    
		private int nummer;
		


	    public speler() {
			super();
		}

		public speler(int id, @Size(min = 2, max = 10) @Size(max = 40) String name, String achternaam, String positie,
				int nummer) {
			super();
			this.id = id;
			this.name = name;
			this.achternaam = achternaam;
			this.positie = positie;
			this.nummer = nummer;
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
		
		
		@Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;
	        speler speler = (speler) o;
	        return Objects.equals(id, speler.id);
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(id);
	    }

		@Override
		public String toString() {
			return "speler [id=" + id + ", name=" + name + ", achternaam=" + achternaam + ", positie=" + positie
					+ ", nummer=" + nummer +  "]";
		}

	    
	}