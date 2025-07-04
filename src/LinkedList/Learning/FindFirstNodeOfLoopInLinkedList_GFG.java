package LinkedList.Learning;

import java.util.HashSet;

import LinkedList.Utils.ListNode;
import LinkedList.Utils.MyList;

public class FindFirstNodeOfLoopInLinkedList_GFG {
//	approch :
//	go throught the list and check the elemeent exists in the hashset or not 
//	if not add it in set if yes return the node as start of loop
//	
	public static  int detectLoop(ListNode head) {
		if(head==null) {
			return -1;
		}
		HashSet<ListNode> set= new HashSet();
		ListNode temp = head;
		while(temp!=null) {
			if(set.contains(temp)) {
				return temp.val;
			}else {
				set.add(temp);
			}
			temp=temp.next;
		}
		return -1;
	}
	public static  int detectLoopBetter(ListNode head) {
		if(head==null) {
			return -1;
		}
		ListNode slow= head;
		ListNode fast= head;
		
		do {
			slow = slow.next;
			if(fast==null) {
				return -1;
			}
			if(fast.next==null) {
				return -1;
			}
			fast=fast.next.next;
		}while(fast!=slow);
		fast=head;
		while(fast!=slow) {
			fast=fast.next;
			slow=slow.next;
		}
		return slow.val;
	}
	
//	use turtle and hare algorith :
	
	
	public static void createCycle(MyList head, int pos ) {
		if(pos<0) {
			return ;
		}
		ListNode tail = head.getTail();
		ListNode node = head.get(pos);
		tail.next= node;
	}
	
	public static void main(String[] args) {
		
//		Example 1 :
		MyList list1= new MyList(1,3,2,4,5);
		int pos1= 1;
		createCycle(list1, pos1);
		int output1=3;

		
//		Example 2 :
		MyList list2= new MyList(1,3,2,4,5);
		int pos2= -1;
		createCycle(list2, pos2);
		int output2=-1;
		
		int ans1=detectLoop(list1.getHead());		
		int ans2=detectLoop(list2.getHead());		
		
		if(output1==ans1) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Actual Output :"+output1);
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
		
		ans1=detectLoopBetter(list1.getHead());		
		ans2=detectLoopBetter(list2.getHead());		
		
		if(output1==ans1) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Actual Output :"+output1);
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
