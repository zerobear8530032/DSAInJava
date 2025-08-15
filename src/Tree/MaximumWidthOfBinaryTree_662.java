//662. Maximum Width of Binary Tree
//        Medium
//Topics
//premium lock icon
//        Companies
//Given the root of a binary tree, return the maximum width of the given tree.
//
//The maximum width of a tree is the maximum width among all levels.
//
//The width of one level is defined as the length between the end-nodes (the leftmost and rightmost non-null nodes), where the null nodes between the end-nodes that would be present in a complete binary tree extending down to that level are also counted into the length calculation.
//
//It is guaranteed that the answer will in the range of a 32-bit signed integer.
//
//
//
//Example 1:
//
//
//Input: root = [1,3,2,5,3,null,9]
//Output: 4
//Explanation: The maximum width exists in the third level with length 4 (5,3,null,9).
//Example 2:
//
//
//Input: root = [1,3,2,5,null,null,9,6,null,7]
//Output: 7
//Explanation: The maximum width exists in the fourth level with length 7 (6,null,null,null,null,null,7).
//Example 3:
//
//
//Input: root = [1,3,2,5]
//Output: 2
//Explanation: The maximum width exists in the second level with length 2 (3,2).
//
//
//Constraints:
//
//The number of nodes in the tree is in the range [1, 3000].
//        -100 <= Node.val <= 100

package Tree;

import TreeUtil.BinaryTree;
import TreeUtil.TreeNode;
import java.util.LinkedList;

public class MaximumWidthOfBinaryTree_662 {
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
//    approch : we can use a bfs approch where we put every node in queue even if its null and when we pop a null node we will
//    add 2 null child nodes then for caluclating the width we can remove all nulls from front and end then the size of queue is our answer
//    we can max it out per iteration
//   time complexity :O(n)
//   time complexity :O(2^h): cause heigh of the tree can be any but we will store null node will take space in queue
        public static int widthOfBinaryTree(TreeNode root) {
            LinkedList<TreeNode> queue = new LinkedList();
            queue.add(root);
            int res = 0;

            while (!queue.isEmpty()) {
                print(queue);
                while (!queue.isEmpty() && queue.peekFirst() == null) {
                    queue.remove();
                }
                while (!queue.isEmpty() && queue.peekLast() == null) {
                    queue.removeLast();
                }
                int levelSize = queue.size();
                res=Math.max(res,levelSize);
                for(int i =0;i<levelSize;i++){
                    TreeNode removed = queue.remove();
                    if(removed==null){
                        queue.add(null);
                        queue.add(null);
                    }else{
                        queue.add(removed.left);
                        queue.add(removed.right);
                    }
                }

            }
            return res;
        }

        public static void print(LinkedList<TreeNode> queue){
            for(TreeNode node :queue){
                if(node==null){
                    System.out.print("null  ");
                }else{

                    System.out.print(node.val+"  ");
                }
            }
            System.out.println();
        }


    public static void main(String[] args) {
        //Example 1:

        BinaryTree root1 = new BinaryTree(1,3,2,5,3,null,9);
        int output1=4;

        //Example 2:

        BinaryTree root2 = new BinaryTree(1,3,2,5,null,null,9,6,null,7);
        int output2=7;

        //Example 3:

        BinaryTree root3 = new BinaryTree(1,3,2,5);
        int output3=2;

        System.out.println("Brute Force Approch :");

        int ans1 = widthOfBinaryTree(root1.getRoot());
        int ans2 = widthOfBinaryTree(root2.getRoot());
        int ans3 = widthOfBinaryTree(root3.getRoot());


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
        if(ans3==(output3)) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Actual Output :"+output3 );
            System.out.println("Your Output :"+ans3);
        }

    }
}
