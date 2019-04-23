package info;

/**
 * Class LinkedList is the class for creating and managing <b>generic linked list</b>
 * <br>only limitation is that the generic type must implement {@link java.lang.Comparable}
 * @author Rollers
 * @param <T> Type of Linked list You want to create
 */
public class LinkedList<T extends Comparable<T> > extends Node<String> {

	/**
	 * head of the linked list(i.e. first node)
	 */
	private Node<T> head;
	/** 
	 <br> Will insert a node into the linked list with the given data
	 @author Rollers
	 @param data : <br> Value of the node
	 @return does not returns anything
	 **/
	public void insertNode(T data) 
	{
		Node<T> node = new Node<T>();
		node.setData(data);
		node.setNext(null);
		if (head == null) 
		{
			head = node;
		} 
		else 
		{
			Node<T> ptr = head;
			while (ptr.getNext() != null) 
			{
				ptr = ptr.getNext();
			}
			ptr.setNext(node);
		}
	}

	/** 
	 <br> Will print linked list 
	 @author Rollers
	 @return does not returns anything
	 **/
	public void printLL() 
	{
		Node<T> ptr = this.head;
		while (ptr.getNext() != null) 
		{
			System.out.print(ptr.getData() + "->");
			ptr = ptr.getNext();
		}
		System.out.print(ptr.getData());
		System.out.println();
	}

	/**
	 * <br>Will search the given <b>node</b> in the Linked list associated with the caller object with the data = elementData
	 * <br>and returns the position of its first occurrence
	 * <br>if the given element is not in the linked list then return <b>-1</b>
	 * @author Rollers
	 * @param elementData
	 * @return position of the given elementData
	 */
	public int firstPositionOf(T elementData)
	{
		int position=-1,temp=1;
		Node<T> ptr=head;
		Node<T> compareNode=new Node<T>();
		compareNode.setData(elementData);
		while(ptr!=null)
		{
			if(ptr.equals(compareNode))
			{
				position=temp;
				break;
			}
			temp++;
			ptr=ptr.getNext();
		}
		return position;
	}
	
	/** 
	 *<br> Will reverse the linked list associated with the caller object 
	 *@author Rollers	
	 *@return does not returns anything
	 **/
	public void reverseLL() 
	{
		Node<T> previous = null;
		Node<T> current = head;
		Node<T> temp = null;
		while (current != null) 
		{
			temp = current.getNext();
			current.setNext(previous);
			previous = current;
			current = temp;
		}
		head = previous;
	}
	/** 
	 <br> Will insert the <b>node</b>(in the linked list) with data = nodeData 
	 <br> after the first occurrence of the node with data = elementData.
	 @author Rollers
	 @param elementData : data of the node after which the insertion is to be done.
	 @param nodeData : data of the node which is to be inserted.
	 @return does not returns anything
	 **/
	public void insertAfterFirstElementOf(T elementData, T nodeData) 
	{
		Node<T> ptr = head;
		Node<T> compareNode = new Node<T>();
		compareNode.setData(elementData);
		compareNode.setNext(null);
		Node<T> nodeToInsert = new Node<T>();
		nodeToInsert.setData(nodeData);
		nodeToInsert.setNext(null);
		while (((!ptr.equals(compareNode)) && (ptr != null))) 
		{
			ptr = ptr.getNext();
		}
		if (ptr != null) 
		{
			nodeToInsert.setNext(ptr.getNext());
			ptr.setNext(nodeToInsert);
		}
	}
	/** 
	 <br> Will insert the <b>node</b>(in the linked list associated with the caller object) with data = nodeData 
	 <br> after the last occurrence of the node with data = elementData.
	 @author Rollers
	 @param elementData : data of the node after which the insertion is to be done.
	 @param nodeData : data of the node which is to be inserted.
	 @return does not returns anything
	 **/
	public void insertAfterLastElementOf(T elementData, T nodeData) 
	{
		reverseLL();
		insertBeforerElement(elementData, nodeData);
		reverseLL();
	}
	
	/** 
	 <br> Will insert the <b>node</b>(in the linked list associated with the caller object) with data = nodeData 
	 <br> before the first occurrence of the node with data = elementData.
	 @author Rollers
	 @param elementData : data of the node before which the insertion is to be done.
	 @param nodeData : data of the node which is to be inserted.
	 @return does not returns anything
	 **/
	public void insertBeforerElement(T elementData, T nodeData) 
	{
		Node<T> ptr = head;
		Node<T> prev = null;
		Node<T> compareNode = new Node<T>();
		compareNode.setData(elementData);
		compareNode.setNext(null);
		Node<T> nodeToInsert = new Node<T>();
		nodeToInsert.setData(nodeData);
		nodeToInsert.setNext(null);
		while ((ptr != null) && ((!ptr.equals(compareNode)))) 
		{
			prev = ptr;
			ptr = ptr.getNext();
		}
		if (ptr != null) 
		{
			nodeToInsert.setNext(ptr);
			if (prev != null) 
			{
				prev.setNext(nodeToInsert);
			} 
			else 
			{
				head = nodeToInsert;
			}
		}
	}
	/** 
	 <br> Will delete the <b>node</b>(from the linked list associated with the caller object) with data = elementData 
	 @author Rollers
	 @param elementData : data of the node which is to be deleted.
	 @return does not returns anything
	 **/
	public void deleteFirstElement(T elementData) 
	{
		Node<T> ptr = head;
		Node<T> prev=head;
		Node<T> compareNode = new Node<T>();
		compareNode.setData(elementData);
		if(head.equals(compareNode))
		{
			head=head.getNext();
		}
		while (((!ptr.equals(compareNode)) && (ptr != null))) 
		{
			prev=ptr;
			ptr = ptr.getNext();
		}
		prev.setNext(ptr.getNext());
		
	}
	/** 
	 <br> Will delete the first occurrence of the <b>node</b>(from the linked list associated with the caller object) 
	 <br>with data = elementData
	 @author Rollers 
	 @param elementData : data of the node which is to be deleted.
	 @return does not returns anything
	 **/
	public void deleteLastElement(T elementData)
	{
		reverseLL();
		deleteFirstElement(elementData);
		reverseLL();
	}

	/**
	 * Will delete all the occurrences of the <b>node</b> with data = elementData from the 
	 * @author Rollers
	 * <br>linked list associated with the caller object 
	 * @param elementData
	 * @return does not returns anything
	 */
	public void deleteAllOccurences(T elementData)
	{
		
	}
	public void mergeSortedlists() 
	{

	}
	public void sort() 
	{
		Node<T> ptr=head;
		Node<T> temp=null;
		while(ptr!=null)
		{
			temp=ptr.getNext();
			while(temp!=null)
			{
				if(temp.compareTo(ptr)==-1)
				{
					T temmpVar=ptr.getData();
					ptr.setData(temp.getData());
					temp.setData(temmpVar);
				}
				temp=temp.getNext();
			}
			ptr=ptr.getNext();
		}
	}
	/**
	 * @author Rollers
	 * @return {@link} head of the linked list associated with the caller object
	 */
	public Node<T> getHead() {
		return head;
	}
	 
	/**
	 * <br>set the head of the linked list associated with the caller object 
	 * @author Rollers
	 * @param head : will set the head as start of the linked list
	 * @return does not returns anything
	 */
	public void setHead(Node<T> head) {
		this.head = head;
	}

}
