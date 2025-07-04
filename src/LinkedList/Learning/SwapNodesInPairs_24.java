//24. Swap Nodes in Pairs
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)
//
// 
//
//Example 1:
//
//Input: head = [1,2,3,4]
//
//Output: [2,1,4,3]
//
//Explanation:
//
//
//
//Example 2:
//
//Input: head = []
//
//Output: []
//
//Example 3:
//
//Input: head = [1]
//
//Output: [1]
//
//Example 4:
//
//Input: head = [1,2,3]
//
//Output: [2,1,3]
//
// 
//
//Constraints:
//
//The number of nodes in the list is in the range [0, 100].
//0 <= Node.val <= 100
package LinkedList.Learning;

import LinkedList.Utils.ListNode;
import LinkedList.Utils.MyList;

public class SwapNodesInPairs_24 {
//	approch :Brute Force Approch ':
//	use 2 pointer one curr second next
//	and add the elemet in swap order in the result list
//	time complexity :O(n)
//	space complexity :O(n)
	 public static ListNode swapPairsBruteForce(ListNode head) {
	        if(head==null){
	            return head;
	        }
	        if(head.next==null){
	            return head;
	        }
	        ListNode res= new ListNode(-1);// dumy node;
	        ListNode restemp = res;
	        ListNode ptr=head;
	        while( ptr!=null && ptr.next!=null){
	            ListNode next = ptr.next;
	            restemp.next= new ListNode(next.val);
	            restemp=restemp.next;
	            restemp.next= new ListNode(ptr.val);
	            restemp=restemp.next;
	            ptr=ptr.next.next;
	        }
	        if(ptr!=null){
	            restemp.next= new ListNode(ptr.val);
	        }
	        return res.next;
	    }
	 
//	 better approch : its better but its not allowed here 
//	 here we just swap the values of the nodes 
//	 time complexity :O(n)
//	 space complexity :O(1)
	  public static ListNode swapPairsBetter(ListNode head) {
		    if(head==null){
		        return head;
		    }
		    if(head.next==null){
		        return head;
		    }
		    ListNode ptr=head;
		    while(ptr!=null && ptr.next!=null){
		        ListNode next = ptr.next;
		        int temp = ptr.val;
		        ptr.val=next.val;
		        next.val=temp;
		        if(ptr==null){
		            break;
		        }
		        ptr=ptr.next.next;
		    } 
		    return head;
		    }

	public static void main(String[] args) {
		
		
		//Example 1:

		MyList head1 = new MyList(1,2,3,4);
		MyList output1 = new MyList(2,1,4,3);

		//Example 2:
		
		MyList head2 = new MyList();
		MyList output2 = new MyList();
		
		//Example 3:

		MyList head3 = new MyList(1);
		MyList output3 = new MyList(1);
		
		//Example 4:

		MyList head4 = new MyList(1,2,3);
		MyList output4 = new MyList(2,1,3);
		
		System.out.println("Brute Force Approch :");
		
		ListNode ans1=swapPairsBruteForce(head1.getHead());		
		ListNode ans2=swapPairsBruteForce(head2.getHead());		
		ListNode ans3=swapPairsBruteForce(head3.getHead());		
		ListNode ans4=swapPairsBruteForce(head4.getHead());		
		
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
			System.out.println("Actual Output :"+output3);
			System.out.println("Your Output :"+ans3);
		}
		if(output4.equals(ans4)) {
			System.out.println("Case 4 Passed");
		}else {
			System.out.println("Case 4 Failed");
			System.out.println("Actual Output :"+output4);
			System.out.println("Your Output :"+ans4);
		}
		
		
		System.out.println("Better Approch :");
		
		ans1=swapPairsBetter(head1.getHead());		
		ans2=swapPairsBetter(head2.getHead());		
		ans3=swapPairsBetter(head3.getHead());		
		ans4=swapPairsBetter(head4.getHead());		
		
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
			System.out.println("Actual Output :"+output3);
			System.out.println("Your Output :"+ans3);
		}
		if(output4.equals(ans4)) {
			System.out.println("Case 4 Passed");
		}else {
			System.out.println("Case 4 Failed");
			System.out.println("Actual Output :"+output4);
			System.out.println("Your Output :"+ans4);
		}

		
		
		
		
	}

}
