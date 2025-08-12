//129. Sum Root to Leaf Numbers

//You are given the root of a binary tree containing digits from 0 to 9 only.
//
//Each root-to-leaf path in the tree represents a number.
//
//For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
//Return the total sum of all root-to-leaf numbers. Test cases are generated so that the answer will fit in a 32-bit integer.
//A leaf node is a node with no children.
//
//
//
//Example 1:
//
//
//Input: root = [1,2,3]
//Output: 25
//Explanation:
//The root-to-leaf path 1->2 represents the number 12.
//The root-to-leaf path 1->3 represents the number 13.
//Therefore, sum = 12 + 13 = 25.
//Example 2:
//
//
//Input: root = [4,9,0,5,1]
//Output: 1026
//Explanation:
//The root-to-leaf path 4->9->5 represents the number 495.
//The root-to-leaf path 4->9->1 represents the number 491.
//The root-to-leaf path 4->0 represents the number 40.
//Therefore, sum = 495 + 491 + 40 = 1026.
//
//
//Constraints:
//
//The number of nodes in the tree is in the range [1, 1000].
//        0 <= Node.val <= 9
//The depth of the tree will not exceed 10.
package Tree;

import TreeUtil.BinaryTree;
import TreeUtil.TreeNode;

public class SumRootToLeafNumbers_129 {
//     approch : here we know the path sum if from root to leaf node so we can
//    use dfs  we can use a helper function that take the curr num which is the num
//    till the node we have reach and that helper function will return sum of all the number
//    the dfs will check if the node is null it will return 0 cause -> if we reach null we does not need
//    to add in our sum
//    if we reach a leaf node means left and right are null we will update the curr sum to add current node lnumber
//    and return the new num
//    to create path num we can do currsum*10 + currnode.val this will add the node val at first place of numebr
//    now because we were in dfs recursion we can just sum left side and right side wthiw will give path sum of left
//    and right and we can return the final answer
//    time complexity :O(n)
//    space complexity :O(n)
    public static int sumNumbers(TreeNode root) {
        return helper(root,0);
    }
    private static int helper(TreeNode node , int currnum){
        if(node==null){
            return 0;
        }
        if(isLeaf(node)){// if we does not use this condition the currnum value will get return 2 time from left and right which we does not want
            return currnum*10+node.val;
        }
        int left = helper(node.left,currnum*10+node.val);
        int right = helper(node.right,currnum*10+node.val);
        return left+right;
    }
    private static boolean isLeaf(TreeNode node){
        return node.left==null && node.right==null;
    }
    public static void main(String[] args) {

    //Example 1:

    BinaryTree root1  =  new BinaryTree(1,2,3);
    int output1= 25;

    //Example 2:

    BinaryTree root2  =  new BinaryTree(4,9,0,5,1);
    int output2 = 1026;

    int ans1=sumNumbers(root1.getRoot());
    int ans2=sumNumbers(root2.getRoot());

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
