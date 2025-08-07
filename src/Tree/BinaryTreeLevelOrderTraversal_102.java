//102. Binary Tree Level Order Traversal
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
//
// 
//
//Example 1:
//
//
//Input: root = [3,9,20,null,null,15,7]
//Output: [[3],[9,20],[15,7]]
//Example 2:
//
//Input: root = [1]
//Output: [[1]]
//Example 3:
//
//Input: root = []
//Output: []
// 
//
//Constraints:
//
//The number of nodes in the tree is in the range [0, 2000].
//-1000 <= Node.val <= 1000

package Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import TreeUtil.TreeNode;

public class BinaryTreeLevelOrderTraversal_102 {
	
//	approch : using bfs 
//	time complexity :O(n)
//	space complexity :O(n)
	 public static List<List<Integer>> levelOrderBFS(TreeNode root) {
	        // using bfs :
	        List<List<Integer>> res= new ArrayList();
	        if(root==null){
	            return res;
	        }
	        ArrayDeque <TreeNode> queue = new ArrayDeque();
	        queue.add(root);
	        while(!queue.isEmpty()){
	            int levelSize = queue.size();
	            List<Integer> levelList = new ArrayList();
	            for(int i =0;i<levelSize;i++){
	                TreeNode poped = queue.remove();
	                levelList.add(poped.val);
	                if(poped.left!=null){
	                    queue.add(poped.left);
	                }
	                if(poped.right!=null){
	                    queue.add(poped.right);
	                }
	            }
	            res.add(levelList);
	        }
	        return res;
	    }
	 
//	approch : using dfs 
//	time complexity :O(n)
//	space complexity :O(n)
	 public static List<List<Integer>> levelOrderDFS(TreeNode root) {
	     List<List<Integer>> res = new ArrayList();
	     dfs(root,res,0);
	     return res;   
	    }

	    public static void dfs(TreeNode node , List<List<Integer>> res , int depth){
	        if(node==null){
	            return ;
	        }
	        if(res.size()-1 < depth){
	            res.add(new ArrayList());
	        }
	        List<Integer> levelList = res.get(depth);
	        levelList.add(node.val);
	        dfs(node.left,res,depth+1);
	        dfs(node.right,res,depth+1);
	    }

	public static void main(String[] args) {
		
		//Example 1:
		
		BinaryTree root1 = new  BinaryTree(3,9,20,null,null,15,7);
		List<List<Integer>> output1= new ArrayList(Arrays.asList(Arrays.asList(3),Arrays.asList(9,20),Arrays.asList(15,7)));
		
		//Example 2:

		BinaryTree root2 = new  BinaryTree(1);
		List<List<Integer>> output2= new ArrayList(Arrays.asList(Arrays.asList(1)));
		
		//Example 3:

		BinaryTree root3 = new  BinaryTree();
		List<List<Integer>> output3= new ArrayList();
		
		System.out.println("DFS Traversal ");
		
		List<List<Integer>> ans1 = levelOrderDFS(root1.getRoot());
		List<List<Integer>> ans2 = levelOrderDFS(root2.getRoot());
		List<List<Integer>> ans3 = levelOrderDFS(root3.getRoot());
		
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
		
		System.out.println("BFS Traversal ");
		
		ans1 = levelOrderBFS(root1.getRoot());
		ans2 = levelOrderBFS(root2.getRoot());
		ans3 = levelOrderBFS(root3.getRoot());
		
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

	}

}
