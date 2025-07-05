//2074. Reverse Nodes in Even Length Groups
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//You are given the head of a linked list.
//
//The nodes in the linked list are sequentially assigned to non-empty groups whose lengths form the sequence of the natural numbers (1, 2, 3, 4, ...). The length of a group is the number of nodes assigned to it. In other words,
//
//The 1st node is assigned to the first group.
//The 2nd and the 3rd nodes are assigned to the second group.
//The 4th, 5th, and 6th nodes are assigned to the third group, and so on.
//Note that the length of the last group may be less than or equal to 1 + the length of the second to last group.
//
//Reverse the nodes in each group with an even length, and return the head of the modified linked list.
//
// 
//
//Example 1:
//
//
//Input: head = [5,2,6,3,9,1,7,3,8,4]
//Output: [5,6,2,3,9,1,4,8,3,7]
//Explanation:
//- The length of the first group is 1, which is odd, hence no reversal occurs.
//- The length of the second group is 2, which is even, hence the nodes are reversed.
//- The length of the third group is 3, which is odd, hence no reversal occurs.
//- The length of the last group is 4, which is even, hence the nodes are reversed.
//Example 2:
//
//
//Input: head = [1,1,0,6]
//Output: [1,0,1,6]
//Explanation:
//- The length of the first group is 1. No reversal occurs.
//- The length of the second group is 2. The nodes are reversed.
//- The length of the last group is 1. No reversal occurs.
//Example 3:
//
//
//Input: head = [1,1,0,6,5]
//Output: [1,0,1,5,6]
//Explanation:
//- The length of the first group is 1. No reversal occurs.
//- The length of the second group is 2. The nodes are reversed.
//- The length of the last group is 2. The nodes are reversed.
// 
//
//Constraints:
//
//The number of nodes in the list is in the range [1, 105].
//0 <= Node.val <= 105


package LinkedList.Learning;

import LinkedList.Utils.ListNode;
import LinkedList.Utils.MyList;

public class ReverseNodesInEvenLengthGroups_2074 {
//	approch :
//	here we get the length of list and 
//	start dividing list in group first we check the current group
//	it even lenght or not if not we can skipp alll nodes of that group
//	if yes wee will check that the  the we have enough nodes left with us to give to group
//	if yes we can reverse those if not we can break 
//	at the end we will check the left nodes are even if yes we can revese them other wise we cna 
//	just return 
	
	    public static ListNode reverseEvenLengthGroups(ListNode head) {
	        int size = getLength(head);
	        int nodeleft=size;
	        ListNode dummy = new ListNode(-1);
	        dummy.next= head;
	        ListNode left=dummy;// this will be the left section of the list which is going to reverse
	        int group = 1;// this is the group count
	        ListNode ptr=head;
	        while(ptr!=null){
	            if(nodeleft<group){// if the left nodes are not equal to group we cannot apply reverse directly
	                break;
	            }
	            if(group%2!=0){// if the node group length is not even we can skip the group
	                for(int i =0;i<group;i++){
	                    left=ptr;
	                    ptr=ptr.next;
	                }
	            }else{
	                // here the reverse code will be to reverse the list
	                ListNode prev= ptr;// here is prev 
	                ListNode revtail=ptr;// this will be the tail of the reverse part of the list 
	                ListNode curr= ptr.next;// this will be the current node 
	                for(int i =0;i<group-1;i++){
	                    ListNode next= curr.next;
	                    curr.next=prev;
	                    prev=curr;
	                    curr=next;
	                }
	                revtail.next=curr;
	                left.next=prev;
	                left=prev;
	                ptr=curr;
	            }
	            nodeleft=nodeleft-group;
	            group++;
	        }
	        if(ptr!=null)
	        if(nodeleft%2==0){
	                ListNode prev= ptr;
	                ListNode revtail=ptr;
	                ListNode curr= ptr.next;
	                while(left.next!=prev){
	                    left=left.next;
	                }
	                while(curr!=null){
	                    ListNode next=curr.next;
	                    curr.next=prev;
	                    prev=curr;
	                    curr=next;
	                }   
	                revtail.next=curr;
	                left.next=prev;
	            }
	        

	        return dummy.next;
	        
	    }
	    public static int getLength(ListNode head ){
	        int  count=0;
	        while(head!=null){
	            count++;
	            head=head.next;
	        }
	        return count;
	    }
	

	public static void main(String[] args) {

		
		//Example 1:
		MyList head1 = new MyList(5,2,6,3,9,1,7,3,8,4);
		MyList output1 = new MyList(5,6,2,3,9,1,4,8,3,7);

		//Example 2:

		MyList head2 = new MyList(1,1,0,6);
		MyList output2= new MyList(1,0,1,6);

		//Example 3:

		MyList head3 = new MyList(1,1,0,6,5);
		MyList output3= new MyList(1,0,1,5,6);
		
		
		ListNode ans1=reverseEvenLengthGroups(head1.getHead());		
		ListNode ans2=reverseEvenLengthGroups(head2.getHead());		
		ListNode ans3=reverseEvenLengthGroups(head3.getHead());		
		
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
