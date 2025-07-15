//148. Sort List
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Given the head of a linked list, return the list after sorting it in ascending order.
//
// 
//
//Example 1:
//
//
//Input: head = [4,2,1,3]
//Output: [1,2,3,4]
//Example 2:
//
//
//Input: head = [-1,5,3,4,0]
//Output: [-1,0,3,4,5]
//Example 3:
//
//Input: head = []
//Output: []
// 
//
//Constraints:
//
//The number of nodes in the list is in the range [0, 5 * 104].
//-105 <= Node.val <= 105
// 
//
//Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)?
//


package LinkedList.Learning;

import LinkedList.Utils.ListNode;
import LinkedList.Utils.MyList;

public class SortList_148 {
	
	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode() {}
	 *     ListNode(int val) { this.val = val; }
	 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	 * }
	 */

	    public static ListNode sortList(ListNode head) {
	        if (head == null || head.next == null) {
	            return head;
	        }
	        ListNode mid = getMid(head);

	        ListNode left = sortList(head);
	        ListNode right = sortList(mid);
	        return mergeList(left, right);
	    }

	    public static ListNode getMid(ListNode head) {
	        ListNode fast = head;
	        ListNode slow = head;
	        ListNode prev=null;
	        while (fast != null && fast.next != null) {
	            prev=slow;
	            slow = slow.next;
	            fast = fast.next.next;
	        }
	        prev.next=null;
	        return slow;
	    }

	    public static ListNode mergeList(ListNode l1, ListNode l2) {
	        ListNode dummy = new ListNode(-1);
	        ListNode temp = dummy;
	        while (l1 != null && l2 != null) {
	            if (l1.val < l2.val) {
	                temp.next = new ListNode(l1.val);
	                temp = temp.next;
	                l1 = l1.next;
	            } else {
	                temp.next = new ListNode(l2.val);
	                temp = temp.next;
	                l2 = l2.next;
	            }
	        }
	        while (l1 != null) {
	            temp.next = new ListNode(l1.val);
	            temp = temp.next;
	            l1 = l1.next;
	        }
	        while (l2 != null) {
	            temp.next = new ListNode(l2.val);
	            temp = temp.next;
	            l2 = l2.next;
	        }
	        return dummy.next;
	    }
	    
	public static void main(String[] args) {

		//Example 1:

		MyList head1 = new MyList(4,2,1,3);
		MyList output1 = new MyList(1,2,3,4);

		//Example 2:

		MyList head2 = new MyList(-1,5,3,4,0);
		MyList output2 = new MyList(-1,0,3,4,5);

		//Example 3:

		MyList head3 = new MyList();
		MyList output3 = new MyList();
		
		ListNode ans1=sortList(head1.getHead());		
		ListNode ans2=sortList(head2.getHead());		
		ListNode ans3=sortList(head3.getHead());		
		
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
			System.out.println("Actual Output :"+output2 );
			System.out.println("Your Output :"+ans2);
		}
		if(output3.equals(ans3)) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Actual Output :"+output3 );
			System.out.println("Your Output :"+ans3);
		}


	}

}
