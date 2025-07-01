//206. Reverse Linked List
//Solved
//Easy
//Topics
//premium lock icon
//Companies
//Given the head of a singly linked list, reverse the list, and return the reversed list.
//
// 
//
//Example 1:
//
//
//Input: head = [1,2,3,4,5]
//Output: [5,4,3,2,1]
//Example 2:
//
//
//Input: head = [1,2]
//Output: [2,1]
//Example 3:
//
//Input: head = []
//Output: []
// 
//
//Constraints:
//
//The number of nodes in the list is the range [0, 5000].
//-5000 <= Node.val <= 5000
// 
//
//Follow up: A linked list can be reversed either iteratively or recursively. Could you implement both?


package LinkedList.Learning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import LinkedList.Utils.ListNode;
import LinkedList.Utils.MyList;


public class ReverseLinkedList_206 {
	
	
//	bruteForce approch :
//	here we store the linked list in a differetn data structure to traverse it reverse
//	and create a new linked list to get teh answer 
//	time complexity : O(n)
//	space complexity : O(n)
	
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
	    public static ListNode reverseListBruteForce(ListNode head) {
	        if(head==null){
	            return head;
	        }
	        List<Integer> list = new ArrayList<Integer>();
	        ListNode temp=head;
	        while(temp!=null){
	            list.add(temp.val);
	            temp=temp.next;
	        }
	        int size=list.size();
	        ListNode res= new ListNode(list.get(size-1));
	        ListNode ptr=res;
	        for(int i =size-2;i>=0;i--){  
	            int x = list.get(i);
	            ListNode node = new ListNode(x);
	            ptr.next=node;
	            ptr=node;
	        }
	        return res;
	    }
	
	
	
//	better approch :
//	here we use a 2 pointer logic a current and prev
//	by default curr is the head and prev is null
//	then we loop untill curr not null
//	inside loop we make a new pointer which point to next ndoe from curr
//	node next = curr.next;
//	now we point curr.next to prev (curr.next=prev)// make connection to prev node
//	now we will get prev to curr (prev=curr)// update the prev to next node 
//	now we will get the curr to the actual next node 
//	curr=next
//	by the end the head of the list will be at prev and curr will be null
//	time complexity : O(n)
//	space complexity : O(1)
	    	    
    public static ListNode reverseListBest(ListNode head) {
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

//	Recursion approch :
//  its same as iterative we will do it recursively
//  here we need  to create a function which take 2 node ptr
//  curr,prev  and it follow same approch as interative one
//	time complexity : O(n)
//	space complexity : O(n)
    
    public static ListNode reverseListRecursive(ListNode head) {
    	return helper(head,null);
    }
    
    public static  ListNode helper(ListNode curr, ListNode prev) {
    	if(curr==null) {
    		return prev;
    	}
    	ListNode next= curr.next;
    	curr.next=prev;
    	prev=curr;
    	curr=next;
    	return helper(curr,prev);	
    }
    
    public static boolean check(ListNode ans, ListNode output) {
    	ListNode anstemp =ans;
    	ListNode outputtemp =output;
    	while(anstemp!=null && outputtemp!=null) {
    		if(anstemp.val!=outputtemp.val) {
    			return false;
    		}
    		anstemp=anstemp.next;
    		outputtemp=outputtemp.next;
    	}
    	return anstemp==null && outputtemp==null;
    }

	public static void main(String[] args) {
		
		//Example 1:
		
		MyList list1 = new MyList();
		list1.addAll(new ArrayList(Arrays.asList(1,2,3,4,5)));
		MyList output1= new MyList();
		output1.addAll(new ArrayList(Arrays.asList(5,4,3,2,1)));
		
		
		//Example 2:

		MyList list2 = new MyList();
		list2.addAll(new ArrayList(Arrays.asList(1,2)));
		MyList output2= new MyList();
		output2.addAll(new ArrayList(Arrays.asList(2,1)));


		//Example 3:
		
		MyList list3 = new MyList();
		MyList output3= new MyList();
		
		
		System.out.println("Brute Force Approch ");
		ListNode ans1= reverseListBruteForce(list1.getHead());
		ListNode ans2= reverseListBruteForce(list2.getHead());
		ListNode ans3= reverseListBruteForce(list3.getHead());
		
		if(check(output1.getHead(),ans1)) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Actual Output :"+output1 );
			System.out.println("Your Output :"+ans1);
		}
		if(check(output2.getHead(),ans2)) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Actual Output :"+output2 );
			System.out.println("Your Output :"+ans2);
		}
		if(check(output3.getHead(),ans3)) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Actual Output :"+output3 );
			System.out.println("Your Output :"+ans3);
		}
		
		
		System.out.println("Recursive Approch ");
		list1= new MyList();
		list1.addAll(new ArrayList(Arrays.asList(1,2,3,4,5)));
		list2= new MyList();
		list2.addAll(new ArrayList(Arrays.asList(1,2)));
		list3= new MyList();
	
		ans1= reverseListRecursive(list1.getHead());
		ans2= reverseListRecursive(list2.getHead());
		ans3= reverseListRecursive(list3.getHead());
		
		if(check(output1.getHead(),ans1)) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Actual Output :"+output1 );
			System.out.println("Your Output :"+ans1);
		}
		if(check(output2.getHead(),ans2)) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Actual Output :"+output2 );
			System.out.println("Your Output :"+ans2);
		}
		if(check(output3.getHead(),ans3)) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Actual Output :"+output3 );
			System.out.println("Your Output :"+ans3);
		}
		
		System.out.println("Best Approch ");
		list1= new MyList();
		list1.addAll(new ArrayList(Arrays.asList(1,2,3,4,5)));
		list2= new MyList();
		list2.addAll(new ArrayList(Arrays.asList(1,2)));
		list3= new MyList();
		
		ans1= reverseListBest(list1.getHead());
		ans2= reverseListBest(list2.getHead());
		ans3= reverseListBest(list3.getHead());
		
		if(check(output1.getHead(),ans1)) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Actual Output :"+output1 );
			System.out.println("Your Output :"+ans1);
		}
		if(check(output2.getHead(),ans2)) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Actual Output :"+output2 );
			System.out.println("Your Output :"+ans2);
		}
		if(check(output3.getHead(),ans3)) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Actual Output :"+output3 );
			System.out.println("Your Output :"+ans3);
		}

		
		
	
	}

}
