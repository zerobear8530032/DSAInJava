//430. Flatten a Multilevel Doubly Linked List
//Medium
//Topics
//premium lock icon
//Companies
//You are given a doubly linked list, which contains nodes that have a next pointer, a previous pointer, and an additional child pointer. This child pointer may or may not point to a separate doubly linked list, also containing these special nodes. These child lists may have one or more children of their own, and so on, to produce a multilevel data structure as shown in the example below.
//
//Given the head of the first level of the list, flatten the list so that all the nodes appear in a single-level, doubly linked list. Let curr be a node with a child list. The nodes in the child list should appear after curr and before curr.next in the flattened list.
//
//Return the head of the flattened list. The nodes in the list must have all of their child pointers set to null.
//
// 
//
//Example 1:
//
//
//Input: head = [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
//Output: [1,2,3,7,8,11,12,9,10,4,5,6]
//Explanation: The multilevel linked list in the input is shown.
//After flattening the multilevel linked list it becomes:
//
//Example 2:
//
//
//Input: head = [1,2,null,3]
//Output: [1,3,2]
//Explanation: The multilevel linked list in the input is shown.
//After flattening the multilevel linked list it becomes:
//
//Example 3:
//
//Input: head = []
//Output: []
//Explanation: There could be empty list in the input.
// 
//
//Constraints:
//
//The number of Nodes will not exceed 1000.
//1 <= Node.val <= 105
// 
//
//How the multilevel linked list is represented in test cases:
//
//We use the multilevel linked list from Example 1 above:
//
// 1---2---3---4---5---6--NULL
//         |
//         7---8---9---10--NULL
//             |
//             11--12--NULL
//The serialization of each level is as follows:
//
//[1,2,3,4,5,6,null]
//[7,8,9,10,null]
//[11,12,null]
//To serialize all levels together, we will add nulls in each level to signify no node connects to the upper node of the previous level. The serialization becomes:
//
//[1,    2,    3, 4, 5, 6, null]
//             |
//[null, null, 7,    8, 9, 10, null]
//                   |
//[            null, 11, 12, null]
//Merging the serialization of each level and removing trailing nulls we obtain:
//
//[1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]

package LinkedList.Learning;

import LinkedList.Utils.MDLL;
import LinkedList.Utils.Node;

public class FlattenAMultilevelDoublyLinkedList_430 {
	
//	approch :
//	we can recurisive apply a function where
//	we iterate over the list from starting to end if the current node is having a child node 
//	we will add the entire child list in btw the current node and enxt node
//	we will do this by getting the head and tail of child node and connect them with current and nect node of the above list 
//	time complexity : O(N) wwhere n is total number of nodes
//	space complexity : O(N) wwhere n is total number of nodes in  call stack
	
	/*
	// Definition for a Node.
	class Node {
	    public int val;
	    public Node prev;
	    public Node next;
	    public Node child;
	};
	*/
	    public static Node flattenRecursion(Node head) {
	        helper(head);
	        return head;
	    }
	    public static  void helper(Node head){
	        if(head==null){
	            return ;
	        }
	        if(head.child!=null){
	            Node childhead= head.child; 
	            Node childtail= head.child;
	            head.child=null;
	            while(childtail.next!=null){
	                childtail=childtail.next;
	            } 
	            Node next= head.next;
	            // connect heads to above list
	            head.next=childhead;
	            childhead.prev=head;

	            if(next!=null){
	            next.prev=childtail;
	            }
	            childtail.next=next;
	        }
	        helper(head.next);
	    }
	    
	    
	    /*
	 // Definition for a Node.
	 class Node {
	     public int val;
	     public Node prev;
	     public Node next;
	     public Node child;
	 };
	 */
// iterative approch :
// here the iterative approch of previous recursive approch 
//	    time complexity :O(n)
//	    space complexity :O(1)
    public static Node flattenInterative(Node head) {
	         Node ptr= head;
	         while(ptr!=null){
	             if(ptr.child!=null){
	                 // get its last node;
	                 Node childhead= ptr.child;
	                 Node childtail= ptr.child;
	                 ptr.child=null;
	                 while(childtail.next!=null){
	                     childtail=childtail.next;
	                 }
	                 Node nextptr= ptr.next;
	                 // connect head with upper level;
	                 ptr.next=childhead;
	                 childhead.prev=ptr;
	                 childtail.next=nextptr;
	                 if(nextptr!=null){
	                 nextptr.prev=childtail;
	                 }
	             }
	             ptr=ptr.next;
	         }       
	         return head;
	     }
	 
	
	public static void main(String[] args) {
		
		
		//Example 1:

		MDLL head1 = new MDLL(1,2,3,4,5,6);
		MDLL ch11 = new MDLL(7,8,9,10);
		MDLL ch12 = new MDLL(11,12);
		head1.get(2).setChild(ch11.getHead());
		ch11.get(1).setChild(ch12.getHead());
		MDLL output1= new MDLL(1,2,3,7,8,11,12,9,10,4,5,6);
		
		//Example 2:

		MDLL head2 = new MDLL(1,2);
		MDLL ch21 = new MDLL(3);
		head2.get(0).setChild(ch21.getHead());
		MDLL output2= new MDLL(1,3,2);
	
		//Example 3:

		MDLL head3 = new MDLL();
		MDLL output3= new MDLL();
		
		System.out.println("Iterative Approch :");
	
		Node ans1= flattenInterative(head1.getHead());
		Node ans2= flattenInterative(head2.getHead());
		Node ans3= flattenInterative(head3.getHead());
		
		
    	if(output1.equals(ans1)) {
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
    	if(output3.equals(ans3)) {
    		System.out.println("Case 3 Passed");
    	}else {
    		System.out.println("Case 3 Failed");
    		System.out.println("Expected Ouput :"+ output3);
    		System.out.println("Your Answer :"+ ans3);  		
    	}
    	
    	System.out.println("Recursion Approch :");
    	
    	ans1= flattenRecursion(head1.getHead());
    	ans2= flattenRecursion(head2.getHead());
    	ans3= flattenRecursion(head3.getHead());
    	
    	
    	if(output1.equals(ans1)) {
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
    	if(output3.equals(ans3)) {
    		System.out.println("Case 3 Passed");
    	}else {
    		System.out.println("Case 3 Failed");
    		System.out.println("Expected Ouput :"+ output3);
    		System.out.println("Your Answer :"+ ans3);  		
    	}

		
		
		
	}

}
