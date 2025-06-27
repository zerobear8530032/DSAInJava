//203. Remove Linked List Elements
//Solved
//Easy
//Topics
//premium lock icon
//Companies
//Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.
//
// 
//
//Example 1:
//
//
//Input: head = [1,2,6,3,4,5,6], val = 6
//Output: [1,2,3,4,5]
//Example 2:
//
//Input: head = [], val = 1
//Output: []
//Example 3:
//
//Input: head = [7,7,7,7], val = 7
//Output: []
// 
//
//Constraints:
//
//The number of nodes in the list is in the range [0, 104].
//1 <= Node.val <= 50
//0 <= val <= 50



package LinkedList.Learning;

public class RemoveLinkedListElements_203 {

//	approch :
//	we can start with the curr and next pointer 
//	where curr start form head amd next from the next node of head
//	now curr and next both will incremenet by one
//	but when next pointer val == val we want to remove we will 
//	skipp all nodes from next.val==val && next!=null 
//	and put the curr.next=null
//	and keep going 
//	time complexity :O(n)
//	space complexity :O(1)
	 public  static ListNode removeElements(ListNode head, int val) {
	        if(head==null){
	            return null;
	        }
	        ListNode curr=head;
	        ListNode next=head.next;
	        while(curr.next!=null){
	            while(next!=null && next.val==val){
	                next=next.next;
	            }
	            curr.next=next;
	            if(next==null){
	                break;
	            }
	            curr=curr.next;
	            next=next.next;
	        }
	        if(head.val==val){
	            return head.next;
	        }
	        return head;
	    }
	public static void main(String[] args) {
		
		//Example 1:

		MyList head1 = new MyList(1,2,6,3,4,5,6);
		int val1 = 6;
		MyList output1 = new MyList(1,2,3,4,5);

		//Example 2:
		
		MyList head2 = new MyList();
		int val2 = 6;
		MyList output2 = new MyList();
		
		//Example 2:
		
		MyList head3 = new MyList(7,7,7,7);
		int val3 = 7;
		MyList output3 = new MyList();

		
	    System.out.println("Better Approch :");
	    ListNode ans1=removeElements(head1.getHead(),val1);
	    ListNode ans2=removeElements(head2.getHead(),val2);
	    ListNode ans3=removeElements(head3.getHead(),val3);
	    
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
