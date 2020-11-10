package com.praktijk3.model;

import java.util.Random;

public class resultaat {
//	
//	schema resultaatClub1;
//	schema resultaatClub2;
//	
//	Random random = new Random();
//
//    //Generate numbers between 0 and 100
//    int firstRandomValue = random.nextInt(5);
//    int secondRandomValue = random.nextInt(5);
//	
//    @Override
//	public String toString() {
//		return "resultaat [resultaatClub1=" + firstRandomValue + ", resultaatClub2=" + secondRandomValue + "]";
//	}
//	
//   
//    //Print the generated random values
//	
//    
    
	  private team team ;
	  private int goals;
	  private String status;
	  
	  
	public resultaat(team team, int goals, String status) {
		super();
		this.team = team;
		this.goals = goals;
		this.status = status;
	}


	public resultaat() {
		super();
	}


	public team getTeam() {
		return team;
	}


	public void setTeam(team team) {
		this.team = team;
	}


	public int getGoals() {
		return goals;
	}


	public void setGoals(int goals) {
		this.goals = goals;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
	  

	public void randomGoals() {
	    double randomDouble = Math.random();
	    randomDouble = randomDouble * 1 + 1;
	    int randomInt = (int) randomDouble;
	    System.out.println(randomInt);
	 }
	  
    
}

