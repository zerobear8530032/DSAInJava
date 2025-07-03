//82. Remove Duplicates from Sorted List II
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.
//
// 
//
//Example 1:
//
//
//Input: head = [1,2,3,3,4,4,5]
//Output: [1,2,5]
//Example 2:
//
//
//Input: head = [1,1,1,2,3]
//Output: [2,3]
// 
//
//Constraints:
//
//The number of nodes in the list is in the range [0, 300].
//-100 <= Node.val <= 100
//The list is guaranteed to be sorted in ascending order.
package LinkedList.Learning;

import java.util.HashMap;

import LinkedList.Utils.ListNode;
import LinkedList.Utils.MyList;

public class RemoveDuplicatesFromSortedListII_82 {
	
//	brute force approch :
//	here we create a hash map which store key frequenccy of each value in linked list and 
// create our answer where we put only nodes with frequency 1 in our output list 
//	time complexity :O(n)
//	time complexity :O(n)
	
	 public static ListNode deleteDuplicatesBruteForce(ListNode head) {
	        HashMap<Integer,Integer> map = new HashMap();
	        ListNode temp = head;
	        while(temp!=null){
	            int val= temp.val;
	            if(map.containsKey(val)){
	                map.put(val,map.get(val)+1);
	            }else{
	                map.put(val,1);
	            }
	            temp=temp.next;
	        }
	        temp = head;
	        ListNode result = new ListNode(-1);
	        ListNode ptr=result;
	        while(temp!=null){
	            int val= temp.val;
	            if(map.get(val)==1){
	                ptr.next=new ListNode(val);
	                ptr=ptr.next;
	            }
	            temp=temp.next;
	        }
	        return result.next;
	    }
	
//	better approch :
//	we can use a two pointer left which go through entire list  at each iteration the right pointer 
//	start from left and go till left.val==right and right!=null and count number frequency of left.val
//	if its 1 we cna add to result other wise we will skip it
//	at the end of each iteration will will do left=right to skip the entire duplicated or node which already seen
//	time complexity :O(n)
//	time complexity :O(1)
	
	    public static ListNode deleteDuplicatesBest(ListNode head) {
	        ListNode left=head;
	        ListNode result = new ListNode(-1);
	        ListNode restemp = result;
	        while(left!=null){
	            int val = left.val;
	            int count = 0;
	            ListNode right = left;
	            while(right!=null && right.val == val){
	                count++;
	                right=right.next;
	            }
	            if(count==1){
	                restemp.next= new ListNode(val);
	                restemp=restemp.next;
	            }
	            left=right;

	        }
	        return result.next;
	    }

	public static void main(String[] args) {
		
		
		//Example 1:

		MyList head1 = new MyList(1,2,3,3,4,4,5);
		MyList output1 = new MyList(1,2,5);
		
		//Example 2:

		MyList head2 = new MyList(1,1,1,2,3);
		MyList output2 = new MyList(2,3);
		
		
		System.out.println("Brute Force  Approch :");
		
		ListNode ans1=deleteDuplicatesBruteForce(head1.getHead());		
		ListNode ans2=deleteDuplicatesBruteForce(head2.getHead());		
		
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
		
		System.out.println("Best Approch :");
		

		ans1=deleteDuplicatesBest(head1.getHead());		
		ans2=deleteDuplicatesBest(head2.getHead());		
		
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
