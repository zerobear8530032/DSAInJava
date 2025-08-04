package TreeUtil;

import java.util.ArrayList;
import java.util.List;

public class AVL {
	class Node {
		int val ;
		Node left;
		Node right;
		int  height;
		public Node() {
			// TODO Auto-generated constructor stub
		}
		public Node(int val ) {
			// TODO Auto-generated constructor stu
			this.val=val;
		}
		public Node(int val , Node left , Node right) {
			// TODO Auto-generated constructor stu
			this.val=val;
			this.left=left;
			this.right=right;
		}
		public int getVal() {
			return val;
		}
		public void setVal(int val) {
			this.val = val;
		}
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
		public int getheight() {
			return height;
		}
		public void setHeight(int  height) {
			this.height = height;
		}
		
		
	}
	
	Node root ;
	public AVL() {
	}
	
	public boolean isEmpty() {
		return root==null;
	}
	
	public int getHeight(Node node) {
		if(node==null) {
			return -1;
		}
		return node.height;
	}
	
	public void insert(int val) {
		root=insert(this.root,val);
	}
	private Node insert(Node root,int val) {
		if(root==null) {
			return new Node(val);
		}
		if(val<root.val) {
			root.left=insert(root.left,val);
		}
		if(val>root.val) {
			root.right=insert(root.right,val);
		}
		
		root.height=Math.max(getHeight(root.left),getHeight(root.right))+1;
		
		return rotate(root);
		
	}
	
	public boolean isBalanced() {
		return isBalanced(root);
	}
	
	private boolean isBalanced(Node root) {
		if(root==null) {
			return true;
		}
		return Math.abs(getHeight(root.left)-getHeight(root.right))<=1 && isBalanced(root.left) && isBalanced(root.right);
	}
	public void display() {
		display(this.root, "Root Node : ");
	}
	
	public void display(Node root, String detail) {
		if(root==null) {
			return ;
		}
		System.out.println(detail+root.getVal());
		display(root.left, "Left Child of "+root.getVal()+" : ");
		display(root.right, "Right Child of "+root.getVal()+" : ");
	}
	
	
	public AVL(int ...elements) {
		for(int x: elements) {
			this.insert(x);
		}
	}
	
	public List<Integer> inorder(){
		List<Integer> res= new ArrayList();
		inorder(root,res);
		return res;
	}
	public List<Integer> preorder(){
		List<Integer> res= new ArrayList();
		preorder(root,res);
		return res;
	}
	public List<Integer> postorder(){
		List<Integer> res= new ArrayList();
		postorder(root,res);
		return res;
	}
	
	private void preorder(Node root, List<Integer> res) {
		if(root==null) {
			return ;
		}
		res.add(root.val);
		preorder(root.left,res);
		preorder(root.right,res);
	}
	private void inorder(Node root, List<Integer> res) {
		if(root==null) {
			return ;
		}
		inorder(root.left,res);
		res.add(root.val);
		inorder(root.right,res);
	}
	
	
	private void postorder(Node root, List<Integer> res) {
		if(root==null) {
			return ;
		}
		postorder(root.left,res);
		postorder(root.right,res);
		res.add(root.val);
	}

//	balacing code for rotations :
	private Node rotate(Node node) {
		//		left heavy case 
		if(getHeight(node.left)-getHeight(node.right)>1) {
			if(getHeight(node.left.left)-getHeight(node.left.right)>0) {
		//		left left case		
				return rightRotate(node);
			}
			if(getHeight(node.left.left)-getHeight(node.left.right)<0) {
		//		left right case		
				node.left=leftRotate(node.left);
				return rightRotate(node);
			}
		}
		//		right Heavy case
		if(getHeight(node.left)-getHeight(node.right)<-1) {
			if(getHeight(node.right.left)-getHeight(node.right.right)<0) {
		//		right right case		
				return leftRotate(node);
			}
			if(getHeight(node.right.left)-getHeight(node.right.right)>0) {
		//		right left case		
				node.right=rightRotate(node.right);
				return leftRotate(node);
			}
		}
	
		return node;
	}
	
	
	public Node rightRotate(Node p) {
		Node c = p.left;
		Node t= c.right;
		c.right= p;
		p.left=t;
		
		p.height= Math.max(getHeight(p.left),getHeight(p.right))+1;
		c.height= Math.max(getHeight(c.left),getHeight(c.right))+1;
		return c;
	}
	public Node leftRotate(Node c) {
		Node p = c.right;
		Node t= p.left;
		
		p.left=c;
		c.right=t;
		
		c.height= Math.max(getHeight(c.left),getHeight(c.right))+1;
		p.height= Math.max(getHeight(p.left),getHeight(p.right))+1;
		return p;
	}
	
}
