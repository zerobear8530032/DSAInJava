//111. Minimum Depth of Binary Tree
//Solved
//Easy
//Topics
//premium lock icon
//Companies
//Given a binary tree, find its minimum depth.
//
//The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
//
//Note: A leaf is a node with no children.
//
// 
//
//Example 1:
//
//
//Input: root = [3,9,20,null,null,15,7]
//Output: 2
//Example 2:
//
//Input: root = [2,null,3,null,4,null,5,null,6]
//Output: 5
// 
//
//Constraints:
//
//The number of nodes in the tree is in the range [0, 105].
//-1000 <= Node.val <= 1000

package Tree;

import TreeUtil.TreeNode;

public class MinimumDepthOfBinaryTree_111 {
	
//	approch :
//	here we will get min depth by calculating the min height of left sub tree and right subtree
//	using bottom up approch but if the left subtree or right subtree is null we will take the max of left 
//	and  right the other side might be the  only height
//	time complexity :O(n)
// space complexity :O(n)
	  public static int minDepth(TreeNode root) {
	        if(root==null){
	            return 0;
	        } 
	        int left = minDepth(root.left);
	        int right = minDepth(root.right);

	        if(root.left==null || root.right==null){
	            return Math.max(left,right)+1;
	        }

	        return Math.min(left,right)+1;        
	    }

	public static void main(String[] args) {
		
		//Example 1:
		
		TreeNode root1 = new TreeNode(3);
		root1.left= new TreeNode(9);
		root1.right= new TreeNode(20);
		
		root1.right.left= new TreeNode(15);
		root1.right.right= new TreeNode(7);
		
		int output1=2;

		//Example 2:

		TreeNode root2 = new TreeNode(2);
		root2.right= new TreeNode(3);		
		root2.right.right= new TreeNode(4);
		root2.right.right.right= new TreeNode(5);
		root2.right.right.right.right= new TreeNode(6);
		
		int output2=5;
		
		
		int ans1= minDepth(root1);
		int ans2= minDepth(root2);
		
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
