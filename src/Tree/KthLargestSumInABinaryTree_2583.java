//2583. Kth Largest Sum in a Binary Tree
//Medium
//Hint
//You are given the root of a binary tree and a positive integer k.
//The level sum in the tree is the sum of the values of the nodes that are on the same level.
//Return the kth largest level sum in the tree (not necessarily distinct). If there are fewer than k levels in the tree, return -1.
//Note that two nodes are on the same level if they have the same distance from the root.
//
//Example 1:
//
//Input: root = [5,8,9,2,1,3,7,4,6], k = 2
//Output: 13
//Explanation: The level sums are the following:
//        - Level 1: 5.
//        - Level 2: 8 + 9 = 17.
//        - Level 3: 2 + 1 + 3 + 7 = 13.
//        - Level 4: 4 + 6 = 10.
//The 2nd largest level sum is 13.
//Example 2:
//
//
//Input: root = [1,2,null,3], k = 1
//Output: 3
//Explanation: The largest level sum is 3.
//
//
//Constraints:
//
//The number of nodes in the tree is n.
// 2 <= n <= 105
// 1 <= Node.val <= 106
// 1 <= k <= n

package Tree;

import TreeUtil.BinaryTree;
import TreeUtil.TreeNode;

import java.util.*;

public class KthLargestSumInABinaryTree_2583 {

    public static long kthLargestLevelSum(TreeNode root, int k) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Long> levelSum = new ArrayList<>();
        while(!queue.isEmpty()){
            int levelSize= queue.size();
            long sum =0;
            for(int i =0;i<levelSize;i++){
                TreeNode poped = queue.remove();
                sum+=poped.val;
                if(poped.left!=null){
                    queue.add(poped.left);
                }
                if(poped.right!=null){
                    queue.add(poped.right);
                }
            }
            levelSum.add(sum);
        }
        Collections.sort(levelSum);
        if(k>levelSum.size()){return -1;}
        return levelSum.get(levelSum.size()-k);
    }
    public static void main(String[] args) {
        //Example 1:

        BinaryTree root1 = new BinaryTree(5,8,9,2,1,3,7,4,6);
        int k1= 2;
        int output1= 13;

        //Example 2:

        BinaryTree root2 = new BinaryTree(1,2,null,3);
        int k2= 1;
        int output2= 3;

        long ans1 = kthLargestLevelSum(root1.getRoot(),k1);
        long ans2 = kthLargestLevelSum(root2.getRoot(),k2);

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
