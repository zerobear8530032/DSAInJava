//437. Path Sum III
//        Medium
//Topics
//premium lock icon
//        Companies
//Given the root of a binary tree and an integer targetSum, return the number of paths where the sum of the values along the path equals targetSum.
//
//The path does not need to start or end at the root or a leaf, but it must go downwards (i.e., traveling only from parent nodes to child nodes).
//
//
//
//Example 1:
//
//
//Input: root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
//Output: 3
//Explanation: The paths that sum to 8 are shown.
//Example 2:
//
//Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//Output: 3
//
//
//Constraints:
//
//The number of nodes in the tree is in the range [0, 1000].
//        -109 <= Node.val <= 109
//        -1000 <= targetSum <= 1000

package Tree;

import TreeUtil.BinaryTree;
import TreeUtil.TreeNode;

public class PathSumIII_437 {
    // approch : go through every node and check from there wheather the path sum of to target Sum
// time complexity :O(n*n)
// space complexity :O(n)
    public static int pathSum(TreeNode root, int targetSum) {
        return traverse(root,targetSum);
    }


    public static  int  traverse(TreeNode root, long targetSum){
        if(root==null){
            return 0;
        }
        int count=checkPath(root,targetSum,0);
        count += traverse(root.left,targetSum);
        count+=  traverse(root.right,targetSum);
        return count;
    }

    public static int checkPath(TreeNode node, long targetSum, long currSum){
        if(node==null){return 0;}
        currSum+=node.val;
        int count = targetSum==currSum? 1:0;// return 1 if targetSum == currSum other wise 0
        count+=checkPath(node.left,targetSum,currSum);
        count+=checkPath(node.right,targetSum,currSum);
        return count;
    }

    public static void main(String[] args) {
        //Example 1:

        BinaryTree root1 = new BinaryTree(10,5,-3,3,2,null,11,3,-2,null,1);
        int targetSum1 = 8;
        int output1=3;

        //Example 2:

        BinaryTree root2 = new BinaryTree(5,4,8,11,null,13,4,7,2,null,null,5,1);
        int targetSum2 = 22;
        int output2=3;

        int ans1= pathSum(root1.getRoot(),targetSum1);
        int ans2= pathSum(root2.getRoot(),targetSum2);

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
