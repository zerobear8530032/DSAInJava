//Linked List Cycle Detection
//Solved
//Given the beginning of a linked list head, return true if there is a cycle in the linked list. Otherwise, return false.
//
//There is a cycle in a linked list if at least one node in the list can be visited again by following the next pointer.
//
//Internally, index determines the index of the beginning of the cycle, if it exists. The tail node of the list will set it's next pointer to the index-th node. If index = -1, then the tail node points to null and no cycle exists.
//
//Note: index is not given to you as a parameter.
//
//Example 1:
//
//
//
//Input: head = [1,2,3,4], index = 1
//
//Output: true
//Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
//
//Example 2:
//
//
//
//Input: head = [1,2], index = -1
//
//Output: false
//Constraints:
//
//1 <= Length of the list <= 1000.
//-1000 <= Node.val <= 1000
//index is -1 or a valid index in the linked list.
package LinkedList.Learning;

import LinkedList.Utils.ListNode;
import LinkedList.Utils.MyList;

public class LinkedListCycleDetection_NEETCODE {
//    approch : use fast slow pointer / turtle hare algo
//    here we use a slow ponite move 1 ahead
//    fast move 2 ahead
//    both starting at head
//    if both of them meet at a point means it have cycle
//    other wise it does not 
//    time complexity : O(n)
//    space complexity : O(1)
    public static boolean hasCycle(ListNode head) {
        ListNode fast= head;
        ListNode slow = head;
        while(fast!=null){
            slow = slow.next;
            if(fast!=null){
                fast=fast.next;
            }
            if(fast!=null){
                fast=fast.next;
            }
            if(fast==slow){
                break;
            }
        }
        return fast!=null && fast==slow;
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

        MyList head1 = new MyList(1,2,3,4);
        int index1 = 1;
        createCycle(head1,index1);
        boolean output1= true;

        //Example 2:


        MyList head2 = new MyList(1,2);
        int index2= -1;
        createCycle(head2,index2);
        boolean output2= false;

        boolean ans1 = hasCycle(head1.getHead());
        boolean ans2 = hasCycle(head2.getHead());

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
