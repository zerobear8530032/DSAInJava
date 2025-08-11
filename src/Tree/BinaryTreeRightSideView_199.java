//199. Binary Tree Right Side View
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
//
// 
//
//Example 1:
//
//Input: root = [1,2,3,null,5,null,4]
//
//Output: [1,3,4]
//
//Explanation:
//
//
//
//Example 2:
//
//Input: root = [1,2,3,4,null,null,null,5]
//
//Output: [1,3,4,5]
//
//Explanation:
//
//
//
//Example 3:
//
//Input: root = [1,null,3]
//
//Output: [1,3]
//
//Example 4:
//
//Input: root = []
//
//Output: []
//
// 
//
//Constraints:
//
//The number of nodes in the tree is in the range [0, 100].
//-100 <= Node.val <= 100

package Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import TreeUtil.BinaryTree;
import TreeUtil.TreeNode;

public class BinaryTreeRightSideView_199 {
//	best approch :
//	here we does not take each node here we explore right node first 
//	and and add the first node at each depth because we explore first node as right 
//	it always the right node as the answer 
	   public static  List<Integer> rightSideViewBest(TreeNode root) {
	        List<Integer> list = new ArrayList();
	        helperBest(root, list,0);
	        return list;
	    }
	    public static void helperBest(TreeNode root,List<Integer> list,int depth){
	        if(root==null){
	            return ;
	        }
	        if(depth==list.size()){
	            list.add(root.val);
	        }
	        helperBest(root.right,list,depth+1);
	        helperBest(root.left,list,depth+1);

	    }
	    
//	    brute force approch :
//	    here we put each  node at a 2d list where each node is map to its correspoding depth 
//	    in the list 
//	    after that we will go throw each row of 2 d list and get last node of the 
//	    row and get right most node 
//	    here we use post order traversal
	    
	    public static List<Integer> rightSideViewBruteForce(TreeNode root) {
	        List<List<Integer>> list = new ArrayList();
	        helperBruteForce(root, list,0);
	        List<Integer> res= new ArrayList();
	        for(int i=0;i<list.size();i++){
	            List<Integer> depth = list.get(i);
	            res.add(depth.get(depth.size()-1));
	        }
	        return res;
	    }
	    public static void helperBruteForce(TreeNode root,List<List<Integer>> list,int depth){
	        if(root==null){
	            return ;
	        }

	        if(list.size()-1<depth){
	            list.add(new ArrayList());
	        }

	        list.get(depth).add(root.val);
	        helperBruteForce(root.left,list,depth+1);
	        helperBruteForce(root.right,list,depth+1);

	    }
	public static void main(String[] args) {

        //Example 1:

        BinaryTree  root1 =  new BinaryTree(1,2,3,null,5,null,4);
        List<Integer> output1= new ArrayList(Arrays.asList(1,3,4));

        //Example 2:

        BinaryTree  root2 =  new BinaryTree(1,2,3,4,null,null,null,5);
        List<Integer> output2= new ArrayList(Arrays.asList(1,3,4,5));

        //Example 3:

        BinaryTree  root3 =  new BinaryTree(1,null,3);
        List<Integer> output3= new ArrayList(Arrays.asList(1,3));

        //
        //Example 4:

        BinaryTree  root4 =  new BinaryTree();
        List<Integer> output4= new ArrayList();

        List<Integer> ans1 = rightSideViewBruteForce(root1.getRoot());
        List<Integer> ans2 = rightSideViewBruteForce(root2.getRoot());
        List<Integer> ans3 = rightSideViewBruteForce(root3.getRoot());
        List<Integer> ans4 = rightSideViewBruteForce(root4.getRoot());

		if(output1.equals( ans1)) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Expected Ouput :"+ output1);
			System.out.println("Your Answer :"+ ans1);
		}
		if(output2.equals(ans2)) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Expected Ouput :"+ output2);
			System.out.println("Your Answer :"+ ans2);
		}
		if(output3.equals(ans3)) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Expected Ouput :"+ output3);
			System.out.println("Your Answer :"+ ans3);
		}
		if(output4.equals(ans4)) {
			System.out.println("Case 4 Passed");
		}else {
			System.out.println("Case 4 Failed");
			System.out.println("Expected Ouput :"+ output4);
			System.out.println("Your Answer :"+ ans4);
		}

		
		System.out.println("Optimize Approch :");
		
		ans1 = rightSideViewBruteForce(root1.getRoot());
		ans2 = rightSideViewBruteForce(root2.getRoot());
		ans3 =  rightSideViewBruteForce(root3.getRoot());
		ans4 =  rightSideViewBruteForce(root4.getRoot());
		

		if(output1.equals( ans1)) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Expected Ouput :"+ output1);
			System.out.println("Your Answer :"+ ans1);
		}
		if(output2.equals(ans2)) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Expected Ouput :"+ output2);
			System.out.println("Your Answer :"+ ans2);
		}
		if(output3.equals(ans3)) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Expected Ouput :"+ output3);
			System.out.println("Your Answer :"+ ans3);
		}
		if(output4.equals(ans4)) {
			System.out.println("Case 4 Passed");
		}else {
			System.out.println("Case 4 Failed");
			System.out.println("Expected Ouput :"+ output4);
			System.out.println("Your Answer :"+ ans4);
		}


	}

}
