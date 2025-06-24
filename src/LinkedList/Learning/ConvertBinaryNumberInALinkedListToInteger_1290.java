//1290. Convert Binary Number in a Linked List to Integer
//Solved
//Easy
//Topics
//premium lock icon
//Companies
//Hint
//Given head which is a reference node to a singly-linked list. The value of each node in the linked list is either 0 or 1. The linked list holds the binary representation of a number.
//
//Return the decimal value of the number in the linked list.
//
//The most significant bit is at the head of the linked list.
//
// 
//
//Example 1:
//
//
//Input: head = [1,0,1]
//Output: 5
//Explanation: (101) in base 2 = (5) in base 10
//Example 2:
//
//Input: head = [0]
//Output: 0
// 
//
//Constraints:
//
//The Linked List is not empty.
//Number of nodes will not exceed 30.
//Each node's value is either 0 or 1.



package LinkedList.Learning;

import myDataStructures.LinkedList.MySinglyLinkedList;
import myDataStructures.LinkedList.Node;

public class ConvertBinaryNumberInALinkedListToInteger_1290 {
//	approch : store the element in a way where we can access it right to left
//	then we can use the formula  from left to irght bysum+= nums[i]*2^index
//	time complexity : O(n)
//	space complexity : O(n)
	  public static  int getDecimalValue(ListNode head) {
	        StringBuilder num = new StringBuilder();
	        ListNode temp =head;
	        while(temp!=null){
	            int x=temp.val;
	            temp=temp.next;
	            num.append(x);
	        }
	        int res=0;
	        for(int i =num.length()-1;i>=0;i--){    
	            if(num.charAt(i)=='1'){
	            res= res+ (int) Math.pow(2,num.length()-i-1);
	            }
	        }
	        return res;
	    }

	public static void main(String[] args) {
		
		//Example 1:

		MyList list1= new MyList();
		list1.add(1);
		list1.add(0);
		list1.add(1);
		ListNode head1 = list1.getHead();
		int output1=5;


		//Example 2:
		
		MyList list2= new MyList();
		list2.add(0);
		ListNode head2 = list2.getHead();
		int output2=0;
		
		//Example 3:
		
		MyList list3= new MyList();
		list3.add(1);
		list3.add(0);
		list3.add(1);
		list3.add(0);
		ListNode head3 = list3.getHead();
		int output3=10;
		
		int ans1=getDecimalValue(head1);		
		int ans2=getDecimalValue(head2);		
		int ans3=getDecimalValue(head3);		
		
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
		if(output3==ans3) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Actual Output :"+output3);
			System.out.println("Your Output :"+ans3);
		}

		
		
	}

}
