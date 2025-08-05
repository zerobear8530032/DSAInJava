//543. Diameter of Binary Tree
//Solved
//Easy
//Topics
//premium lock icon
//Companies
//Given the root of a binary tree, return the length of the diameter of the tree.
//
//The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
//
//The length of a path between two nodes is represented by the number of edges between them.
//
// 
//
//Example 1:
//
//
//Input: root = [1,2,3,4,5]
//Output: 3
//Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
//Example 2:
//
//Input: root = [1,2]
//Output: 1
// 
//
//Constraints:
//
//The number of nodes in the tree is in the range [1, 104].
//-100 <= Node.val <= 100

package TreeUtil;

public class DiameterOfBinaryTree_543 {
//	approch :
//	in order to find athe largest diameter we 
//	need nodes which are furthest apart from each other 
//	and to see how much a node is apart we can take a node 
//	and check its left mode leaf and right most  leaf node 
//	and add both heights that will give us diameter of that node
//	so we can create a dfs which get height of each node and we can 
//	calculate diameter at each instance and get max in a global variable 
//	time complexity :O(n)
//	space complexity :O(n)
	 static int maxDimeter;
	    public static int diameterOfBinaryTree(TreeNode root) {
	        maxDimeter= 0;
	        dfs(root);
	        return maxDimeter;
	    }

	    public static int dfs(TreeNode node){
	        if(node==null){
	            return 0;
	        }
	        int left = dfs(node.left);
	        int right = dfs(node.right);
	        int diameter = left+right;
	        maxDimeter= Math.max(maxDimeter,diameter);
	        return Math.max(left,right)+1;
	    }

	public static void main(String[] args) {
		
		//Example 1:
		
		TreeNode root1 = new TreeNode(1);
		root1.left= new TreeNode(2);
		root1.right= new TreeNode(3);
		root1.left.left= new TreeNode(4);
		root1.left.right= new TreeNode(5);
		int output1=3;
		

		//Example 2:
		
		TreeNode root2 = new TreeNode(1);
		root2.left= new TreeNode(2);
		int output2=1;
		
		int ans1 = diameterOfBinaryTree(root1);
		int ans2 = diameterOfBinaryTree(root2);
		
		if(ans1==output1) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Actual Output :"+output1 );
			System.out.println("Your Output :"+ans1);
		}
		if(ans2==output2) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Actual Output :"+output2 );
			System.out.println("Your Output :"+ans2);
		}
		




	}

}
