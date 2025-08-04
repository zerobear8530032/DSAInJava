//530. Minimum Absolute Difference in BST
//Solved
//Easy
//Topics
//premium lock icon
//Companies
//Given the root of a Binary Search Tree (BST), return the minimum absolute difference between the values of any two different nodes in the tree.
//
// 
//
//Example 1:
//
//
//Input: root = [4,2,6,1,3]
//Output: 1
//Example 2:
//
//
//Input: root = [1,0,48,null,null,12,49]
//Output: 1
// 
//
//Constraints:
//
//The number of nodes in the tree is in the range [2, 104].
//0 <= Node.val <= 105
// 
//
//Note: This question is the same as 783: https://leetcode.com/problems/minimum-distance-between-bst-nodes/
package Tree;

import TreeUtil.TreeNode;

public class MinimumAbsoluteDifferenceInBST_530 {
	
	    static Integer prev = null;
	    static int minDiff = Integer.MAX_VALUE;

	    public static int getMinimumDifference(TreeNode root) {
	    	prev=null;
	    	minDiff= Integer.MAX_VALUE;
	        inOrder(root);
	        return minDiff;
	    }

	    private static void inOrder(TreeNode node) {
	        if (node == null) return;

	        inOrder(node.left);

	        if (prev != null) {
	            minDiff = Math.min(minDiff, Math.abs(node.val - prev));
	        }
	        prev = node.val;

	        inOrder(node.right);
	    }


	public static void main(String[] args) {
		
		
		//Example 1:

		TreeNode root1 =  new TreeNode(4);
		root1.left= new TreeNode(2);
		root1.right= new TreeNode(6);
		root1.left.left= new TreeNode(1);
		root1.left.right= new TreeNode(3);
		int output1=1;
		
		//Example 2:
		TreeNode root2 =  new TreeNode(1);
		root2.left= new TreeNode(0);
		root2.right= new TreeNode(48);
		root1.right.left= new TreeNode(12);
		root1.right.right= new TreeNode(39);
		int output2=1;
		
		
		int ans1 = getMinimumDifference(root1);
		int ans2 = getMinimumDifference(root2);
		
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
