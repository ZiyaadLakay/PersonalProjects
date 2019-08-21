/*
ZIYAAD LAKAY 

*/
/*WORKING WITH STACKS*/
public class Stack
{
	private Position[] stack = new Position[100];
	private int count = 0;//will keep count of number of items in stack

	public Stack(Position item)
	{
		stack[0] = item;
		count++;
	}

	public Stack(Position[] items)
	{
		for(int i = 0; i < items.length; i++)
		{
			stack[i] = items[i]; //populates stack when object is created	
			count++;
		}
	}//end of object method

	public Position pop()
	{	Position item = null;
		if (!isEmpty())
		{
			System.out.println(stack[count]);
			item = stack[count];
			stack[count] = null; //sets last item to null
			count--;
			
		}
		else
			System.out.println("Empty stack");
		
		return item;
	}//end of pop
	
	public void push(Position item)
	{
		if(!isFull())
		{
			stack[count] = item;//populates next item in stack
			count++;
		}
		else
			System.out.println("Stack is full");
	}//end of push method

	public boolean isEmpty()
	{
		return (count == 0);
	}//end of isempty method
	
	public boolean isFull()
	{
		return (count == stack.length);
	}//end of is full method

	public void top()
	{
		stack[0] = null; //sets top of stack to null
		int j = 1;
		for(int i = 0; i < count; i++)//resets posistions of items
		{	
			if(stack[i] == null)
			{
				
				stack[i] = stack[j];
				stack[j] = null;	
			}
		
			j++;
		}
		count--;
	}//end of top method

	public int getHeight()
	{
		return count;
	}//end of get height method
	
	public 	Position head(int hd)
	{
		return stack[hd];//returns item in stack
	}//end of head method

	public void display()
	{	if(!isEmpty())
		{
			for(int i = 0; i < count; i++)
				System.out.println(stack[i]);
			System.out.println();
		}
		else
			System.out.println("Stack is empty - nothing to print");
	}//end of display method
}//end of class
