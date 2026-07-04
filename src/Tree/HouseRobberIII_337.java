//337. House Robber III
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//
//The thief has found himself a new place for his thievery again. There is only one entrance to this area, called root.
//
//Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that all houses in this place form a binary tree. It will automatically contact the police if two directly-linked houses were broken into on the same night.
//
//Given the root of the binary tree, return the maximum amount of money the thief can rob without alerting the police.
//
//
//
//Example 1:
//
//Input: root = [3,2,3,null,3,null,1]
//
//Output: 7
//
//Explanation:
//
//Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
//
//Example 2:
//
//Input: root = [3,4,5,1,3,null,1]
//
//Output: 9
//
//Explanation:
//
//Maximum amount of money the thief can rob = 4 + 5 = 9.
//
//
//
//Constraints:
//
//The number of nodes in the tree is in the range [1, 10^4].
//0 <= Node.val <= 10^4

package Trees;

import Tree.TreeUtil.BinaryTree;
import Tree.TreeUtil.TreeNode;

public class HouseRobberIII_337 {

    // approach :
    // For every node we calculate two values:
    // 1. withRoot    -> maximum money if we rob the current node.
    //                  Then we cannot rob its immediate children.
    // 2. withoutRoot -> maximum money if we skip the current node.
    //                  Then each child can either be robbed or skipped,
    //                  whichever gives a larger value.
    //
    // helper() returns {withRoot, withoutRoot}.
    //
    // Time Complexity : O(n)
    // Space Complexity : O(h)
    // h = height of the tree (O(n) in worst case, O(log n) for balanced tree)

    public static int rob(TreeNode root) {
        int[] pair = helper(root);
        return Math.max(pair[0], pair[1]);
    }

    private static int[] helper(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }

        int[] left = helper(root.left);
        int[] right = helper(root.right);

        int withRoot = root.val + left[1] + right[1];

        int withoutRoot =
                Math.max(left[0], left[1]) +
                        Math.max(right[0], right[1]);

        return new int[]{withRoot, withoutRoot};
    }

    public static void main(String[] args) {

        // Example 1:
        TreeNode root1 = new BinaryTree(3,2,3,null,3,null,1).getRoot();

        int output1 = 7;

        // Example 2:
        TreeNode root2 = new BinaryTree(3,4,5,1,3,null,1).getRoot();
        int output2 = 9;

        int ans1 = rob(root1);
        int ans2 = rob(root2);

        if (ans1 == output1) {
            System.out.println("Case 1 Passed");
        } else {
            System.out.println("Case 1 Failed");
            System.out.println("Actual Output : " + output1);
            System.out.println("Your Output   : " + ans1);
        }

        if (ans2 == output2) {
            System.out.println("Case 2 Passed");
        } else {
            System.out.println("Case 2 Failed");
            System.out.println("Actual Output : " + output2);
            System.out.println("Your Output   : " + ans2);
        }
    }

}