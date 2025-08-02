//145. Binary Tree Postorder Traversal
//Solved
//Easy
//Topics
//premium lock icon
//Companies
//Given the root of a binary tree, return the postorder traversal of its nodes' values.
//
// 
//
//Example 1:
//
//Input: root = [1,null,2,3]
//
//Output: [3,2,1]
//
//Explanation:
//
//
//
//Example 2:
//
//Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]
//
//Output: [4,6,7,5,2,9,8,3,1]
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
//The number of the nodes in the tree is in the range [0, 100].
//-100 <= Node.val <= 100
// 
//
//Follow up: Recursive solution is trivial, could you do it iteratively?

package Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import TreeUtil.TreeNode;

public class BinaryTreePostorderTraversal_145 {
//	approch :
//	first process left then right after that root 
//	time complexity :O(n)
//	space complexity :O(n)
	public static List<Integer> postorderTraversalRecursive(TreeNode root) {
        List<Integer> res = new ArrayList();
	        dfs(root,res);
	        return res;
	    }

	    public static  void dfs(TreeNode root,List<Integer> res){
	        if(root==null){return ;}
	        dfs(root.left,res);
	        dfs(root.right,res);
	        res.add(root.val);
	    }

//	approch :
//	here we use the approch 
//	    where we use 2 stack one to maintain the node and one to weather it should be added iin
//	    res or not so we only add a  node if we visit it second time 
//	    so we will push root and a false in stacks
//	    and loop until stack is empty now
//	    we check if the node is not null iff true we will continue to next iteration
//	    other wise we  will push the value in the sequence we wana process
//	    so we wana process root at last so we push it first and visit will be true cause
//	    we have already visited root 1 time
//	    then we [ush right and false cause this is first time we seen right
//	    then we push left and false cause we first time see left
//	    so the next iteration the top node will remove
//	    if its not null and the next nodex will at at the result
//	    but if the return node is visited we can added it to our res 
//	time complexity :O(n)
//	space complexity :O(n)
	    public static List<Integer> postorderTraversalIterative(TreeNode root) {
	    	
	            Stack<TreeNode> stk = new Stack();
	            Stack<Boolean> visit = new Stack();
	            List<Integer> res = new ArrayList();
	            stk.push(root);
	            visit.push(false);
	            while (!stk.isEmpty()) {
	                TreeNode node = stk.pop();
	                boolean v = visit.pop();
	                if(node!=null) {      	
	                    if (v) {
	                        res.add(node.val);
	                    } else {// adding node in the sequence we wana process it will add in reverse cause its a stck
	                        stk.push(node);
	                        visit.push(true);
	                        stk.push(node.right);
	                        visit.push(false);
	                        stk.push(node.left);
	                        visit.push(false);
	                    }
	                }
	            }
	            return res;
	        }
	    
	public static void main(String[] args) {
		//Example 1:

		TreeNode root1 = new TreeNode (1);
		root1.right= new TreeNode(2);
		root1.right.left= new TreeNode(3);
		List<Integer> output1= new ArrayList(Arrays.asList(3,2,1));
		
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
		
		List<Integer> output2= new ArrayList(Arrays.asList(4,6,7,5,2,9,8,3,1));
		
		//Example 3:

		TreeNode root3 =null;
		List<Integer> output3= new ArrayList();

		//Example 4:

		TreeNode root4 =new TreeNode(1);
		List<Integer> output4= new ArrayList(Arrays.asList(1));
		
		
		System.out.println("Recursive Approch :");
		
		List<Integer> ans1 = postorderTraversalRecursive(root1);
		List<Integer> ans2 = postorderTraversalRecursive(root2);
		List<Integer> ans3 = postorderTraversalRecursive(root3);
		List<Integer> ans4 = postorderTraversalRecursive(root4);
		
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
		ans1 = postorderTraversalIterative(root1);
		ans2 = postorderTraversalIterative(root2);
		ans3 = postorderTraversalIterative(root3);
		ans4 = postorderTraversalIterative(root4);
		
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
		


	}

}
