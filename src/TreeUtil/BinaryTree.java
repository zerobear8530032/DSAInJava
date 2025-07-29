package TreeUtil;

import java.util.Scanner;

public class BinaryTree {
	
	private TreeNode root;
	public BinaryTree() {
	}
	
	
	public TreeNode getRoot() {
		return root;
	}
	public void setRoot(TreeNode root) {
		this.root = root;
	}
	public void populate(Scanner sc) {
		
		System.out.println("Enter the Root Node Value :");
		int rootval = sc.nextInt();
		root =new TreeNode(rootval);
		populate(sc, root);
	}
	private void populate(Scanner sc , TreeNode root) {
		System.out.println("you want to enter Element Left of :"+root.val);
		boolean left= sc.nextBoolean();
		if(left) {
			System.out.println("Enter the Value of the Node Left of :"+root.val);
			int leftval = sc.nextInt();
			root.left= new TreeNode(leftval);
			System.out.println("Node inserted ");
			populate(sc,root.left);
		}
		System.out.println("you want to enter Element Right of :"+root.val);
		boolean right= sc.nextBoolean();
		if(right) {
			System.out.println("Enter the Value of the Node Right of :"+root.val);
			int rightval = sc.nextInt();
			root.right= new TreeNode(rightval);
			System.out.println("Node inserted ");
			populate(sc,root.right);
		}
	}
	
	public void display() {
		display(this.root);
		System.out.println();
	}
	private void display(TreeNode root) {
		if(root==null) {
			return ;
		}
		System.out.print(root.val+" ");
		display(root.left);
		display(root.right);
	}
	
	public void prettyDisplay() {
		prettyDisplay(this.root,0);
	}
	private void prettyDisplay(TreeNode root,int level) {
		if(root==null) {
			return ;
		}
		prettyDisplay(root.right,level+1);
		if(level!=0) {
			for(int i =0;i<level-1;i++) {
				System.out.print("|\t\t");
			}
			System.out.println("|---->"+root.val);			
		}else {
			System.out.println(root.val);			
		}
		prettyDisplay(root.left,level+1);
		
	}
	
	
	

}
