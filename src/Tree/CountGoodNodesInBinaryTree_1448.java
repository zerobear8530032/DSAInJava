//1448. Count Good Nodes in Binary Tree
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no nodes with a value greater than X.
//
//Return the number of good nodes in the binary tree.
//
//
//
//Example 1:
//
//
//
//Input: root = [3,1,4,3,null,1,5]
//Output: 4
//Explanation: Nodes in blue are good.
//Root Node (3) is always a good node.
//Node 4 -> (3,4) is the maximum value in the path starting from the root.
//Node 5 -> (3,4,5) is the maximum value in the path
//Node 3 -> (3,1,3) is the maximum value in the path.
//Example 2:
//
//
//
//Input: root = [3,3,null,4,2]
//Output: 3
//Explanation: Node 2 -> (3, 3, 2) is not good, because "3" is higher than it.
//Example 3:
//
//Input: root = [1]
//Output: 1
//Explanation: Root is considered as good.
//
//
//Constraints:
//
//The number of nodes in the binary tree is in the range [1, 10^5].
//Each node's value is between [-10^4, 10^4].
package Tree;

import TreeUtil.BinaryTree;
import TreeUtil.TreeNode;

public class CountGoodNodesInBinaryTree_1448 {
//    approch :
//    we can use a helpder which will do pre order traversal
//    where we first check current node value is greater or equal to max of nodes we seen till now
//    if yes we can increase the good count other wise we can left explore left , right directions
//    do this for every sub tree at the end return good + left + right
//    time complexity : O(n)
//    space complexity : O(n)
    public static int goodNodes(TreeNode root) {
        return countGoodNodes(root, Integer.MIN_VALUE);
    }

    public static int countGoodNodes(TreeNode root, int max){
        if(root==null){return 0;}
        int good=0;
        if(max<=root.val){
            good+=1;
        }
        max= Math.max(max,root.val);
        int left = countGoodNodes(root.left,max);
        int right = countGoodNodes(root.right,max);
        return left+right+good;
    }
    public static void main(String[] args) {
        //Example 1:

        BinaryTree root1 = new BinaryTree(2,1,1,3,null,1,5);
        int output1= 3;

        //Example 2:


        BinaryTree root2 = new BinaryTree(1,2,-1,3,4);
        int output2= 4;

        int ans1 = goodNodes(root1.getRoot());
        int ans2 = goodNodes(root2.getRoot());
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
