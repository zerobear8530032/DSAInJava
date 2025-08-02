//144. Binary Tree Preorder Traversal
//Solved
//Easy
//Topics
//premium lock icon
//Companies
//Given the root of a binary tree, return the preorder traversal of its nodes' values.
//
//Example 1:
//
//Input: root = [1,null,2,3]
//
//Output: [1,2,3]
//
//Explanation:
//
//
//
//Example 2:
//
//Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]
//
//Output: [1,2,4,5,6,7,3,8,9]
//
//Explanation:
//
//
//
//Example 3:
//
//Input: root = []
//
//Output: []
//
//Example 4:
//
//Input: root = [1]
//
//Output: [1]
//
// 
//
//Constraints:
//
//The number of nodes in the tree is in the range [0, 100].
//-100 <= Node.val <= 100
// 
//
//Follow up: Recursive solution is trivial, could you do it iteratively?

package Tree;

import TreeUtil.TreeNode;
import  java.util.*;
public class BinaryTreePreorderTraversal_144 {
//	approch : just follow sequence process the root  then left then right
//	time complexity:O(n)
//	space complexity:O(n)
	
	 	public static List<Integer> preorderTraversalRecursive(TreeNode root) {
	        List<Integer> res = new ArrayList();
	        dfs(root,res);
	        return res;
	    }

	    public static  void dfs(TreeNode root,List<Integer> res){
	        if(root==null){return ;}
	        res.add(root.val);
	        dfs(root.left,res);
	        dfs(root.right,res);
	    }
//	    approch is same just iterative using stack 
//		time complexity:O(n)
//		space complexity:O(n)
		    
	 	public static List<Integer> preorderTraversalIterative(TreeNode root) {
	 		Stack<TreeNode> stk = new Stack();
	 		List<Integer> res= new ArrayList();
	 		while(!stk.isEmpty() || root!=null) {
	 			
	 			while(root!=null) {
	 				res.add(root.val);
	 				stk.push(root);
	 				root=root.left;
	 			}
	 			if(stk.isEmpty()) {
	 				break;
	 			}
	 			TreeNode poped = stk.pop();
	 			root=poped.right;
	 		}
	 		return res;
	    }


	public static void main(String[] args) {
		
		//Example 1:

		TreeNode root1 = new TreeNode (1);
		root1.right= new TreeNode(2);
		root1.right.left= new TreeNode(3);
		List<Integer> output1= new ArrayList(Arrays.asList(1,2,3));
		
		//Example 2:

		TreeNode root2 = new TreeNode (1);
		root2.left= new TreeNode(2);
		root2.right= new TreeNode(3);
		
		root2.left.left = new TreeNode(4);
		root2.left.right = new TreeNode(5);
		
		root2.right.right= new TreeNode(8);
		
		root2.left.right.left = new TreeNode(6);
		root2.left.right.right= new TreeNode(7);
		
		root2.right.right.left= new TreeNode(9);
		
		List<Integer> output2= new ArrayList(Arrays.asList(1,2,4,5,6,7,3,8,9));
		
		//Example 3:

		TreeNode root3 =null;
		List<Integer> output3= new ArrayList();

		//Example 4:

		TreeNode root4 =new TreeNode(1);
		List<Integer> output4= new ArrayList(Arrays.asList(1));
		
		
		System.out.println("Recursive Approch :");
		
		List<Integer> ans1 = preorderTraversalRecursive(root1);
		List<Integer> ans2 = preorderTraversalRecursive(root2);
		List<Integer> ans3 = preorderTraversalRecursive(root3);
		List<Integer> ans4 = preorderTraversalRecursive(root4);
		
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
		if(ans3.equals(output3)) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Actual Output :"+output3);
			System.out.println("Your Output :"+ans3);
		}
		if(ans4.equals(output4)) {
			System.out.println("Case 4 Passed");
		}else {
			System.out.println("Case 4 Failed");
			System.out.println("Actual Output :"+output4);
			System.out.println("Your Output :"+ans4);
		}
		
		System.out.println("Iterative Approch :");
		ans1 = preorderTraversalIterative(root1);
		ans2 = preorderTraversalIterative(root2);
		ans3 = preorderTraversalIterative(root3);
		ans4 = preorderTraversalIterative(root4);
		
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
		if(ans3.equals(output3)) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Actual Output :"+output3);
			System.out.println("Your Output :"+ans3);
		}
		if(ans4.equals(output4)) {
			System.out.println("Case 4 Passed");
		}else {
			System.out.println("Case 4 Failed");
			System.out.println("Actual Output :"+output4);
			System.out.println("Your Output :"+ans4);
		}
		
		
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
