//328. Odd Even Linked List
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.
//
//The first node is considered odd, and the second node is even, and so on.
//
//Note that the relative order inside both the even and odd groups should remain as it was in the input.
//
//You must solve the problem in O(1) extra space complexity and O(n) time complexity.
//
// 
//
//Example 1:
//
//
//Input: head = [1,2,3,4,5]
//Output: [1,3,5,2,4]
//Example 2:
//
//
//Input: head = [2,1,3,5,6,4,7]
//Output: [2,3,6,7,1,5,4]
// 
//
//Constraints:
//
//The number of nodes in the linked list is in the range [0, 104].
//-106 <= Node.val <= 106
package LinkedList.Learning;

import LinkedList.Utils.ListNode;
import LinkedList.Utils.MyList;

public class OddEvenLinkedList_328 {
//	approch :
//	this approch uses 2 pointers : even and odd  
//	both pointer start from the starting 
//	now the thing is we know the first node is gonna be the odd one its given in the question
//	so we can say ever odd node which will come will come after the first node
//	so we use a odd pointer to add odd nodes after the head 
//	now we will detect all the next odd nodes by an even ppointer 
//	we will start even pointer at starting and if the first node is odd
//	the next node will be even and it its even the next node again will be odd
//	so by that logic we will move event pointer 1 step ahead and check from that point there is a node after it
//	it it exists then we will remove it by coonnection even.next to even.next.nexxt 
//	and connect the remove nodes to the odd.next and we can also maintina the first even number 
//	pointer to easily connect the new node to the even one 
//	
//	i would do it brute force also but in the question its given that it accept O(n) and O(1) space only
//	time comlexity :O(n)
//	space comlexity :O(1)
	 public static ListNode oddEvenList(ListNode head) {
	        if(head==null){
	            return head;
	        }
	        if(head.next==null){
	            return head;
	        }
	        if(head.next.next==null){
	            return head;
	        }
	        ListNode odd =head;// add odd node
	        ListNode even= head;// kept at even node to acces next odd nodes
	        ListNode connection=head.next;// hold the first even node ptr to connect odd nodes end to even nodes start
	        while(even!=null){
	            even=even.next;
	            if(even==null){
	                break;
	            }
	            ListNode remove = even.next;
	            if(remove==null){
	                break;
	            }
	            even.next= remove.next;
	            odd.next=remove;
	            odd=remove;
	            remove.next=connection;
	        }
	        return head;
	    }

	public static void main(String[] args) {
		
		//Example 1:

		MyList head1 = new MyList(1,2,3,4,5);
		MyList output1 = new MyList(1,3,5,2,4);
		
		//Example 2:

		MyList head2 = new MyList(2,1,3,5,6,4,7);
		MyList output2 = new MyList(2,3,6,7,1,5,4);
		
		//Example 3:
		
		MyList head3 = new MyList(1,2,3,4,5,6,7,8);
		MyList output3 = new MyList(1,3,5,7,2,4,6,8);
		
		System.out.println("Better Approch :");
		
		ListNode ans1 = oddEvenList(head1.getHead());
		ListNode ans2 = oddEvenList(head2.getHead());
		ListNode ans3 = oddEvenList(head3.getHead());
		
		
		if(output1.equals(ans1)) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Actual Output :"+output1);
			System.out.println("Your Output :"+ans1);
		}
		if(output2.equals(ans2)) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Actual Output :"+output2);
			System.out.println("Your Output :"+ans2);
		}
		if(output3.equals(ans3)) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Actual Output :"+output3);
			System.out.println("Your Output :"+ans3);
		}


	}

}
