//3217. Delete Nodes From Linked List Present in Array
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//You are given an array of integers nums and the head of a linked list. Return the head of the modified linked list after removing all nodes from the linked list that have a value that exists in nums.
//
//
//
//Example 1:
//
//Input: nums = [1,2,3], head = [1,2,3,4,5]
//
//Output: [4,5]
//
//Explanation:
//
//
//
//Remove the nodes with values 1, 2, and 3.
//
//Example 2:
//
//Input: nums = [1], head = [1,2,1,2,1,2]
//
//Output: [2,2,2]
//
//Explanation:
//
//
//
//Remove the nodes with value 1.
//
//Example 3:
//
//Input: nums = [5], head = [1,2,3,4]
//
//Output: [1,2,3,4]
//
//Explanation:
//
//
//
//No node has value 5.
//
//
//
//Constraints:
//
//1 <= nums.length <= 105
//1 <= nums[i] <= 105
//All elements in nums are unique.
//The number of nodes in the given list is in the range [1, 105].
//1 <= Node.val <= 105
//The input is generated such that there is at least one node in the linked list that has a value not present in nums.
package LinkedList;

import LinkedList.Utils.ListNode;
import LinkedList.Utils.MyList;

import java.util.HashSet;

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
class DeleteNodesFromLinkedListPresentInArray_3217 {
//    approch :
//     use a hashset to store all nums in it
//    and go through entire linkedlist
//    if the hashset contains the values then skip it
//    other wise add the node to the output list
//    time complexity : O(n+m)
//    space complexity : O(n)
    public static ListNode modifiedList(int[] nums, ListNode head) {
        HashSet<Integer> remove= new HashSet();
        for(int x:nums){
            remove.add(x);
        }
        ListNode res= new ListNode();
        ListNode ptr= res;
        while(head!=null){
            ListNode next = head.next;
            if(!remove.contains(head.val)){
                ptr.next=head;
                ptr=ptr.next;
                ptr.next=null;
            }
            head=next;
        }

        return res.next;
   }

    public static void main(String[] args) {
        //Example 1:

        int [] nums1 = {1,2,3};
        MyList  head1 = new MyList(1,2,3,4,5);
        MyList  output1 = new MyList(4,5);

        //Example 2:

        int [] nums2 = {1};
        MyList  head2 = new MyList(1,2,1,2,1,2);
        MyList  output2 = new MyList(2,2,2);

        //Example 3:

        int [] nums3 = {5};
        MyList  head3 = new MyList(1,2,3,4);
        MyList  output3 = new MyList(1,2,3,4);

        ListNode ans1 = modifiedList(nums1,head1.getHead());
        ListNode ans2 = modifiedList(nums2,head2.getHead());
        ListNode ans3 = modifiedList(nums3,head3.getHead());


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
         if(output3.equals(ans3)) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Actual Output :"+output3 );
            System.out.println("Your Output :"+ans3);
        }

    }
}