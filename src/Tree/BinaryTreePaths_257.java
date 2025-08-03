//257. Binary Tree Paths
//Solved
//Easy
//Topics
//premium lock icon
//Companies
//Given the root of a binary tree, return all root-to-leaf paths in any order.
//
//A leaf is a node with no children.
//
// 
//
//Example 1:
//
//
//Input: root = [1,2,3,null,5]
//Output: ["1->2->5","1->3"]
//Example 2:
//
//Input: root = [1]
//Output: ["1"]
// 
//
//Constraints:
//
//The number of nodes in the tree is in the range [1, 100].
//-100 <= Node.val <= 100

package Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import TreeUtil.TreeNode;

public class BinaryTreePaths_257 {
	
//	Approch : here we use a dfs where first add the value to the currpath
//	if the current node is the leaf we will add it to res and return other wise 
//	we will add a arrow to the path and search its left and right subtree
//	if any time node becomes null we will return 
//	time complexity :O(n)
//	space complexity :O(n)
	 public  static List<String> binaryTreePaths(TreeNode root) {
	        List<String> res = new ArrayList<String>();
	        dfs(root,res,"");
	        return res;
	    }
	    public static void dfs(TreeNode node, List<String> res , String path)  {
	        if(node==null ){
	          return ;
	        }
	        path+=Integer.toString(node.val);
	        if(node.left==null && node.right==null){
	            res.add(path);
	            return ;
	        }

	        path+="->";
	        dfs(node.left,res,path);
	        dfs(node.right,res,path);
	    }

	public static void main(String[] args) {
		//Example 1:
		
		TreeNode root1 =  new TreeNode(1);
		root1.left= new TreeNode(2);
		root1.right= new TreeNode(3);
		
		root1.left.right= new TreeNode(5);
		List<String> output1= new ArrayList(Arrays.asList("1->2->5","1->3"));
		
		TreeNode root2 =  new TreeNode(1);
		List<String> output2= new ArrayList(Arrays.asList("1"));
		
		List<String > ans1 = binaryTreePaths(root1);
		List<String > ans2 = binaryTreePaths(root2);
		
		
		Collections.sort(ans1);
		Collections.sort(ans2);
		Collections.sort(output1);
		Collections.sort(output2);
		
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
