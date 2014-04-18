import java.util.*;
import javax.swing.*;
import java.text.*;
import java.io.*;
public class project4
{
  /*Global VAriable declarations*/
	public static Scanner globalScanner;
	public static File globalFile;
	public static String filename1 = "PremiershipFixtures.txt";
  	public static String filename2 = "PremiershipResults.txt";
  	public static String filename3 = "PremiershipTeamsOrPlayers.txt";
	public static ArrayList<Fixtures> fixtureArrayList = new ArrayList<Fixtures>() ;
	public static ArrayList<Results>  resultsArrayList =new ArrayList<Results>() ;
	public static ArrayList<Teams>    teamsArrayList = new ArrayList<Teams>() ; 
	public static ArrayList<LeaderBoard>    aLeaderBoard = new ArrayList<LeaderBoard>() ;
    public static ArrayList<LeaderBoard>    aLeaderBoardEntry = new ArrayList<LeaderBoard>() ;	
		
	
	

	public static void main(String[]args)throws IOException
	{ //call to createArrayListFixture Method
		fixtureArrayList = createArrayListFixture();
    //call to createArrayListResults Method     	 
		resultsArrayList = createArrayListResults();
    //call to createArrayListTeams  Method
		teamsArrayList   = createArrayListTeams();	
    		ArrayList<Integer> fixtureArrayListInteger  = new ArrayList<Integer>();
    		ArrayList<Integer> resultsArrayListInteger= new ArrayList<Integer>();
    		ArrayList<String> teamsArrayListSpring  = new ArrayList<String>();
    /* Left these commented because the methods do not exist yet!*/
    //-------------------------------------------------------------//
    //fixtureArrayListInteger = createArrayListInteger(filename1);
    //resultsArrayListInteger = createArrayListInteger(filename2);
    //------------------------------------------------------------//
    teamsArrayListSpring  = createArrayListString();
    ///////////////////////  can be deleted later Its ju8st a test!////////////////
    //----------------------------------------------------------------------------//
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
      ///////////////////End of test////////End of test////////////////////////////////
       //----------------------------------------------------------------------------//
      //---------------------Start of evaluation of userChoice!----------------------//
		  String userInput ="";
      int userInputChoice;
      while (userInput !=null && !userInput.equals("4"))
          {
          //--------------Call to displayMenuAndGetInput Method ---------------------//
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
    public static String displayMenuAndGetInput()
    {

    globalScanner =new Scanner (System.in);
    String pattern = "[1-4]{1}";
    String exitPattern = "[0-1]{1}";
    String errorMessage1 = "Invalid menu Selection.";
    errorMessage1 += "\n\nValid options are 1 to 3 inclusive.";
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
        System.out.println(menuDisplay);
        userInput = globalScanner.nextLine();
        System.out.println("[" + userInput + "]");
        if( userInput == null || userInput.matches(pattern))
          {
           validInput=true;
          }
        else
          {
            System.out.println(errorMessage1 + "Error in user input!\n");
            System.out.println("Press any key followed by return to continue.");
            continueExit = (globalScanner.nextLine());
            if(continueExit == null || continueExit.matches(exitPattern))
              {
              exitContinueChoice = Integer.parseInt(continueExit);
              //if (exitContinueChoice != "")
              //{
              // validInput=true;
              //}
              } 
          }
       }
     return userInput;
    }
	  public static ArrayList<Fixtures> createArrayListFixture( )throws IOException
    {
     /*-----------createArrayListFixture Method----------------------/
        This method creates an ArrayList with Objects of 
        Fixture Type. It uses Constructor methods and/or
        other userdefined methods to assign data from a file to
        an object of Fixture Type!
     */
         //Declare a temp Array of Results type that can be returend!
     ArrayList<Fixtures> fixtureList = new ArrayList<Fixtures>();
        //Declare a Object of Results Type!
     Fixtures detailsOfFixtures; 
       //String declaration to hold data from a line in the file 
     String lineFromFile;
       //Integer declaration  see String declaration above!
     int aFixtureNumber, aHomeFixture, aAwayFixture;
       // Assign required File Name to Global Scanner
     globalFile = new File (filename1);
     //Check if that file exist!
      if (!globalFile.exists())
        //if no show errorMesssage
     	 JOptionPane.showMessageDialog(null,filename1+" was not found!");
     else
       {
          //other wise:
          //---Assign globalFile for Global Scanner
          globalScanner = new Scanner (globalFile);
          //---As long the file contains data
          while (globalScanner.hasNext())
          {
            //Do:
            //---read first line from file into String!
            lineFromFile = globalScanner.nextLine();
            //---split linefromfile where it sees a cooma into String Array!
            String [] tempArray = lineFromFile.split(",");
            //---convert data in string Array and Assign to integers!
            aFixtureNumber   = Integer.parseInt(tempArray [0]);
            aHomeFixture     = Integer.parseInt(tempArray [1]);
            aAwayFixture     = Integer.parseInt(tempArray [2]);
            //---Assign Integer Values to the Results Object!
            detailsOfFixtures = new Fixtures (aFixtureNumber, aHomeFixture, aAwayFixture);
            //---Add the Object to the Arrylist of Object type Fixtures!
            fixtureList.add(detailsOfFixtures);
          }
          //---close Scanner!
          globalScanner.close();
       } 
       //---Return the ArrayList of Fixture type
       return fixtureList; 
	  }	    	 
	  public static ArrayList<Results> createArrayListResults( )throws IOException
    {
      /*-----------createArrayListFixture Method----------------------/
        This method creates an ArrayList with Objects of 
        Results Type. It uses Constructor methods and/or
        other userdefined methods to assign data from a file to
        an object of Result Type!
     */
        //Declare a temp Array of Results type that can be returend!
     ArrayList<Results> resultsList = new ArrayList<Results>();
        //Declare a Object of Results Type!
     Results detailsOfResults; 
        //String declaration to hold data from a line in the file
     String lineFromFile;
        //Integer declaration  see String declaration above!
     int aFixtureNumber, aHomeScore, aAwayScore;
        // Assign required File Name to Global Scanner
     globalFile = new File (filename2);
        //Check if that file exist!
     if (!globalFile.exists())
        //if no show errorMesssage
     	 JOptionPane.showMessageDialog(null,filename2+" was not found!");
     else
     	 {    //other wise:
            //---Assign globalFile for Global Scanner
	          globalScanner = new Scanner (globalFile);
            //---As long the file contains data
	          while (globalScanner.hasNext())
	          {
              //Do:
              //---read first line from file into String!
	            lineFromFile = globalScanner.nextLine();
              //---split linefromfile where it sees a cooma into String Array!
	            String [] tempArray = lineFromFile.split(",");
              //---convert data in string Array and Assign to integers!
	            aFixtureNumber = Integer.parseInt(tempArray [0]);
	            aHomeScore     = Integer.parseInt(tempArray [1]);
	            aAwayScore     = Integer.parseInt(tempArray [2]);
              //---Assign Integer Values to the Results Object!
	            detailsOfResults = new Results (aFixtureNumber, aHomeScore, aAwayScore);
              //---Add the Object to the Arrylist of Object type Results!
 	            resultsList.add(detailsOfResults);
	          }
              //---close Scanner!
	          globalScanner.close();  
	          
          }  
          //---Return the ArrayList of Fixture type
          return resultsList;
    }	
    public static ArrayList<Teams> createArrayListTeams(  )throws IOException
    {
    /*-----------createArrayListFixture Method----------------------/
        This method creates an ArrayList with Objects of 
        Teams Type. It uses Constructor methods and/or
        other userdefined methods to assign data from a file to
        an object of Teams Type!
     */
        //Declare a temp Array of Teams type that can be returend!
     ArrayList<Teams> teamsList = new ArrayList<Teams>();
        //Declare a Object of Teams Type!
     Teams detailsOfTeams; 
        //String declaration to hold data from a line in the file
     String aTeamName, lineFromFile;
        //Integer declaration,  see String declaration above!
     int aTeamNumber;
       //use pos of comma access data at required index!
     int posOfComma;
       // Assign required File Name to Global Scanner
     globalFile = new File (filename3);
       //Check if that file exist!
     if (!globalFile.exists())
       //if no show errorMesssage
     	 JOptionPane.showMessageDialog(null,filename3 +" was not found!");
     else
       {
          //other wise:
          //---Assign globalFile for Global Scanner
          globalScanner = new Scanner (globalFile);
          //---As long the file contains data
          while (globalScanner.hasNext())
          	  {
                //Do:
                //---read first line from file into String!
                lineFromFile = globalScanner.nextLine();
                //---split linefromfile where it sees a cooma into String Array!
                posOfComma = lineFromFile.indexOf(",");
                //---convert data in string Array and Assign to integers!
                aTeamNumber = Integer.parseInt(lineFromFile.substring(0,posOfComma));
                aTeamName = lineFromFile.substring(posOfComma + 1);
                //---Assign Integer Values to the Results Object!
                detailsOfTeams = new Teams (aTeamNumber, aTeamName);
                //---Add the Object to the Arrylist of Object type Teams!
                teamsList.add(detailsOfTeams);
          	  }
              //---close Scanner!
          	  globalScanner.close();
       }
       //---Return the ArrayList of Fixture type
       return teamsList;
	   }
     public static ArrayList<String> createArrayListString()throws IOException
     {

      ArrayList<String>tempArray = new ArrayList<String>();
      globalFile = new File (filename3);
      if(!globalFile.exists())
        {
         System.out.println("The file " + filename3 + " cannot be found.");
        }
      else
        {
          globalScanner = new Scanner (globalFile );
          System.out.println("Another test for teams!");
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
      ////////////////////////////////////////// Method View Fixtures ////////////////////////////////////////////////////////
     public static void viewListOfFixtures()throws IOException
     {
        /*This Methods displayes to date played fixtures!*/
        //----Object Assignments
        Teams teamsDisplay;
        Fixtures fixtureDisplay;
        //---Integer value for the longest word e.g Teamname
        int longestWord =0;  
        //-- loop to assign Integer value for the longest Teamname!  
        for (int index = 0; index < teamsArrayList.size(); index ++)
            {
               String tempword = teamsArrayList.get(index).getTeamName();
               if (tempword.length() > longestWord)
                   longestWord = tempword.length();
            }
        //---Integers for the Fixture Info    
        int f1 =0;
        int f2 =0;
        int f3 =0; 
        String result ="";
        String teamName1="";
        String  teamName2="";
        //-- String to hold empty spaces!
        String emptySpaces;
        int tempInt =0;
        for (int i = 0; i < resultsArrayList.size(); i++)
            {
              //---Assures string is empty and holds nothing before each iteration!
              emptySpaces ="";
              f1 = fixtureArrayList.get(i).getFixtureNumber();//--method call to Fixture class
              f2 = fixtureArrayList.get(i).getHomeFixture();//---method call to Fixture class
              f3 = fixtureArrayList.get(i).getAwayFixture();//---method call to Fixture class
              teamName1=teamsArrayList.get(f2 - 1).getTeamName();//---method call to Teams class
              teamName2=  teamsArrayList.get(f3 - 1).getTeamName();//---method call to Teams class
              tempInt = longestWord - teamName1.length();
              for (int x = 0; x < tempInt; x++)
                  {
                    emptySpaces += " ";
                  }
              result += f1 + "\t" + teamName1 + emptySpaces + "\tVS\t" + teamName2 + "\n";
            }
            System.out.println(result);

     }
     ////////////////////////////////////////// Method View Future Fixtures ////////////////////////////////////////////////////////
    public static void viewFutureFixtures()throws IOException
     {
	     /* This method compares the length of the results array and the length of the fixtures array.
	     	if the results array is shorter than the fixtures, the remaining details of the fixtures array are 
	     	displayed to the user as fixtures yet to be played.*/
	     String team1 = "", team2 = "", result = "", tempWord, tempWord1 = "";
	     tempWord = teamsArrayList.get(0).getTeamName();//assigns first team in teamsArrayList to temp word.
	     
	     //loop to assign the longest team name to tempWord	
	     for(int x = 0; x < teamsArrayList.size(); x++)
	     {
	     tempWord1 = teamsArrayList.get(x).getTeamName();
	     
	     if(tempWord1.length() > tempWord.length())
	     {
		     tempWord = tempWord1;
	     }
     	 }
     	      
	     int t0 ,t1, t2, x, lw;
	     lw = tempWord.length();
			
	     x = fixtureArrayList.size();
	     
         if(fixtureArrayList.size() > resultsArrayList.size())
         {
	     result += "\t\tFixtures yet to be played\n";
	     result += "FIXTURE No. \tHOME TEAM \t\t\t AWAY TEAM\n";
	     for(int i = i = resultsArrayList.size();  i < x ; i++)
	     {
		     t0 = fixtureArrayList.get(i).getFixtureNumber();//--method call to Fixture class
		     t1 = fixtureArrayList.get(i).getHomeFixture();//--method call to Fixture class
		     t2 = fixtureArrayList.get(i).getAwayFixture();//--method call to Fixture class
		     	for(int j = 0; j < teamsArrayList.size(); j++)
		     	{
			     	//A number of calls to Teams class to get team names and assign them to a local string
			     	if(t1 == teamsArrayList.get(j).getTeamNumber())
			     	{
				     	team1 = teamsArrayList.get(j).getTeamName();
			     	}
			     	if(t2 == teamsArrayList.get(j).getTeamNumber())
			     	{
				     	team2 = teamsArrayList.get(j).getTeamName();
			     	}
			     	
	     		}
	     		//this if statement assigns all teams to the same length for output purposes
	     				if(team1.length() < lw)
				     	{
					     	for(int k = team1.length(); k < lw; k++)
					     	{
						     	team1 += " ";
					     	}
				     	}
	     		
	     		result += (t0 + "\t\t" + team1 + "\tVs\t " + team2 + "\n");
	     }
	     System.out.print(result);
     	}
	 }
     ////////////////////////////////////////// Method Display Table ////////////////////////////////////////////////////////
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
