//236. Lowest Common Ancestor of a Binary Tree
//        Solved
//Medium
//        Topics
//premium lock icon
//        Companies
//Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
//
//According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
//
//
//
//Example 1:
//
//
//Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//Output: 3
//Explanation: The LCA of nodes 5 and 1 is 3.
//Example 2:
//
//
//Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//Output: 5
//Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
//Example 3:
//
//Input: root = [1,2], p = 1, q = 2
//Output: 1
//
//
//Constraints:
//
//The number of nodes in the tree is in the range [2, 105].
//        -109 <= Node.val <= 109
//All Node.val are unique.
//        p != q
//p and q will exist in the tree.


package Tree;

import TreeUtil.BinaryTree;
import TreeUtil.TreeNode;

public class LowestCommonAncestorOfABinarTree_36 {

//    brute force approch :
//    here we check from each and every node and check its distance to p and q
//    then we will take the node which have smallest distance from p and q combine as answer
//    time complexity : O(n)
//    space complexity : O(n)
    static TreeNode lca;
    static int minDistance ;

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        minDistance = Integer.MAX_VALUE;
        lca = null;
        int dispq= findDistance(p,q,0);
        int disqp= findDistance(p,q,0);
        if(dispq!=Integer.MAX_VALUE){return p;}
        if(disqp!=Integer.MAX_VALUE){return q;}
        helper(root, p, q);
        return lca;
    }

    public static void helper(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) {
            return;
        }

        int distancep = findDistance(node, p, 0);
        int distanceq = findDistance(node, q, 0);
        if (distancep != Integer.MAX_VALUE && distanceq != Integer.MAX_VALUE) {
            int totaldis = distancep + distanceq;
            if (totaldis < minDistance) {
                lca = node;
                minDistance = totaldis;
            }
        }
        helper(node.left, p, q);
        helper(node.right, p, q);
    }

    public static int findDistance(TreeNode node, TreeNode findNode, int distance) {
        if (node == null) {
            return Integer.MAX_VALUE;
        }
        if (node == findNode) {
            return distance;
        }
        int left =findDistance(node.left, findNode, distance + 1);
        int right =findDistance(node.right, findNode, distance + 1);
        return Math.min(left,right);
    }

    //    better force approch :
    //    here we check a t every node and see we can find p or q at left or right side or not
    //    we use in order traversal where if we found a both nodes from one node is our answer
    //    other wise the the node which are present have the other node as children so we can return the node which we already found

    //    time complexity : O(n)
    //    space complexity : O(height of tree)
    public static TreeNode lowestCommonAncestorBest(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode left =lowestCommonAncestorBest(root.left, p, q);
        TreeNode right = lowestCommonAncestorBest(root.right, p, q);
        if(left!=null && right!=null){return root;}
        return left==null?right:left;// return right if  left ==null other wose right
    }
    public static void main(String[] args) {

        //Example 1:

        BinaryTree root1 =  new BinaryTree(3,5,1,6,2,0,8,null,null,7,4);
        TreeNode p1 = root1.getNode(5), q1 = root1.getNode(1);
        TreeNode output1=root1.getNode(3);

        //Example 2:

        BinaryTree root2 =  new BinaryTree(3,5,1,6,2,0,8,null,null,7,4);
        TreeNode p2 = root2.getNode(5), q2 = root2.getNode(4);
        TreeNode output2=root2.getNode(5);

        //Example 3:

        BinaryTree root3 =  new BinaryTree(1,2);
        TreeNode p3= root3.getNode(1), q3= root3.getNode(2);
        TreeNode output3= root3.getNode(1);

        System.out.println("BruteForce approch");

        TreeNode ans1 = lowestCommonAncestor(root1.getRoot(),p1,q1);
        TreeNode ans2 = lowestCommonAncestor(root2.getRoot(),p2,q2);
        TreeNode ans3 = lowestCommonAncestor(root3.getRoot(),p3,q3);

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
        }if(ans3.equals(output3)) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Actual Output :"+output3 );
            System.out.println("Your Output :"+ans3);
        }
        System.out.println("Best approch");

         ans1 = lowestCommonAncestor(root1.getRoot(),p1,q1);
         ans2 = lowestCommonAncestor(root2.getRoot(),p2,q2);
         ans3 = lowestCommonAncestor(root3.getRoot(),p3,q3);

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
        }if(ans3.equals(output3)) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Actual Output :"+output3 );
            System.out.println("Your Output :"+ans3);
        }

    }
}
