public class Results
{
	private int fN;
	private int hS;
	private int aS;
	Results(int fixtureNumber, int homeScore, int awayScore )
	{
		fN = fixtureNumber;
		hS = homeScore;
		aS = awayScore;
	}
	public void setFixtureNumber(int fixtureNumber)
	{   
		fN += fixtureNumber;
	}
	public void setHomeFixture(int homeScore)
	{   
		hS += homeScore;
	}
	public void setawayFixture(int awayScore)
	{   
		aS += awayScore;
	}
	public int getFixtureNumber(int fixtureNumber)
	{   
		return fN;
	}
	public int getHomeFixture(int homeScore)
	{   
		return hS;
	}
	public int getawayFixture(int awayScore)
	{   
		return aS;
	}
}
