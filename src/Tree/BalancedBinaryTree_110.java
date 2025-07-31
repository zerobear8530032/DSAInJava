//110. Balanced Binary Tree
//Attempted
//Easy
//Topics
//premium lock icon
//Companies
//Given a binary tree, determine if it is height-balanced.
//Example 1:
//
//
//Input: root = [3,9,20,null,null,15,7]
//Output: true
//Example 2:
//
//
//Input: root = [1,2,2,3,3,null,null,4,4]
//Output: false
//Example 3:
//
//Input: root = []
//Output: true
// 
//
//Constraints:
//
//The number of nodes in the tree is in the range [0, 5000].
//-104 <= Node.val <= 104

package Tree;

import TreeUtil.TreeNode;

public class BalancedBinaryTree_110 {
	
// approch : we go to each and every node and  check its left and right substree height
//	and get difference is equal or greater then 1 if its greater then 1 return false 
//	time complexity :O(n*n)
//	space complexity :O(n*n)
    public static  boolean isBalancedBruteForce(TreeNode root) {
        if(root==null){
            return true;
        }
        int lh = getHeight(root.left);
        int rh = getHeight(root.right);
        if(Math.abs(lh-rh)>1){
            return false;
        }
        boolean left = isBalancedBruteForce(root.left);
        boolean right = isBalancedBruteForce(root.right);
        return left && right;
    }


    public static int getHeight(TreeNode node){
        if(node==null){
            return 0;
        }
        int left = getHeight(node.left);
        int right = getHeight(node.right);
        return Math.max(left,right)+1;
    }
//    approch : here we use a function to find the height of the tree from node
//    but we will check at each node that the height is balanced or not 
//    if any node have a height unbalance it will not return the actual height instead it 
//    will return -1 at the end if the height function return  -1 we can say the tree is notbalance 
//    time complexity :O(n)
//    space complexity :O(n)
    
    
    public static boolean isBalancedBetter(TreeNode root) {
        return checkBalanced(root)!=-1;
    }
    public static int checkBalanced(TreeNode node){
        if(node==null){
            return 0;
        }

        int lh= checkBalanced(node.left);
        int lr= checkBalanced(node.right);
        boolean notbalance = Math.abs(lh-lr)>1;
        if(lh==-1 || lr==-1 || notbalance){
            return -1;
        }

        return Math.max(lh,lr)+1;
    }

	public static void main(String[] args) {
		TreeNode t1=new TreeNode(3);
		t1.left= new TreeNode(9);
		t1.right= new TreeNode(20);
		t1.right.left= new TreeNode(15);
		t1.right.right= new TreeNode(7);
		boolean output1= true;
		
		
		TreeNode t2=new TreeNode(1);
		t2.left= new TreeNode(2);
		t2.left.left= new TreeNode(3);
		t2.left.right= new TreeNode(3);
		t2.left.left.left= new TreeNode(4);
		t2.left.left.right= new TreeNode(4);
		t2.right= new TreeNode(2);
		boolean output2= false;

		TreeNode t3=null;
		boolean output3= true;
		
		System.out.println("Brute Force Approch :");
		
		boolean ans1= isBalancedBruteForce(t1);		
		boolean ans2= isBalancedBruteForce(t2);		
		boolean ans3= isBalancedBruteForce(t3);		
		
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
		if(ans3==output3) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Actual Output :"+output3 );
			System.out.println("Your Output :"+ans3);
		}
		
		System.out.println("Better Approch :");
		
		ans1= isBalancedBetter(t1);		
		ans2= isBalancedBetter(t2);		
		ans3= isBalancedBetter(t3);		
		
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
		if(ans3==output3) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Actual Output :"+output3 );
			System.out.println("Your Output :"+ans3);
		}

	}

}
