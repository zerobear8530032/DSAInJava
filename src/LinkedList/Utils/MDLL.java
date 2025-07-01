package LinkedList.Utils;

import java.util.HashSet;

public class MDLL {
	
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
	 
	Node head;
	Node tail;
	int size;
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

	
	public int size() {
		return size;
	}
	
	public MDLL(int ...values) {
		for(int x: values) {
			add(x);
		}
	}
	
	
	public void addAll(int ...values) {
		for(int x: values) {
			add(x);
		}		
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
	
	
	public void add(int val) {
		Node node= new Node (val);
		if(head==null) {
			head=node;
			tail=node;
		}else {
			tail.next=node;
			node.prev=tail;
			tail=node;
		}
		size++;
	}
	
	
	  
	@Override
	public String toString() {
		HashSet<Node> set= new HashSet();
		StringBuilder res= new StringBuilder("[");
		Node temp = head;
		if(temp==null) {
			return null;
		}
		boolean isCycle = false;
		while(temp.next!=null) {
			if(set.contains(temp)) {
				isCycle=true;
				break;
			}else {
				set.add(temp);
				res.append(temp.val+", ");
			}
			temp=temp.next;
		}
		if(isCycle) {
			res.setCharAt(res.length()-1,']');
		}else {
			res.append(temp.val).append(']');			
		}
		return res.toString();
	}


	public  boolean equals( Node lst) {
		 Node l1=head;
		 Node l2=lst;
		
		while(l1 != null && l2!= null) {
			if(l1.val!=l2.val) {
				return false;
			}
			l1=l1.next;
			l2=l2.next;
		}
		
		return l1==null && l2 ==null;
	}
	public  boolean equals(MDLL lst) {
	     Node l1=head;
		 Node l2=lst.getHead();
		
		while(l1 != null && l2!= null) {
			if(l1.val!=l2.val) {
				return false;
			}
			l1=l1.next;
			l2=l2.next;
		}
		
		return l1==null && l2 ==null;
	}
	public static  boolean equals( Node lst1, Node lst2) {
		 Node l1=lst1;
		 Node l2=lst2;
		
		while(l1 != null && l2!= null) {
			if(l1.val!=l2.val) {
				return false;
			}
			l1=l1.next;
			l2=l2.next;
		}
		
		return l1==null && l2 ==null;
	}
	
}
