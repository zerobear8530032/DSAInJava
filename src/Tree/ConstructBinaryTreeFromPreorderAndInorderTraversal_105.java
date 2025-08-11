//105. Construct Binary Tree from Preorder and Inorder Traversal

//        Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.
//
//
//
//        Example 1:
//
//
//        Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//        Output: [3,9,20,null,null,15,7]
//        Example 2:
//
//        Input: preorder = [-1], inorder = [-1]
//        Output: [-1]
//
//
//        Constraints:
//
//        1 <= preorder.length <= 3000
//        inorder.length == preorder.length
//        -3000 <= preorder[i], inorder[i] <= 3000
//        preorder and inorder consist of unique values.
//        Each value of inorder also appears in preorder.
//        preorder is guaranteed to be the preorder traversal of the tree.
//        inorder is guaranteed to be the inorder traversal of the tree.
//        105. Construct Binary Tree from Preorder and Inorder Traversal
//        Solved
//        Medium
//        Topics
//        premium lock icon
//        Companies
//        Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.
//
//
//
//        Example 1:
//
//
//        Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//        Output: [3,9,20,null,null,15,7]
//        Example 2:
//
//        Input: preorder = [-1], inorder = [-1]
//        Output: [-1]
//
//
//        Constraints:
//
//        1 <= preorder.length <= 3000
//        inorder.length == preorder.length
//        -3000 <= preorder[i], inorder[i] <= 3000
//        preorder and inorder consist of unique values.
//        Each value of inorder also appears in preorder.
//        preorder is guaranteed to be the preorder traversal of the tree.
//        inorder is guaranteed to be the inorder traversal of the tree.


        package Tree;

import TreeUtil.BinaryTree;
import TreeUtil.TreeNode;

import java.util.Arrays;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal_105 {
// approch :
// first we will check the current 0 index preorder that will be our root
//  then we will use this root and find its place in the inorder
//  this will give us the  node left side are left subtreenodes and right side are right subtree nodes
//  then we can easily call the function again on these function
//    for left side node we can take a subarray from 0 , index +1 for preorder and for inorder we can take 0 till index
//    similary we can take for right subtree index+1 till end of array for inorder and preorder
//    time complexity :O(n)
//    space complexity :O(n*h): sub array will take extra spaces
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0){return null;}
        int r= preorder[0];
        int index= 0;// index of root in inorder
        for(int i =0;i<inorder.length;i++){
            if(inorder[i]==r){
                index=i;
                break;
            }
        }

        TreeNode node = new TreeNode(r);
        node.left= buildTree(Arrays.copyOfRange(preorder,1,index+1),Arrays.copyOfRange(inorder,0,index));
        node.right= buildTree(Arrays.copyOfRange(preorder,index+1,preorder.length),Arrays.copyOfRange(inorder,index+1,inorder.length));
        return node;
    }
    public static void main(String[] args) {

        // Example 1:

        int [] preorder1= {3,9,20,15,7};
        int [] inorder1={9,3,15,20,7};
        BinaryTree output1= new BinaryTree(3,9,20,null,null,15,7);

        // Example 2:

        int[] preorder2={-1};
        int[] inorder2={-1};
        BinaryTree output2= new BinaryTree(-1);

        TreeNode  ans1 = buildTree(preorder1,inorder1);
        TreeNode  ans2 = buildTree(preorder2,inorder2);

        if(output1.equals( ans1)) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Ouput :"+ output1);
            System.out.println("Your Answer :"+ ans1);
        }
        if(output2.equals(ans2)) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Ouput :"+ output2);
            System.out.println("Your Answer :"+ ans2);
        }
    }
}
