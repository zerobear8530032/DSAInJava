//25. Reverse Nodes in k-Group
//Solved
//Hard
//Topics
//premium lock icon
//Companies
//Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
//
//k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
//
//You may not alter the values in the list's nodes, only nodes themselves may be changed.
//
// 
//
//Example 1:
//
//
//Input: head = [1,2,3,4,5], k = 2
//Output: [2,1,4,3,5]
//Example 2:
//
//
//Input: head = [1,2,3,4,5], k = 3
//Output: [3,2,1,4,5]
// 
//
//Constraints:
//
//The number of nodes in the list is n.
//1 <= k <= n <= 5000
//0 <= Node.val <= 1000
// 
//
//Follow-up: Can you solve the problem in O(1) extra memory space?

package LinkedList.Learning;

import java.util.Arrays;

import LinkedList.Utils.ListNode;
import LinkedList.Utils.MyList;

public class ReverseNodesInkGroup_25 {
	
	
//	brute force approch:
//	here we first convert the entire list to array
//	then we can just  create a function which revese a part of array
//	it given a start index , ending index , arr
//	then we can just start =0 to end = k 
//	and each time we increase start = start+k , end = end+k
//	if end > size means the index is out of bound means we
//	can leave the rest of nodes 
    public static ListNode reverseKGroupBruteForce(ListNode head, int k) {
        ListNode curr= head;
        int len = getLength(head);
        int [] arr= new int[len];
        int idx=0;
        while(curr!=null){
            arr[idx]=curr.val;
            idx++;
            curr=curr.next;
        }
        int size = len;
        int start=0;
        int end= k-1;
        while(end<size){
            revereseK(arr,start,end);
            start=start+k;
            end=end+k;
        }
        idx=0;
        curr=head;
        while(curr!=null){
            curr.val=arr[idx];
            curr=curr.next;
            idx++;
        }
        return head;
    }
    public static void revereseK(int [] arr, int s , int e){
        while(s<e){
            swap(arr,s,e);
            s++;
            e--;
        }
    }

    public static void swap(int [] arr, int s , int e){
        int temp = arr[s];
        arr[s]=arr[e];
        arr[e]=temp;
    }

    
 


//	approch :
//	we will create a function which reverese the previous node and a head where ther reveresal
//	will start and k number of node which will reverese
//	and we will apply this function on each k chunks of the list to 
//	do it in place 
//	the reversal function is giving the last node of the reverse list so
//	that we can continue reversing the rest of section
//	time complexity :O(n)
//	space complexity :O(1)
    public static ListNode reverseKGroupBetter(ListNode head, int k) {
	        if (k < 2) {
	            return head;
	        }
	        ListNode dummy = new ListNode(-1);
	        dummy.next = head;
	        ListNode curr = head;
	        ListNode prev = dummy;
	        int size = getLength(head);
	        while (k <=size && curr != null) {
	            prev=reverseK(prev, curr, k);
	            curr=prev.next;
	            size = size - k;
	        }
	        return dummy.next;
	    }
	    public static int getLength(ListNode head) {
	        int count = 0;
	        while (head != null) {
	            count++;
	            head = head.next;
	        }
	        return count;
	    }
	// this function return the last reversed node  of linked list  
	    public static ListNode reverseK(ListNode leftSide, ListNode curr, int k) {
	        ListNode head = curr;
	        ListNode prev = curr;
	        curr = curr.next;
	        for (int i = 0; i < k - 1; i++) {
	            ListNode next = curr.next;
	            curr.next = prev;
	            prev = curr;
	            curr = next;
	        }
	        leftSide.next = prev;
	        head.next = curr;
	        return head;
	    }
	

	public static void main(String[] args) {
		//Example 1:

		MyList head1 =  new MyList(1,2,3,4,5);
		int k1 = 2;
		MyList output1 =  new MyList(2,1,4,3,5);


		//Example 2:
		
		MyList head2 =  new MyList(1,2,3,4,5);
		int k2 = 3;
		MyList output2 =  new MyList(3,2,1,4,5);
		
		System.out.println("Brute Force Approch :");
		
		ListNode ans1 = reverseKGroupBruteForce(head1.getHead(),k1);
		ListNode ans2 = reverseKGroupBruteForce(head2.getHead(),k2);
		
		
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
		
		System.out.println("Best Approch ");
		head1 =  new MyList(1,2,3,4,5);
		head2 =  new MyList(1,2,3,4,5);
		
		ans1 = reverseKGroupBetter(head1.getHead(),k1);
		ans2 = reverseKGroupBetter(head2.getHead(),k2);
		
		
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
	}

}
