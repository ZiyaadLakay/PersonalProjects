public class AccountDriver
{
	public static void main(String args[])
	{
		AccountDriver obj1 = new AccountDriver();
		obj1.run(); 
	}//end of main class
	
	public void run()
	{
		Account mark = new Account(50000);
		
		System.out.println(mark);
		
		mark.withdraw(100);
		
		System.out.println(mark);
		
		mark.deposit(200);
		
		System.out.println(mark);

		System.out.println(mark.getBalance());
		
	}//end of run method
	
}//end of class
