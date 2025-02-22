package myDataStructures.LinkedList;



public class MySinglyLinkedList {
	private Node head;
	private Node tail;
	int size;
	
	
	
	public MySinglyLinkedList() {
		head =tail=null;
		size=0;
	}

	
	public void clear() {
		head=tail=null;
		size=0;
	}
	
	public void traverse() {
		if(head==null) {
			System.out.println("[]");
			return ;
		}
		Node ptr=head;
		
		while(ptr!=null) {
				System.out.print(ptr.getValue()+"->");				
				ptr=ptr.getNext();
		}
		System.out.println("null");
	}
	
	

	
	public  void insertAtHead(int val) {// insert element at head
		Node node= new Node(val);
		
		if(head==null) {
			head=tail=node;
			size++;
		}else {
			node.setNext(this.head);
			head=node;
			size++;			
		}
	
	}
	
	public  void insertAtTail(int val) {
		Node node = new Node(val);
		if(head==null) {
			head=tail=node;
			size++;
		}else {			
		tail.setNext(node);
		tail=node;		
		size+=1;
		}
	}
	
	
	public  void insertAtIndex(int index,int val) {
		Node node= new Node(val);
		if (size <= index || index < 0) {
		    throw new IndexOutOfBoundsException();
		}

		if(index ==0) {
			this.insertAtHead(val);
			return;
		}
		if(index==size) {
			this.insertAtTail(val);
			return;
		
		}
		
		Node prevptr =head;
		int i =0;
		while(prevptr!=null && i<index-1) {
			prevptr=prevptr.getNext();
			i++;
		}
		Node nextptr=prevptr.getNext();
		Node newnode = new Node(val);
		newnode.setNext(nextptr);
		prevptr.setNext(newnode);
		size+=1;
		
	}
	
	
	public  void deleteAtHead() {
		if(head==null) {
			System.out.println("Linked list is empty");
			return ;
		}
		  Node temp = head;  // Save the current head node
		    head = head.getNext();  // Update the head to the next node
		    temp = null;  
		    size--;  // Decrease the size of the list
	if(head==null) {
		tail=null;
	}
	}
	
	public  void deleteAtTail() {
		if(head==null) {
			System.out.println("Linked list is empty");
			return ;
		}	
		if(head==tail) {
			head=tail=null;
			size--;
		}else {		
			Node ptr = head;
			while(ptr.getNext()!=tail) {
				ptr=ptr.getNext();
			}
			ptr.setNext(null);
			tail=ptr;
			size--;
		}
	}
	
	public  void deleteAtIndex(int index) {
		if (index>=size || index < 0) {
		    throw new IndexOutOfBoundsException();
		}

		if(index ==0) {
			this.deleteAtHead();
			return;
		}
		if(index==size-1) {
			this.deleteAtTail();
			return;
		}
		
		Node prevptr =head;
		int i =0;
		while(prevptr!=null && i<index-1) {
			prevptr=prevptr.getNext();
			i++;
		}
		prevptr.setNext(prevptr.getNext().getNext());
		size-=1;
		
	}
	
	
	
	
	public int getSize() {
		return this.size;
	}
	
	
	public boolean search(int val) {
		if(head==null) {
			return false;
		}		
		Node ptr = head;
		while(ptr!=null) {
			if(ptr.getValue()==val) {
				return true;
			}
			ptr=ptr.getNext();
		}
		return false;
	}
	
	public int getIndex(int val) {
		if(head==null) {
			return -1;
		}		
		Node ptr = head;
		int i=0;
		while(ptr!=null) {
			if(ptr.getValue()==val) {
				return i;
			}
			ptr=ptr.getNext();
			i++;
		}
		return -1;
	}
	
	public void deleteValue(int val) {
		int index =getIndex(val);
		
		if(index!=-1) {
			this.deleteAtIndex(index);
		}
		
	}
	
	
	
	
	public int  get(int index) {
	
		if (index < 0 || index>=size) {
		    throw new IndexOutOfBoundsException();
		}

		Node prevptr =head;
		int i =0;
		while(prevptr!=null  ) {
			  if (i == index) {
		            return prevptr.getValue();
		        }
			  prevptr = prevptr.getNext();
		        i++;
		}
		return -1;
	}
	
	public boolean isEmpty() {
		return head==null;
	}
	
	
	
	@Override
	public String toString() {
	    if (head == null) {
	        return "[]";
	    }

	    StringBuilder str = new StringBuilder("[");
	    Node ptr = head;
	    while (ptr != null) { // Iterate until ptr is null
	        str.append(ptr.getValue());
	        ptr = ptr.getNext();
	        if (ptr != null) { // Add a comma if there are more elements
	            str.append(", ");
	        }
	    }
	    str.append("]"); // Close the bracket
	    return str.toString();
	    
	    
	    
	    
	    
	}
	public Node getHead() {
		return head;
	}
	public void setHead(Node head) {
		this.head = head;
	}
	public Node getTail() {
		return tail;
	}
	public void setTail(Node tail) {
		this.tail = tail;
	}
	public static void main(String[] args) {
		MySinglyLinkedList l = new MySinglyLinkedList();
		System.out.println(l.getSize());
		l.insertAtTail(0);
		l.insertAtTail(1);
		l.insertAtTail(2);
		l.insertAtTail(3);
		l.deleteAtTail();
		l.deleteAtTail();
		l.deleteAtTail();
		l.deleteAtTail();
		l.deleteAtTail();
		l.traverse();
		System.out.println(l.getSize());
	}

}
