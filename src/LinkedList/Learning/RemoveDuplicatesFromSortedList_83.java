//83. Remove Duplicates from Sorted List
//Solved
//Easy
//Topics
//premium lock icon
//Companies
//Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.
//
//Example 1:
//
//
//Input: head = [1,1,2]
//Output: [1,2]
//Example 2:
//
//
//Input: head = [1,1,2,3,3]
//Output: [1,2,3]
// 
//
//Constraints:
//
//The number of nodes in the list is in the range [0, 300].
//-100 <= Node.val <= 100
//The list is guaranteed to be sorted in ascending order.


package LinkedList.Learning;

public class RemoveDuplicatesFromSortedList_83 {
// approch : best
//	we can have 2 pointer left and right
//	where both start from head 
//	and right will move forward until the left.val ==right.val
//	once they are not equal we can increment left by 1 node ahead 
//	and put the value of current right to the current left value 
//	keep repeating it untill the right reached the end 
//	once its at the end we can remove all the nodes from left and get our sorted unique element list 
//	time complexity :O(n)
//	space complexity :O(1)
	
	  public static ListNode deleteDuplicates(ListNode head) {
	        if(head==null) {return null;}
	        ListNode left = head;
	        ListNode  right= head;
	        while(right!=null){
	            while(right!=null && right.val == left.val){// skip duplicates
	                right=right.next;
	            }
	            if(left!=null && right!=null){
	                left=left.next;
	                left.val=right.val;
	            }
	        }
	        
	        left.next=null;
	        return head;
	    }
	public static void main(String[] args) {
		//Example 1:

		MyList  head1 =  new MyList(1,1,2);
		MyList output1= new MyList(1,2);
		
		//Example 2:

		MyList  head2 =  new MyList(1,1,2,3,3);
		MyList output2= new MyList(1,2,3);
		
		
		System.out.println("Best Approch :");
		
		ListNode ans1=deleteDuplicates(head1.getHead());		
		ListNode ans2=deleteDuplicates(head2.getHead());		
		
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
