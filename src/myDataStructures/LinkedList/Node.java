package myDataStructures.LinkedList;

public class Node{
	int value;
	Node next;
	
	public Node() {
		this.next=null;
		this.value=0;
	}
	public Node(int v) {
		this.next=null;
		this.value=v;
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
	
	
}