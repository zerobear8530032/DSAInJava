//226. Invert Binary Tree
//Solved
//Easy
//Topics
//premium lock icon
//Companies
//Given the root of a binary tree, invert the tree, and return its root.
//
// 
//
//Example 1:
//
//
//Input: root = [4,2,7,1,3,6,9]
//Output: [4,7,2,9,6,3,1]
//Example 2:
//
//
//Input: root = [2,1,3]
//Output: [2,3,1]
//Example 3:
//
//Input: root = []
//Output: []
// 
//
//Constraints:
//
//The number of nodes in the tree is in the range [0, 100].
//-100 <= Node.val <= 100
package Tree;

import TreeUtil.TreeNode;

public class InvertBinaryTree_226 {
	
//	approch 
//	we will explore left , right subtree first and  swap the left and right sub tree at each level
//	time complexity :O(n)
//	space complexity :O(n)
	  public static TreeNode invertTree(TreeNode root) {
	        if(root==null){
	            return null;
	        }

	        root.left= invertTree(root.left);
	        root.right= invertTree(root.right);


	        TreeNode temp = root.left;
	        root.left=root.right;
	        root.right=temp;
	        return root;
	    }
	  

	public static void main(String[] args) {
//		Example  1 :
		
		TreeNode root1 = new TreeNode(4);
		root1.left = new TreeNode(2);
		root1.right = new TreeNode(7);
		root1.left.left = new TreeNode(1);
		root1.left.right = new TreeNode(3);
		root1.right.left = new TreeNode(6);
		root1.right.right = new TreeNode(9);
		
		TreeNode output1 = new TreeNode(4);
		output1.left = new TreeNode(7);
		output1.right = new TreeNode(2);
		output1.left.left = new TreeNode(9);
		output1.left.right = new TreeNode(6);
		output1.right.left = new TreeNode(3);
		output1.right.right = new TreeNode(1);		
		
//		Example  2 :
		
		TreeNode root2 = new TreeNode(2);
		root2.left = new TreeNode(1);
		root2.right = new TreeNode(3);
		
		TreeNode output2=new TreeNode(2);
		output2.left = new TreeNode(3);
		output2.right = new TreeNode(1);
		
		
//		Example  3 :
		
		TreeNode root3= null;
		TreeNode output3=null;
		
		TreeNode ans1 = invertTree(root1);		
		TreeNode ans2 = invertTree(root2);		
		TreeNode ans3 = invertTree(root3);		
		
		
		if(ans1.equals(output1)) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Actual Output :"+output1 );
			System.out.println("Your Output :"+ans1);
		}
		if(ans2.equals(output2)) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Actual Output :"+output2 );
			System.out.println("Your Output :"+ans2);
		}
		if(ans3== output3 || ans3.equals(output3)) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Actual Output :"+output3);
			System.out.println("Your Output :"+ans3);
		}
	}
}
