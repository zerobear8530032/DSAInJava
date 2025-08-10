//993. Cousins in Binary Tree
//Solved
//Easy
//Topics
//premium lock icon
//Companies
//Given the root of a binary tree with unique values and the values of two different nodes of the tree x and y, return true if the nodes corresponding to the values x and y in the tree are cousins, or false otherwise.
//
//Two nodes of a binary tree are cousins if they have the same depth with different parents.
//
//Note that in a binary tree, the root node is at the depth 0, and children of each depth k node are at the depth k + 1.
//
// 
//
//Example 1:
//
//
//Input: root = [1,2,3,4], x = 4, y = 3
//Output: false
//Example 2:
//
//
//Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
//Output: true
//Example 3:
//
//
//Input: root = [1,2,3,null,4], x = 2, y = 3
//Output: false
// 
//
//Constraints:
//
//The number of nodes in the tree is in the range [2, 100].
//1 <= Node.val <= 100
//Each node has a unique value.
//x != y
//x and y are exist in the tree.


package Tree;

import java.util.ArrayList;
import java.util.Arrays;

import TreeUtil.BinaryTree;
import TreeUtil.Tree;
import TreeUtil.TreeNode;

public class CousinsInBinaryTree_993 {
	 public static boolean isCousins(TreeNode root, int x, int y) {
	        TreeNode nodex= getNode(root, x);
	        TreeNode nodey= getNode(root, y);
	        return (level(root,nodex,0)==level(root,nodey,0) &&(!isSibling(root,nodex,nodey)));
	    }

	    public static TreeNode getNode(TreeNode node, int x){
	        if(node==null){
	            return null;
	        }
	        if(node.val==x){
	            return node;
	        }
	        TreeNode ans=null;
	        TreeNode left = getNode(node.left,x);
	        if(left!=null){
	            ans=left;
	        }
	        TreeNode right = getNode(node.right,x);
	        if(right!=null){
	            ans=right;
	        }
	        return ans;
	    }

	    public static int level(TreeNode root, TreeNode nodex, int depth){
	        if(root==null){
	            return -1;
	        }
	        if(root==nodex){
	            return depth;
	        }
	        int  left = level(root.left,nodex,depth+1);
	        int  right = level(root.right,nodex,depth+1);
	        return Math.max(left,right);
	    }

	    public static boolean isSibling(TreeNode root, TreeNode nodex, TreeNode nodey){
	        if(root==null){return false;}
	        if((root.left==nodex && root.right==nodey)||(root.left==nodey && root.right==nodex)){
	            return true;
	        }
	        boolean left = isSibling(root.left,nodex,nodey);
	        boolean right = isSibling(root.right,nodex,nodey);
	        return left || right;
	    }

	public static void main(String[] args) {
		//Example 1:

		BinaryTree root1 = new BinaryTree((Arrays.asList(1,2,3,4)));
		int x1 = 4, y1 = 3;
		boolean output1= false;
		
		//Example 2:

		BinaryTree root2 = new BinaryTree(Arrays.asList(1,2,3,null,4,null,5));
		int x2 = 5, y2 = 4;
		boolean output2= true;
		
		//Example 3:

		BinaryTree root3 = new BinaryTree(Arrays.asList(1,2,3,null,4));
		int x3 = 2, y3 = 3;
		boolean output3= false;
		
		boolean ans1 = isCousins(root1.getRoot(), x1, y1);
		boolean ans2 = isCousins(root2.getRoot(), x2, y2);
		boolean ans3 = isCousins(root3.getRoot(), x3, y3);
		
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
		if(ans3==output3) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Actual Output :"+output3);
			System.out.println("Your Output :"+ans3);
		}		
	}
}
