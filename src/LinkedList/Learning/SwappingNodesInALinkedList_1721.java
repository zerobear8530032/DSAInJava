//1721. Swapping Nodes in a Linked List
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//You are given the head of a linked list, and an integer k.
//
//Return the head of the linked list after swapping the values of the kth node from the beginning and the kth node from the end (the list is 1-indexed).
//
// 
//
//Example 1:
//
//
//Input: head = [1,2,3,4,5], k = 2
//Output: [1,4,3,2,5]
//Example 2:
//
//Input: head = [7,9,6,6,7,8,3,0,9,5], k = 5
//Output: [7,9,6,6,8,7,3,0,9,5]
// 
//
//Constraints:
//
//The number of nodes in the list is n.
//1 <= k <= n <= 105
//0 <= Node.val <= 100
package LinkedList.Learning;

import LinkedList.Utils.ListNode;
import LinkedList.Utils.MyList;

public class SwappingNodesInALinkedList_1721 {
	
//	approch:
//	find the length of the entire list and then get the node which need to be swapped
//	then just swap the values of the node s 
//	time complexity :O(n)
//	space complexity :O(1)
	
	 public static ListNode swapNodes(ListNode head, int k) {
	        int len= getLength(head);
	        ListNode LNode = getNode(head,k);
	        ListNode RNode = getNode(head,len-k+1);
	        int temp=LNode.val;
	        LNode.val=RNode.val;
	        RNode.val=temp;
	        return head;
	    }
	    public static ListNode getNode(ListNode head, int idx){
	        for(int i =1;i<idx;i++){
	            head=head.next;
	        }
	        return head;
	    }
	    public static int getLength(ListNode head){
	        int count=0;
	        while(head!=null){
	            head=head.next;
	            count++;
	        }
	        return count;
	    }
	public static void main(String[] args) {
		
		
		//Example 1:

		MyList head1 = new MyList(1,2,3,4,5);
		int  k1 = 2;
		MyList output1 = new MyList(1,4,3,2,5);
		
		//Output: [1,4,3,2,5]
		//Example 2:

		MyList head2 = new MyList(7,9,6,6,7,8,3,0,9,5);
		int  k2 = 5;
		MyList output2 = new MyList(7,9,6,6,8,7,3,0,9,5);
		
		ListNode ans1= swapNodes(head1.getHead(), k1);
		ListNode ans2= swapNodes(head2.getHead(), k2);
	    		    	
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

	}

}

