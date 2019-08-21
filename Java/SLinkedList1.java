/*Working with a Linked List*/
public class SLinkedList1
{
	private Node head; //head of the node
	private long size; //number of nodes in list
	
	public SLinkedList1()
	{
		head = null;
		size = 0;
	}//constructor method
	
	public long getSize()
	{
		return size;
	}//returns the size of nlist
	
	public Node getHead()
	{
		return head;
	}//returns first item in list
	
	public boolean isEmpty()
	{
		return(head == null);
	}
	
	public void addFirst(Node n)
	{
		n.setNext(head); //points the new node to the head making the new node the head
		head = n;
		size+= 1;
	}
	
	public void addValueFirst(String s)
	{
		Node temp = new Node(s, null);
		addFirst(temp);
	}
	
	public void addLast(Node n)
	{
		Node temp = head;
		Node prev = null;
		while(temp != null)
		{
			prev = temp;
			temp = temp.getNext();	
		}
		prev.setNext(n);
		size += 1;
	}
	
	public void addValueLast(String s)
	{
		Node temp = new Node(s, null);
		addLast(temp);
	}
	
	public void addValueInOrder(String s)
	{
		Node newNode = new Node(s, null);
		
		Node prev = null;
		if(isEmpty())
		{
			addValueFirst(s);
		}
		else if(size == 1)
		{
			addValueLast(s);
		}
		else
		{
			Node temp = head;
			while(temp != null)
			{
				if(temp.getNext() == null)
				{
					addValueLast(s);
					temp = null;
				}
				else if (temp.getElement().compareTo(newNode.getElement()) == 0)
				{
					newNode.setNext(temp);
					prev.setNext(newNode);
					temp = null;
					size+=1;
				}
				else if(temp.getElement().compareTo(newNode.getElement()) > 0)
				{
					newNode.setNext(temp);
					prev.setNext(newNode);
					temp = null;
					size+=1;
				}
				else
				{	//System.out.println(temp.getNext().getElement());
					prev = temp;
					temp = temp.getNext();
					
				}
			
			}
		}
	}
	
	
	public void removeFirst()
	{
		if(!isEmpty())
		{
			head = head.getNext();
			size -= 1;
		}
		
		else
		{
			System.out.println("Can't remove from list, list is empty");
		}
	}
	
	public boolean inList(String s)
	{
		boolean foundValue=false;
		Node temp=head;
		while((temp!=null)&&(foundValue==false))
		{
			if (temp.getElement().equals(s))
				foundValue=true;
			else temp=temp.getNext();
		}
		return foundValue;
	}


	public void removeValue(String s)
	{
		Node temp = head;
		Node prev = null;
		
		while(temp != null)
		{
			if(temp.getElement().equals(s))
			{
				if(temp == head)
					removeFirst();
				else
				{
					prev.setNext(temp.getNext());
					size -= 1;
				}
			}
			
			else
				prev = temp;
				
			temp = temp.getNext();
		}
	}

	public String toString() 
	{
		String result = "";
		Node current = head;
		while(current != null)
		{
			result += current.getElement() + ", ";
			current = current.getNext();
		}
		return result;
	}

}//end of class
