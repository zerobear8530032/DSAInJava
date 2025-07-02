//61. Rotate List
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Given the head of a linked list, rotate the list to the right by k places.
//
// 
//
//Example 1:
//
//
//Input: head = [1,2,3,4,5], k = 2
//Output: [4,5,1,2,3]
//Example 2:
//
//
//Input: head = [0,1,2], k = 4
//Output: [2,0,1]
// 
//
//Constraints:
//
//The number of nodes in the list is in the range [0, 500].
//-100 <= Node.val <= 100
//0 <= k <= 2 * 109
package LinkedList.Learning;

import LinkedList.Utils.ListNode;
import LinkedList.Utils.MyList;

public class RotateList_61 {
//	approch : it will take k%n rotation only because every k rotation will revert the list back to itts original shape
//	time complexity :O(n*k%n)
//	time complexity :O(1)
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
	
	    public  static ListNode rotateRight(ListNode head, int k) {
	        if(head==null){
	            return null;
	        }
	        if(head.next==null){
	            return head;
	        }
	        int len = getLength(head);
	        int times =  k%len;
	        if(times==0){
	            return head;
	        }
	        // System.out.println(len);
	        // System.out.println(times);
	        for(int i =0;i<times;i++){
	            head=rotate(head);
	        }
	        return head;
	    }
	    public static ListNode rotate(ListNode head){
	        ListNode tailprev =head;
	        
	        while(tailprev.next.next!=null){
	            tailprev= tailprev.next;
	        }

	        ListNode tail = tailprev.next;
	        tailprev.next=null;
	        tail.next=head;
	        return tail;
	    }


	    public static int getLength(ListNode head){
	        int count =0;
	        while(head!=null){
	            count++;
	            head=head.next;
	        }
	        return count;
	    }
	

	public static void main(String[] args) {
		
		
		//Example 1:

		MyList head1 = new MyList(1,2,3,4,5);
		int  k1 = 2;
		MyList output1= new MyList(4,5,1,2,3);
		
		//Example 2:

		MyList head2 = new MyList(0,1,2);
		int  k2 = 4;
		MyList output2= new MyList(2,0,1);
		
		
		ListNode ans1=rotateRight(head1.getHead(), k1);		
		ListNode ans2=rotateRight(head2.getHead(),k2);		
		
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



	}

}
