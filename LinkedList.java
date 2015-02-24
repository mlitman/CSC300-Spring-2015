
public class LinkedList 
{
	private Node head;
	private Node tail;
	private int count;
	
	//upgrade our LinkedList to such that there is a pointer called tail
	//that points to the end of the list, and each node, knows about the 
	//previousNode.  So you need to update all the add methods, all the
	//remove methods, and finally re-write displayInReverse to take advantage
	//of our new double-linked list.
	//GitHub: https://github.com/mlitman/CSC300-Spring-2015
	
	public LinkedList()
	{
		this.head = null;
		this.count = 0;
	}
	
	public void displayInReverse()
	{
		for(int i = this.count-1; i >= 0; i--)
		{
			System.out.print(this.get(i) + "->");
		}
		System.out.println(" null");
	}
	
	public int get(int index)
	{
		int count = this.count();
		if(index >= count || index < 0)
		{
			System.out.println("Illegal Index");
			return -1;
		}
		else
		{
			Node curr = head;
			for(int i = 0; i < index; i++)
			{
				curr = curr.getNextNode();
			}
			return curr.getPayload();
		}
	}
	
	public int count()
	{
		return this.count;
	}
	
	public void display()
	{
		if(head == null)
		{
			System.out.println("Empty List");
		}
		else
		{
			Node currNode = this.head;
			while(currNode.getNextNode() != null)
			{
				System.out.print(currNode.getPayload() + "->");
				currNode = currNode.getNextNode();
			}
			System.out.println(currNode.getPayload() + "-> null");
		}
	}
	
	public void addAtIndex(int payload, int index)
	{
		//hw goes here
		//add a Node containing the payload such that this node will 
		//be added to the list and live at position index.
		//For now: any index less than zero should add at the front of
		//the list, and any index greater than or equal to count should
		//add at the end of the list
		if(index <= 0)
		{
			this.addFront(payload);
		}
		else if(index >= this.count)
		{
			this.addEnd(payload);
		}
		else
		{
			Node n = new Node(payload);
			Node curr = head;
			for(int i = 0; i < index-1; i++)
			{
				curr = curr.getNextNode();
			}
			n.setNextNode(curr.getNextNode());
			curr.setNextNode(n);
			this.count++;
		}
		
	}
	
	public void addFront(int payload)
	{
		Node n = new Node(payload);
		if(head == null)
		{
			head = n;
		}
		else
		{
			n.setNextNode(head);
			head = n;
		}
		this.count++;
	}
	
	public void addEnd(int payload)
	{
		Node n = new Node(payload);
		if(this.head == null)
		{
			this.head = n;
		}
		else
		{
			//find the last node in the list
			Node currNode = this.head;
			while(currNode.getNextNode() != null)
			{
				currNode = currNode.getNextNode();
			}
			//currNode will point to the very last Node in the list
			currNode.setNextNode(n);
		}
		this.count++;
	}
	
	public int removeAtIndex(int index) throws Exception
	{
		if(head == null)
		{
			throw new Exception("Can Not Remove At Index: Empty List");
		}
		else if(index < 0 || index > this.count-1)
		{
			throw new Exception("Can Not Remove At Index: Index Out of Bounds : " + index);
		}
		else
		{
			//so we have something to remove
			if(index == 0)
			{
				return this.removeFront();
			}
			else if(index == this.count-1)
			{
				return this.removeEnd();
			}
			else
			{
				Node currNode = head;
				for(int i = 1; i < index; i++)
				{
					currNode = currNode.getNextNode();
				}
				int payloadToReturn = currNode.getNextNode().getPayload();
				Node temp = currNode.getNextNode().getNextNode();
				currNode.getNextNode().setNextNode(null);
				currNode.setNextNode(temp);
				return payloadToReturn;
			}
		}
	}
	
	public int removeEnd() throws Exception
	{
		if(head == null)
		{
			throw new Exception("Can Not Remove End: Empty List");
		}
		else if(this.count == 1)
		{
			return this.removeFront();
		}
		else
		{
			Node currNode = head;
			for(int i = 1; i < this.count-1; i++)
			{
				currNode = currNode.getNextNode();
			}
			int payloadToReturn = currNode.getNextNode().getPayload();
			currNode.setNextNode(null);
			this.count--;
			return payloadToReturn;
		}
	}
	public int removeFront() throws Exception
	{
		if(head == null)
		{
			throw new Exception("Can Not Remove Front: Empty List");
		}
		Node currNode = head;
		head = head.getNextNode();
		currNode.setNextNode(null);
		this.count--;
		return currNode.getPayload();
	}
}
