//971. Flip Binary Tree To Match Preorder Traversal
//Medium
//Topics
//premium lock icon
//Companies
//You are given the root of a binary tree with n nodes, where each node is uniquely assigned a value from 1 to n. You are also given a sequence of n values voyage, which is the desired pre-order traversal of the binary tree.
//
//Any node in the binary tree can be flipped by swapping its left and right subtrees. For example, flipping node 1 will have the following effect:
//
//
//Flip the smallest number of nodes so that the pre-order traversal of the tree matches voyage.
//
//Return a list of the values of all flipped nodes. You may return the answer in any order. If it is impossible to flip the nodes in the tree to make the pre-order traversal match voyage, return the list [-1].
//
//
//
//Example 1:
//
//
//Input: root = [1,2], voyage = [2,1]
//Output: [-1]
//Explanation: It is impossible to flip the nodes such that the pre-order traversal matches voyage.
//Example 2:
//
//
//Input: root = [1,2,3], voyage = [1,3,2]
//Output: [1]
//Explanation: Flipping node 1 swaps nodes 2 and 3, so the pre-order traversal matches voyage.
//Example 3:
//
//
//Input: root = [1,2,3], voyage = [1,2,3]
//Output: []
//Explanation: The tree's pre-order traversal already matches voyage, so no nodes need to be flipped.
//
//
//Constraints:
//
//The number of nodes in the tree is n.
//n == voyage.length
//1 <= n <= 100
//1 <= Node.val, voyage[i] <= n
//All the values in the tree are unique.
//All the values in voyage are unique.

package Tree;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import TreeUtil.BinaryTree;
import TreeUtil.TreeNode;



public class FlipBinaryTreeToMatchPreorderTraversal_971 {
//    approch : check root node if its equal check left and right node if all are equal we can get going if not we can add the root to res
//  time complexity :O(n)
//  space complexity :O(n)
//    2458. Height of Binary Tree After Subtree Removal Queries
    static int i = 0;
    static List<Integer> res = new ArrayList<>();

    public static List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        i=0;
        res=new ArrayList<>();
        if (dfs(root, voyage)) {
            return res;
        }
        return Arrays.asList(-1);
    }

    private static boolean dfs(TreeNode node, int[] voyage) {
        if (node == null) return true;

        // If current node doesn’t match voyage, fail
        if (node.val != voyage[i++]) return false;

        // If left child exists and doesn’t match the next voyage value
        if (node.left != null && i < voyage.length && node.left.val != voyage[i]) {
            // flip needed
            res.add(node.val);
            return dfs(node.right, voyage) && dfs(node.left, voyage);
        }

        // normal preorder
        return dfs(node.left, voyage) && dfs(node.right, voyage);
    }
    public static void main(String[] args) {
        //Example 1:

        BinaryTree root1 = new BinaryTree(1,2);
        int [] voyage1 = {2,1};
        List<Integer>  output1=new ArrayList<>(Arrays.asList(-1));

        //Example 2:

        BinaryTree root2 = new BinaryTree(1,2,3);
        int [] voyage2 = {1,3,2};
        List<Integer>  output2=new ArrayList<>(Arrays.asList(1));

        //Example 3:

        BinaryTree root3 = new BinaryTree(1,2,3);
        int [] voyage3 = {1,2,3};
        List<Integer>  output3=new ArrayList<>();

        List<Integer> ans1 = flipMatchVoyage(root1.getRoot(),voyage1);
        List<Integer> ans2 = flipMatchVoyage(root2.getRoot(),voyage2);
        List<Integer> ans3 = flipMatchVoyage(root3.getRoot(),voyage3);

        if(ans1.equals(output1)) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Actual Output :"+output1 );
            System.out.println("Your Output :"+ans1);
        }
        if(ans2.equals(output2)) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Actual Output :"+output2 );
            System.out.println("Your Output :"+ans2);
        }
        if(ans3== output3 || ans3.equals(output3)) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Actual Output :"+output3);
            System.out.println("Your Output :"+ans3);
        }

    }
}
