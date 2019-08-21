public class TestLinkedList1
{
	public static void main(String[] args)
	{
		SLinkedList1 mySLinkedList= new SLinkedList1();
		mySLinkedList.addValueInOrder("alice");
		mySLinkedList.addValueInOrder("bob");
		mySLinkedList.addValueInOrder("craig");
		mySLinkedList.addValueInOrder("douglas");
		
		System.out.println("The list is: "+mySLinkedList.toString());
		System.out.println("charles is in the list: "+
mySLinkedList.inList("charles"));
		System.out.println("craig is in the list: "+mySLinkedList.inList("craig"));
		mySLinkedList.removeValue("bob");
		System.out.println("After removing bob, list is now: "+mySLinkedList.toString());
		System.out.println("size of list is now: "+mySLinkedList.getSize());
		mySLinkedList.addValueInOrder("brian");
		mySLinkedList.addValueInOrder("brian");
		System.out.println("After adding brian twice, list is now: "+mySLinkedList.toString());
		System.out.println("size of list is now: "+mySLinkedList.getSize());
	}
}
