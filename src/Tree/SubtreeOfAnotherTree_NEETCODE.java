//Subtree of Another Tree
//Solved
//Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.
//
//A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants. The tree tree could also be considered as a subtree of itself.
//
//Example 1:
//
//
//
//Input: root = [1,2,3,4,5], subRoot = [2,4,5]
//
//Output: true
//Example 2:
//
//
//
//Input: root = [1,2,3,4,5,null,null,6], subRoot = [2,4,5]
//
//Output: false
//Constraints:
//
//1 <= The number of nodes in both trees <= 100.
//-100 <= root.val, subRoot.val <= 100
package Tree;

import TreeUtil.BinaryTree;
import TreeUtil.Tree;
import TreeUtil.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class SubtreeOfAnotherTree_NEETCODE {
    public static  boolean isSubtree(TreeNode root, TreeNode subRoot) {
        List<TreeNode> roots= new ArrayList<>();
        findNode(root,subRoot.val,roots);
        for(TreeNode node:roots){
            if(isSameTree(subRoot,node)){
                return true;
            }
        }
        return false;
    }
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null){return true;}
        if(p==null ){return false;}
        if(q==null ){return false;}
        if(p.val!=q.val){return false;}
        boolean left= isSameTree(p.left,q.left);
        boolean right= isSameTree(p.right,q.right);
        return left && right;
    }
    public static void findNode(TreeNode root, int val,List<TreeNode> list){
        if(root==null){return ;}
        if(root.val==val){list.add(root);}
        findNode(root.left,val,list);
        findNode(root.right,val,list);
    }
    public static void main(String[] args) {
        //Example 1:

        BinaryTree root1 = new BinaryTree(1,2,3,4,5), subRoot1 = new BinaryTree(2,4,5);
        boolean output1= true;

        //Example 2:

        BinaryTree root2 = new BinaryTree(1,2,3,4,5,null,null,6),subRoot2 = new BinaryTree(2,4,5);
        boolean output2= false;

        boolean ans1 = isSubtree(root1.getRoot(),subRoot1.getRoot());
        boolean ans2 = isSubtree(root2.getRoot(),subRoot2.getRoot());

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
