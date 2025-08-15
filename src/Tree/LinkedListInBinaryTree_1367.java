//1367. Linked List in Binary Tree
//        Medium
//Topics
//premium lock icon
//        Companies
//Hint
//Given a binary tree root and a linked list with head as the first node.
//
//Return True if all the elements in the linked list starting from the head correspond to some downward path connected in the binary tree otherwise return False.
//
//        In this context downward path means a path that starts at some node and goes downwards.
//
//
//
//Example 1:
//
//
//
//Input: head = [4,2,8], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]
//Output: true
//Explanation: Nodes in blue form a subpath in the binary Tree.
//Example 2:
//
//
//
//Input: head = [1,4,2,6], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]
//Output: true
//Example 3:
//
//Input: head = [1,4,2,6,8], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]
//Output: false
//Explanation: There is no path in the binary tree that contains all the elements of the linked list from head.
//
//
//        Constraints:
//
//The number of nodes in the tree will be in the range [1, 2500].
//The number of nodes in the list will be in the range [1, 100].
//        1 <= Node.val <= 100 for each node in the linked list and binary tree.

package Tree;

import LinkedList.Utils.ListNode;
import LinkedList.Utils.MyList;
import TreeUtil.BinaryTree;
import TreeUtil.TreeNode;

public class LinkedListInBinaryTree_1367 {

//    approch : here we use a dfs where we go through each node
//    and try to check the linkedlist is avaiable from the node or not
//    time complexity : O(n*h) : n is node h is hieght of binary tree
//    space complexity : O(h) : height of binary tree
    public static boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null) return false;

        // Try to start a match here
        if (checkRestPath(head, root)) return true;

        // Or try starting in left or right subtrees
        return isSubPath(head, root.left) || isSubPath(head, root.right);

    }
    // check the path we current have contains list or not
    public static boolean checkRestPath(ListNode node, TreeNode root){
        if(node==null){return true;}
        if(root==null){return false;}
        if(check(node,root)){
            // check left side
            boolean left = checkRestPath(node.next,root.left);
            // check right side
            boolean right = checkRestPath(node.next,root.right);
            return left || right;
        }else{
            return false;
        }

    }




    public static boolean check(ListNode Lnode, TreeNode Tnode){
        return Lnode.val==Tnode.val;
    }
    public static void main(String[] args) {
        //Example 1:

        MyList head1 = new MyList(4,2,8);
        BinaryTree root1 = new BinaryTree(1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3);
        boolean output1= true;

        //Example 2:

         MyList head2 = new MyList(1,4,2,6);
         BinaryTree root2 = new BinaryTree(1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3);
         boolean output2= true;

        //Example 3:

        MyList head3 = new MyList(1,4,2,6,8);
        BinaryTree root3 = new BinaryTree(1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3);
        boolean output3= false;

        //Example 4:

        MyList head4 = new MyList(1,10);
        BinaryTree root4 = new BinaryTree(1,null,1,10,1,9);
        boolean output4= true;


        boolean ans1= isSubPath(head1.getHead(),root1.getRoot());
        boolean ans2= isSubPath(head2.getHead(),root2.getRoot());
        boolean ans3= isSubPath(head3.getHead(),root3.getRoot());
        boolean ans4= isSubPath(head4.getHead(),root4.getRoot());

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
        if(ans3==(output3)) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Actual Output :"+output3 );
            System.out.println("Your Output :"+ans3);
        }
        if(ans4==(output4)) {
            System.out.println("Case 4 Passed");
        }else {
            System.out.println("Case 4 Failed");
            System.out.println("Actual Output :"+output4 );
            System.out.println("Your Output :"+ans4);
        }


    }
}
