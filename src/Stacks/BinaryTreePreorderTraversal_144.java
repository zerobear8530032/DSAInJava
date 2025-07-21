//144. Binary Tree Preorder Traversal
//Solved
//Easy
//Topics
//premium lock icon
//Companies
//Given the root of a binary tree, return the preorder traversal of its nodes' values.
//
// 
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

package Stacks;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import TreeUtil.TreeNode;

public class BinaryTreePreorderTraversal_144 {
	
//	    approch : here we use stack approch where  we first tracerse left side
//		and add each node to the stack
//		untill the left node is null when it happen we will pop the node and 
//		and check its right side 
// 		time complexity :O(n)
// 		space complexity :O(n)
	
	    public List<Integer> preorderTraversalIterative(TreeNode root) {
	         List<Integer> res= new ArrayList<>();
	        Stack<TreeNode> stk= new Stack<>();
	        
	        while( root!=null || stk.size()!=0){
	            while(root!=null){
	                res.add(root.val);
	                stk.push(root);
	                root=root.left;        
	            }
	            if(stk.isEmpty()){
	                break;
	            }
	            TreeNode poped= stk.pop();
	            root=poped.right;
	        }
	        return res; 
	    }
	    
//	    approch : here we use recursive approch where  we first tracerse left side
//	    then root then right side 
// 		time complexity :O(n)
// 		space complexity :O(n)
	
        public static List<Integer> preorderTraversalRecursive(TreeNode root) {
            List<Integer> res = new ArrayList();
            traversal(res,root);
            return res;
        }
        public static void traversal(List<Integer> res, TreeNode root) {
            if(root==null){
                return ;
            }
            res.add(root.val);
            traversal(res,root.left);
            traversal(res,root.right);
        }
    

	public static void main(String[] args) {
		

	}

}
