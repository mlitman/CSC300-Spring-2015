import java.util.Random;
import java.util.Scanner;



public class Driver 
{
	public static void main(String[] args)
	{
		LinkedList ll = new LinkedList();
		try
		{
			System.out.println(ll.removeFront());
		}
		catch(Exception e)
		{
			System.out.println("Failed to remove");
		}
		ll.addFront(2);
		ll.addFront(3);
		ll.addFront(4);
		ll.addFront(5);
		ll.addFront(6);
		ll.addFront(7);
		ll.display();
		try
		{
			System.out.println(ll.removeFront());
		}
		catch(Exception e)
		{
			System.out.println("Failed to remove");
		}
		ll.display();
	}
}
