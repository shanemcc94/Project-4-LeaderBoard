import java.util.*;
import javax.swing.*;
import java.text.*;
import java.io.*;
public class project4
{
	public static Scanner globalScanner;
	public static PrintWriter globalPrintWriter;
	public static FileWriter globalFileWriter;
	public static ArrayList <String> fixtureArrayList= new ArrayList<String>();
	public static ArrayList<String> resultsArrayList= new ArrayList<String>();
	public static ArrayList<String> teamsArrayList= new ArrayList<String>();
	public static void main(String[]args)throws IOException
	{
		
	    File Fixtures = new File("PremiershipFixtures.txt");
		File Results = new File("PremiershipResults.txt");
		File Teams = new File("PremiershipTeamsOrPlayers.txt");
		fixtureArrayList = createArrayList(Fixtures);     	 
		resultsArrayList = createArrayList(Results);
		teamsArrayList = createArrayList(Teams);
		globalScanner = new Scanner (System.in);		
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

   }   
   

	
	
	
}
	
