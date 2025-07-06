////1019. Next Greater Node In Linked List
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//You are given the head of a linked list with n nodes.
//
//For each node in the list, find the value of the next greater node. That is, for each node, find the value of the first node that is next to it and has a strictly larger value than it.
//
//Return an integer array answer where answer[i] is the value of the next greater node of the ith node (1-indexed). If the ith node does not have a next greater node, set answer[i] = 0.
//
// 
//
//Example 1:
//
//
//Input: head = [2,1,5]
//Output: [5,5,0]
//Example 2:
//
//
//Input: head = [2,7,4,3,5]
//Output: [7,0,5,5,0]
// 
//
//Constraints:
//
//The number of nodes in the list is n.
//1 <= n <= 104
//1 <= Node.val <= 109


package LinkedList.Learning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import LinkedList.Utils.ListNode;
import LinkedList.Utils.MyList;

public class NextGreaterNodeInLinkedList_1019 {
	
//	approch :
//	check from every single node and find its next greater element
//	time complexity :O(n*n)
//	space complexity :O(1)
	   public static int[] nextLargerNodesBruteForce(ListNode head) {
	        List<Integer>res= new ArrayList<Integer>();
	        ListNode i=head;
	        while(i!=null){
	            ListNode j = i.next;
	            int ival = i.val;
	            boolean isGreater = false;
	            while(j!=null){
	                int jval = j.val;
	                if(ival<jval){
	                    isGreater=true;
	                    res.add(jval);
	                    break;
	                }
	                j=j.next;
	            }
	            if(!isGreater){
	                res.add(0);
	            }
	            i=i.next;
	        }
	        int [] ans = new int [res.size()];
	        int idx = 0;
	        for(int x:res){
	            ans[idx]=x;
	            idx++;
	        }
	        // System.out.println(res);
	        return ans;
	    }
	   
//	   approch :
//	   here we use a monotnic stack and traverse in a reverse order where if we found a greater eleent push in stakc 
//	   by poping all the smaller onces
//	   time compelxity:O(n)
//	   space compelxity:O(n)
	   public static int[] nextLargerNodesBest(ListNode head) {
	        List<Integer> list = new ArrayList<>();
	        ListNode ptr = head;
	        while (ptr != null) {
	            list.add(ptr.val);
	            ptr = ptr.next;
	        }

	        Stack<Integer> stk = new Stack();
	        int size = list.size();
	        int[] arr = new int[size];

	        for (int i = size - 1; i >= 0; i--) {
	            int currVal = list.get(i);
	            while (!stk.isEmpty() && stk.peek() <= currVal) {
	                stk.pop();
	            }

	            arr[i] = stk.isEmpty() ? 0 : stk.peek();
	            stk.push(currVal);  // use original value for future comparisons
	        }

	        return arr;
	    }
	   
	   
	   public static boolean check(int [] output , int [] ans) {
		   if(ans.length!=output.length) {
			   return false;
		   }
		   for(int i =0;i<ans.length;i++) {
			   if(ans[i]!=output[i]) {
				   return false;
			   }
		   }
		   return true;
	   }

	public static void main(String[] args) {

		
		
		//Example 1:

		MyList head1 = new MyList(2,1,5);
		int [] output1 = {5,5,0};


		//Example 2:

		MyList head2 = new MyList(2,7,4,3,5);
		int [] output2 = {7,0,5,5,0};

		System.out.println("Brute Force Approch :");
		
		int []ans1=nextLargerNodesBruteForce(head1.getHead());		
		int []ans2=nextLargerNodesBruteForce(head2.getHead());		
		
		if(check(output1,ans1)) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Actual Output :"+Arrays.toString(output1));
			System.out.println("Your Output :"+Arrays.toString(ans1));
		}
		if(check(output2,ans2)) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Actual Output :"+Arrays.toString(output2));
			System.out.println("Your Output :"+Arrays.toString(ans2));
		}
		
		System.out.println("Better Approch :");
		
		ans1=nextLargerNodesBest(head1.getHead());		
		ans2=nextLargerNodesBest(head2.getHead());		
		
		if(check(output1,ans1)) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Actual Output :"+Arrays.toString(output1));
			System.out.println("Your Output :"+Arrays.toString(ans1));
		}
		if(check(output2,ans2)) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Actual Output :"+Arrays.toString(output2));
			System.out.println("Your Output :"+Arrays.toString(ans2));
		}

	}

}
