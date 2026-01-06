//1161. Maximum Level Sum of a Binary Tree
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.
//
//Return the smallest level x such that the sum of all the values of nodes at level x is maximal.
//
//
//
//Example 1:
//
//
//Input: root = [1,7,0,7,-8,null,null]
//Output: 2
//Explanation:
//Level 1 sum = 1.
//Level 2 sum = 7 + 0 = 7.
//Level 3 sum = 7 + -8 = -1.
//So we return the level with the maximum sum which is level 2.
//Example 2:
//
//Input: root = [989,null,10250,98693,-89388,null,null,null,-32127]
//Output: 2
//
//
//Constraints:
//
//The number of nodes in the tree is in the range [1, 104].
//-105 <= Node.val <= 105
package Tree;

import TreeUtil.BinaryTree;
import TreeUtil.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumLevelSumOfABinaryTree_1161 {
    public static int maxLevelSum(TreeNode root) {
        // simple BFS algo :
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level =1;
        int res =-1;
        int maxSum =Integer.MIN_VALUE;
        while(!queue.isEmpty()){
            int size =queue.size();
            int sum =0;
            for(int i =0;i<size;i++){
                TreeNode poped= queue.poll();
                sum+=poped.val;
                if(poped.left!=null){
                    queue.add(poped.left);
                }
                if(poped.right!=null){
                    queue.add(poped.right);
                }
            }
            if(maxSum<sum){
                res=level;
                maxSum =sum;
            }
            level++;
        }
        return res;
    }
    public static void main(String[] args) {
        //Example 1:

        TreeNode root1 = new BinaryTree(1,7,0,7,-8,null,null).getRoot();
        int output1= 2;

        //Example 2:

        TreeNode root2 = new BinaryTree(989,null,10250,98693,-89388,null,null,null,-32127).getRoot();
        int output2= 2;

        int ans1= maxLevelSum(root1);
        int ans2= maxLevelSum(root2);

        if(output1==(ans1)) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Actual Output :"+output1 );
            System.out.println("Your Output :"+ans1);
        }
        if(output2==(ans2)) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Actual Output :"+output2 );
            System.out.println("Your Output :"+ans2);
        }

    }
}
