package LinkedList.Learning;

public class DLL {
	
	Node head;
	Node tail;
	int size=0;
	
	
	class InvalidIndexException extends RuntimeException{
		public InvalidIndexException() {
			super();
		}
		public InvalidIndexException(String msg) {
			super(msg);
		}
	}
	class EmptyListException extends RuntimeException{
		public EmptyListException() {
			super();
		}
		public EmptyListException(String msg) {
			super(msg);
		}
	}
	class NodeDoesNotExistsException extends RuntimeException{
		public NodeDoesNotExistsException() {
			super();
		}
		public NodeDoesNotExistsException(String msg) {
			super(msg);
		}
	}
	
	private class Node{
		int val;
		Node next;
		Node prev;
		@Override
		public String toString() {
			return "Node [val=" + val + ", next=" + next + ", prev=" + prev + "]";
		}
		public int getVal() {
			return val;
		}
		public void setVal(int val) {
			this.val = val;
		}
		public Node getNext() {
			return next;
		}
		public void setNext(Node next) {
			this.next = next;
		}
		public Node getPrev() {
			return prev;
		}
		public void setPrev(Node prev) {
			this.prev = prev;
		}
		public Node(int val, Node next, Node prev) {
			this.val = val;
			this.next = next;
			this.prev = prev;
		}
		public Node(int val) {
			this.val = val;
		}
	}
	
	public void addFirst(int val) {
		Node node = new Node(val);
		node.next=head;
		node.prev=null;
		if(head!=null) {
			head.prev=node;
		}else {
			tail=node;
		}
		head=node;
		size++;
	}
	public void addLast(int val) {
		Node node = new Node(val);
		node.next=null;
		if(tail==null) {
			addFirst(val);
			return;
		}
		node.prev=tail;
		tail.next=node;
		tail=node;
		size++;
	}
	public void addAtIndex(int val, int idx) {
		if(idx<0 || idx>size) {
			throw new InvalidIndexException("Invalid index :"+idx+" does not exists in size :"+size);	
		}
		if(idx==0) {
			addFirst(val);
			return;
		}else if(idx==size) {
			addLast(val);
			return;			
		}
		Node prev= get(idx-1);
		Node next= prev.next;
		
		Node node = new Node(val);
		prev.next=node;
		node.prev=prev;
		
		node.next=next;
		next.prev=node;
		
		size++;
	}
	
	
	public Node get(int idx) {
		if(idx<0 || idx>size) {
			throw new InvalidIndexException("Invalid index :"+idx+" does not exists in size :"+size);	
		}
		Node temp = head;
		for(int i =0;i<idx;i++) {
			temp=temp.next;	
		}
		return temp;
		
	}
	
	
	public void insertAfterVal(int x, int val) {
		Node node= find(x);
		if(node==null) {
			throw new NodeDoesNotExistsException("Sorry the node does not exists");
		}
		Node nextnode= node.next;
		if(nextnode==null) {
			addLast(val);
			return ;
		}
		Node insertnode = new Node(val);
		node.next=insertnode;
		insertnode.prev=node;
		insertnode.next=nextnode;
		nextnode.prev=insertnode;
		size++;
	}
	
	public Node find(int val) {
		Node temp = head;
		while(temp!=null) {
			if(temp.getVal()==val) {
				return temp;
			}
			temp=temp.next;
			
		}
		return null;
	}
	
	
	public void display() {
		Node temp =head;
		while(temp!=null) {
			System.out.print(temp.getVal()+"->");
			temp=temp.next;
		}
		System.out.println("END");
	}
	public void displayRevese() {
		Node temp =tail;
		while(temp!=null) {
			System.out.print(temp.getVal()+"->");
			temp=temp.prev;
		}
		System.out.println("START");
	}
	

	
	public int size() {
		return size;
	}
	

	
}
