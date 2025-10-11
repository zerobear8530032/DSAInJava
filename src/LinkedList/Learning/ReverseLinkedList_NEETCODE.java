//Reverse Linked List
//Solved 
//Given the beginning of a singly linked list head, reverse the list, and return the new beginning of the list.
//
//Example 1:
//
//Input: head = [0,1,2,3]
//
//Output: [3,2,1,0]
//Example 2:
//
//Input: head = []
//
//Output: []
//Constraints:
//
//0 <= The length of the list <= 1000.
//-1000 <= Node.val <= 1000


package LinkedList.Learning;

import LinkedList.Utils.MyList;
import LinkedList.Utils.ListNode;

public class ReverseLinkedList_NEETCODE {
//     approch :
//    use 3 pointers :
//    prev : this will remain behind current
//    curr : this is the current node
//    next : this will be ahead of current
//    steps :
//    by default current = head , prev = null , next = null
//    1: first assign next to curr.next
//    2: now assign current.next pointer to prev this will remove the connection of curr and next
//    and create a connection to current and prev
//    3: now assign prev to current so that prev will get to previous node for next iteration
//    4: now get the current to next node
//    repeat above steps until current not becomes null
//    at the end prev will be at the tail of original list and becomes the head of reverse list
//    time complexity : O(n)
//    space complexity : O(1)
    public static ListNode reverseList(ListNode head) {
        ListNode prev=null;
        ListNode curr=head;
        while(curr!=null){
            ListNode next= curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
    public static void main(String[] args) {
        //Example 1:

        MyList head1 = new MyList(0,1,2,3);
        MyList output1 = new MyList(3,2,1,0);

        //Example 2:

        MyList head2 = new MyList();
        MyList output2 = new MyList();

        ListNode ans1= reverseList(head1.getHead());
        ListNode ans2= reverseList(head2.getHead());

        if(output1.equals(ans1)) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Actual Output :"+output1 );
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
