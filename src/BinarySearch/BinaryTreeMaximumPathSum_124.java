//124. Binary Tree Maximum Path Sum
//Solved
//Hard
//Topics
//premium lock icon
//Companies
//A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.
//
//The path sum of a path is the sum of the node's values in the path.
//
//Given the root of a binary tree, return the maximum path sum of any non-empty path.
//
//
//
//Example 1:
//
//
//Input: root = [1,2,3]
//Output: 6
//Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.
//Example 2:
//
//
//Input: root = [-10,9,20,null,null,15,7]
//Output: 42
//Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.
//
//
//Constraints:
//
//The number of nodes in the tree is in the range [1, 3 * 104].
//-1000 <= Node.val <= 1000
package BinarySearch;

import TreeUtil.BinaryTree;
import TreeUtil.TreeNode;

import java.util.Arrays;

public class BinaryTreeMaximumPathSum_124 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
        static int res;
        public static int maxPathSum(TreeNode root) {
            res=Integer.MIN_VALUE;
            getMaxPath(root);
            return res;
        }

        public static int getMaxPath(TreeNode node){
            if(node==null){
                return 0;
            }
            int left =getMaxPath(node.left);
            int right =getMaxPath(node.right);
            left=Math.max(0,left);
            right=Math.max(0,right);
            int pathsum=left+right+node.val;
            res=Math.max(res,pathsum);
            return Math.max(left,right)+node.val;
        }


        public static boolean isLeaf(TreeNode node){
            return node.left==null && node.right==null;
        }

    public static void main(String[] args) {
        //Example 1:

        BinaryTree root1 = new BinaryTree(1,2,3);
        int output1= 6;

        //Example 2:

        BinaryTree root2 = new BinaryTree(-10,9,20,null,null,15,7);
        int output2= 42;

        int ans1 = maxPathSum(root1.getRoot());
        int ans2 = maxPathSum(root2.getRoot());
        if((output1==ans1)) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Ouput :"+(output1));
            System.out.println("Your Answer :"+ (ans1));
        }
        if((ans2==output2)) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Ouput :"+ (output2));
            System.out.println("Your Answer :"+ (ans2));
        }


    }

}
