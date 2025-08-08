package Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import TreeUtil.BinaryTree;
import TreeUtil.TreeNode;

public class BinaryTreeLevelOrderTraversalII_107 {
//	same as bfs level order traversal just each new level list add at front
//	time compelxity :O(n)
//	space compelxity :O(n)
	  public static List<List<Integer>> levelOrderBottom(TreeNode root) {
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
		            res.addFirst(levelList);
		        }
		        return res;
		   
		    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Example 1:
		
				BinaryTree root1 = new  BinaryTree(3,9,20,null,null,15,7);
				List<List<Integer>> output1= new ArrayList(Arrays.asList(Arrays.asList(15,7),Arrays.asList(9,20),Arrays.asList(3)));
				
				//Example 2:

				BinaryTree root2 = new  BinaryTree(1);
				List<List<Integer>> output2= new ArrayList(Arrays.asList(Arrays.asList(1)));
				
				//Example 3:

				BinaryTree root3 = new  BinaryTree();
				List<List<Integer>> output3= new ArrayList();
				
				
				List<List<Integer>> ans1 = levelOrderBottom(root1.getRoot());
				List<List<Integer>> ans2 = levelOrderBottom(root2.getRoot());
				List<List<Integer>> ans3 = levelOrderBottom(root3.getRoot());
				
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
