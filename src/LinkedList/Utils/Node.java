package LinkedList.Utils;

import java.util.HashSet;

public class Node {
	int val;
	public Node next;
	public Node prev;
	public Node child;
	
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
	public Node getChild() {
		return child;
	}
	public void setChild(Node child) {
		this.child = child;
	}
	
	public Node() {
	}
	
	public Node(int val, Node next, Node prev, Node child) {
		this.val = val;
		this.next = next;
		this.prev = prev;
		this.child = child;
	}
	
	
	public Node(int val) {
		this.val=val;
	}
	
	
	
	
	
	@Override
	public String toString() {
		 StringBuilder res= new StringBuilder("[");
		 Node temp = this;
		 HashSet<Node> set= new HashSet();
		 boolean addlast=true;
		 while(temp.next!=null) {
			 if(set.contains(temp)) {
				 addlast=false;
				 break;
			 }else {
				 set.add(temp);
			 }
			 res.append(temp.val).append(",");
			 temp=temp.next;
		 }
		 if(addlast) {
			 
		 res.append(temp.val);
		 res.append("]");
		 }else {
			 res.setCharAt(res.length()-1, ']');
		 }
		 return res.toString();
	}
}
