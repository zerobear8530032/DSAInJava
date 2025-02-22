package myDataStructures.LinkedList;


class LinkedListEmptyException extends RuntimeException{
	public LinkedListEmptyException() {
		super();
		
	}
	public LinkedListEmptyException(String str) {
		super(str);
		
	}
	
}

public class MySinglyCircularLinkedList {
	Node head;
	Node tail;
	int size ;
	public MySinglyCircularLinkedList() {
		head=tail=null;
		size=0;
	}
	
	public void deleteAtHead( ) {
		if(head==null) {
			throw new LinkedListEmptyException();
		}else if(head==tail) {
			head=tail=null;
		}else {
			Node temp =head;
			head=head.getNext();// update the head 
			temp.setNext(null);//remove the prev head link 
			tail.setNext(head);//update the tail next 	
		}
		size--;
	}
	
	public void deleteAtTail() {
		if(head==null) {
			throw new LinkedListEmptyException();
		}else if(head==tail){
			head=tail=null;
		}else {
			Node ptr=head;
			while(ptr.getNext()!=tail) {
				ptr=ptr.getNext();
			}
			Node oldtail = ptr.getNext();
			oldtail.setNext(null);// remove the old tail connection to head
			tail=ptr;
			tail.setNext(head);
		}
		size--;
	}
	
	
	public void deleteAtIndex( int index ) {
		if(index>=size || index<0) {
			throw new IndexOutOfBoundsException();
		}
		if(index==0) {
			deleteAtHead();
		}else if(index==size-1) {
			deleteAtTail();
		}else {
			int idx=0;
			Node prevptr=head;
			while(idx<index-1) {
				prevptr=prevptr.getNext();
				idx++;
			}
			Node deleteNodeptr= prevptr.getNext();// get the deletion node 
			Node nextptr= deleteNodeptr.getNext();
			deleteNodeptr.setNext(null);// remove the connection to the linked list 
			prevptr.setNext(nextptr);// connect the prev with next ptr this remove the deletion  node 
			size--;
		}
	}
	public void insertAtHead(int element ) {
		Node node = new Node(element);
		if(head==null) {
			this.head=this.tail=node;
			tail.setNext(head);
		}else {
			node.setNext(head);
			head=node;
			tail.setNext(head);
		}
		size++;
	}
	
	public void insertAtTail(int element ) {
		Node node = new Node(element);
		if(head==null) {
			this.head=this.tail=node;
			tail.setNext(head);
		}else {
			tail.setNext(node);
			tail=node;
			tail.setNext(head);			
		}
		size++;
	}
	
	
	public void insertAtIndex(int element, int index ) {
		if(index>size || index<0) {
			throw new IndexOutOfBoundsException();
		}
		if(index==0) {
			insertAtHead(element);
		}else if(index==size) {
			insertAtTail(element);
		}else {
			int idx=0;
			Node node = new Node(element);
			Node prevptr=head;
			while(idx<index-1) {
				prevptr=prevptr.getNext();
				idx++;
			}
			Node nextptr= prevptr.getNext();
			prevptr.setNext(node);
			node.setNext(nextptr);
			size++;
		}
	}
	
	public  void traverse() {
		if(head==null) {
			System.out.println("null");
			return ;
		}
		if(head==tail) {
			System.out.println(head.getValue()+"-> head");
			return;
		}
		Node ptr=head;
		do {
			
			System.out.print(ptr.getValue()+"->");
			ptr=ptr.getNext();
		}while(ptr!=head);
		System.out.println("head");
	}
	public  String  toString() {
		if(head==null) {
			return "[]";
		}
		if(head==tail) {
			return "["+head.getValue()+"]";
		}
		Node ptr=head;
		StringBuilder str = new StringBuilder("[");
		do {
			if(ptr.getNext()!=head) {
				str.append(ptr.getValue()).append(",");				
			}else {
				str.append(ptr.getValue());
			}
		
			ptr=ptr.getNext();
		}while(ptr!=head);
		str.append("]");
		return str.toString();
	}
	public int size() {
		return size;
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

	public boolean isEmpty() {
		return head==null;
	}
	public void clear() {
		head=tail=null;
		size=0;
	}
	public static void main(String[] args) {
		MySinglyCircularLinkedList cl= new MySinglyCircularLinkedList();
		
		cl.insertAtIndex(0,0);
		cl.insertAtIndex(1,1);
		cl.insertAtIndex(1,2);
		cl.insertAtIndex(3,3);
		cl.insertAtIndex(4,4);
		System.out.println(cl);
		System.out.println(cl.tail.getNext()==cl.head);
		cl.deleteAtIndex(0);
		System.out.println(cl);
		
		cl.deleteAtIndex(1);
		System.out.println(cl);
		System.out.println(cl.tail.getNext()==cl.head);
		cl.deleteAtIndex(cl.size);
		System.out.println(cl);
		System.out.println(cl.tail.getNext()==cl.head);
		cl.deleteAtIndex(cl.size);
		System.out.println(cl.tail.getNext()==cl.head);		
		cl.deleteAtIndex(0);
		System.out.println(cl.tail.getNext()==cl.head);
		System.out.println(cl);
	}

}
