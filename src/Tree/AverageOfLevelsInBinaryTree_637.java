//637. Average of Levels in Binary Tree

//premium lock icon
//Companies
//Given the root of a binary tree, return the average value of the nodes on each level in the form of an array. Answers within 10-5 of the actual answer will be accepted.
// 
//
//Example 1:
//
//
//Input: root = [3,9,20,null,null,15,7]
//Output: [3.00000,14.50000,11.00000]
//Explanation: The average value of nodes on level 0 is 3, on level 1 is 14.5, and on level 2 is 11.
//Hence return [3, 14.5, 11].
//Example 2:
//
//
//Input: root = [3,9,20,15,7]
//Output: [3.00000,14.50000,11.00000]
// 
//
//Constraints:
//
//The number of nodes in the tree is in the range [1, 104].
//-231 <= Node.val <= 231 - 1

package Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import TreeUtil.TreeNode;

public class AverageOfLevelsInBinaryTree_637 {
	
//	approch :
//	 user BFS : to travese by level and get the avg:
//	time complexity :O(n)
//	space complexity :O(n)
	  public static List<Double> averageOfLevels(TreeNode root) {
	        List<Double> res = new ArrayList<Double>();
	        if(root==null){
	            return res;
	        }
	        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
	        queue.add(root);
	        while(!queue.isEmpty()){
	            double levelSize = queue.size();
	            double sum =0;
	            for(int i =0;i<levelSize;i++){
	                TreeNode poped = queue.remove();
	                sum+=poped.val;
	                if(poped.left!=null){
	                    queue.add(poped.left);
	                }
	                if(poped.right!=null){
	                    queue.add(poped.right);
	                }
	            }
	            res.add(sum/levelSize);
	        }
	        return res;
	    }

	public static void main(String[] args) {
		
		
		//Example 1:
		
		BinaryTree root1 = new BinaryTree(Arrays.asList(3,9,20,null,null,15,7));
		List<Double> output1= new ArrayList(Arrays.asList(3.00000,14.50000,11.00000));
		
		//Example 2:
		
		BinaryTree root2 = new BinaryTree(Arrays.asList(3,9,20,15,7));
		List<Double> output2= new ArrayList(Arrays.asList(3.00000,14.50000,11.00000));
		
		List<Double> ans1= averageOfLevels(root1.getRoot());		
		List<Double> ans2= averageOfLevels(root2.getRoot());		
		
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

	}

}
