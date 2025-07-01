//876. Middle of the Linked List
//Solved
//Easy
//Topics
//premium lock icon
//Companies
//Given the head of a singly linked list, return the middle node of the linked list.
//
//If there are two middle nodes, return the second middle node.
//
// 
//
//Example 1:
//
//
//Input: head = [1,2,3,4,5]
//Output: [3,4,5]
//Explanation: The middle node of the list is node 3.
//Example 2:
//
//
//Input: head = [1,2,3,4,5,6]
//Output: [4,5,6]
//Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.
// 
//
//Constraints:
//
//The number of nodes in the list is in the range [1, 100].
//1 <= Node.val <= 100

package LinkedList.Learning;

import java.util.ArrayList;
import java.util.Arrays;

import LinkedList.Utils.ListNode;
import LinkedList.Utils.MyList;

public class MiddleOfTheLinkedList_876 {
	
	
	
//	approch :
//	fiirst iterate over entire list and get its number of nodes 
//	then divide it by 2 and then just return that index node by reiterating 
//	time complexity O(n+n/2)
//	space complexity O(1)
	
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
   public static ListNode middleNode(ListNode head) {
       int count =0;
       ListNode temp = head;
       while(temp!=null){
           count++;
           temp=temp.next;
       }
       int mididx = count/2;
       return get(head,mididx);
   }
   public static ListNode get(ListNode head,int idx){
       ListNode ptr= head;
       for(int i =0;i<idx;i++){
           ptr=ptr.next;
       }
       return ptr;
   }

	public static void main(String[] args) {
		
		//Example 1:

		MyList list1 = new MyList();
		list1.addAll(new ArrayList<Integer>(Arrays.asList(1,2,3,4,5)));
		MyList output1 = new MyList();
		output1.addAll(new ArrayList<Integer>(Arrays.asList(3,4,5)));

		//Example 2:

		MyList list2 = new MyList();
		list2.addAll(new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6)));
		MyList output2 = new MyList();
		output2.addAll(new ArrayList<Integer>(Arrays.asList(4,5,6)));
		
		ListNode ans1= middleNode(list1.getHead());
		ListNode ans2= middleNode(list2.getHead());
		
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
		


	}

}
