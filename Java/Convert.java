/*
ZIYAAD LAKAY 
*/

/*CONVERTING TO POLISH NOTATION*/
public class Convert
{
	public static void main(String[] args)
	{
		Convert obj1 = new Convert();
		obj1.run();
	}//end of main method
	
	public void run()
	{
		System.out.println(ConvertToPolishNotation("+(b*c-d/(e^f)*g)*h)"));
	}//end of run method

	public StackChar ConvertToPolishNotation(String Q)
	{
		StackChar P = new StackChar();
		StackChar stk = new StackChar();
		stk.push('(');
		//System.out.println(stk.head());
		
		Q = Q + ')';
		
		String operator = "^*/+-";
		char temp = '\u0000';
		//2
		for(int i = 0; i < Q.length(); i++)
		{	//3
			if(Q.charAt(i) >= 'a' && Q.charAt(i) <= 'z')
				P.push(Q.charAt(i));
			//4
			if(Q.charAt(i) == '(')
				stk.push(Q.charAt(i));
				
			for(int j = 0; j < operator.length(); j++)
			{	//5
				if(Q.charAt(i) == operator.charAt(j))
				{	
					while(!stk.isEmpty())
					{	//5a
						stk.display();
						P.push(stk.top());
					}
					//5b
					stk.push(Q.charAt(i));
				}	
			}
			//6
			if(Q.charAt(i) == ')')
			{
				while(!stk.isEmpty() && stk.head() != '(')
					{	//6a
						P.push(stk.pop());
					}
					//6b
					stk.pop();
			}
		}
		
		return P;
	}//end of convert method

	

}//end of main class
