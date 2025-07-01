//237. Delete Node in a Linked List
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//There is a singly-linked list head and we want to delete a node node in it.
//
//You are given the node to be deleted node. You will not be given access to the first node of head.
//
//All the values of the linked list are unique, and it is guaranteed that the given node node is not the last node in the linked list.
//
//Delete the given node. Note that by deleting the node, we do not mean removing it from memory. We mean:
//
//The value of the given node should not exist in the linked list.
//The number of nodes in the linked list should decrease by one.
//All the values before node should be in the same order.
//All the values after node should be in the same order.
//Custom testing:
//
//For the input, you should provide the entire linked list head and the node to be given node. node should not be the last node of the list and should be an actual node in the list.
//We will build the linked list and pass the node to your function.
//The output will be the entire list after calling your function.
// 
//
//Example 1:
//
//
//Input: head = [4,5,1,9], node = 5
//Output: [4,1,9]
//Explanation: You are given the second node with value 5, the linked list should become 4 -> 1 -> 9 after calling your function.
//Example 2:
//
//
//Input: head = [4,5,1,9], node = 1
//Output: [4,5,9]
//Explanation: You are given the third node with value 1, the linked list should become 4 -> 5 -> 9 after calling your function.
// 
//
//Constraints:
//
//The number of the nodes in the given list is in the range [2, 1000].
//-1000 <= Node.val <= 1000
//The value of each node in the list is unique.
//The node to be deleted is in the list and is not a tail node.


package LinkedList.Learning;

import java.util.ArrayList;
import java.util.Arrays;

import LinkedList.Utils.ListNode;
import LinkedList.Utils.MyList;

public class DeleteNodeInALinkedList_237 {
	
// approch :
//	we are not having the head so we can shift the  current node to the end of list and 
//	remove it to the list 
//	we will use a curr , prev pointer
//	the curr will move on the next node untill the curr.next!= null
//	and prev will reamin at previous node to curr 
//	each time we will put the next node val in the current node
//	and keep going till end
//	at last curr will be atlast node and prev will be last -1 node
//	at last we will remove curr by prev.next=null
//	remove last node and rest of the list remain as it is 
//	time complexity :O(n)
//	space complexity :O(1)
	 public static void deleteNode(ListNode node) {
	        ListNode curr=node;
	        ListNode prev=node;
	        while(curr.next!=null){
	            prev=curr;
	            ListNode next = curr.next;
	            int nextval=next.val;
	            prev.val=nextval;
	            curr=next;
	        }
	        prev.next=null;
	    }

	 
	 public static boolean check(ListNode ans, ListNode output) {
	    	ListNode anstemp =ans;
	    	ListNode outputtemp =output;
	    	while(anstemp!=null && outputtemp!=null) {
	    		if(anstemp.val!=outputtemp.val) {
	    			return false;
	    		}
	    		anstemp=anstemp.next;
	    		outputtemp=outputtemp.next;
	    	}
	    	return anstemp==null && outputtemp==null;
	    }
	public static void main(String[] args) {
		
		
		//Example 1:
		MyList head1 = new MyList();
		head1.addAll(new ArrayList(Arrays.asList(4,5,1,9)));
		ListNode node1=head1.getVal(5);		
		MyList output1 = new MyList();
		output1.addAll(new ArrayList(Arrays.asList(4,1,9)));
		
		//Example 2:
		MyList head2 = new MyList();
		head2.addAll(new ArrayList(Arrays.asList(4,5,1,9)));
		ListNode node2=head2.getVal(1);		
		MyList output2 = new MyList();
		output2.addAll(new ArrayList(Arrays.asList(4,5,9)));
		deleteNode(node1);
		deleteNode(node2);	
		if(check(output1.getHead(),head1.getHead())) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Actual Output :"+output1 );
			System.out.println("Your Output :"+head1);
		}
		if(check(output2.getHead(),head2.getHead())) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Actual Output :"+output2 );
			System.out.println("Your Output :"+head2);
		}		
	}
}
