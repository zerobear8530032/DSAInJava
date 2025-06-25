//234. Palindrome Linked List
//Solved
//Easy
//Topics
//premium lock icon
//Companies
//Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
//
// 
//
//Example 1:
//
//
//Input: head = [1,2,2,1]
//Output: true
//Example 2:
//
//
//Input: head = [1,2]
//Output: false
// 
//
//Constraints:
//
//The number of nodes in the list is in the range [1, 105].
//0 <= Node.val <= 9
// 
//
//Follow up: Could you do it in O(n) time and O(1) space?

package LinkedList.Learning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PalindromeLinkedList_234 {
//	approch : brute force:
//	here we use a arraylist and store all element of the linkedlist in one traversal
//	then we can reverse travese the arraylist and again travese the linkedlist and match
//	value if they are not equal return false;
//	time complexity :O(n)
//	space complexity :O(n)
	 public static boolean isPalindromeBruteForce(ListNode head) {
	        ListNode temp = head;
	        List<Integer> list = new ArrayList();
	        while(temp!=null){
	            list.add(temp.val);
	            temp=temp.next;
	        }
	        temp=head;
	        int idx = list.size()-1;
	        while(temp!=null){
	            if(temp.val!=list.get(idx)){
	                return false;
	            }
	            idx--;
	            temp=temp.next;
	        }
	        return true;
	    }
	
//	 better approch :
//	 here we use a function which reverse the linked list untill the given index 
//	 so we can do one thing first go from head to tail in linkedlist and find its length
//	 once we get it we will check  the mid point idx
//	 now we will reverse the linked list till mid point -1 idx 
//	 once its done we can just compare the to lists points we get one which we reverse and one we 
//	 left and check each value is equal or not 
//	 but if the list length isnot even then we will skip the mid node
//	 where the mid node will be we can skip it 
//	 time complexity :O(n)
//	 space complexity :O(1)
	 
	    public static boolean isPalindromeBetter(ListNode head) {
	         int len =0;
	         ListNode temp =head;
	         while(temp!=null){
	             temp=temp.next;
	             len++;
	         }
	         int idx=len/2;
	         ListNode [] nodes=revereseK(head,idx);
	         ListNode prev = nodes[0];
	         ListNode curr = nodes[1];
	         if(len%2==0){
	        	 ListNode currhead=curr;
	             while(prev!=null && curr!=null){
	                 if(prev.val!=curr.val){
	                     return false;
	                 }
	                 
	                 prev=prev.next;
	                 curr=curr.next;
	             }
	         }else{
	             // this will skip the mid element :
	             curr=curr.next;
	             while(prev!=null && curr!=null){
	                 if(prev.val!=curr.val){
	                     return false;
	                 }
	                 prev=prev.next;
	                 curr=curr.next;
	             }
	         }

	         return true;
	     }


	     public static ListNode[] revereseK(ListNode head, int idx){
	         ListNode prev=null;
	         ListNode curr=head;
	         ListNode next=null;
	         ListNode[] res= new ListNode[2];
	         for(int i =0;i<idx;i++){
	             next=curr.next;
	             curr.next=prev;
	             prev=curr;
	             curr=next;
	         }
	         res[0]=prev;
	         res[1]=curr; 
	         return res;
	     }
	 
	public static void main(String[] args) {
		//Example 1:

		MyList head1 = new MyList();
		head1.addAll(new ArrayList(Arrays.asList(1,2,2,1)));
		boolean output1=true;
		
		//Example 2:

		MyList head2 = new MyList();
		head2.addAll(new ArrayList(Arrays.asList(1,2)));
		boolean output2=false;
		
		System.out.println("Brute Force Approch :");
		
		boolean ans1=isPalindromeBruteForce(head1.getHead());		
		boolean ans2=isPalindromeBruteForce(head2.getHead());		
		
		if(output1==ans1) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Actual Output :"+output1 );
			System.out.println("Your Output :"+ans1);
		}
		if(output2==ans2) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Actual Output :"+output2 );
			System.out.println("Your Output :"+ans2);
		}
	
		System.out.println("Better Approch :");
		
		ans1=isPalindromeBetter(head1.getHead());		
		ans2=isPalindromeBetter(head2.getHead());		
		
		if(output1==ans1) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Actual Output :"+output1 );
			System.out.println("Your Output :"+ans1);
		}
		if(output2==ans2) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Actual Output :"+output2 );
			System.out.println("Your Output :"+ans2);
		}
		

	}

}
