//a binary tree and a array arr is given you have to find a path given in array from left to right
// exists any where is the given tree
package Tree;

import TreeUtil.BinaryTree;
import TreeUtil.TreeNode;

public class FindPathExistsInATree {

    public static boolean checkPathExists(TreeNode root, int [] path){
        if(root==null){
            return path.length==0;
        }
        return helper(root,path,0);
    }
    private static boolean helper(TreeNode root, int [] path, int idx){
       if(root==null){
           return false;
       }
       if(idx>=path.length || root.val!=path[idx]){return false;}
       if(root.left==null && root.right==null && idx==path.length){return true;}
       boolean left = helper(root.left,path,idx+1);
       boolean right = helper(root.right,path,idx+1);
       return left || right;
    }

    public static  void main(String args[]){
    //  Example 1 :
        BinaryTree tree1= new BinaryTree(3,5,9,null,null,10,12,16,null,8);
        int [] paths1 = {3,9,12,8};

    //  Example 2 :
        BinaryTree tree2= new BinaryTree(3,3,null,5,9,null,null,12,16,null,8);
        int [] paths2 = {3,9,12,8};

    //  Example 3 :
        BinaryTree tree3= new BinaryTree(7,3,5,9,null,null,10,12,16,null,8);
        int [] paths3 = {3,9,12,8};

        System.out.println(checkPathExists(tree1.getRoot(),paths1));
        System.out.println(checkPathExists(tree2.getRoot(),paths2));
        System.out.println(checkPathExists(tree3.getRoot(),paths3));

    }
}
