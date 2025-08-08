//116. Populating Next Right Pointers in Each Node
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:
//
//struct Node {
//  int val;
//  Node *left;
//  Node *right;
//  Node *next;
//}
//Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
//
//Initially, all next pointers are set to NULL.
//
// 
//
//Example 1:
//
//
//Input: root = [1,2,3,4,5,6,7]
//Output: [1,#,2,3,#,4,5,6,7,#]
//Explanation: Given the above perfect binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.
//Example 2:
//
//Input: root = []
//Output: []
// 
//
//Constraints:
//
//The number of nodes in the tree is in the range [0, 212 - 1].
//-1000 <= Node.val <= 1000
// 
//
//Follow-up:
//
//You may only use constant extra space.
//The recursive approach is fine. You may assume implicit stack space does not count as extra space for this problem.
package Tree;

import TreeUtil.CustomeTree;
import TreeUtil.Node;

public class PopulatingNextRightPointersInEachNode_116 {
	
//	approch :
	
//	here we know the tree are perfect binary tree
//	so we can create function which take 2 subtree and  we can go left side and right 
//	most nodes of each sub tree conneting them together 
//	then we can use root to connect each children with each other 
//	time  complexity :O(n)
//	space  complexity :O(n) : uses recursion:
	
	    public static Node connectRecursion(Node root) {
	        if(root==null){
	            return root;
	        }
	        if(root.left!=null && root.right!=null){
	            root.left.next=root.right;
	            connectBetweenSubTrees(root.left,root.right);
	            connectRecursion(root.left);
	            connectRecursion(root.right);
	        }
	        return root;  
	    }

//	    connect 2 sub tree together 
	    public static void connectBetweenSubTrees(Node leftSubTree, Node rightSubTree){
	        if(leftSubTree==null && rightSubTree==null){
	            return;
	        }

	        leftSubTree.next=rightSubTree; 
	        connectBetweenSubTrees(leftSubTree.right,rightSubTree.left);
	    }
	
//	approch : better
//	here we take the root and get the left most element 
//	now we can see its children and connect it left.next to right
//	by that we can use the next pointer to move to the sibling of the 
//	node without using the root of them 
//	by that we can use current and go at each level and pointer each element left to next untill that entire 
//	level is connected 
//	time complexity :O(n)
//	space complexity :O(1)
	
    public static Node connectIterative(Node root) {
        if(root==null){
            return root;
        }
        Node leftMost = root;
        while(leftMost.left!=null){
            Node current = leftMost;
            while(current!=null){
                current.left.next=current.right;
                if(current.next!=null){
                    current.right.next=current.next.left;
                }
                current=current.next;
            }
            leftMost= leftMost.left;
        }
        return root;
    }

    
    

	public static void main(String[] args) {
		

		//Example 1:

		CustomeTree root1 = new CustomeTree(1,2,3,4,5,6,7);
		CustomeTree output1 = new CustomeTree(1,2,3,4,5,6,7);
		output1.connect();
		
		
		//Example 2:
		
		CustomeTree root2 = new CustomeTree();
		CustomeTree output2 = new CustomeTree();
		output2.connect();
		
		System.out.println("Recursion Approch : ");
		Node ans1 = connectRecursion(root1.getRoot());
		Node ans2 = connectRecursion(root2.getRoot());
		
		

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
		
		System.out.println("Iterative Approch : ");
		
		ans1 = connectIterative(root1.getRoot());
		ans2 = connectIterative(root2.getRoot());
		
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
		
		
		

		
		

	}

}
