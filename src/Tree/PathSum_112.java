//112. Path Sum
//Attempted
//Easy
//Topics
//premium lock icon
//Companies
//Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.
//
//A leaf is a node with no children.
//
// 
//
//Example 1:
//
//
//Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
//Output: true
//Explanation: The root-to-leaf path with the target sum is shown.
//Example 2:
//
//
//Input: root = [1,2,3], targetSum = 5
//Output: false
//Explanation: There are two root-to-leaf paths in the tree:
//(1 --> 2): The sum is 3.
//(1 --> 3): The sum is 4.
//There is no root-to-leaf path with sum = 5.
//Example 3:
//
//Input: root = [], targetSum = 0
//Output: false
//Explanation: Since the tree is empty, there are no root-to-leaf paths.
// 
//
//Constraints:
//
//The number of nodes in the tree is in the range [0, 5000].
//-1000 <= Node.val <= 1000
//-1000 <= targetSum <= 1000

package Tree;

import TreeUtil.TreeNode;

public class PathSum_112 {
	
//	approch : here we will check targetsum-rootval ==0 and the current node is a root
//	we will return true; and we cna recursively check for each subtree
//	and return left || right
//	time complexity :O(n)
//	space complexity :O(1)
	
	 public static boolean hasPathSum(TreeNode root, int targetSum) {
	        if(root==null){
	            return false;
	        }
	        
	        if(targetSum-root.val==0 && isLeaf(root)){
	            return true;
	        }

	        boolean left= hasPathSum(root.left,targetSum-root.val);
	        boolean right= hasPathSum(root.right,targetSum-root.val);
	        return left  || right;
	    }

//	 time complexity :O(1)
//	 space complexity :O(1)
	    public static boolean isLeaf(TreeNode node){
	        return node.left==null && node.right==null;
	    }

	public static void main(String[] args) {
		
//		Example 1 :
		
		TreeNode root1 = new TreeNode(5);
		root1.left= new TreeNode(4);
		root1.left.left= new TreeNode(11);
		root1.left.left.left= new TreeNode(7);
		root1.left.left.right= new TreeNode(2);
		boolean output1= true;
		
		root1.right= new TreeNode(8);
		root1.right.left= new TreeNode(13);
		root1.right.right= new TreeNode(4);
		root1.right.right.right= new TreeNode(1);
		int targetSum1= 22;
		
		
//		Example 2 :
		
		TreeNode root2 = new TreeNode(1);
		root2.left= new TreeNode(2);
		root2.right= new TreeNode(8);
		int targetSum2=5;
		boolean output2= false;
		
//		Example 3 :
		
		TreeNode root3 = new TreeNode(1);
		root3.left= new TreeNode(2);
		int targetSum3=1;
		boolean output3= false;
		

//		Example 4 :
		
		TreeNode root4=null;
		int targetSum4=0;
		boolean output4= false;
		
		boolean ans1 = hasPathSum(root1, targetSum1);
		boolean ans2 = hasPathSum(root2, targetSum2);
		boolean ans3 = hasPathSum(root3, targetSum3);
		boolean ans4 = hasPathSum(root4, targetSum4);
		
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
		if(ans4==output4) {
			System.out.println("Case 4 Passed");
		}else {
			System.out.println("Case 4 Failed");
			System.out.println("Actual Output :"+output4);
			System.out.println("Your Output :"+ans4);
		}

		
		
	}

}
