//687. Longest Univalue Path
//        Solved
//Medium
//        Topics
//premium lock icon
//        Companies
//Given the root of a binary tree, return the length of the longest path, where each node in the path has the same value. This path may or may not pass through the root.
//
//The length of the path between two nodes is represented by the number of edges between them.
//
//
//
//Example 1:
//
//
//Input: root = [5,4,5,1,1,null,5]
//Output: 2
//Explanation: The shown image shows that the longest path of the same value (i.e. 5).
//Example 2:
//
//
//Input: root = [1,4,5,4,4,null,5]
//Output: 2
//Explanation: The shown image shows that the longest path of the same value (i.e. 4).
//
//
//Constraints:
//
//The number of nodes in the tree is in the range [0, 104].
//        -1000 <= Node.val <= 1000
//The depth of the tree will not exceed 1000.

package Tree;

import TreeUtil.BinaryTree;
import TreeUtil.TreeNode;

public class LongestUnivaluePath_687 {

    static  int res;
    public static int longestUnivaluePath(TreeNode root) {
        res=0;
        helper(root);
        return res;
    }
    public static int [] helper(TreeNode root){
        if(root==null){
            return new int[]{Integer.MIN_VALUE,0};
        }
        if(isLeaf(root)){
            return new int []{root.val,0};
        }
        int [] left = helper(root.left);
        int [] right = helper(root.right);
        int  left_node_val = left[0];
        int  left_longest= left[1];
        int  right_node_val = right[0];
        int  right_longest= right[1];
        if(left_node_val==root.val && right_node_val==root.val){
            res= Math.max(res,2+left_longest+right_longest);
            return new int [] {root.val,Math.max(left_longest,right_longest)+1};
        }
        else if(left_node_val==root.val){
            res= Math.max(res,1+left_longest);
            return new int []{root.val,1+left_longest};
        }
        else if(right_node_val==root.val){
            res= Math.max(res,1+right_longest);
            return new int []{root.val,1+right_longest};
        }else{
            return new int [] {root.val,0};
        }
    }
    public static boolean isLeaf(TreeNode node){
        return node.left==null && node.right==null;
    }

    public static void main(String[] args) {
        //Example 1:

        BinaryTree root1 = new BinaryTree(5,4,5,1,1,null,5);
        int output1= 2;

        //Example 2:

        BinaryTree root2 = new BinaryTree(1,4,5,4,4,null,5);
        int output2= 2;

        int ans1= longestUnivaluePath(root1.getRoot());
        int ans2= longestUnivaluePath(root2.getRoot());

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
