//143. Reorder List
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//You are given the head of a singly linked-list. The list can be represented as:
//
//L0 → L1 → … → Ln - 1 → Ln
//Reorder the list to be on the following form:
//
//L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
//You may not modify the values in the list's nodes. Only nodes themselves may be changed.
//
// 
//
//Example 1:
//
//
//Input: head = [1,2,3,4]
//Output: [1,4,2,3]
//Example 2:
//
//
//Input: head = [1,2,3,4,5]
//Output: [1,5,2,4,3]
// 
//
//Constraints:
//
//The number of nodes in the list is in the range [1, 5 * 104].
//1 <= Node.val <= 1000


package LinkedList.Learning;

import java.util.List;

import LinkedList.Utils.ListNode;
import LinkedList.Utils.MyList;

public class ReorderList_143 {
// approch : brute force approch
//	iterate over the list and at each point get current last node and aappend it just ahead 
//	of current pointer
//	time complexity :O(n*n)
//	space complexity :O(1)
	 public static void reorderListBruteForce(ListNode head) {
	        if(head==null){// null head means nothing 
	            return ;
	        }
	        if(head.next==null){// head next null means only a single node 
	            return ;
	        }
	        ListNode curr= head;
	        while(curr != null && curr.next!=null){// curr != null keep us in bounds and  we keep the last node in check to add the last node
	            ListNode lastNode = popLast(curr);// this pop last will remove tthe last nddoe and get the node 
	            ListNode next= curr.next;// here we create a reference of next node
	            curr.next=lastNode;// create connection to th elast node to add ahead of current
	            lastNode.next=next;// now add the rest of the list ahead of th elast ndoe 
	            curr=next;// update the curr to be the next node and reaprt it again 
	            
	        }
	    }
//	 here the optimization we canjust take the current pointer to find last node that will allow us to not travel from start each time 

	    public static ListNode popLast(ListNode curr){
// here we reach last nextNode and remove the connection and return the last node 
	        while(curr.next.next!=null){
	            curr=curr.next;
	        }
	        ListNode lastnode =curr.next;
	        curr.next=null;
	        return lastnode;       
	    }
	    
	    
	    
//	best approch :
//	the approch is simple we will get the length of the list : [1,2,3,4,5] : here the list length =5 
//	now we take mid = 5/2 =2 in integer
//	now we will reverse the list from index 2 till end of list
//	so the list will be in 2 parts :
//	[1,2] , [3,4,5]-> rev second part = [5,4,3]
//	now we can iterate and add the list elements alternatively
//	 1,5,2,4,3
//	 we can add alternative elements to the original list 
public static void reorderListBest(ListNode head) {
    // in place reorder
    ListNode mid=getMidNode(head);
    ListNode secondHalf= mid.next;
    mid.next=null;
    ListNode reversed= reverse(secondHalf);
    // insert the values in the linked list :
    ListNode left= head;
    ListNode right= reversed;
    while(left!=null && right!=null){
        ListNode leftnext = left.next;
        ListNode rightnext = right.next;
        left.next=right;
        right.next=leftnext;
        left=leftnext;
        right=rightnext;
    }
}


    public static ListNode reverse(ListNode head){
        ListNode prev=null;
        ListNode curr=head;
        while(curr!=null){
            ListNode next = curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }

    public static ListNode getMidNode(ListNode head){
        if(head==null){return head;}
        ListNode slow=head;
        ListNode fast=head.next;
        while(fast!=null){
            fast=fast.next;
            if(fast==null){break;}
            fast=fast.next;
            slow=slow.next;
        }
        return slow;
    }

	    
	public static void main(String[] args) {
		
		//Example 1:

		MyList head1 = new MyList(1,2,3,4);
		MyList output1= new MyList(1,4,2,3);

		//Example 2:
		
		MyList head2 = new MyList(1,2,3,4,5);
		MyList output2= new MyList(1,5,2,4,3);
		
		
		  System.out.println("Brute Force Approch :");
	    	
		  reorderListBruteForce(head1.getHead());
		  reorderListBruteForce(head2.getHead());
		  

	    	if(output1.equals(head1)) {
	    		System.out.println("Case 1 Passed");
	    	}else {
	    		System.out.println("Case 1 Failed");
	    		System.out.println("Expected Ouput :"+ output1);
				System.out.println("Your Answer :"+ head1);  		
	    	}
	    	if(output2.equals(head2)) {
	    		System.out.println("Case 2 Passed");
	    	}else {
	    		System.out.println("Case 2 Failed");
	    		System.out.println("Expected Ouput :"+ output2);
	    		System.out.println("Your Answer :"+ head2);  		
	    	}
		    	
		    System.out.println("Better Approch :");
		   head1 = new MyList(1,2,3,4);
		   head2 = new MyList(1,2,3,4,5);
		    
		    reorderListBest(head1.getHead());
		    reorderListBest(head2.getHead());
		    
		    if(output1.equals(head1)) {
		    	System.out.println("Case 1 Passed");
		    }else {
		    	System.out.println("Case 1 Failed");
		    	System.out.println("Expected Ouput :"+ output1);
		    	System.out.println("Your Answer :"+ head1);  		
		    }
		    if(output2.equals(head2)) {
		    	System.out.println("Case 2 Passed");
		    }else {
		    	System.out.println("Case 2 Failed");
		    	System.out.println("Expected Ouput :"+ output2);
		    	System.out.println("Your Answer :"+ head2);  		
		    }
	}

}
