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
  public int getFixtureNumber()
  {   
    return fN;
  }
   public int getHomeScore()
  {   
     return hS;
  }
  public int getAwayScore()
  {   
     return aS;
  }
}
