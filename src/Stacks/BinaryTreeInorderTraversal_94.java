//94. Binary Tree Inorder Traversal
//Solved
//Easy
//Topics
//premium lock icon
//Companies
//Given the root of a binary tree, return the inorder traversal of its nodes' values.
//
// 
//
//Example 1:
//
//Input: root = [1,null,2,3]
//
//Output: [1,3,2]
//
//Explanation:
//
//
//
//Example 2:
//
//Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]
//
//Output: [4,2,6,5,7,1,3,9,8]
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

//Follow up: Recursive solution is trivial, could you do it iteratively?

package Stacks;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import TreeUtil.TreeNode;

public class BinaryTreeInorderTraversal_94 {
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode() {}
	 *     TreeNode(int val) { this.val = val; }
	 *     TreeNode(int val, TreeNode left, TreeNode right) {
	 *         this.val = val;
	 *         this.left = left;
	 *         this.right = right;
	 *     }
	 * }
	 */
//    approch : here we use recursive approch where  we first add the node to res then  tracerse left side
//    then right side 
//		time complexity :O(n)
//		space complexity :O(n)
	    public static List<Integer> inorderTraversalRecursive(TreeNode root) {
	        List<Integer> res = new ArrayList<Integer>();
	        traversal(res,root);
	        return res;
	    }
	    public static void traversal(List<Integer> res, TreeNode root) {
	        if(root==null){
	            return ;
	        }
	        traversal(res,root.left);
	        res.add(root.val);
	        traversal(res,root.right);
	    }
	    
	    
	    
	    
//    approch : here we use stack approch where  we first add node in res then travers left side
//	and add each node to the stack
//	untill the left node is null when it happen we will pop the node and 
//	and check its right side 
//		time complexity :O(n)
//		space complexity :O(n)
	    
	        public static List<Integer> inorderTraversalIterative(TreeNode root) {
	            List<Integer> res= new ArrayList();
	            Stack<TreeNode> stk= new Stack();

	            while( true){
	                while(root!=null){
	                    stk.push(root);
	                    root=root.left;        
	                }
	                if(stk.isEmpty()){
	                    break;
	                }
	                TreeNode poped= stk.pop();
	                res.add(poped.val);
	                root=poped.right;
	            }
	        return res;
	        }
	    

	public static void main(String[] args) {

	}

}
