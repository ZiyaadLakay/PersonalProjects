public class Account
{
	private double currentBal;
	
	public Account()
	{
	
	}//end of defaut constructor
	
	public Account(double curr)
	{
		currentBal = curr; //initialize current balance
	}
	public double getBalance()
	{
		return currentBal; //returns the balance of the account
	}//end of get balance  
	
	public void deposit(double dep)
	{
		currentBal = currentBal + dep; //increases the balance
		System.out.println("R"+dep+" Deposited !");
	}
	
	public void withdraw(double with)
	{
		if(with > currentBal) //checks if within balance
			System.out.println("Not enough funds");
		else 
		{	
			currentBal = currentBal - with;
			System.out.println("R"+with+" Withdrawed !");
			
		}
	}
	
	public String toString()
	{
		return "Balance : R"+currentBal;
	}
}//end of class
