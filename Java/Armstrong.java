/*
ZIYAAD LAKAY

*/

import java.util.Scanner; //importing scanner 

public class Armstrong 
{	
	
	//main method
	public static void main(String[] args)
	{
		int i = 0;
		int digit = 0;
		
		while(i != 20)
		{	
			digit += 1;	
			if(isArmstrong(digit) == true){
				System.out.println(digit+ " is an Armstrong number");
				i += 1;
			}		
		}//end of while loop
	
	}//end of main method

	

	//check armstrong number
	public static boolean isArmstrong(int no)
	{
			double total = 0;
			String strNum = no + "";
			for(int i=0; i < strNum.length(); i++)
				total = total + java.lang.Math.pow(Double.parseDouble(strNum.charAt(i)+""),strNum.length());
			
			if(total == no)
				return true;
			else
				return false;			

	}//end of isArmstrong
	
	

}
