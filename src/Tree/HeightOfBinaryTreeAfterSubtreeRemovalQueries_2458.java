//2458. Height of Binary Tree After Subtree Removal Queries
//Attempted
//Hard
//Topics
//premium lock icon
//Companies
//Hint
//You are given the root of a binary tree with n nodes. Each node is assigned a unique value from 1 to n. You are also given an array queries of size m.
//
//You have to perform m independent queries on the tree where in the ith query you do the following:
//
//Remove the subtree rooted at the node with the value queries[i] from the tree. It is guaranteed that queries[i] will not be equal to the value of the root.
//Return an array answer of size m where answer[i] is the height of the tree after performing the ith query.
//
//Note:
//
//The queries are independent, so the tree returns to its initial state after each query.
//The height of a tree is the number of edges in the longest simple path from the root to some node in the tree.
//
//
//Example 1:
//
//
//Input: root = [1,3,4,2,null,6,5,null,null,null,null,null,7], queries = [4]
//Output: [2]
//Explanation: The diagram above shows the tree after removing the subtree rooted at node with value 4.
//The height of the tree is 2 (The path 1 -> 3 -> 2).
//Example 2:
//
//
//Input: root = [5,8,9,2,1,3,7,4,6], queries = [3,2,4,8]
//Output: [3,2,3,2]
//Explanation: We have the following queries:
//- Removing the subtree rooted at node with value 3. The height of the tree becomes 3 (The path 5 -> 8 -> 2 -> 4).
//- Removing the subtree rooted at node with value 2. The height of the tree becomes 2 (The path 5 -> 8 -> 1).
//- Removing the subtree rooted at node with value 4. The height of the tree becomes 3 (The path 5 -> 8 -> 2 -> 6).
//- Removing the subtree rooted at node with value 8. The height of the tree becomes 2 (The path 5 -> 9 -> 3).
//
//
//Constraints:
//
//The number of nodes in the tree is n.
//2 <= n <= 105
//1 <= Node.val <= n
//All the values in the tree are unique.
//m == queries.length
//1 <= m <= min(n, 104)
//1 <= queries[i] <= n
//queries[i] != root.val


package Tree;

import TreeUtil.BinaryTree;
import TreeUtil.TreeNode;

import java.util.Arrays;

public class HeightOfBinaryTreeAfterSubtreeRemovalQueries_2458 {

    // brute force approch : use get hieght method and caluclate height if the root is removed once return 0 ;
    // time complexity : O(n)
    // space complexity : O(n)
    public static int[] treeQueries(TreeNode root, int[] queries) {
        int [] res = new int [queries.length];
        int idx =0;
        for(int x:queries){
            res[idx]=getHeight(root,queries[idx])-1;
            idx++;
        }
        return res;
    }

    public static int getHeight(TreeNode root , int nodeval){
        if(root==null){
            return 0;
        }
        if(root.val==nodeval){
            return 0;
        }
        int left = getHeight(root.left,nodeval);
        int right = getHeight(root.right,nodeval);
        return Math.max(left,right)+1;
    }

    public static boolean check(int [] arr1, int [] arr2 ){
        if(arr1.length!=arr2.length){return false;}
        for(int i=0;i<arr1.length;i++){
            if(arr1[i]!=arr2[i]){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        //Example 1:

        BinaryTree root1 = new BinaryTree(1,3,4,2,null,6,5,null,null,null,null,null,7);
        int [] queries1 = {4};
        int [] output1= {2};

        //Example 2:

        BinaryTree root2 = new BinaryTree(5,8,9,2,1,3,7,4,6);
        int [] queries2 = {3,2,4,8};
        int [] output2= {3,2,3,2};

        int [] ans1= treeQueries(root1.getRoot(),queries1);
        int [] ans2= treeQueries(root2.getRoot(),queries2);

        if(check(ans1,output1)) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Actual Output :"+ Arrays.toString(output1) );
            System.out.println("Your Output :"+Arrays.toString(ans1));
        }
        if(check(ans2,output2)) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Actual Output :"+Arrays.toString(output2 ));
            System.out.println("Your Output :"+Arrays.toString(ans2));
        }


    }

}
