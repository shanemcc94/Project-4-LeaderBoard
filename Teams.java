public class Teams
{
  private int tNumber;
  private String tName;

  Teams(int teamNumber, String teamName )
  { 
     tNumber = teamNumber;
     tName = teamName;
  }
   public int getTeamNumber()
  {   
     return tNumber;
  }
  public String getTeamName()
  {   
    return tName;
  }
}
