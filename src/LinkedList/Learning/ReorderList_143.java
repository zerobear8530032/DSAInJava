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
//	now we will reverse the list frppm index 2 till end of list
//	so the list will be in 2 parts :
//	[1,2] , [3,4,5]-> rev second part = [5,4,3]
//	now we can iterate and add the list elements 
//	 1,5,2,4,3
//	 we can add alternative elements to the original list 

	    public static void reorderListBest(ListNode head) {
	        if(head==null){
	            return ;
	        }
	        if(head.next==null){
	            return ;
	        }
	        int length =getLength(head);// get length
	        int midIndex= length/2;// miid idx
	        ListNode revList = reverseFromIndex( head, midIndex);// reverse the list and get the head
	        ListNode curr= head;// get curr list head
	        while(curr!=null && curr.next!=null){// here we add alternative nodes
	            ListNode next = curr.next;// next ptr
	            ListNode revnext= revList.next;// reverselist ptr
	            curr.next=revList;// connect current node to revfirst node
	            revList.next=next;// connect rest of list to the revfirst node
	            curr=next;// get to the next node
	            revList=revnext;// get the next node of rev
	        }
	        curr.next=revList;// here if the node is null we can just add the rest of the rev list to the end 
	    
	    }
	    public static int getLength(ListNode head){
	        int  count=0;
	        while(head!=null){
	            head=head.next;
	            count++;
	        }
	        return count;
	    }
	    public static ListNode reverseFromIndex(ListNode head,int idx){
	        ListNode ptr=head;
	        // reach the reverse index
	        for(int i =0;i<idx-1;i++){// here we get the index -1 node why 
	        // because we have to break the connection btw the rev and prev node
	            ptr=ptr.next;
	        }
	        // this next currently store the head of list which will  reverse  
	        ListNode next= ptr.next;
	        ptr.next=null;// and ptr will break connection from rest of the list 
	        ptr=next;// now ptr will be the head 
	        // start reverse :
	        ListNode prev=null;
	        while(ptr!=null){
	            next = ptr.next;
	            ptr.next=prev;
	            prev=ptr;
	            ptr=next;
	        }
	        // at the endd the list will be reverse and curr will be null 
	        // and the prev will have the head of the reverse list 
	        return prev;
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
