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
	public static void main(String[]args)throws IOException
	{
	    File Fixtures = new File("PremiershipFixtures.txt");
		File Results = new File("PremiershipResults.txt");
		fixtureArrayList = createArrayList(Fixtures);     	 
		resultsArrayList = createArrayList(Results);						
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
}
