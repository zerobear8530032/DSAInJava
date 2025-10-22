//98. Validate Binary Search Tree
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Given the root of a binary tree, determine if it is a valid binary search tree (BST).
//
//A valid BST is defined as follows:
//
//The left subtree of a node contains only nodes with keys strictly less than the node's key.
//The right subtree of a node contains only nodes with keys strictly greater than the node's key.
//Both the left and right subtrees must also be binary search trees.
// 
//
//Example 1:
//
//
//Input: root = [2,1,3]
//Output: true
//Example 2:
//
//
//Input: root = [5,1,4,null,null,3,6]
//Output: false
//Explanation: The root node's value is 5 but its right child's value is 4.
// 
//
//Constraints:
//
//The number of nodes in the tree is in the range [1, 104].
//-231 <= Node.val <= 231 - 1

package Tree;

import java.util.ArrayList;
import java.util.List;

import TreeUtil.TreeNode;

public class ValidateBinarySearchTree_98 {
	
//	approch :
//	here we traverse a tree and find at each node the left sub tree have all values less then root
//	and right subtree have all node greater the root
//	time complexity :O(n*n)-> each node get checked
//	space complexity :O(n) : the max a recursin depth will be 2* height of a tree
	
	  public static boolean isValidBSTBruteForce(TreeNode root) {
	        if(root==null){
	            return true;
	        }
	        boolean left =isValidBSTBruteForce(root.left);
	        if(!(isValidLeft(root.left,root.val) && isValidRight(root.right,root.val))){
	            return false;
	        }
	        boolean right =isValidBSTBruteForce(root.right);
	        return left && right;
	    }

	    public static boolean isValidLeft(TreeNode node, int val){
	        if(node==null){
	            return true;
	        }
	        boolean left=isValidLeft(node.left,val);
	        if(node.val>=val){
	            return false;
	        }
	        boolean right=isValidLeft(node.right,val);
	        return left && right;
	    }
	    public static boolean isValidRight(TreeNode node, int val){
	        if(node==null){
	            return true;
	        }
	        boolean left=isValidRight(node.left,val);
	        if(node.val<=val){
	            return false;
	        }
	        boolean right=isValidRight(node.right,val);
	        return left && right;
	    }
	
//	approch :
//	if we traverse inorder  a binary tree it give sorted order of node 
//	so we can get all node values as list and check 
//	its strict ascending or nodt
//	time complexity :O(n)
//	space complexity :O(n) -> call stack , node list space
	  public static boolean isValidBSTBetter(TreeNode root) {
	        List<Integer> tree= new ArrayList<Integer>();
	        inOrderBetter(root,tree);
	        return validate(tree);
	    }
	    public static void inOrderBetter(TreeNode node, List<Integer> treenodes){
	        if(node==null){
	            return ;
	        }
	        inOrderBetter(node.left,treenodes);
	        treenodes.add(node.val);
	        inOrderBetter(node.right,treenodes);
	    }

	    public static boolean validate(List<Integer> tree){
	        for(int i =0;i<tree.size()-1;i++){
	            if(tree.get(i)>=tree.get(i+1)){
	                return false;
	            }
	        }
	        return true;
	    }

	
	
//	best approch :
//	here we use a prev pointer which hold the previous visited node
//	then we can do inorder traversal and check if the current  node is smaller then 
//	prev node means its not a valid bst because the bst inorder traversal is always sorted order
//	time compleixyty :O(n)
//	space compleixyty :O(n) -> only call stack space
	  static TreeNode prev;
	    public static boolean isValidBSTBest(TreeNode root) {
	        prev=null;  
	        return inOrderBest(root);
	    }
	    public static boolean inOrderBest(TreeNode node) {
            if (node == null) {
                return true;
            }
            boolean left = inOrderBest(node.left);
            if (prev != null && prev.val >= node.val) {
                return false;
            }
            prev = node;
            boolean right = inOrderBest(node.right);
            return left && right;
        }

//        Approch : here we can use pre -order traversal where we keep a range of number the node should be initialy no range can be define
//              but if we check left side we can check the upper limit should be less then previos node
//          similarly on right side we can do in right side where lower limiit is the previouse node
//	time compleixyty :O(n)
//	space compleixyty :O(n) -> only call stack space
    public static boolean isValidBSTRecursion(TreeNode root) {
        return helper(root, null,null);
    }

    public static boolean helper(TreeNode node , Integer low, Integer high){
        if(node==null){
            return true;
        }
        if(low!=null && low>=node.val){
            return false;
        }
        if(high!=null && high<=node.val){
            return false;
        }
        boolean leftside= helper(node.left,low,node.val);
        boolean rightside= helper(node.right,node.val,high);
        return leftside && rightside;
    }

	public static void main(String[] args) {
		
		//Example 1:

		TreeNode  root1 =  new TreeNode(2);
		root1.left= new TreeNode(1);
		root1.right= new TreeNode(3);
		boolean output1= true;
		

		//Example 2:

		TreeNode  root2 =  new TreeNode(5);
		root2.left= new TreeNode(1);
		root2.right= new TreeNode(4);
		root2.right.left= new TreeNode(3);
		root2.right.right= new TreeNode(6);
		boolean output2= false;
	
		System.out.println("Brute Force Approch :");
		
		boolean ans1= isValidBSTBruteForce(root1);
		boolean ans2= isValidBSTBruteForce(root2);

		
		if(ans1==output1) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Actual Output :"+output1 );
			System.out.println("Your Output :"+ans1);
		}
		if(ans2==output2) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Actual Output :"+output2 );
			System.out.println("Your Output :"+ans2);
		}
		
		System.out.println("Better approch : ");
		
		ans1= isValidBSTBetter(root1);
		ans2= isValidBSTBetter(root2);
		
		
		if(ans1==output1) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Actual Output :"+output1 );
			System.out.println("Your Output :"+ans1);
		}
		if(ans2==output2) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Actual Output :"+output2 );
			System.out.println("Your Output :"+ans2);
		}
		

		System.out.println("Best Recursion Approch : ");
		
		ans1= isValidBSTRecursion(root1);
		ans2= isValidBSTRecursion(root2);
		
		
		if(ans1==output1) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Actual Output :"+output1 );
			System.out.println("Your Output :"+ans1);
		}
		if(ans2==output2) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Actual Output :"+output2 );
			System.out.println("Your Output :"+ans2);
		}

	}

}
