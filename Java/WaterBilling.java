/*
Ziyaad Lakay
 WATER BILLING
*/

import java.util.Scanner;

public class WaterBilling
{
	float[] conRange = new float[6]; //to hold consumption range
	
	public void run()
	{
		Scanner sc = new Scanner(System.in);
		/*System.out.println("Enter Start Date");
		String start = sc.nextLine();
		System.out.println("Enter End Date");
		String end = sc.nextLine();*/
		System.out.println("Enter Previous Reading");
		int prev = sc.nextInt();
		System.out.println("Enter Current Reading");
		int curr = sc.nextInt();
		System.out.println("Enter Number of days");
		int days = sc.nextInt();
		
		period(days);
		
		calcTarrif((curr - prev));
	
	}//end of run method

	public static void main(String[] args)
	{
		WaterBilling obj1 = new WaterBilling();
		obj1.run();
	}//end of main method

	public double calcTarrif(int used)
	{
	
		System.out.println("");
		System.out.println("Water used : "+used+"kl");
		System.out.println(String.format("Volume used in (kl): \t\t Cost:"));
		double[] tarArray = {4.00,15.57,22.78,38.32,99.99,265.12};//hold the tarrif amounts
		
		String result = "";
		double tarrif = 0;
		int i = 0;

		while(i < conRange.length) //loops through range of consumptions
		{
			if (used > conRange[i])
			{
				if(used < conRange[i+1]) //subtracts water used from highest range of consumption
					tarrif = tarrif + ((used - conRange[i])*tarArray[i]);
				else  // subtract from prev range
					tarrif = tarrif + ((conRange[i+1] - conRange[i])*tarArray[i]);
	
			result = String.format("%.2f - %.2f \t\t\t R %.2f", conRange[i],conRange[i+1],tarrif);
			
			System.out.println(result);
			}
			
			i += 1;
		}
		System.out.println("");
		System.out.println(String.format("Total inc. VAT : R %.2f", tarrif*1.14));
		return (tarrif*1.14); // returns tarrif including VAT
	}//end of calc Method
	
	public void period(float days)
	{
		conRange[0] = 0.000f;
		conRange[1] = days / (365.0f/12.0f) * 6.00f;
		conRange[2] = (days / (365.0f/12.0f)) * 10.50f;
		conRange[3] = (days / (365.0f/12.0f)) * 20.00f; //calculate consumption range
		conRange[4] = (days / (365.0f/12.0f)) * 35.00f;
		conRange[5] = (days / (365.0f/12.0f)) * 50.00f;
		
	}//end of period method
	
	/*public int getDays(String s, String e)
	{
		int days = 0;
		String[] start = s.split(" ");
		String[] end = e.split(" ");
		String[] months = {"","January","February","March","April","May","June","July","August","September","October","November", "December"};
		if (end[1].equals(start[1]))
		{
			days = Integer.parseInt(end[0]) - Integer.parseInt(start[0]);
		}
		else 
		{
			int i = 1;
			while (i < months.length)
			{
				if(end[1].equals(months[i]))
					end[1]= i +"";
				if(start[1].equals(months[i]))
					start[1] = i +"";
				i += 1;
			}
			
			days = ((Integer.parseInt(end[1]) - Integer.parseInt(start[1])) * 30 - Integer.parseInt(end[0])) + Integer.parseInt(start[0]);
		}

		System.out.println("Days :" + (days-2));		

		return days-2;

	}//end of days method
	*/

}//end of CLASS

