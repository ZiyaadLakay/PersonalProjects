/*
ZIYAAD LAKAY

*/
import java.util.*;
import java.io.*;

public class WordSearch
{	
	String[] hashTbl = new String[100];
	
	public static void main(String args[])
	{
		WordSearch obj1 = new WordSearch();
		obj1.run();
	}//end of main method
	
	public void run()
	{
		populateTable("Randonwords1"); //populating hash table
		compare("Randonwords2");//compares the second text file
		System.out.println();
		userInput();//lets user search for a word
		printTable();//prints the table
		
	}//end of run method
	
	public void printTable()
	{
		for(int i = 0; i < hashTbl.length ; i++)
			System.out.println(i+" : "+hashTbl[i]);
	}//end of print table
	
	public void userInput()
	{
		String word = "";
		Scanner sc = new Scanner(System.in); //to get input from the user
		
		while(true) //loops until user quits
		{	
			System.out.println("Enter word (or type quit to exit): ");
			word = sc.next();//next String value
			
			if(word.equalsIgnoreCase("quit")) //exits loop if user types quit
				break;
			if(searchWord(word)) //search for word in hash table
				System.out.println("Found word : "+word);
			else 
				System.out.println("Word not Found : "+word);
				
			System.out.println();
		}
		sc.close();//close file
		System.out.println();
	}//end of user inout method
	
	public void compare(String fileName)
	{
		try
		{
		Scanner sc = new Scanner(new File(fileName)); //opens file to compare
		
		int count = 0; String word = ""; int total = 0;
		
		while(sc.hasNext()) //loops through whole text file
		{
			word = sc.next();//next string
			
			if(searchWord(word)) //searches the word in hash table
				count++; //keeps count of words
				
			total++;//keeps count of iterations
		}
		
		sc.close();
		
		System.out.println("Checking Hash Table for Randonwords2");
		System.out.println("Number of searches conducted : "+total);
		System.out.println("Number of Successful searches Achieved : "+count);
		
		}catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		
	}//em=nd of compare method
	
	public boolean searchWord(String word)
	{
		String w = word;
		long hashC = 0; int index = 0;int count = 0;boolean flag = false;
		
		hashC = hashCode(w);//the hash code
		long in = hashC % hashTbl.length; //using hashing formula
		index = (int) in; //converting long to int
		
		while(count != 100 && flag == false) //loops until word is found or loops through whole array
		{	
			if(hashTbl[index].equals(w)) //if word in hash table equals word entered
				flag = true;
			index ++;
			count++; //keep count if you loop through whole array
			if(index == 99) //wrap around
				index = 0;
		}
		
		return flag;
	}//end of search word 
	
	public long hashCode(String s)
	{
		long g = 7; //constant
		long hash = 0; //to hold hash key
		
		for(int i = 0; i < s.length() ; i++) //loops through string
		{
			hash = (g * hash) + s.charAt(i);//gets the ASCII unicode and adds it to hash key
			//System.out.println(hash);
		}
			
		return hash;
	}//end of hash code
	
	public void populateTable(String FileName)
	{
		try
		{
			long hashC =0; int index = 0; String word = "";
			
			Scanner sc = new Scanner(new File(FileName)); //opening file
			
			while(sc.hasNext())// looping through whole file
			{
				word = sc.next(); //storing string item 
				hashC = hashCode(word); //finding the hash code
				long in = hashC % hashTbl.length; //using hashing formula
				index = (int) in; //converting long to int
				
				if(hashTbl[index] == null) //if empty
					hashTbl[index] = word;
				else
				{
					while(hashTbl[index] != null)
					{	index ++;//move down table till empty space
						if(index == 100) // go back to top
							index = 0;
					}
					
					//System.out.println("Break");
					hashTbl[index] = word;
				}
			}
			
			sc.close();
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}//end of populate
	
	
	
}//end of main class
