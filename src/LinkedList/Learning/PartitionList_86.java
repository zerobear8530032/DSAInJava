//86. Partition List
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
//
//You should preserve the original relative order of the nodes in each of the two partitions.
//
// 
//
//Example 1:
//
//
//Input: head = [1,4,3,2,5,2], x = 3
//Output: [1,2,2,4,3,5]
//Example 2:
//
//Input: head = [2,1], x = 2
//Output: [1,2]
// 
//
//Constraints:
//
//The number of nodes in the list is in the range [0, 200].
//-100 <= Node.val <= 100
//-200 <= x <= 200

package LinkedList.Learning;

import LinkedList.Utils.ListNode;
import LinkedList.Utils.MyList;

public class PartitionList_86 {
//	approch :
//	here we create 2 lists one contains all small values and one all equal or greater values
//	now we will go over the entire list and add these values in specific lists 
//	and just combine both list will give answer and order will be maintianed;
//	time complexity :O(n)
//	space complexity :O(n)

    public static ListNode partition(ListNode head, int x) {
	        if(head==null){
	            return null;
	        }
	        ListNode curr = head;
	        ListNode lefthead= new ListNode(-1);
	        ListNode righthead= new ListNode(-1);
	        ListNode left=lefthead;
	        ListNode right=righthead;
	        while(curr!=null){
	            int val = curr.val;
	            if(val<x){
	                left.next= new ListNode(val);
	                left=left.next;
	            }else{
	                right.next= new ListNode(val);
	                right=right.next;
	            }
	            curr=curr.next;
	        }
	//  skill the temprary node
	        righthead= righthead.next;
	        left.next=righthead;
	        return lefthead.next;
	    }
	

	public static void main(String[] args) {
		//Example 1:

		MyList head1 = new MyList(1,4,3,2,5,2);
		int x1 = 3;
		MyList output1 = new MyList(1,2,2,4,3,5);
		
		//Example 2:

		MyList head2 = new MyList(2,1);
		int x2 = 2;
		MyList output2 = new MyList(1,2);
		
System.out.println("Best Approch :");
		

		ListNode ans1=partition(head1.getHead(),x1);		
		ListNode ans2=partition(head2.getHead(),x2);		
		
		if(output1.equals(ans1)) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Faile5rd");
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


	}

}
