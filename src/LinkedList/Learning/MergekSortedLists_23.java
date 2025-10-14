//23. Merge k Sorted Lists
//Solved
//Hard
//Topics
//premium lock icon
//Companies
//You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
//
//Merge all the linked-lists into one sorted linked-list and return it.

//Example 1:
//
//Input: lists = [[1,4,5],[1,3,4],[2,6]]
//Output: [1,1,2,3,4,4,5,6]
//Explanation: The linked-lists are:
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//merging them into one sorted list:
//1->1->2->3->4->4->5->6
//Example 2:
//
//Input: lists = []
//Output: []
//Example 3:
//
//Input: lists = [[]]
//Output: []
// 
//
//Constraints:
//
//k == lists.length
//0 <= k <= 104
//0 <= lists[i].length <= 500
//-104 <= lists[i][j] <= 104
//lists[i] is sorted in ascending order.
//The sum of lists[i].length will not exceed 104.



package LinkedList.Learning;

import LinkedList.Utils.ListNode;
import LinkedList.Utils.MyList;

import java.util.PriorityQueue;

public class MergekSortedLists_23 {
//	brute force approch :
//	approch : we can take 2 pointer one at l1 , l2 
//	and add the smaller one in the new list and move that pointer ahead
//	keep doing it and we will have a sorted new list 
//	apply it on each lists with previous lists
//	we cna get the sorted lists 
//	
//	time complexity :O(n*k)
//	space complexity :O(n*k)
	    public static ListNode mergeKLists(ListNode[] lists) {
	        if (lists.length == 0) {
	            return null;
	        }
	        ListNode dummy = new ListNode(0);
	        int idx = 0;
	        ListNode head = null;
	        for (idx = 0; idx < lists.length; idx++) {
	            if (lists[idx] != null) {
	                head = lists[idx];
	                break;
	            }
	        }

	        dummy.next = head;
	        for(int i =idx+1;i<lists.length;i++){
	            dummy.next=merge(dummy.next,lists[i]);
	        }
	        return dummy.next;
	    }


	    public static ListNode merge(ListNode l1, ListNode l2){
	        ListNode dummy = new ListNode(-1) ;
	        ListNode res= dummy;
	        ListNode ptr1= l1;
	        ListNode ptr2= l2;
	        while(ptr1!=null && ptr2!=null){
	            if(ptr1.val<ptr2.val){
	                res.next= new ListNode(ptr1.val);
	                res=res.next;
	                ptr1=ptr1.next;
	            }else{
	                res.next= new ListNode(ptr2.val);
	                res=res.next;
	                ptr2=ptr2.next;
	            }
	        }
	        if(ptr1!=null){
	            while(ptr1!=null){
	                res.next=new ListNode(ptr1.val);
	                res=res.next;
	                ptr1=ptr1.next;
	            }
	        }
	        if(ptr2!=null){
	            while(ptr2!=null){
	                res.next=new ListNode(ptr2.val);
	                res=res.next;
	                ptr2=ptr2.next;
	            }
	        }
	        return dummy.next;
	    }

//        better approch: here we cna use  a priority queue to get all list sorted in n log n time
//    and create a linked list out of the queue elements
//    time complexity : (k*n log k*n)

        public static ListNode mergeKListsBetter(ListNode[] lists) {
            PriorityQueue<Integer> queue = new PriorityQueue();
            for(ListNode list:lists){
                fillQueue(queue,list);
            }
            // creat list :
            ListNode res= new ListNode();
            ListNode ptr= res;
            while(!queue.isEmpty()){
                ptr.next=new ListNode(queue.poll());
                ptr=ptr.next;
            }
            return res.next;
        }
        public static void fillQueue(PriorityQueue<Integer> queue, ListNode head){
            while(head!=null){
                queue.add(head.val);
                head=head.next;
            }
        }




    public static void main(String[] args) {

		
			//Example 1:
			
			ListNode [] lists1 = {new MyList(1,4,5).getHead(),new MyList(1,3,4).getHead(),new MyList(2,6).getHead()};
			MyList output1= new MyList(1,1,2,3,4,4,5,6);
	
			//Example 2:

			ListNode [] lists2 = {};
			MyList output2= new MyList();

			//Example 3:
			
			ListNode [] lists3 = {new MyList().getHead()};
			MyList output3= new MyList();
			
			//Example 4:
			
			ListNode [] lists4 = {new MyList(1,3,4,6,8,9,12).getHead(),new MyList(1,2,5,7,11,21,24).getHead(),new MyList(-4,0,4,7,10,14,22,29).getHead()};
			MyList output4= new MyList(-4,0,1,1,2,3,4,4,5,6,7,7,8,9,10,11,12,14,21,22,24,29);
			
			
			System.out.println("Better Approch :");

			ListNode ans1 = mergeKLists(lists1);
            ListNode ans2 = mergeKLists(lists2);
            ListNode ans3 = mergeKLists(lists3);
			ListNode ans4 = mergeKLists(lists4);
			
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
				System.out.println("Actual Output :"+output2);
				System.out.println("Your Output :"+ans2);
			}
			if(output3.equals(ans3)) {
				System.out.println("Case 3 Passed");
			}else {
				System.out.println("Case 3 Failed");
				System.out.println("Actual Output :"+output3);
				System.out.println("Your Output :"+ans3);
			}
			if(output4.equals(ans4)) {
				System.out.println("Case 4 Passed");
			}else {
				System.out.println("Case 4 Failed");
				System.out.println("Actual Output :"+output4);
				System.out.println("Your Output :"+ans4);
			}

			System.out.println("Brute Force Approch :");

         lists1 = new ListNode[] {new MyList(1,4,5).getHead(),new MyList(1,3,4).getHead(),new MyList(2,6).getHead()};
         lists2 = new ListNode[]{};
         lists3 = new ListNode[]{new MyList().getHead()};
         lists4 = new ListNode[]{new MyList(1,3,4,6,8,9,12).getHead(),new MyList(1,2,5,7,11,21,24).getHead(),new MyList(-4,0,4,7,10,14,22,29).getHead()};


         ans1 = mergeKListsBetter(lists1);
		 ans2 = mergeKListsBetter(lists2);
         ans3 = mergeKListsBetter(lists3);
		 ans4 = mergeKListsBetter(lists4);

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
				System.out.println("Actual Output :"+output2);
				System.out.println("Your Output :"+ans2);
			}
			if(output3.equals(ans3)) {
				System.out.println("Case 3 Passed");
			}else {
				System.out.println("Case 3 Failed");
				System.out.println("Actual Output :"+output3);
				System.out.println("Your Output :"+ans3);
			}
			if(output4.equals(ans4)) {
				System.out.println("Case 4 Passed");
			}else {
				System.out.println("Case 4 Failed");
				System.out.println("Actual Output :"+output4);
				System.out.println("Your Output :"+ans4);
			}


	}

}
