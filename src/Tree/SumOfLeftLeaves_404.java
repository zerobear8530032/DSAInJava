//404. Sum of Left Leaves
//Solved
//Easy
//Topics
//premium lock icon
//Companies
//Given the root of a binary tree, return the sum of all left leaves.
//
//A leaf is a node with no children. A left leaf is a leaf that is the left child of another node.
//
// 
//
//Example 1:
//
//
//Input: root = [3,9,20,null,null,15,7]
//Output: 24
//Explanation: There are two left leaves in the binary tree, with values 9 and 15 respectively.
//Example 2:
//
//Input: root = [1]
//Output: 0
// 
//
//Constraints:
//
//The number of nodes in the tree is in the range [1, 1000].
//-1000 <= Node.val <= 1000

package Tree;

import TreeUtil.BinaryTree;
import TreeUtil.TreeNode;

public class SumOfLeftLeaves_404 {
//	approch :
//	we will just pass a character to find its a left or right node 
//	and check if this is leaf or not
//	as last we will reutnr sum of left and right sub tree 
//	time complexity : O(n)
//	space complexity : O(n)
	 public static int sumOfLeftLeaves(TreeNode root) {
	        return dfs(root, 'R');
	    }

	    private static int dfs(TreeNode node, char dir) {
	        if (node == null) return 0;

	        if (isLeaf(node) && dir == 'L') return node.val;

	        return dfs(node.left, 'L') + dfs(node.right, 'R');
	    }

	    private static boolean isLeaf(TreeNode node) {
	        return node.left == null && node.right == null;
	    }

	public static void main(String[] args) {
		
		
		//Example 1:

        BinaryTree root1 = new BinaryTree(3,9,20,null,null,15,7);
		int output1= 24;
		
		//Example 2:

        BinaryTree root2 =new BinaryTree(1);
		int output2= 0;
		
		//Example 3:

        BinaryTree root3 =new BinaryTree(1,2,3,4,5);
		int output3=4;
		
		
		int ans1 = sumOfLeftLeaves(root1.getRoot());
		int ans2 = sumOfLeftLeaves(root2.getRoot());
		int ans3 = sumOfLeftLeaves(root3.getRoot());
		
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
