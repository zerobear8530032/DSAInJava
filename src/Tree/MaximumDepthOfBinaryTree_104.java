//104. Maximum Depth of Binary Tree
//Solved
//Easy
//Topics
//premium lock icon
//Companies
//Given the root of a binary tree, return its maximum depth.
//
//A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
//
// 
//
//Example 1:
//
//
//Input: root = [3,9,20,null,null,15,7]
//Output: 3
//Example 2:
//
//Input: root = [1,null,2]
//Output: 2
// 
//
//Constraints:
//
//The number of nodes in the tree is in the range [0, 104].
//-100 <= Node.val <= 100

package Tree;

import TreeUtil.TreeNode;

public class MaximumDepthOfBinaryTree_104 {

//	use a helper function in dfs and check every node 
//	compare the depth of left side and right side and return the max of both
//	time complexity :O(n)
//	space complexity :O(1)
	
	public static int maxDepth(TreeNode root) {
        return helper(root,0);
    }
    public static int helper(TreeNode root,int depth){
        if(root==null){
            return depth;
        }
        int l = helper(root.left,depth+1);
        int r = helper(root.right,depth+1);
        return Math.max(l,r);
    }
	public static void main(String[] args) {

		//Example 1:
	
		TreeNode root1 = new TreeNode(3);
		root1.left= new TreeNode(9);
		root1.right= new TreeNode(20);
		root1.right.left= new TreeNode(15);
		root1.right.right= new TreeNode(7);
		int output1= 3;
				
		//Example 2:

		TreeNode root2 = new TreeNode(1);
		root2.right= new TreeNode(2);
		int output2= 2;
		
    	int ans1 =maxDepth(root1);
    	int ans2 =maxDepth(root2);	
		
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
