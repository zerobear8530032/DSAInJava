//2095. Delete the Middle Node of a Linked List
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//You are given the head of a linked list. Delete the middle node, and return the head of the modified linked list.
//
//The middle node of a linked list of size n is the ⌊n / 2⌋th node from the start using 0-based indexing, where ⌊x⌋ denotes the largest integer less than or equal to x.
//
//For n = 1, 2, 3, 4, and 5, the middle nodes are 0, 1, 1, 2, and 2, respectively.
// 
//
//Example 1:
//
//
//Input: head = [1,3,4,7,1,2,6]
//Output: [1,3,4,1,2,6]
//Explanation:
//The above figure represents the given linked list. The indices of the nodes are written below.
//Since n = 7, node 3 with value 7 is the middle node, which is marked in red.
//We return the new list after removing this node. 
//Example 2:
//
//
//Input: head = [1,2,3,4]
//Output: [1,2,4]
//Explanation:
//The above figure represents the given linked list.
//For n = 4, node 2 with value 3 is the middle node, which is marked in red.
//Example 3:
//
//
//Input: head = [2,1]
//Output: [2]
//Explanation:
//The above figure represents the given linked list.
//For n = 2, node 1 with value 1 is the middle node, which is marked in red.
//Node 0 with value 2 is the only node remaining after removing node 1.
// 
//
//Constraints:
//
//The number of nodes in the list is in the range [1, 105].
//1 <= Node.val <= 105
package LinkedList.Learning;

import LinkedList.Utils.ListNode;
import LinkedList.Utils.MyList;

public class DeleteTheMiddleNodeOfALinkedList_2095 {
//	approch :
//	here we will get length of linked list first then find size/2
//	then get n/2-1 index node call it prev and connect the prev.next to prev.next.next node
//	it takes 2 pass
//	time complexity :O(n)
//	space complexity :O(1)
	  public static ListNode deleteMiddleBruteForce(ListNode head) {
	        if(head==null){
	            return null;
	        }
	        if(head.next==null){
	            return null;
	        }
	        int size= getLength(head);
	        int mididx= size/2;
	        ListNode prev= getNode(head,mididx-1);
	        ListNode next= prev.next.next;
	        prev.next=next;
	        return head;
	    }
	    public static ListNode getNode(ListNode head, int idx){
	        ListNode ptr= head;
	        for(int i =0;i<idx;i++){
	            ptr=ptr.next;
	        }
	        return ptr;

	    }

	    public static int getLength(ListNode head ){
	        int count =0;
	        while(head!=null){
	            head=head.next;
	            count++;
	        }
	        return count;
	    }
	
	
//	approch :
//	here we can use 2 pointer where slow and fast both start from starting and slow move 1 step and fast move 2 step
//	if fast reach end the start is at the node we wna delete thenwe can use a start prev pointer which ppointer
//	at the prev node of start then we can connect start next with start prev to deelte start ponter node
//	it takes 1 pass
//	time complexity :O(n)
//	space complexity :O(1)
	public static ListNode deleteMiddleBest(ListNode head) {
        if(head==null){
            return null;
        }
        if(head.next==null){
            return null;
        }
        ListNode slow=head;
        ListNode slowprev=slow;
        ListNode fast=head;
        do{
            if(fast==null){
                break;
            }
            if(fast.next==null){
                break;
            }
            fast=fast.next.next;
            slowprev=slow;
            slow=slow.next;
        }while(fast!=null);
        // System.out.println(fast.val+"  "+slow.val);
        slowprev.next=slow.next;
        return head;
    }

	public static void main(String[] args) {
		
		//Example 1:
		
		MyList head1 = new MyList(1,3,4,7,1,2,6);
		MyList output1 = new MyList(1,3,4,1,2,6);
		//Example 2:

		MyList head2 = new MyList(1,2,3,4);
		MyList output2 = new MyList(1,2,4);

		//Example 3:

		MyList head3 = new MyList(2,1);
		MyList output3 = new MyList(2);
		
		System.out.println("Brute Force Approch :");
		
		ListNode ans1=deleteMiddleBruteForce(head1.getHead());		
		ListNode ans2=deleteMiddleBruteForce(head2.getHead());		
		ListNode ans3=deleteMiddleBruteForce(head3.getHead());		
		
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
		
		head1 = new MyList(1,3,4,7,1,2,6);
		head2 = new MyList(1,2,3,4);
		head3 = new MyList(2,1);

		System.out.println("Best Approch :");
		
		ans1=deleteMiddleBest(head1.getHead());		
		ans2=deleteMiddleBest(head2.getHead());		
		ans3=deleteMiddleBest(head3.getHead());		
		
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
