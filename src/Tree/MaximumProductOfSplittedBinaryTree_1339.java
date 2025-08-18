//1339. Maximum Product of Splitted Binary Tree
//Attempted
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//Given the root of a binary tree, split the binary tree into two subtrees by removing one edge such that the product of the sums of the subtrees is maximized.
//
//Return the maximum product of the sums of the two subtrees. Since the answer may be too large, return it modulo 109 + 7.
//
//Note that you need to maximize the answer before taking the mod and not after taking it.
//
//
//
//Example 1:
//
//
//Input: root = [1,2,3,4,5,6]
//Output: 110
//Explanation: Remove the red edge and get 2 binary trees with sum 11 and 10. Their product is 110 (11*10)
//Example 2:
//
//
//Input: root = [1,null,2,3,4,null,null,5,6]
//Output: 90
//Explanation: Remove the red edge and get 2 binary trees with sum 15 and 6.Their product is 90 (15*6)
//
//
//Constraints:
//
//The number of nodes in the tree is in the range [2, 5 * 104].
//1 <= Node.val <= 104


package Tree;

import TreeUtil.BinaryTree;
import TreeUtil.TreeNode;

public class MaximumProductOfSplittedBinaryTree_1339 {
//     approch : first get sum of all nodes
    // then use a function which will take sum of subtree now we can calculate product
    // by substracting current subtree sum - total give as rest of subtree value
    // product it with current subtree
//     we can maximize it in static variaable
//    and recursion can return sum of subtrees;
//     time complexity :O(n)
//     space complexity :O(n)
    private static long max;
    private static final int MOD = 1000000007;

    public static int maxProduct(TreeNode root) {
        max = 0;
        int totalSum = sumAll(root);
        postOrderGetSum(root, totalSum);
        return (int)(max % MOD);  // apply mod only once here
    }

    public static int sumAll(TreeNode root) {
        if (root == null) return 0;
        return sumAll(root.left) + sumAll(root.right) + root.val;
    }

    public static long postOrderGetSum(TreeNode root, int totalSum) {
        if (root == null) return 0;
        long left = postOrderGetSum(root.left, totalSum);
        long right = postOrderGetSum(root.right, totalSum);
        long subTreeSum = left + right + root.val;

        long product = (totalSum - subTreeSum) * subTreeSum;  // no %MOD here
        max = Math.max(product, max);

        return subTreeSum;  // return true subtree sum, not reduced
    }
    public static void main(String[] args) {


        //Example 1:

        BinaryTree root1 = new BinaryTree(1,2,3,4,5,6);
        int output1=110;

        //Example 2:

        BinaryTree root2 = new BinaryTree(1,null,2,3,4,null,null,5,6);
        int output2=90;

        int ans1 = maxProduct(root1.getRoot());
        int ans2 = maxProduct(root2.getRoot());

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
