//ZIYAAD LAKAY

/*Working with Data Structures*/

import javax.swing.JOptionPane;

public class Lock
{
	private int[] combination = new int[3]; //hold the combination
	
	public Lock()
	{
	
	}//end of default constructor
	
	public Lock(int[] combo)
	{
		combination[0] = combo[0];
		combination[1] = combo[1]; //initialising the combination when the constructor is created
		combination[2] = combo[2];
	}//end of contrsuctor
	
	public boolean open(int[] combo)
	{
		for(int i = 0; i < combo.length; i ++) //loops until finds the wrong number 
		{
			if(combo[i] != combination[i])
				return false;
		}
		
		//System.out.println("Opened !");
		return true; //returns true only if it never entered previous if statement
	}
	
	public void changeCombo(int[] oldCombo)
	{
		if(open(oldCombo)) //checks if combination is right before changing it
		{
			
			JOptionPane.showMessageDialog(null, "Enter New Combo");//System.out.println("Enter new combo : ");
			
			for(int i = 0; i < combination.length; i ++)
			{
				combination[i] = Integer.parseInt(JOptionPane.showInputDialog("Enter New Combo "+(i+1)));
			}
			
			JOptionPane.showMessageDialog(null, "Combo Changed !");

		}
		else
			JOptionPane.showMessageDialog(null, "Wrong Combination !");//System.out.println("Wrong combination !"); //outputs if user entered wrong combination
	}
	
	public void outPut()
	{
		System.out.println(""+combination[0]+""+combination[1]+""+combination[2]);
	}
}//end of class
