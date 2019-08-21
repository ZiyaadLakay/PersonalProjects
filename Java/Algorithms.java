/*
ZIYAAD LAKAY

------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------
*/

public class Algorithms
{
	public static void main(String args[])
	{
		Algorithms obj1 = new Algorithms();
		obj1.run();
	}//end of main method
	
	public void run()
	{
		int[] arr = {-8,-5,-3,-2,-1,0,1,2,3,4,5,6,7,5}; //array holding a list
		
		long startTime = System.nanoTime(); //starting time in nano seconds because Milli Seconds is hard to measure
		
		//System.out.println("Algorithm 1 : "+Algorithm1(2, arr)); //calling function ALgorithm1
		System.out.println("Algorithm 2 : "+Algorithm2(arr,2, 0, arr.length - 1));// calling algorithm2
		//System.out.println("Algorithm 3 : "+Algorithm3(0, arr.length - 1, arr));//calling algorithm3
		
		long endTime = System.nanoTime();
		System.out.println("Time : "+(endTime - startTime)+" nano secs");
		
	}//end of run method
	
	public boolean Algorithm1(int num, int[] array)
	{
	
	/* We were not told if the algorithm should check if value is also in list 
		so i ignored that and just looked for the negative
		Also i assumed that the array would run from negative to positive
		*/
		
		for(int i = 0; i < array.length; i++) //loop through every element in array
		{
			if(array[i] == (0 - num)) //if found same element that is negative of value you looking for return true
				return true;
		}
		
		return false;
	}//end of algorithm 1
	
	public boolean Algorithm2(int[] data, int target, int low, int high)
	{
	
	/* We were not told if the algorithm should check if value is also in list 
		so i ignored that and just looked for the negative
		Also i assumed that the array would run from negative to positive
		*/
		if(low > high) //if low meets high number not found
			return false;
		else
		{
			int mid = (high + low) / 2; //middle value
			//System.out.println(mid);
			if((0-target) == data[mid]) //if negative value is found
				return true;
			else if((0-target) < data[mid]) //if on left side of array
				return Algorithm2(data, target, low, mid-1);
			else 
				return Algorithm2(data, target, mid + 1, high);
		}
	}//end of binary search
	
	public boolean Algorithm3(int i, int j,int[] data)
	{
	
	/*This Algorithm was not clear and i wasn't sure how to implement it
		They never said x is being compared to anything so it basically searches for the 
		first negative and positive pair in the list, regardless of the value of x
		*/
		
		if(i == j)
			return false;
		else 
		{
			//System.out.println(""+data[j]);	
			if(data[i] + data[j] == 0)
				return true;
			else if(data[i] + data[j] < 0)
				return Algorithm3(i+1,j,data);
			else
				return Algorithm3(i,j-1,data);
		}
	}
	
}//end of class
