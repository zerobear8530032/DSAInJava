//21. Merge Two Sorted Lists
//Solved
//Easy
//Topics
//premium lock icon
//Companies
//You are given the heads of two sorted linked lists list1 and list2.
//
//Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
//
//Return the head of the merged linked list.
//
// 
//
//Example 1:
//
//
//Input: list1 = [1,2,4], list2 = [1,3,4]
//Output: [1,1,2,3,4,4]
//Example 2:
//
//Input: list1 = [], list2 = []
//Output: []
//Example 3:
//
//Input: list1 = [], list2 = [0]
//Output: [0]
// 
//
//Constraints:
//
//The number of nodes in both lists is in the range [0, 50].
//-100 <= Node.val <= 100
//Both list1 and list2 are sorted in non-decreasing order.


package LinkedList.Learning;

import java.util.ArrayList;
import java.util.Arrays;

import LinkedList.Utils.ListNode;
import LinkedList.Utils.MyList;

public class MergeTwoSortedLists_21 {
//	approch :
//	here we use  a 2 pointer kind of  traversal where we check the val of list one 
//	and list 2  we compare and take the smaller value 
//	and incremeent the pointer of that list to next
//	if the value is same we can move any pointer or both pointer at the same time and adding them to list
//	after this end maybe some elements left so we will add them to the end of the list 
//	the list will remain sorted cause 2 list were sorted be default

//     approch is simple : this is the same priciple used to implement merge sort 
//
//    use 2 pointer one at l1 second at l2
//    now check which one is smaller if l1 add it to result list and move l1 pointer
//    other wise if l2 is smaller add l2 current node at result list and move l2 pointer
//    in the end both list will get used
//    and we will get sorted list merged together
//  time complexity : O(n+m) : n, m are l1,l2 length
//  space complexity : O(n+m) : the final listwill have all teh nodes 
	public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
	        ListNode reshead= new ListNode();
	        ListNode ptr = reshead;
	        while(list1!=null && list2!=null){
	            if(list1.val<list2.val){
	                int val = list1.val;
	                ptr.next=new ListNode(val);
	                list1=list1.next;
	                ptr=ptr.next;
	            }else{
	                int val = list2.val;
	                ptr.next=new ListNode(val);
	                list2=list2.next;
	                ptr=ptr.next;
	            }
	        }
//	        this will add alll element at the end of list 1
	        while(list1!=null){
	                int val = list1.val;
	                ptr.next=new ListNode(val);
	                ptr=ptr.next;
	                list1=list1.next;
	        }
//	        this will add alll element at the end of list 2
	        while(list2!=null){
	                int val = list2.val;
	                ptr.next=new ListNode(val);
	                ptr=ptr.next;
	                list2=list2.next;
	        }
	        return reshead.next;

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
		// TODO Auto-generated method stub
	//Example 1:

	MyList list11 = new MyList();
	MyList list12 = new MyList();
	MyList output1 = new MyList();
	list11.addAll(new ArrayList(Arrays.asList(1,2,3)));
	list12.addAll(new ArrayList(Arrays.asList(1,3,4)));
	output1.addAll(new ArrayList(Arrays.asList(1,1,2,3,4,4)));
	
	//Example 2:
	

	MyList list21 = new MyList();
	MyList list22 = new MyList();
	MyList output2 = new MyList();
	
	//Example 3:
	
	
	MyList list31 = new MyList();
	MyList list32 = new MyList();
	MyList output3 = new MyList();
	list32.addAll(new ArrayList(Arrays.asList(0)));
	output3.addAll(new ArrayList(Arrays.asList(0)));
	
	
	ListNode ans1= mergeTwoLists(list11.getHead(),list12.getHead());
	ListNode ans2= mergeTwoLists(list21.getHead(),list22.getHead());
	ListNode ans3= mergeTwoLists(list31.getHead(),list32.getHead());
	
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
