//445. Add Two Numbers II
//premium lock icon
//Companies
//You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
//
//You may assume the two numbers do not contain any leading zero, except the number 0 itself.
//
// 
//
//Example 1:
//
//
//Input: l1 = [7,2,4,3], l2 = [5,6,4]
//Output: [7,8,0,7]
//Example 2:
//
//Input: l1 = [2,4,3], l2 = [5,6,4]
//Output: [8,0,7]
//Example 3:
//
//Input: l1 = [0], l2 = [0]
//Output: [0]
// 
//
//Constraints:
//
//The number of nodes in each linked list is in the range [1, 100].
//0 <= Node.val <= 9
//It is guaranteed that the list represents a number that does not have leading zeros.
// 
//
//Follow up: Could you solve it without reversing the input lists?

package LinkedList.Learning;

import java.util.Stack;

import LinkedList.Utils.ListNode;
import LinkedList.Utils.MyList;

public class AddTwoNumbersII_445 {
	
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
//	approch :
//	reverse the lists and then add the values of the linked lists using previous approch 
//	and re reverse the answer list
//	time complexity :O(n+m): 
//	space complexity :O(1):



	     public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		        ListNode n1=reverseList(l1);
		        ListNode n2=reverseList(l2);
		        ListNode resHead= null;
		        int carry =0;
		        while(n1!=null && n2!=null){
		            int v1=n1.val;
		            int v2=n2.val;
		            int sum = v1+v2+carry;
		            int n= sum%10;
		            carry = sum/10;
	                ListNode node = new ListNode(n);
	                node.next=resHead;
	                resHead=node;
		            n1=n1.next;
		            n2=n2.next;
		        }
		        while(n1!=null){
		            int v1=n1.val;
		            int sum = v1+carry;
		            int n= sum%10;
		            carry = sum/10;
	                ListNode node = new ListNode(n);
	                node.next=resHead;
	                resHead=node;
		            n1=n1.next;
		        }
		        while(n2!=null){
		            int v2=n2.val;
		            int sum = v2+carry;
		            int n= sum%10;
		            carry = sum/10;
	                ListNode node = new ListNode(n);
	                node.next=resHead;
	                resHead=node;
		            n2=n2.next;
		        }
		        if(carry!=0){
	                ListNode node = new ListNode(carry);
	                node.next=resHead;
	                resHead=node;
		        }
//		        this can be used to  revert the linked list
		        // reverseList(l1);
                // reverseList(l2);
		        return resHead;
		    }

	    public static ListNode reverseList(ListNode head) {
	        ListNode curr= head;
	        ListNode prev = null;
	        while(curr!=null){
	           ListNode next= curr.next;
	           curr.next=prev;
	           prev=curr;
	           curr=next; 
	        }
	        return prev;
	    }

	
//	Better approch :
//	here we put all list element in 2 seperate stack and pop element to traverse list in reverse
//	here we add the result in the list at head not at tail what we did in the addtwo number questions
//	follow same approch we   use in add 2 number problem 
//	 time complexity :O(n+m)        
//	 time complexity :O(n+m)        
     
	    public static ListNode addTwoNumbersFollowUp(ListNode l1, ListNode l2) {
	        Stack <Integer>n1=putAllInStack(l1);
	        Stack <Integer>n2=putAllInStack(l2);
            ListNode resHead= null;
	        int carry =0;
	        while(!n1.isEmpty() && !n2.isEmpty()){
	            int v1=n1.peek();
	            int v2=n2.peek();                
	            int sum = v1+v2+carry;
	            int n= sum%10;
	            carry = sum/10;
                ListNode node = new ListNode(n);
                node.next=resHead;
                resHead=node;
                n1.pop();
                n2.pop();
	        }
	        while(!n1.isEmpty()){
	            int v1=n1.peek();
	            int sum = v1+carry;
	            int n= sum%10;
	            carry = sum/10;
               ListNode node = new ListNode(n);
                node.next=resHead;
                resHead=node;
                n1.pop();
	        }
	        while(!n2.isEmpty()){
	            int v2=n2.peek();
	            int sum = v2+carry;
	            int n= sum%10;
	            carry = sum/10;
               ListNode node = new ListNode(n);
                node.next=resHead;
                resHead=node;
                n2.pop();
	        }
	        if(carry!=0){
                ListNode node = new ListNode(carry);
                node.next=resHead;
                resHead=node;
 
	        }
            
	        return resHead;
	    }

    public static Stack putAllInStack(ListNode head){
        Stack<Integer> stack= new Stack();
        while(head!=null){
            stack.add(head.val);
            head=head.next;
        }
        return stack;
    }
   

		     
		     



	public static void main(String[] args) {
		//Example 1:

		MyList l11 = new MyList(7,2,4,3), l12 = new MyList(5,6,4);
		MyList output1= new MyList(7,8,0,7);
				

		//Example 2:
		MyList l21 = new MyList(2,4,3), l22 = new MyList(5,6,4);
		MyList output2= new MyList(8,0,7);
		

		//Example 3:
		//
		MyList l31 = new MyList(0), l32 = new MyList(0);
		MyList output3= new MyList(0);
				
		System.out.println("Solution :");
		
		ListNode ans1= addTwoNumbers(l11.getHead(), l12.getHead());
		ListNode ans2= addTwoNumbers(l21.getHead(), l22.getHead());
		ListNode ans3= addTwoNumbers(l31.getHead(), l32.getHead());
	    		    	
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
    
    	System.out.println("Follow up Approch :");
    	//Example 1:

		l11 = new MyList(7,2,4,3);
		l12 = new MyList(5,6,4);

		//Example 2:
		
		l21 = new MyList(2,4,3);
		l22 = new MyList(5,6,4);
		

		//Example 3:

		l31 = new MyList(0);
		l32 = new MyList(0);
		
		ans1= addTwoNumbersFollowUp(l11.getHead(), l12.getHead());
		ans2= addTwoNumbersFollowUp(l21.getHead(), l22.getHead());
		ans3= addTwoNumbersFollowUp(l31.getHead(), l32.getHead());

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
