//2058. Find the Minimum and Maximum Number of Nodes Between Critical Points
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//A critical point in a linked list is defined as either a local maxima or a local minima.
//
//A node is a local maxima if the current node has a value strictly greater than the previous node and the next node.
//
//A node is a local minima if the current node has a value strictly smaller than the previous node and the next node.
//
//Note that a node can only be a local maxima/minima if there exists both a previous node and a next node.
//
//Given a linked list head, return an array of length 2 containing [minDistance, maxDistance] where minDistance is the minimum distance between any two distinct critical points and maxDistance is the maximum distance between any two distinct critical points. If there are fewer than two critical points, return [-1, -1].
//
// 
//
//Example 1:
//
//
//Input: head = [3,1]
//Output: [-1,-1]
//Explanation: There are no critical points in [3,1].
//Example 2:
//
//
//Input: head = [5,3,1,2,5,1,2]
//Output: [1,3]
//Explanation: There are three critical points:
//- [5,3,1,2,5,1,2]: The third node is a local minima because 1 is less than 3 and 2.
//- [5,3,1,2,5,1,2]: The fifth node is a local maxima because 5 is greater than 2 and 1.
//- [5,3,1,2,5,1,2]: The sixth node is a local minima because 1 is less than 5 and 2.
//The minimum distance is between the fifth and the sixth node. minDistance = 6 - 5 = 1.
//The maximum distance is between the third and the sixth node. maxDistance = 6 - 3 = 3.
//Example 3:
//
//
//Input: head = [1,3,2,2,3,2,2,2,7]
//Output: [3,3]
//Explanation: There are two critical points:
//- [1,3,2,2,3,2,2,2,7]: The second node is a local maxima because 3 is greater than 1 and 2.
//- [1,3,2,2,3,2,2,2,7]: The fifth node is a local maxima because 3 is greater than 2 and 2.
//Both the minimum and maximum distances are between the second and the fifth node.
//Thus, minDistance and maxDistance is 5 - 2 = 3.
//Note that the last node is not considered a local maxima because it does not have a next node.
// 
//
//Constraints:
//
//The number of nodes in the list is in the range [2, 105].
//1 <= Node.val <= 105
package LinkedList.Learning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import LinkedList.Utils.ListNode;
import LinkedList.Utils.MyList;

public class FindTheMinimumAndMaximumNumberOfNodesBetweenCriticalPoints_2058 {
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
//	approch :
//	have 3 pointer prev curr  next initaial prev at head , curr head.next and next curr.next
//	and check if curr is smaller then both pointer or greater then both pointers if yes 
//	
//	add  its index to critical points list and move all pointer by 1 ahead
//	untill entire list is traverse 
//	at the end we will have the list of critical pointer which are in ascending order we can find min
//	distance by finiding distance btw each pair of points and max distance is just the last element -first element
//	if there are less then 2 critical points return -1,-1
//	time complexity :O(n)
//	space complexity :O(k)
	    public static int[] nodesBetweenCriticalPoints(ListNode head) {
	        int [] res = {-1,-1};
	        if (head == null || head.next == null || head.next.next == null){
	            return res;
	        }
	        // so there can only be a critical point  when there is at least 3 nodes 
	        List<Integer> criticalpoints = new ArrayList();
	        ListNode prev= head;
	        ListNode curr=head.next;
	        int idx=2;// this will start from 2 because the curr is at head.next
	        while(curr.next!=null){
	            ListNode next= curr.next;
	            int pval=prev.val;
	            int cval=curr.val;
	            int nval=next.val;
	            if((pval<cval && cval>nval) || (cval<pval && nval>cval)){
	                criticalpoints.add(idx);
	            }
	            idx++;
	            prev=curr;
	            curr=curr.next;

	        }
	        // System.out.println(criticalpoints);
	        if(criticalpoints.size()<2){
	            return res;
	        }else{
	            int size = criticalpoints.size();
	            int min =min(criticalpoints);
	            int max = criticalpoints.get(size-1)-criticalpoints.get(0);
	            res[0]=min;
	            res[1]=max;
	        }
	        return res;
	    }
	    public static int min(List<Integer> arr){
	        int min = Integer.MAX_VALUE;
	        for(int i =0;i<arr.size()-1;i++){
	            min=Math.min(min,arr.get(i+1)-arr.get(i));
	        }
	        return min;
	    }
	
	    
	    public static boolean check(int [] output, int [] ans) {
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
		
		MyList  head1 = new MyList(3,1);
		int [] output1= {-1,-1};

		//Example 2:
		
		MyList  head2 = new MyList(5,3,1,2,5,1,2);
		int [] output2= {1,3};

		//Example 3:

		MyList  head3 = new MyList(1,3,2,2,3,2,2,2,7);
		int [] output3= {3,3};

		
		
		int [] ans1 = nodesBetweenCriticalPoints(head1.getHead());
		int [] ans2 = nodesBetweenCriticalPoints(head2.getHead());
		int [] ans3 = nodesBetweenCriticalPoints(head3.getHead());
		
		
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
		if(check(output3,ans3)) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Actual Output :"+Arrays.toString(output3));
			System.out.println("Your Output :"+Arrays.toString(ans3));
		}

	}

}
