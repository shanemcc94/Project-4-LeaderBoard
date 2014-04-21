import java.util.*;
import javax.swing.*;
import java.text.*;
import java.io.*;
public class project4Group8
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
	{ 
	//call to createArrayListFixture Method
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
          while(globalScanner.hasNext())
          {
           tempArray.add(globalScanner.nextLine());
          }
          globalScanner.close();

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
		int homeScore = 0;
		int awayScore = 0;
        String teamName1="";
        String  teamName2="";
        //-- String to hold empty spaces!
        String emptySpaces;
        int tempInt =0;
		result += "\t\t\t\tFIXTURES PLAYED\n";
	    result += "FIXTURE No. \tHOME TEAM \t\t\tRESULT\t\tAWAY TEAM\n";
        for (int i = 0; i < resultsArrayList.size(); i++)
            {
              //---Assures string is empty and holds nothing before each iteration!
              emptySpaces ="";
              f1 = fixtureArrayList.get(i).getFixtureNumber();//--method call to Fixture class
              f2 = fixtureArrayList.get(i).getHomeFixture();//---method call to Fixture class
              f3 = fixtureArrayList.get(i).getAwayFixture();//---method call to Fixture class
			  homeScore = resultsArrayList.get(i).getHomeScore();
			  awayScore = resultsArrayList.get(i).getAwayScore();
              teamName1=teamsArrayList.get(f2 - 1).getTeamName();//---method call to Teams class
              teamName2=  teamsArrayList.get(f3 - 1).getTeamName();//---method call to Teams class
              tempInt = longestWord - teamName1.length();
              for (int x = 0; x < tempInt; x++)
                  {
                    emptySpaces += " ";
                  }

              result += f1 + "\t\t" + teamName1  + emptySpaces +"\t\t(" + homeScore + "" + "-" + awayScore+")\t\t" + teamName2 + "\n";
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
	     result += "\t\t\tFUTURE FIXTURES\n";
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
	     System.out.print(result +"\n");
     	}
	 } 
	public static void displayTable()
    {
    	String TeamInfo [][] = new String [20][15];
    	System.out.println("*****************************************************************************************************************************************");   	
    	System.out.println("POS.\t" + "TEAM\t\t" + "\tP\t" + "HW\t" + "HD\t" + "HL\t"  + "HGF\t" + "HGA\t" +  "AW\t" + "AD\t" + "AL\t" + "\tAGF\t" + "AGA\t"+  "GD\t" + "POINTS\t" + "\n");
    	
    	for(int t = 0; t < 20; t++)
    	{
    		int played = 0;
    		int homeWin = 0;  int awayWin = 0;
    		int homeDraw = 0; int awayDraw = 0;
    		int homeLoss = 0; int awayLoss = 0;
			int gF = 0; int aGF = 0;
			int gA = 0; int aGA = 0;
			int gD = 0; int totalPoints = 0;
    		    	    		
    		//Fixtures aFixture = fixtureArrayList.get(t);
    		TeamInfo[t][0] = "" + (t + 1);
			String filledName = lengthenedString(teamsArrayList.get(t).getTeamName());
			
			
    		TeamInfo[t][1] = filledName;
    		
    	   		
    	   	for(int i = 0; i < resultsArrayList.size();i++)
    	   	{
    	   		if((t + 1) == fixtureArrayList.get(i).getHomeFixture()  )
				{
					played++;
					if(resultsArrayList.get(i).getHomeScore() > resultsArrayList.get(i).getAwayScore())
						homeWin++;  
					if(resultsArrayList.get(i).getHomeScore() == resultsArrayList.get(i).getAwayScore())
    	   				homeDraw++; 
					if(resultsArrayList.get(i).getHomeScore() < resultsArrayList.get(i).getAwayScore())
    	   				homeLoss++;  
					gF+=(resultsArrayList.get(i).getHomeScore()); 
					gA +=(resultsArrayList.get(i).getAwayScore());
    	   		}
    	   		if((t + 1) == fixtureArrayList.get(i).getAwayFixture()  )
				{
    				played++;					
					if(resultsArrayList.get(i).getAwayScore() > resultsArrayList.get(i).getHomeScore())
						awayWin++; 
    	   			if(resultsArrayList.get(i).getAwayScore() == resultsArrayList.get(i).getHomeScore())
    	   				awayDraw++;  
    	   			if(resultsArrayList.get(i).getAwayScore() < resultsArrayList.get(i).getHomeScore())
    	   				awayLoss++; 
					aGA+=(resultsArrayList.get(i).getHomeScore());   
					aGF+=(resultsArrayList.get(i).getAwayScore())  ;  					
        	   	}	
				gD = ((gF+aGF) - (gA+aGA));
				totalPoints =(((homeWin+awayWin)*3) + (homeDraw+awayDraw));
		
    		}
    	   	TeamInfo[t][2] = "" + played;  //  Third column done(P)
			TeamInfo[t][3] = "" + homeWin;  // Fourth column done(W)
			TeamInfo[t][4] = "" + homeDraw; //Fifth column done(D)  
			TeamInfo[t][5] = "" + homeLoss; //Sixth column done(L)
			TeamInfo[t][6] = "" + gF; //Seventh column done(F)
			TeamInfo[t][7] = "" + gA; //Eight column done(GA)			
			TeamInfo[t][8] = "" + awayWin;  // Ninth column done(W)	
			TeamInfo[t][9] = "" + awayDraw;  // Tenth column done(D)
			TeamInfo[t][10] = "" + awayLoss;  // Eleventh column done(L)	   
			TeamInfo[t][11] = "" + aGF; //Twelfth  column done(GF)
			TeamInfo[t][12] = "" + aGA; //Thirteenth column done(GA)
			TeamInfo[t][13] = "" + gD; //Fourteenth column done(GD)
			TeamInfo[t][14] = "" + totalPoints; //Fifteenth column done(P)			
    	   	//System.out.println(TeamInfo[t][0] + "\t\t" + TeamInfo[t][1] + "\t\t" + TeamInfo[t][2] + "\t\t" + TeamInfo[t][3] + "\t" + TeamInfo[t][4] + "\t" + TeamInfo[t][5]+   "\t" + TeamInfo[t][6] +"\t" +  TeamInfo[t][7]  +"\t\t\t" + TeamInfo[t][8] + "\t" + TeamInfo[t][9] +"\t" + TeamInfo[t][10]+ "\t" + TeamInfo[t][11] +"\t" + TeamInfo[t][12]+ "\t" + TeamInfo[t][13]+ "\t" + TeamInfo[t][14]);

    	}
		
		
	
		
		
		for(int i = 0;i<20;i++)
		{
			for (int j = 0;j<15;j++)
			{
				System.out.print(TeamInfo[i][j] + "\t");				
			}
			System.out.print("\n");
			
		}
		//Sort here
		

		System.out.println("*****************************************************************************************************************************************");   	
    	System.out.println("\n");
		
    }   
	public static String lengthenedString(String teamName)
	{
	  int fixedLength = 20;
	  return String.format("%-"+fixedLength+ "s", teamName);				
	}

}
