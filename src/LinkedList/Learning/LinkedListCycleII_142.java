//142. Linked List Cycle II
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.
//
//There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter.
//
//Do not modify the linked list.
//
// 
//
//Example 1:
//
//
//Input: head = [3,2,0,-4], pos = 1
//Output: tail connects to node index 1
//Explanation: There is a cycle in the linked list, where tail connects to the second node.
//Example 2:
//
//
//Input: head = [1,2], pos = 0
//Output: tail connects to node index 0
//Explanation: There is a cycle in the linked list, where tail connects to the first node.
//Example 3:
//
//
//Input: head = [1], pos = -1
//Output: no cycle
//Explanation: There is no cycle in the linked list.
// 
//
//Constraints:
//
//The number of the nodes in the list is in the range [0, 104].
//-105 <= Node.val <= 105
//pos is -1 or a valid index in the linked-list.
// 
//
//Follow up: Can you solve it using O(1) (i.e. constant) memory?
package LinkedList.Learning;

import java.util.HashSet;

import LinkedList.Utils.ListNode;
import LinkedList.Utils.MyList;

public class LinkedListCycleII_142 {
//	brute force approch:
//	here we use a hashset and we put every node in hash set if we have not seen it other wise return the node
//	which already exists in the set
//	time complexity :O(n)
//	space complexity :O(n)
	public static ListNode detectCycleBruteForce(ListNode head) {
        ListNode ptr= head;
        HashSet<ListNode> set= new HashSet();
        while(ptr!=null){
            if(set.contains(ptr)){
                return ptr;
            }else{
                set.add(ptr);
            }
            ptr=ptr.next;
        }
        return null;
    }
	
//	Better force approch:
//	here we use slow and fast pointer both start from starting 
//	and go untill booth are not equal the slow will go one node ahead each iteration and
//	the fast will go 2 nodes if both meet at a point means there is cycle other wise its non cycle
//	if the cycle exists we will reset the fast pointer now it will go ahead 1 node and the slow pointer
//	also move one node ahead until they both meet that meeting pointer is the node having the cycle
//	time complexity :O(n)
//	space complexity :O(1)
	public static ListNode detectCycleBetter(ListNode head) {
		ListNode ptr= head;
		HashSet<ListNode> set= new HashSet();
		while(ptr!=null){
			if(set.contains(ptr)){
				return ptr;
			}else{
				set.add(ptr);
			}
			ptr=ptr.next;
		}
		return null;
	}
	
	public static void createCycle(MyList head, int pos ) {
		if(pos<0) {
			return ;
		}
		ListNode tail = head.getTail();
		ListNode node = head.get(pos);
		tail.next= node;
	}

	public static void main(String[] args) {
		
		//Example 1:

		MyList  head1 = new MyList(3,2,0,-4);
		int  pos1 = 1;
		createCycle(head1, pos1);
		ListNode output1= head1.get(pos1);

		//Example 2:

		MyList  head2 = new MyList(1,2);
		int  pos2 = 0;
		createCycle(head2, pos2);
		ListNode output2= head2.get(pos2);
		
		//Example 3:

		MyList  head3 = new MyList(1);
		int  pos3 = -1;
		createCycle(head3, pos3);
		ListNode output3= null;		
		
		
		
	System.out.println("Brute Force Approch :");
		
		ListNode ans1=detectCycleBruteForce(head1.getHead());		
		ListNode ans2=detectCycleBruteForce(head2.getHead());		
		ListNode ans3=detectCycleBruteForce(head3.getHead());		
		
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
		if(output3==ans3) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Actual Output :"+output3);
			System.out.println("Your Output :"+ans3);
		}

		
		
		System.out.println("Better Approch :");
		
		ans1=detectCycleBetter(head1.getHead());		
		ans2=detectCycleBetter(head2.getHead());		
		ans3=detectCycleBetter(head3.getHead());		
		
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
		if(output3==ans3) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Actual Output :"+output3);
			System.out.println("Your Output :"+ans3);
		}
		
		
		
		


	}

}
