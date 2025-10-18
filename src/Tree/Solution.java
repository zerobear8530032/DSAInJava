package Tree;

import TreeUtil.BinaryTree;
import TreeUtil.TreeNode;

class Solution {
    static TreeNode LCA;
    static boolean pNodefound;
    static boolean qNodefound;
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        LCA=null;
        pNodefound= false;
        qNodefound = false;
        helper(root,p,q);
        if(LCA!=null){
            return LCA;
        }else if(pNodefound){
            return p;
        }else{
            return q;
        }
    }

    public static boolean helper(TreeNode root, TreeNode p ,TreeNode q){
        if(root==null){return false;}
        if(p.val==root.val){
            pNodefound= true;
            return true;
        }
        if(q.val==root.val){
            qNodefound= true;
            return true;
        }

        boolean left=helper(root.left,p,q);
        boolean right=helper(root.right,p,q);
        if(left && right && LCA ==null){
            LCA= root;
        }
        if(left || right){return true;}
        return false;
    }

    public static void main(String[] args) {
        BinaryTree root1 = new BinaryTree(5,3,8,1,4,7,9,null,2);
        TreeNode p1 = root1.getNode(3), q1 = root1.getNode(8);
        TreeNode output1= root1.getNode(5);

        BinaryTree root2 = new BinaryTree(5,3,8,1,4,7,9,null,2);
        TreeNode p2 = root1.getNode(2), q2 = root1.getNode(4);
        TreeNode output2= root1.getNode(5);

        TreeNode ans1 = lowestCommonAncestor(root1.getRoot(),p1,q1);
        TreeNode ans2 = lowestCommonAncestor(root2.getRoot(),p2,q2);
    }
}
