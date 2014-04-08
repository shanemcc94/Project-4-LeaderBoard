public class LeaderBoard
{
	private int tN;
    	private int gP;
    	private int hW;
    	private int hD;
    	private int hL;
	private int hGFor;
	private int hGAgainst;
	private int awayW;
	private int awayD;
	private int awayL;
	private int awayGFor;
	private int awayGAgainst;
	private int goalD;
	private int totalP;
    	LeaderBoard(int teamNumber, int gamesPlayed, int homeWins, int homeDraw, int homeLoss, int homeGoalsFor, int homeGoalsAgainst, int awayWins, int awayDraws, int awayLoss, int awayGoalsFor, int awayGoalsAgainst, int goalDifference, int totalPoints )
	{
		tN = teamNumber;
		gP = gamesPlayed;
		hW = homeWins;
		hD = homeDraw;
		hL = homeLoss;
		hGFor = homeGoalsFor;
		hGAgainst = homeGoalsAgainst;
		awayW = awayWins;
		awayD = awayDraws;
		awayL = awayLoss;
		awayGFor = awayGoalsFor;
		awayGAgainst = awayGoalsAgainst;
		goalD = goalDifference;
		totalP = totalPoints;
	}
	public void setTeamNumber(int teamNumber)
	{ 	
		tN += teamNumber;
	}
	public void setGamesPlayed(int gamesPlayed)
	{ 	
  	 	gP += gamesPlayed;
	}
	public void setHomeWins(int homeWins)
	{ 	
  	 	hW += homeWins;
	}
	public void setHomeDraw(int homeDraw)
	{ 
		hD += homeDraw;
	}
	public void setHomeLoss(int homeLoss)
	{ 	
		hL += homeLoss;
	}
	public void setHomeGoalsfor(int homeGoalsFor)
	{ 	
		hGFor += homeGoalsFor;
	}
	public void setHomeGoalsAgainst(int homeGoalsAgainst)
	{ 	
		hGAgainst += homeGoalsAgainst;
	}
	public void setAwayWins(int awayWins)
	{ 	
		awayW += awayWins;
	}
	public void setAwayDraws(int awayDraws)
	{ 	
		awayD += awayDraws;
	}
	public void setAwayLoss(int awayLoss)
	{ 	
		awayL += awayLoss;
	}
	public void setAwayGoalsFor(int awayGoalsFor)
	{ 	
		awayGFor = awayGoalsFor;
	}
	public void setAwayGoalsAgainst(int awayGoalsAgainst)
	{	 	
		awayGAgainst += awayGoalsAgainst;
	}
	public void setGoalDifference(int goalDifference)
	{ 
	goalD += goalDifference;	
	}
	public void setTotalPoints(int totalPoints)
	{ 	
		totalP += totalPoints;
	}
	public int getTeamNumber(int teamNumber)
	{ 	
		return tN;
	}
	public int getGamesPlayed(int gamesPlayed)
	{ 
		return gP;	
	}
	public int getHomeWins(int homeWins)
	{ 
		return hW;	
	}
	public int getHomeDraw(int homeDraw)
	{ 	
  		return hD;
	}
	public int getHomeLoss(int homeLoss)
	{ 	
		return hL;
	}
	public int getHomeGoalsfor(int homeGoalsFor)
	{ 	
		return hGFor;
	}
	public int getHomeGoalsAgainst(int homeGoalsAgainst)
	{ 
		return hGAgainst;
	}
	public int getAwayWins(int awayWins)
	{
		return awayW; 	
	}
	public int getAwayDraws(int awayDraws)
	{ 	
		return awayD;
	}
	public int getAwayLoss(int awayLoss)
	{ 	
		return awayL;
	}
	public int getAwayGoalsFor(int awayGoalsFor)
	{ 
		return awayGFor;	
	}
	public int getAwayGoalsAgainst(int awayGoalsAgainst)
	{ 
		return awayGAgainst;
	}
	public int getGoalDifference(int goalDifference)
	{	 	
		return goalD;
	}
	public int getTotalPoints(int totalPoints)
	{ 	
		return totalP;
	}
}
 
