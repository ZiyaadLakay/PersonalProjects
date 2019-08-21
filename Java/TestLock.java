import javax.swing.JOptionPane;

public class TestLock
{

	public int[] usrCombo()
	{	
		int[] tempCombo = new int[3];//stores combination in array
		

		for(int i = 0; i < tempCombo.length; i++)
		{	
			tempCombo[i] = Integer.parseInt(JOptionPane.showInputDialog("Enter Combination "+(i+1)));
		}
			
		return tempCombo;

	}//end of usrCombo

	public void run()
	{
		//System.out.println("Please enter 3 combination numbers : ");
		JOptionPane.showMessageDialog(null, "Please enter 3 combination numbers : ");		
		Lock lock = new Lock(usrCombo()); //creates lock object then saves combination
		JOptionPane.showMessageDialog(null, "Locked !");//System.out.println("Locked !");
		
		//Scanner sc = new Scanner(System.in);
	
		String option = JOptionPane.showInputDialog("What would you like to do ?"+"\n"+"O - open ; C - change lock ; E - exit");	

		while(!option.equalsIgnoreCase("E")) //loops till user exits program
		{	
			if(option.equalsIgnoreCase("O")) //if user opens lock
			{
				//System.out.println("Enter Combination");
				if(lock.open(usrCombo())) //checks if combination is correct and opens lock
					JOptionPane.showMessageDialog(null, "Unlocked !");//System.out.println("Unlocked");
				else
					JOptionPane.showMessageDialog(null, "Wrong Combination !");			
			}
			else if(option.equalsIgnoreCase("C"))
			{
				
				lock.changeCombo(usrCombo()); //changes lock
			}

			option = JOptionPane.showInputDialog("What would you like to do ?"+"\n"+"O - open ; C - change lock ; E - exit");
		}
		
		System.out.println("Finsihed");
		
		System.exit(0);		
	}//end of run method

	public static void main(String args[])
	{
		TestLock obj1 = new TestLock();
		obj1.run();
	}//end of main class
}//end of class
