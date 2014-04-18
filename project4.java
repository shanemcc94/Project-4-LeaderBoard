import java.util.*;
import javax.swing.*;
import java.text.*;
import java.io.*;
public class project4
{
        public static Scanner globalScanner;
	public static File globalFile;
 	public static String filename1 = "PremiershipFixtures.txt";
        public static String filename2 = "PremiershipResults.txt";
        public static String filename3 = "PremiershipTeamsOrPlayers.txt";
	public static ArrayList<Fixtures> fixtureArrayList = new ArrayList<Fixtures>() ;
	public static ArrayList<Results>  resultsArrayList =new ArrayList<Results>() ;
	public static ArrayList<Teams>    teamsArrayList = new ArrayList<Teams>() ; 
	public static ArrayList<String> fixtureArrayList= new ArrayList<String>();
	public static ArrayList<String> resultsArrayList= new ArrayList<String>();
	public static ArrayList<String> teamsArrayList= new ArrayList<String>();
	public static void main(String[]args)throws IOException
	{

		fixtureArrayList = createArrayListFixture(globalScanner, globalFile, filename1 );     	 
		resultsArrayList = createArrayListResults(globalScanner, globalFile, filename2 );
		teamsArrayList   = createArrayListTeams(globalScanner, globalFile, filename3 );	
		globalScanner = new Scanner (System.in);
		////////////////////////////// Test For Objects!///////////////////////////////////
		       String tester1="";
		       String tester2="";
		      String tester3="";
		      for (int i=0; i< fixtureArrayList.size() ;i++)
			{
		           tester1 += (fixtureArrayList.get(i)).getFixtureNumber() +"\t"; 
		           tester1 += (fixtureArrayList.get(i)).getHomeFixture() +"\t"; 
		           tester1 += (fixtureArrayList.get(i)).getAwayFixture() + "\n"; 
			}

		     for (int i=0; i< resultsArrayList.size() ; i++)
			 {
		          tester2 += resultsArrayList.get(i).getFixtureNumber() +"\t"; 
		          tester2 += resultsArrayList.get(i).getHomeScore() +"\t"; 
		          tester2 += resultsArrayList.get(i).getAwayScore() +"\n"; 
		        }

		    for (int i=0; i< teamsArrayList.size(); i++)
			 {
		          tester3 += teamsArrayList.get(i).getTeamNumber() + "\t";
		          tester3 += teamsArrayList.get(i).getTeamName() + "\n";
			 }
			    System.out.println("This here should output FixtureList!\n");
			    System.out.println(tester1);
			    System.out.println("This here should output resultsList!\n");
			    System.out.println(tester2);
			    System.out.println("This here should output TeamsList!\n");
			    System.out.println(tester3); 
/////////////////////////////////// End of Test! /////////////////////////////////////////////////////////////////			    
		String userInput ="";
		int userInputChoice;
		while ( userInput !=null && !userInput.equals("4"))
        {
            userInput = displayMenuAndGetInput();
			if (userInput != null)
			{
				userInputChoice = Integer.parseInt(userInput);   
				if (userInputChoice !=4)
				{
					switch (userInputChoice)
					{
						case 1 : viewListOfFixtures();
						break;
						case 2 : viewFutureFixtures();
						break;
						case 3 : displayTable();
						break;
					}
				}
			}

		}			
	}	 


	/*
	public static ArrayList<String> createArrayList(File fileName)throws IOException
	{
		ArrayList<String>tempArray = new ArrayList<String>();
		if(!fileName.exists())
        {
			System.out.println("The file " + fileName + " cannot be found.");       	 
        }
		else
		{
		
			globalScanner = new Scanner (fileName);
			while(globalScanner.hasNext())
			{
				tempArray.add(globalScanner.nextLine());
			}
			globalScanner.close();
			for(int i = 0; i<tempArray.size(); i++)
				System.out.println(tempArray.get(i));
		}
		return tempArray;				
	}
	*/
	public static String displayMenuAndGetInput()
	{

		String pattern = "[1-4]{1}";
		String exitPattern = "[0-1]{1}";
		String errorMessage1  = "Invalid menu Selection.";
			   errorMessage1  += "\n\nValid options are 1 to 3 inclusive.";               
		String userInput = "";
		String continueExit = "";
		String menuDisplay = "1.) View a list of fixtures played to date." +
    		  			     "\n\n2.) View a list of fixtures yet to be played." +
    		  			     "\n\n3.) View league table." +
							 "\n\n4.) Exit the program." ;
		int exitContinueChoice;
		boolean validInput= false;
      
		while ( !validInput )
		{
			System.out.println(menuDisplay);;
			userInput = (globalScanner.nextLine());
			System.out.println("[" + userInput + "]");             
			if ( userInput == null || userInput.matches(pattern))
			{
				validInput=true;
			}
			else 
			{
				System.out.println(errorMessage1 + "Error in user input!\n");
				System.out.println("Press any key to continue.");
				continueExit = (globalScanner.nextLine());
				if (continueExit == null || continueExit.matches(exitPattern))
				{
					exitContinueChoice = Integer.parseInt(continueExit);   
					//if (exitContinueChoice != "")
					//{
					//	validInput=true;						
					//}					
				}			
			}
		}
		return userInput;
   }
   
   public static ArrayList<Fixtures> createArrayListFixture(Scanner globalScanner, File globalFile, String filename1 )throws IOException
    {
     ArrayList<Fixtures> fixtureList = new ArrayList<Fixtures>();
     Fixtures detailsOfFixtures; 
     String lineFromFile;
     int aFixtureNumber, aHomeFixture, aAwayFixture;
     globalFile = new File (filename1);
      if (!globalFile.exists())
     	 JOptionPane.showMessageDialog(null,filename1+" was not found!");
     else
       {
          globalScanner = new Scanner (globalFile);
          while (globalScanner.hasNext())
          {
            lineFromFile = globalScanner.nextLine();
            String [] tempArray = lineFromFile.split(",");
            aFixtureNumber   = Integer.parseInt(tempArray [0]);
            aHomeFixture     = Integer.parseInt(tempArray [1]);
            aAwayFixture     = Integer.parseInt(tempArray [2]);
            detailsOfFixtures = new Fixtures (aFixtureNumber, aHomeFixture, aAwayFixture);
            fixtureList.add(detailsOfFixtures);
          }
          globalScanner.close();
       } 
       return fixtureList; 
	}	    	 
     public static ArrayList<Results> createArrayListResults(Scanner globalScanner, File globalFile, String filename2 )throws IOException
    {
     ArrayList<Results> resultsList = new ArrayList<Results>();
     Results detailsOfResults; 
     String lineFromFile;
     int aFixtureNumber, aHomeScore, aAwayScore;
     int posOfComma;
     globalFile = new File (filename2);
     if (!globalFile.exists())
     	 JOptionPane.showMessageDialog(null,filename2+" was not found!");
     else
     	 {
	          globalScanner = new Scanner (globalFile);
	          while (globalScanner.hasNext())
	          {
	            lineFromFile = globalScanner.nextLine();
	            String [] tempArray = lineFromFile.split(",");
	            aFixtureNumber = Integer.parseInt(tempArray [0]);
	            aHomeScore     = Integer.parseInt(tempArray [1]);
	            aAwayScore     = Integer.parseInt(tempArray [2]);
	            detailsOfResults = new Results (aFixtureNumber, aHomeScore, aAwayScore);
	            resultsList.add(detailsOfResults);
	          }
	          globalScanner.close();  

          }  
          return resultsList;
    }	
    public static ArrayList<Teams> createArrayListTeams( Scanner globalScanner, File globalFile, String filename3 )throws IOException
    {
     ArrayList<Teams> teamsList = new ArrayList<Teams>();
     Teams detailsOfTeams; 
     String aTeamName, lineFromFile;
     int aTeamNumber;
     int posOfComma;
     globalFile = new File (filename3);
     if (!globalFile.exists())
     	 JOptionPane.showMessageDialog(null,filename3 +" was not found!");
     else
       {
          globalScanner = new Scanner (globalFile);
          while (globalScanner.hasNext())
          	  {
                lineFromFile = globalScanner.nextLine();
                posOfComma = lineFromFile.indexOf(",");
                aTeamNumber = Integer.parseInt(lineFromFile.substring(0,posOfComma));
                aTeamName = lineFromFile.substring(posOfComma + 1);
                detailsOfTeams = new Teams (aTeamNumber, aTeamName);
                teamsList.add(detailsOfTeams);
          	  }
          	  globalScanner.close();
       }
       return teamsList;
	   }
   }
   //////////////////////////////////////////  Method View Fixtures  ////////////////////////////////////////////////////////
   public static void viewListOfFixtures()throws IOException
   {

   }
   //////////////////////////////////////////  Method View Future Fixtures  ////////////////////////////////////////////////////////
   public static void viewFutureFixtures()throws IOException
   {

   }
   //////////////////////////////////////////  Method Display Table  ////////////////////////////////////////////////////////
    public static void displayTable()throws IOException
    {
		aLeaderBoard = new ArrayList<LeaderBoard>() ; 								
		for(int i = 0; i<teamsArrayList.size();i++)
		{		   
			LeaderBoard aLeaderBoardEntry = new LeaderBoard(0,0,0,0,0,0,0,0,0,0,0,0,0,0);
			aLeaderBoard.add(aLeaderBoardEntry);
			System.out.println("[" + aLeaderBoardEntry + "");
		}
	
		for(int i = 0; i<resultsArrayList.size();i++)
		{

			Results aResult = resultsArrayList.get(i);
			int aFixtureNumber = aResult.getFixtureNumber();
			int aHomeScore = aResult.getHomeScore();
			int aAwayScore = aResult.getAwayScore();			
			Fixtures aFixture = fixtureArrayList.get(i);						 
			int aHomeTeamNumber = aFixture.getHomeFixture();
			int aAwayTeamNumber = aFixture.getAwayFixture();
			System.out.println(aFixtureNumber + "\t" + aHomeScore + "\t" + aAwayScore  + "\t" + aHomeTeamNumber + "\t" + aAwayTeamNumber);
			if(aHomeScore == aAwayScore)
			{
				recordFixtureResultForHomeTeam(aHomeTeamNumber,0,1,0,aHomeScore,aAwayScore,1);
				recordFixtureResultForAwayTeam(aAwayTeamNumber,0,1,0,aHomeScore,aAwayScore,1);
			}
			
			else if (aHomeScore > aAwayScore)
			{
				recordFixtureResultForHomeTeam(aHomeTeamNumber,1,0,0,aHomeScore,aAwayScore,3);
				recordFixtureResultForAwayTeam(aAwayTeamNumber,0,0,1,aHomeScore,aAwayScore,0);									
			}
			
			
			else
			{
				recordFixtureResultForHomeTeam(aHomeTeamNumber,0,0,1,aHomeScore,aAwayScore,0);
				recordFixtureResultForAwayTeam(aAwayTeamNumber,1,0,0,aHomeScore,aAwayScore,3);											
			}
		}
		//Order LeaderBoardMethod
		//displayLeaderBoard();
			
		
	}
	
	public static void recordFixtureResultForHomeTeam(int aHTeamNumber, int w, int d, int l, int hScore, int aScore, int points)
	{

		LeaderBoard aLeaderBoardEntry = null;
		aLeaderBoardEntry = aLeaderBoard.get(aHTeamNumber-1);
		aLeaderBoardEntry.setTeamNumber(aHTeamNumber-1);
		aLeaderBoardEntry.setGamesPlayed(1);	aLeaderBoardEntry.setHomeWins(w);
		aLeaderBoardEntry.setHomeDraw(d);		aLeaderBoardEntry.setHomeLoss(l);
		aLeaderBoardEntry.setHomeGoalsfor(hScore);
		aLeaderBoardEntry.setHomeGoalsAgainst(aScore);
		aLeaderBoardEntry.setGoalDifference(hScore-aScore);
		aLeaderBoardEntry.setTotalPoints(points);
	
	
	}
		
	public static void recordFixtureResultForAwayTeam(int aATeamNumber, int w, int d, int l, int hScore, int aScore, int points)
	{
		LeaderBoard aLeaderBoardEntry = null;
		aLeaderBoardEntry = aLeaderBoard.get(aATeamNumber-1);
		aLeaderBoardEntry.setTeamNumber(aATeamNumber-1);
		aLeaderBoardEntry.setGamesPlayed(1);	aLeaderBoardEntry.setAwayWins(w);
		aLeaderBoardEntry.setAwayDraws(d);		aLeaderBoardEntry.setAwayLoss(l);
		aLeaderBoardEntry.setAwayGoalsFor(aScore);
		aLeaderBoardEntry.setAwayGoalsAgainst(hScore);
		aLeaderBoardEntry.setGoalDifference(aScore-hScore);
		aLeaderBoardEntry.setTotalPoints(points);		
	}	







}
