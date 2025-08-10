//
//230. Kth Smallest Element in a BST
//Solved
//        Medium
//Topics
//premium lock icon
//        Companies
//Hint
//Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
//
//
//
//Example 1:
//
//
//Input: root = [3,1,4,null,2], k = 1
//Output: 1
//Example 2:
//
//
//Input: root = [5,3,6,2,4,null,null,1], k = 3
//Output: 3
//
//
//Constraints:
//
//The number of nodes in the tree is n.
//1 <= k <= n <= 104
//        0 <= Node.val <= 104
//
//
//Follow up: If the BST is modified often (i.e., we can do insert and delete operations) and you need to find the kth smallest frequently, how would you optimize?

package Tree;


import TreeUtil.BinaryTree;
import TreeUtil.TreeNode;

public class KthSmallestElementInABST_230 {

     static int count=0;
    public static int kthSmallest(TreeNode root, int k){
        count=0;
        return helper(root,k).val;
    }
    public static TreeNode helper(TreeNode root, int k) {
        if(root==null){return null;}
        TreeNode left = helper(root.left,k);
        if(left!=null){
            return left;
        }
        count++;
        if(count==k){return root;}
        return helper(root.right,k);
    }

    public static void main(String[] args) {
        //Example 1:

        BinaryTree root1 = new BinaryTree(3,1,4,null,2);
        int k1 = 1;
        int output1=1;

        //Example 2:

        BinaryTree root2 = new BinaryTree(5,3,6,2,4,null,null,null,1);
        int k2 = 3;
        int output2=3;

        int ans1= kthSmallest(root1.getRoot(),k1);
        int ans2= kthSmallest(root2.getRoot(),k2);

        if(ans1==(output1)) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Actual Output :"+output1 );
            System.out.println("Your Output :"+ans1);
        }
        if(ans2==(output2)) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Actual Output :"+output2 );
            System.out.println("Your Output :"+ans2);
        }
    }
}
