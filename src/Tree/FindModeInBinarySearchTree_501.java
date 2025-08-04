//501. Find Mode in Binary Search Tree
//Solved
//Easy
//Topics
//premium lock icon
//Companies
//Given the root of a binary search tree (BST) with duplicates, return all the mode(s) (i.e., the most frequently occurred element) in it.
//
//If the tree has more than one mode, return them in any order.
//
//Assume a BST is defined as follows:
//
//The left subtree of a node contains only nodes with keys less than or equal to the node's key.
//The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
//Both the left and right subtrees must also be binary search trees.
// 
//
//Example 1:
//
//
//Input: root = [1,null,2,2]
//Output: [2]
//Example 2:
//
//Input: root = [0]
//Output: [0]
// 
//
//Constraints:
//
//The number of nodes in the tree is in the range [1, 104].
//-105 <= Node.val <= 105
// 
//
//Follow up: Could you do that without using any extra space? (Assume that the implicit stack space incurred due to recursion does not count).

package Tree;

import TreeUtil.TreeNode;
import java.util.*;

public class FindModeInBinarySearchTree_501 {
	
//	approch :
//	just use a traerasal and count frequency get max freq and find all mods
//	time complexity :O(n)
//	space complexity :O(n)

	 public static int[] findMode(TreeNode root) {
	        HashMap<Integer, Integer> map = new HashMap();
	        dfs(root,map);
	        int maxfreq= 0;
	        for(Map.Entry<Integer,Integer> e:map.entrySet()){
	            int val= e.getValue();
	            maxfreq=Math.max(maxfreq,val);
	        }
	        List<Integer> modes = new ArrayList();
	        for(Map.Entry<Integer,Integer> e:map.entrySet()){
	            int val= e.getValue();
	            if(val==maxfreq){
	                modes.add(e.getKey());
	            }
	        }
	        int i =0;
	        int [] res = new int [modes.size()];
	        for(int x:modes){
	            res[i++]=x;
	        }
	        return res;
	    }
	    private static void dfs(TreeNode root, HashMap<Integer,Integer> map){
	        if(root==null){
	            return;
	        }

	        int val = root.val;
	        if(map.containsKey(val)){
	            map.put(val,map.get(val)+1);
	        }else{
	            map.put(val,1);
	        }

	        dfs(root.left,map);
	        dfs(root.right,map);
	    }
	    
	    
	    public static boolean check(int [] output, int []ans) {
	    	if(ans.length!= output.length) {
	    		return false;
	    	}
	    	for(int i =0;i<ans.length;i++) {
	    		if(ans[i]!=output[i]) {
	    			return false;
	    		}
	    	}
	    	return true;
	    	
	    }
	public static void main(String[] args) {
		
		//Example 1:

		TreeNode  root1 =   new TreeNode(1);
		root1.right= new TreeNode(2);
		root1.left= new TreeNode(2);
		
		int []  output1= {2};
		
		
		//Example 2:

		TreeNode  root2 =   new TreeNode(0);
		
		int []  output2= {0};
		
		int []  ans1= findMode(root1); 
		int []  ans2= findMode(root2);
		
		if(check(ans2, output2)) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Actual Output :"+Arrays.toString(output1) );
			System.out.println("Your Output :"+Arrays.toString(ans1));
		}
		if(check(ans2,output2)) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Actual Output :"+Arrays.toString(output2) );
			System.out.println("Your Output :"+Arrays.toString(ans2));
		}




	}

}
