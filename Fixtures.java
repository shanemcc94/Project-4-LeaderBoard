public class Fixtures
{
	private int fN;
	private int hF;
	private int aF;
 
	Fixtures(int fixtureNumber, int homeFixture, int awayfixture  )
	{
		fN = fixtureNumber;
		hF = homeFixture;
		aF = awayfixture;
	}
	public void setFixtureNumber(int fixtureNumber)
	{ 	
		fN += fixtureNumber;
	}
	public void setHomeFixture(int homeFixture)
	{ 	
		hF += homeFixture;
	}
	public void setawayFixture(int awayFixture)
	{   
		aF += awayFixture;
	}
	public int getFixtureNumber(int fixtureNumber)
	{   
		return fN;
	}
	public int getHomeFixture(int homeFixture)
	{   
		return hF;
	}
	public int getawayFixture(int awayFixture)
	{   
     return aF;
	}
}
