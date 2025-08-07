//103. Binary Tree Zigzag Level Order Traversal
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).
//
// 
//
//Example 1:
//
//
//Input: root = [3,9,20,null,null,15,7]
//Output: [[3],[20,9],[15,7]]
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
//-100 <= Node.val <= 100

package Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import TreeUtil.TreeNode;

public class BinaryTreeZigzagLevelOrderTraversal_103 {
//	approch :
//	here we will follow simple approch :
//	we have to add in queue from end and remove from front 
//	when the level of tree is even first level of tree is consider as 0 
//	and we will reverse it when the odd level come like 1 3 5 etc
//	in reverse we will add at front of queue and delte from the last element of the queue
//	this will replicate the zigzag
//	time complexity :O(n)
//	space complexity :O(n)
	
	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res= new ArrayList();
        if(root==null){
            return res;
        }
        ArrayDeque<TreeNode> queue= new ArrayDeque();
        queue.add(root);
        boolean reverse =false;
        while(!queue.isEmpty()){
            int levelSize= queue.size();
            List<Integer> levelList= new ArrayList();
            for(int i =0;i<levelSize;i++){
                if(!reverse){
                    TreeNode poped = queue.removeFirst();
                    levelList.add(poped.val);
                    if(poped.left!=null){
                        queue.addLast(poped.left);
                    }
                    if(poped.right!=null){
                        queue.addLast(poped.right);
                    }
                }else{
                    TreeNode poped = queue.removeLast();
                    levelList.add(poped.val);
                    if(poped.right!=null){
                        queue.addFirst(poped.right);
                    }
                    if(poped.left!=null){
                        queue.addFirst(poped.left);
                    }
                }
            }
            res.add(levelList);
            reverse= !reverse;
        }
        return res;
    }
	
	public static void main(String[] args) {
		BinaryTree root1 = new  BinaryTree(3,9,20,null,null,15,7);
		List<List<Integer>> output1= new ArrayList(Arrays.asList(Arrays.asList(3),Arrays.asList(20,9),Arrays.asList(15,7)));
		
		//Example 2:

		BinaryTree root2 = new  BinaryTree(1);
		List<List<Integer>> output2= new ArrayList(Arrays.asList(Arrays.asList(1)));
		
		//Example 3:

		BinaryTree root3 = new  BinaryTree();
		List<List<Integer>> output3= new ArrayList();
		
		
		List<List<Integer>> ans1= zigzagLevelOrder(root1.getRoot());
		List<List<Integer>> ans2= zigzagLevelOrder(root2.getRoot());
		List<List<Integer>> ans3= zigzagLevelOrder(root3.getRoot());
		
		
		
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
