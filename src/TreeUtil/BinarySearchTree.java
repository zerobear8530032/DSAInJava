package TreeUtil;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

import TreeUtil.AVL.Node;

public class BinarySearchTree {
	BSTNode root;
	public BinarySearchTree() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean isEmpty() {
		return root==null;
	}
	
	public int getHeight(BSTNode node) {
		if(node==null) {
			return -1;
		}
		return node.height;
	}
	
	public void insert(int val) {
		root=insert(this.root,val);
	}
	private BSTNode insert(BSTNode root,int val) {
		if(root==null) {
			return new BSTNode(val);
		}
		if(val<root.val) {
			root.left=insert(root.left,val);
		}
		if(val>root.val) {
			root.right=insert(root.right,val);
		}
		
		root.height=Math.max(getHeight(root.left),getHeight(root.right))+1;
		
		return root;
		
	}
	
	public boolean isBalanced() {
		return isBalanced(root);
	}
	
	private boolean isBalanced(BSTNode root) {
		if(root==null) {
			return true;
		}
		return Math.abs(getHeight(root.left)-getHeight(root.right))<=1 && isBalanced(root.left) && isBalanced(root.right);
	}
	public void display() {
		display(this.root, "Root Node : ");
	}
	
	public void display(BSTNode root, String detail) {
		if(root==null) {
			return ;
		}
		System.out.println(detail+root.getVal());
		display(root.left, "Left Child of "+root.getVal()+" : ");
		display(root.right, "Right Child of "+root.getVal()+" : ");
	}
	
	
	public BinarySearchTree(int ...elements) {
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
	
	private void preorder(BSTNode root, List<Integer> res) {
		if(root==null) {
			return ;
		}
		res.add(root.val);
		preorder(root.left,res);
		preorder(root.right,res);
	}
	private void inorder(BSTNode root, List<Integer> res) {
		if(root==null) {
			return ;
		}
		inorder(root.left,res);
		res.add(root.val);
		inorder(root.right,res);
	}
	
	
	private void postorder(BSTNode root, List<Integer> res) {
		if(root==null) {
			return ;
		}
		postorder(root.left,res);
		postorder(root.right,res);
		res.add(root.val);
	}
	
	
	public void BreadthFirstTraversal() {
		BreadthFirstTraversal(this.root);
	}
	
	private void BreadthFirstTraversal(BSTNode root) {
		if(root==null) {
			System.out.println("[]");
			return ;
		}
		
		System.out.print("[");
		ArrayDeque<BSTNode> queue = new ArrayDeque();
		queue.add(root);
		while(!queue.isEmpty()) {
			BSTNode poped = queue.remove();
			System.out.print(poped.val+", ");
			if(poped.left!=null) {
				queue.add(poped.left);
			}
			if(poped.right!=null) {
				queue.add(poped.right);
			}
		}
		System.out.print("]");
		System.out.println();
	}
	 
	
}
