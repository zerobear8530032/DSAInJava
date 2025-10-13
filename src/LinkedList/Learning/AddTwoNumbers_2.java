//2. Add Two Numbers
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
//
//You may assume the two numbers do not contain any leading zero, except the number 0 itself.
//
// 
//
//Example 1:
//
//
//Input: l1 = [2,4,3], l2 = [5,6,4]
//Output: [7,0,8]
//Explanation: 342 + 465 = 807.
//Example 2:
//
//Input: l1 = [0], l2 = [0]
//Output: [0]
//Example 3:
//
//Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//Output: [8,9,9,9,0,0,0,1]
// 
//
//Constraints:
//
//The number of nodes in each linked list is in the range [1, 100].
//0 <= Node.val <= 9
//It is guaranteed that the list represents a number that does not have leading zeros.

package LinkedList.Learning;

import LinkedList.Utils.ListNode;
import LinkedList.Utils.MyList;

public class AddTwoNumbers_2 {
//	approch :
//	simple just iterate over 2 list with a pointer 
//	and add there values while adding we have to use val1+val2+carry by default carry is 0
//	and each sum is preprocess 
//	where sum%10 will be added in answer list and sum/10 will be the new carry
//	we do this while ptr1!=null && ptr2!=null
//	but what if the ptr1 || ptr2 still left so we will seperately perform this operation again on rest 
//	of list one amd 2 if there are still elemts left
//	in the end the carry will add if its values is greater the 0 in the answer
//	time complexity :O(Max(n,m)) : here n is the number of element in l1  and m is the number of element in l2
//	space complexity :O(1)
	  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	        ListNode n1=l1;
	        ListNode n2=l2;
	        ListNode resHead= new ListNode();
	        ListNode ptr=resHead;
	        ListNode prev=resHead;
	        int carry =0;
	        while(n1!=null && n2!=null){
	            int v1=n1.val;
	            int v2=n2.val;
	            int sum = v1+v2+carry;
	            int n= sum%10;
	            carry = sum/10;
	            ptr.val=n;
	            ptr.next= new ListNode();
	            prev=ptr;
	            ptr=ptr.next;
	            n1=n1.next;
	            n2=n2.next;
	        }
	        while(n1!=null){
	            int v1=n1.val;
	            int sum = v1+carry;
	            int n= sum%10;
	            carry = sum/10;
	            ptr.val=n;
	            ptr.next= new ListNode();
	            prev=ptr;
	            ptr=ptr.next;
	            n1=n1.next;
	        }
	        while(n2!=null){
	            int v2=n2.val;
	            int sum = v2+carry;
	            int n= sum%10;
	            carry = sum/10;
	            ptr.val=n;
	            ptr.next= new ListNode();
	            prev=ptr;
	            ptr=ptr.next;
	            n2=n2.next;
	        }
	        if(carry!=0){
	            ptr.val=carry;
	            ptr.next=new ListNode();
	            prev=ptr;
	            ptr=ptr.next;
	        }
	        prev.next=null;
	        return resHead;
	    }


//        clear code of above approch :
//    we need to know 2 thing before it
//    first we can get the place value of sum of 2 number by n1+n2+carry %10 // this will give value of first number
//    second we can get the carray over value of the sum of 2 number by n1+n2+carry /10 // this wil; remove the first number
//    above works for 2 digits number only and sum of two single digits  number cannot exceed 2 digits
//    now if we can find of above things we can just iterate over both linkedlist and compute every thing as a single list
//    one last thing to make sure the sum should be reversed so we can add the elements ahead of a dummy node as result
//    this will automatically reverse it for us
//    time complexity : O(n)
//    space complexity : O(n)
public ListNode addTwoNumbersClean(ListNode l1, ListNode l2) {
    int carry=0;
    ListNode res= new ListNode();
    ListNode ptr=res;
    while(l1!=null || l2!=null || carry!=0){
        int n1= l1==null ? 0:l1.val;
        int n2= l2==null ? 0:l2.val;
        int sum = n1+n2+carry;
        int placeval= sum%10;
        carry= sum/10;
        ptr.next= new ListNode(placeval);
        ptr=ptr.next;
        if(l1!=null){l1=l1.next; }
        if(l2!=null){l2=l2.next; }
    }
    return res.next;}

    public static void main(String[] args) {
		//Example 1:

		MyList l11 = new MyList(2,4,3), l12 = new MyList(5,6,4);
		MyList output1= new MyList(7,0,8);
				

		//Example 2:
		
		MyList l21 = new MyList(0), l22 = new MyList(0);
		MyList output2= new MyList(0);

		//Example 3:
		//
		MyList l31 = new MyList(9,9,9,9,9,9,9), l32 = new MyList(9,9,9,9);
		MyList output3= new MyList(8,9,9,9,0,0,0,1);
		
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
    		System.out.println("Case 2 Passed");
    	}else {
    		System.out.println("Case 2 Failed");
    		System.out.println("Expected Ouput :"+ output3);
    		System.out.println("Your Answer :"+ ans3);  		
    	}
    

	}

}
