//1669. Merge In Between Linked Lists
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//You are given two linked lists: list1 and list2 of sizes n and m respectively.
//
//Remove list1's nodes from the ath node to the bth node, and put list2 in their place.
//
//The blue edges and nodes in the following figure indicate the result:
//
//
//Build the result list and return its head.
//
// 
//
//Example 1:
//
//
//Input: list1 = [10,1,13,6,9,5], a = 3, b = 4, list2 = [1000000,1000001,1000002]
//Output: [10,1,13,1000000,1000001,1000002,5]
//Explanation: We remove the nodes 3 and 4 and put the entire list2 in their place. The blue edges and nodes in the above figure indicate the result.
//Example 2:
//
//
//Input: list1 = [0,1,2,3,4,5,6], a = 2, b = 5, list2 = [1000000,1000001,1000002,1000003,1000004]
//Output: [0,1,1000000,1000001,1000002,1000003,1000004,6]
//Explanation: The blue edges and nodes in the above figure indicate the result.
// 
//
//Constraints:
//
//3 <= list1.length <= 104
//1 <= a <= b < list1.length - 1
//1 <= list2.length <= 104

package LinkedList.Learning;

import LinkedList.Utils.ListNode;
import LinkedList.Utils.MyList;

public class MergeInBetweenLinkedLists_1669 {
	
	
//	approch :
//	here we get start from  0 index and get the node at a-1
//	after that we can start form a-1 node and get b-a+1 node
//	then we can just connect a-1 to head of list2 and list2 tail will
//	connect to the from a-1 :b-a+1 node
	 public static ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
	        ListNode dummy= new ListNode(-1);
	        dummy.next=list1;
	        ListNode start=getNode(list1,a-1);
	        ListNode end=getNode(start,b-a+2);
	        start.next=list2;
	        ListNode ptr = list2;
	        while(ptr.next!=null){
	            ptr=ptr.next;
	        }
	        ptr.next=end;
	        return dummy.next;
	    }
	    public static ListNode getNode(ListNode node , int idx){
	        for(int i =0;i<idx;i++){
	            node=node.next;
	        }
	        return node;
	    }

	public static void main(String[] args) {
		
		//Example 1:

		MyList list11 = new MyList(10,1,13,6,9,5) , list12 = new MyList(1000000,1000001,1000002);
		int a1 = 3, b1 = 4; 
		MyList output1= new MyList(10,1,13,1000000,1000001,1000002,5);

		//Example 2:

		MyList list21 = new MyList(0,1,2,3,4,5,6) , list22 = new MyList(1000000,1000001,1000002,1000003,1000004);
		int a2 = 2, b2 = 5; 
		MyList output2= new MyList(0,1,1000000,1000001,1000002,1000003,1000004,6);
		
		
		
		ListNode ans1=mergeInBetween(list11.getHead(), a1, b1, list12.getHead());
		ListNode ans2=mergeInBetween(list21.getHead(), a2, b2, list22.getHead());
		
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
