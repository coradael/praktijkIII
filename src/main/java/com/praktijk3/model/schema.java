package com.praktijk3.model;

public class schema {
	
	    public team teamHome;
	    public team teamAway;
	    public int teamHomeGoals;
	    public int teamAwayGoals;
	    public String matchDay;
	    public int noOfTeams;
	    public String[][] rounds;
	    public String[][] round;

	    team teamList = new team();

	    //no-arg constructor
	    schema(){   
	    }

	    schema(String matchDay, team teamHome, team teamAway, int teamHomeGoals, int teamAwayGoals){
	        this.matchDay = matchDay;
	        this.teamHome = teamHome;
	        this.teamAway = teamAway;
	        this.teamHomeGoals = teamHomeGoals;
	        this.teamAwayGoals = teamAwayGoals;
	    }

	    //  round robin schedule method
	            public String[][] schedule(){

	            this.rounds = new String[(teamList.getSize()-1)*2][(teamList.getSize() / 2)];
	            for (int round = 0; round < (teamList.getSize()-1)*2; round++) {
	                for (int match = 0; match < (teamList.getSize() / 2); match++) {

	                    this.teamHome = teamList.getIndex((round + match) % (teamList.getSize() - 1)); 
	                    this.teamAway = teamList.getIndex((teamList.getSize() - 1 - match + round) % (teamList.getSize() - 1)); 

	                    // Last team stays in the same place while the others rotate around it.
	                    if (match == 0) {
	                        teamAway = teamList.getIndex(teamList.getSize() - 1);
	                    }

	                    // from rounds half interchange the position of teams in rounds, to get both home and away matches     
	                    String mixedRounds;
	                    if (round < (teamList.getSize() - 1)) {
	                        mixedRounds = ( teamHome + " vs " + teamAway + "  " + teamHome.getGoal()+ " - " + teamAway.getGoal());
	                    } else {
	                        mixedRounds = (teamAway + " vs " + teamHome + "  " + teamAway.getGoal()+ " - " + teamHome.getGoal());
	                    }

	                    rounds[round][match] = mixedRounds;
	                }
	            }
	            return rounds;
	        }


	}



