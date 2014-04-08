public class Teams
{
	private String tName;
	private int tNumber;
 
	Teams(String teamName, int teamNumber)
	{
		tName = teamName;
		tNumber = teamNumber;
	}
	public String getTeamName(String teamName)
	{	   
		return tName;
	}
	public int getTeamNumber(int teamNumber)
	{   
		return tNumber;
	}
}
