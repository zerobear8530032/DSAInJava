package LinkedList.Learning;

public class CLL {
	private Node head;
	private Node tail;
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
	private class Node{
		int val;
		Node next;
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
		public Node(int val, Node next) {
			super();
			this.val = val;
			this.next = next;
		}
		public Node(int val) {

			this.val = val;
		}
		@Override
		public String toString() {
			return "Node [val=" + val + ", next=" + next + "]";
		}
	}
	
	
	
	public void addLast(int val) {
		Node node= new Node(val);
		if(tail!=null) {			
			tail.next=node;
			node.next=head;
			tail=node;
		}else {
			tail=node;
			head=node;
			tail.next=head;
			head.next=tail;
		}
		size++;
	}
	public void addFirst(int val) {
		Node node= new Node(val);
		if(tail!=null) {			
			tail.next=node;
			node.next=head;
			head=node;
		}else {
			tail=node;
			head=node;
			tail.next=head;
			head.next=tail;
		}
		size++;
	}
	public void addAtIndex(int val, int idx) {
		if(idx<0 || idx>size) {
			throw new InvalidIndexException("index :"+idx+" does not exists in size :"+size);
		}
		if(idx==0) {
			addFirst(val);
			return ;
		}
		if(idx==size) {
			addLast(val);
			return;
		}
		Node node= new Node(val);
		Node prev= get(idx-1);
		Node next= prev.next;
		prev.next=node;
		node.next=next;
		size++;
	}
	
	public Node get(int idx) {
		if(idx<0 || idx>size) {
			throw new InvalidIndexException("index :"+idx+" does not exists in size :"+size);
		}
		int i=0;
		Node node = head;
		do {
			if(i==idx) {
				break;
			}
			i++;
			node=node.next;
		}while(node!=head);
		return node;
	}
	
	
	public int removeFirst() {
		if(size==0) {
			throw new EmptyListException("List is Empty Cannot remove"); 
		}
		int val = head.getVal();
		if(size==1) {
			head=null;
			tail=null;
			size--;
			return val;
		}
		head=head.next;
		tail.next=head;
		size--;
		return val;
	}
	
	public int removeLast() {
		if(size==0) {
			throw new EmptyListException("List is Empty Cannot remove"); 
		}
		int val = tail.getVal();
		if(size==1) {
			head=null;
			tail=null;
			size--;
			return val;
		}
		Node prev=get(size-2);
		prev.next=head;
		tail=prev;
		size--;
		return val;
	}
	
	
	public void remove(int val) {
		Node temp = head;
		do{
			if(temp.next.getVal()==val) {
				break;
			}
			temp=temp.next;
		}while(temp!=head);
		if(temp!=null) {
			if(temp.next==head) {
				removeFirst();
				return;
			}else if(temp.next==tail) {
				removeLast();
				return;
			}
			Node next = temp.next.next;
			temp.next=next;
		}
		size--;

	}
	
	
	
	
	
	public  void display() {
		Node temp = head;
		if(temp!=null) {	
		do {
			System.out.print(temp.getVal()+"->");
			temp=temp.next;
		}while(temp!=head);
		}
		System.out.println("END");
		
		
	}

}
