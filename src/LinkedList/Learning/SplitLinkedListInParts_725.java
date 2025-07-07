//725. Split Linked List in Parts
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//Given the head of a singly linked list and an integer k, split the linked list into k consecutive linked list parts.
//
//The length of each part should be as equal as possible: no two parts should have a size differing by more than one. This may lead to some parts being null.
//
//The parts should be in the order of occurrence in the input list, and parts occurring earlier should always have a size greater than or equal to parts occurring later.
//
//Return an array of the k parts.
//
//Example 1:
//
//
//Input: head = [1,2,3], k = 5
//Output: [[1],[2],[3],[],[]]
//Explanation:
//The first element output[0] has output[0].val = 1, output[0].next = null.
//The last element output[4] is null, but its string representation as a ListNode is [].
//Example 2:
//
//
//Input: head = [1,2,3,4,5,6,7,8,9,10], k = 3
//Output: [[1,2,3,4],[5,6,7],[8,9,10]]
//Explanation:
//The input has been split into consecutive parts with size difference at most 1, and earlier parts are a larger size than the later parts.
// 
//
//Constraints:
//
//The number of nodes in the list is in the range [0, 1000].
//0 <= Node.val <= 1000
//1 <= k <= 50

package LinkedList.Learning;

import java.util.Arrays;

import LinkedList.Utils.ListNode;
import LinkedList.Utils.MyList;

public class SplitLinkedListInParts_725 {
	
//	approch :
//	we can divide the list in equal parts = n/k parts
//	but we can have at least 1 different btw each parts 
//	and all the longer parts should be at the begining then smaller ones
//	so we can do this if n/k : we can have that much node in each part
//	and we can find remaining node by n%k and we can give 1 extra node to starting 
//	n%k parts that will cover the starting node with one extra node and they will be 
//	biggest then rest of the nodes which come later
	
	
	 public static  ListNode[] splitListToParts(ListNode head, int k) {
	        ListNode [] res= new ListNode [k];
	        int size = getLength(head);
	        ListNode ptr = head;
	        int parts= size/k;
	        int extra=size%k;
	        int idx=0;     
	        while(ptr!=null){
	            int part= parts;
	            if(extra!=0){
	                extra--;   
	                part=part+1;
	            }
	            res[idx]=ptr;
	            idx++;
	            for(int i =0;i<part-1;i++){
	                ptr=ptr.next;
	            }
	            if(ptr==null){
	                break;
	            }
	            ListNode next= ptr.next;
	            ptr.next=null;
	            ptr=next;
	        }
	        return res;

	    }

	    public static int  getLength(ListNode head){
	        int count=0;
	        while(head!=null){
	            count++;
	            head=head.next;
	        }
	        return count;
	    }
	    
	    public static boolean check(ListNode [] output, ListNode[] ans) {
	    	if(ans.length!=output.length) {
	    		return false;
	    	}
	    	for(int i =0;i<ans.length;i++) {
	    		if(ans[i]==null && output[i]==null) {
	    			continue;
	    		}
	    		if(!ans[i].equals(output[i])) {
	    			return false;
	    		}
	    	}
	    	return true;
	    }

	public static void main(String[] args) {

		
		//Example 1:
		
		MyList head1= new MyList(1,2,3);
		int k1 = 5;		
		ListNode [] output1= {new MyList(1).getHead(), new MyList(2).getHead(),new MyList(3).getHead(), null, null};

		//Example 2:
		
		MyList head2= new MyList(1,2,3,4,5,6,7,8,9,10);
		int k2 = 3;		
		ListNode [] output2= {new MyList(1,2,3,4).getHead(), new MyList(5,6,7).getHead(),new MyList(8,9,10).getHead()};
		
	
		
		System.out.println("Better Approch :");
		
		ListNode [] ans1=splitListToParts(head1.getHead(),k1);		
		ListNode [] ans2=splitListToParts(head2.getHead(),k2);		
		
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
			System.out.println("Actual Output :"+Arrays.toString(output2) );
			System.out.println("Your Output :"+Arrays.toString(ans2));
		}


	}

}
