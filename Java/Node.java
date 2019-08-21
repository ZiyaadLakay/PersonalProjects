public class Node
{
	private String element;
	private Node next;
	
	public Node()
	{
		this(null,null);
	}
	
	public Node(String s, Node n)
	{
		element = s;
		next = n;
	}
	
	public String getElement()
	{
		return element;
	}
	
	public Node getNext()
	{
		return next;
	}
	
	public void setNext(Node n)
	{
		next = n;
	}
	
	
}//end of node class
