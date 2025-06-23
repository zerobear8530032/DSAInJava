package LinkedList.Learning;

public class LL {
	private Node head;
	private Node tail;
	private int size ;
	
	public LL() {
		size=0;
	}
	
	private class InvalidIndexException extends RuntimeException{
		public InvalidIndexException() {
			super();
		}
		public InvalidIndexException(String msg) {
			super(msg);
		}
	}
	private class EmptyListException extends RuntimeException{
		public EmptyListException() {
			super();
		}
		public EmptyListException(String msg) {
			super(msg);
		}
	}
	
	private class Node{
		private int value;
		private Node next;


		
		public Node(int value, Node next) {
			this.value = value;
			this.next = next;
		}
		
		public int getValue() {
			return value;
		}
		public void setValue(int value) {
			this.value = value;
		}
		public Node getNext() {
			return next;
		}
		public void setNext(Node next) {
			this.next = next;
		}
		@Override
		public String toString() {
			return "Node [value=" + value + ", next=" + next + "]";
		}

		
		
		
	}
	
//	methods :
//	insertAt first
	
	public void insertAtFirst(int n) {
		Node node = new Node(n,null);
		node.next=head; // node next point to current head
		head=node;// head point to new head
		if(tail==null) {// if tail is null  means this is the first node so tail will be at head 
			tail=head;
		}
		size++;		
	}
	public void insertAtLast(int n) {
		if(tail==null) {
			insertAtFirst(n);
			return ;
		}
			Node node = new Node(n,null);
			tail.next=node;
			tail=node;
			size++;		
	}
	
	public int getSize() {
		return size;
	}
	
	public void insertAtIndex(int n, int idx) {
//		assuming the ll is 0 based indexing 
		if(idx<0 || idx>size) {
			throw new InvalidIndexException("Index :"+idx+" is not present in Linked List size :"+size);
		}
		if(idx==0) {
			insertAtFirst(n);
		}else if(idx==size) {
			insertAtLast(n);			
		}else {

			Node temp = head;
			for(int i =1;i<idx;i++){
				temp = temp.next;
			}
			Node tempnext = temp.next;
			Node node = new Node(n, tempnext);
			temp.next=node;
			size++;
		}		
	}
	
	
	public  void display() {
		Node temp = head;
		while(temp!=null) {
			System.out.print(temp.getValue()+"->");
			temp=temp.next;
		}
		System.out.println("END");
	}
	
	
//	deleting items :
	
	public int deleteFirst() {
		if(size==0) {
			throw new EmptyListException("List is Empty Cannot Remove Element !");
		}
		int val = head.getValue();
		if(head!=null) {
			head=head.next;			
		}
		if(head==null) {
			tail=null;
		}
		size--;
		return val;
	}
	public int deleteLast() {
		if(size==0) {
			throw new EmptyListException("List is Empty Cannot Remove Element !");
		}
		if(size==1) {
			return deleteFirst();
		}
		Node secondlast = getNode(size-2);
		int val = tail.getValue();
		secondlast.next=null;
		tail=secondlast;
		size--;
		return val;
	}
	
	public int deleteAtIndex(int idx) {
		if(size==0) {
			throw new EmptyListException("List is Empty Cannot Remove Element !");
		}
		if(idx==0) {
			return deleteFirst();
		}else if(idx==size-1) {
			return deleteLast();
		}
		Node behindnode= getNode(idx-1);
		Node removenode = behindnode.next;
		int val = removenode.getValue();
		behindnode.next=removenode.next;
		size--;
		return val;
	}
	
//	find values:
	
	public Node find(int val) {
		Node temp =head;
		while(temp!=null) {
			if(temp.getValue()==val) {
				return temp;
			}
			temp=temp.next;
		}
		return temp;
	}
	
	public int findIndex(int val) {
		Node temp =head;
		for(int i =0;i<size;i++) {
			if(temp.getValue()==val) {
				return i;
			}
			temp=temp.next;
		}
		return -1;
	}
	
	
	
	
	
	public Node getNode(int idx) {
		if(idx<0 || idx>=size) {
			throw new InvalidIndexException("Index :"+idx+" is not present in Linked List size :"+size);
		}
		Node temp =head;
		for(int i =0;i<idx;i++) {
			temp=temp.next;
		}
		return temp;
	}
	public int getValue(int idx) {
		if(idx<0 || idx>=size) {
			throw new InvalidIndexException("Index :"+idx+" is not present in Linked List size :"+size);
		}
		Node temp =head;
		for(int i =0;i<idx;i++) {
			temp=temp.next;
		}
		return temp.getValue();
	}


}
