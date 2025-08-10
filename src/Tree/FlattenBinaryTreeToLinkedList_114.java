//114. Flatten Binary Tree to Linked List
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//Given the root of a binary tree, flatten the tree into a "linked list":
//
//The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
//The "linked list" should be in the same order as a pre-order traversal of the binary tree.
// 
//
//Example 1:
//
//
//Input: root = [1,2,5,3,4,null,6]
//Output: [1,null,2,null,3,null,4,null,5,null,6]
//Example 2:
//
//Input: root = []
//Output: []
//Example 3:
//
//Input: root = [0]
//Output: [0]
// 
//
//Constraints:
//
//The number of nodes in the tree is in the range [0, 2000].
//-100 <= Node.val <= 100
//Follow up: Can you flatten the tree in-place (with O(1) extra space)?

package Tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import TreeUtil.BinaryTree;
import TreeUtil.TreeNode;

public class FlattenBinaryTreeToLinkedList_114 {
	
	
//	approch we can use a queue and using pre order traevrsal put every node in queue 
//	after that we can remove each node and making it connect each other at right side and removing left nodes
//	Time complexity :O(n)
//	Space complexity :O(n)
	
    public static void flattenBruteForce(TreeNode root) {
        if(root==null){return ;}
        Queue<TreeNode> queue = new LinkedList();
        preOrder(root,queue);
        root= queue.remove();
        root.left=null;
        while(!queue.isEmpty()){
            root.right=queue.remove();
            root=root.right;
            root.left=null;
        }
    }

    public static void preOrder(TreeNode node,Queue<TreeNode> queue){
        if(node==null){
            return ;
        }
        queue.add(node);
        preOrder(node.left,queue);
        preOrder(node.right,queue);
    }
    
    
//	approch we can use a check each node having a left sub tree or not
//   if yes we can put it in the right side and connecting the previouse right subtree 
//    to the right most node of the left subtree
//	Time complexity :O(n)
//	Space complexity :O(1)
    
    public static void flattenBetter(TreeNode root) {
    	        TreeNode node=root;
    	        while(node!=null){
    	            if(node.left!=null){
    	                TreeNode right = node.right;
    	                TreeNode left = node.left;
    	                node.left=null;// remove the connection btw node
    	                TreeNode lastLeft= left;
    	                while(lastLeft.right!=null){
    	                    lastLeft=lastLeft.right;
    	                }
    	                node.right=left;
    	                lastLeft.right=right;
    	                right=node.right;
    	            }
    	            node=node.right;
    	        }
    }

	public static void main(String[] args) {
		
		//Example 1:

		BinaryTree root1 = new BinaryTree(Arrays.asList(1,2,5,3,4,null,6));
		BinaryTree output1 = new BinaryTree(Arrays.asList(1,null,2,null,3,null,4,null,5,null,6));
		
		//Example 2:

		BinaryTree root2 = new BinaryTree();
		BinaryTree output2 = new BinaryTree();
		
		//Example 3:

		BinaryTree root3 = new BinaryTree(Arrays.asList(0));
		BinaryTree output3 = new BinaryTree(Arrays.asList(0));
		
		System.out.println("Recursion Approch : ");
		
		flattenBruteForce(root1.getRoot());
		flattenBruteForce(root2.getRoot());
		flattenBruteForce(root3.getRoot());
		
		
		if(root1.equals(output1)) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Actual Output :"+output1 );
			System.out.println("Your Output :"+root1);
		}
		if(root2.equals(output2)) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Actual Output :"+output2 );
			System.out.println("Your Output :"+root2);
		}		
		if(root3.equals(output3)) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Actual Output :"+output3);
			System.out.println("Your Output :"+root3);
		}		
		System.out.println("Recursion Approch : ");
		
		root1 = new BinaryTree(Arrays.asList(1,2,5,3,4,null,6));
		root2 = new BinaryTree();
		root3 = new BinaryTree(Arrays.asList(0));
		
		flattenBetter(root1.getRoot());
		flattenBetter(root2.getRoot());
		flattenBetter(root3.getRoot());
		
		
		if(root1.equals(output1)) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Actual Output :"+output1 );
			System.out.println("Your Output :"+root1);
		}
		if(root2.equals(output2)) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Actual Output :"+output2 );
			System.out.println("Your Output :"+root2);
		}		
		if(root3.equals(output3)) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Actual Output :"+output3);
			System.out.println("Your Output :"+root3);
		}		

		


	}

}
