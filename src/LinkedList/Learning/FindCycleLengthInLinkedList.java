//141. Linked List Cycle
//Solved
//Easy
//Topics
//premium lock icon
//Companies
//Given head, the head of a linked list, determine if the linked list has a cycle in it.
//
//There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
//
//Return true if there is a cycle in the linked list. Otherwise, return false.
//
// 
//
//Example 1:
//
//
//Input: head = [3,2,0,-4], pos = 1
//Output: true
//Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
//Example 2:
//
//
//Input: head = [1,2], pos = 0
//Output: true
//Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.
//Example 3:
//
//
//Input: head = [1], pos = -1
//Output: false
//Explanation: There is no cycle in the linked list.
// 
//
//Constraints:
//
//The number of the nodes in the list is in the range [0, 104].
//-105 <= Node.val <= 105
//pos is -1 or a valid index in the linked-list.
// 
//
//Follow up: Can you solve it using O(1) (i.e. constant) memory?


package LinkedList.Learning;

import java.util.HashSet;

import LinkedList.Utils.ListNode;
import LinkedList.Utils.MyList;

public class FindCycleLengthInLinkedList {
	
	
//	approch best: we can use turtle and hare technique where 2 ptr fast and slow start
//	at 0 , 1 respectively and slow move 1 ahead fast move 2 ahead
//	if any one reach end it have no cycle iff both reach same node there is a cycle
//	time complexity :O(n)
//	space complexity :O(1)

public static  int getCycleLength(ListNode head) {
	ListNode slow= head;
	ListNode fast= head;
	
	while(fast!=null && slow!=null && fast.next!=null) {
		slow=slow.next;
		fast=fast.next.next;
		if(fast==slow) {
			int len =0;
			do {
				slow=slow.next;
				len++;
			}while(fast!=slow);
			return len;
		}
	}
	
	return -1;
    
}
	public static void createCycle(MyList head, int pos ) {
		if(pos<0) {
			return ;
		}
		ListNode tail = head.getTail();
		ListNode node = head.get(pos);
		tail.next= node;
	}

	public static void main(String[] args) {
		
		
		//Example 1:
		
		MyList head1 = new MyList();
		head1.addAll(3,2,0,-4); 
		int pos1 = 1;
		int output1=3;
//		create cycle :
		createCycle(head1,pos1);
		
		
		
		

		//Example 2:
		
		MyList head2 = new MyList();
		head2.addAll(1,2); 
		int pos2 = 0;
		int output2=2;
		createCycle(head2,pos2);
		

		//Example 3:
		
		MyList head3 = new MyList();
		head3.addAll(1); 
		int pos3 = -1;
		int output3=-1;
		createCycle(head3,pos3);
	
		
	System.out.println("Brute Force Approch :");
		
		
		int ans1=getCycleLength(head1.getHead());		
		int ans2=getCycleLength(head2.getHead());		
		int ans3=getCycleLength(head3.getHead());		
		
		if(output1==ans1) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Actual Output :"+output1);
			System.out.println("Your Output :"+ans1);
		}
		if(output2==ans2) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Actual Output :"+output2 );
			System.out.println("Your Output :"+ans2);
		}
		if(output3==ans3) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Actual Output :"+output3);
			System.out.println("Your Output :"+ans3);
		}
		
		

	}


}
