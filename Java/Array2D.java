import java.util.Arrays;
public class Array2D
{
	public Array2D()
	{
	
	}//end of constructor
	
	public double sum(double[][] arr)
	{
		double s = 0;
		for(int row = 0; row < arr.length; row++)
		{
			for(int col = 0; col < arr[0].length; col++)
			{
				s += arr[row][col];
			}
		}
		return s;
	}//end of sum method
	
	public double average(double[][] arr)
	{
		double ave = sum(arr) / (arr.length * arr[0].length);
		return ave;
		
	}//end of average
	
	public void mode(double[][] arr)
	{
	
		double mode = 0;
		double number = 0;
		double[] array1D = new double[arr.length*arr[0].length];
		int count = 0;
		for(int row = 0; row < arr.length; row ++)
		{;
			for(int col = 0; col < arr[0].length ; col++)
			{
				array1D[count] = arr[row][col];
				count++;
			}
		}
		
		Arrays.sort(array1D);
		
		int iniCount = 1;
		int finCount = 1;
		number = array1D[0];
		mode = number;
		
		for(int i = 0; i < array1D.length; i++)
		{
			if(array1D[i] == number)
				iniCount++;
			else
			{	 
				if(iniCount > finCount)
				{
					finCount = iniCount;
					mode = number;
				}
				
				iniCount = 1;
				number = array1D[i];
			}
		}
		
		
		System.out.println(""+mode);
	}//end of mode method

	public void run()
	{
		double array[][] = {{8,1,9,2,3,6},{3,5,4,7,8,1}};
		//System.out.println(sum(array)+"");
		mode(array);
				
	}//end of run method

	public static void main(String args[])
	{
		Array2D obj1 = new Array2D();
		obj1.run();
	}//end of main method
	
}//end of class
