package TreeUtil;

public class Node {
	
	public Node left;
	public Node right;
	public Node next;
	public int val;
	public Node getLeft() {
		return left;
	}
	public void setLeft(Node left) {
		this.left = left;
	}
	public Node getRight() {
		return right;
	}
	public void setRight(Node right) {
		this.right = right;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	public int getVal() {
		return val;
	}
	public void setVal(int val) {
		this.val = val;
	}
	
	public Node() {
		// TODO Auto-generated constructor stub
	}
	public Node(int val) {
		this.val=val;
	}
	public Node(Node left, Node right, Node next, int val) {
		super();
		this.left = left;
		this.right = right;
		this.next = next;
		this.val = val;
	}
	

}
