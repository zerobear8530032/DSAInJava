//92. Reverse Linked List II
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.
//
// 
//
//Example 1:
//
//
//Input: head = [1,2,3,4,5], left = 2, right = 4
//Output: [1,4,3,2,5]
//Example 2:
//
//Input: head = [5], left = 1, right = 1
//Output: [5]
// 
//
//Constraints:
//
//The number of nodes in the list is n.
//1 <= n <= 500
//-500 <= Node.val <= 500
//1 <= left <= right <= n
// 
//
//Follow up: Could you do it in one pass?

package LinkedList.Learning;

import java.util.ArrayList;
import java.util.List;

public class ReverseLinkedListII_92 {
	
	
//	approch : brute force :
//	here we will iterate over the  list and take all elements form range l to r in a arraylist 
//	then we can reiterate the list and put the arraylist element in reverse order in teh original list 
//	time complexity :O(n)
//	space complexity :O(right-left) // how many elements the range of right - left have in worst case
//	it O(n)
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
	    public ListNode reverseBetweenBruteForce(ListNode head, int left, int right) {
	        if(head==null) {
	            return null;
	        }
	        ListNode ptr=head;
	        List<Integer>  revelements = new ArrayList<Integer>();
	        int i =1;
	        while(ptr!=null){
	            if(i>=left && i<=right){
	                revelements.add(ptr.val);
	            }
	            i++;
	            ptr=ptr.next;
	        }
	        i=1;
	        ptr=head;
	        int idx=revelements.size()-1;
	        while(ptr!=null){
	            if(i>=left && i<=right){
	                ptr.val=revelements.get(idx);
	                idx--;
	            }
	            i++;
	            ptr=ptr.next;
	        }
	        return head;
	    }

	    
//	better approch:
//	    note the index of linked list here are consider at 0 based but in question they are consider
//	    as 1 based 
//	here we can solve it in one pass without extra space
//	we will do some thing 
//	assume we can divide the list in 3 parts 
//	left part : this start of list till left-1 
//	right part : this is right+1 till end
//	mid part : which is the list we want to reverse 
//	then we can keep track of reverse starting node  left index
//	then we can keep track of reverse ending node  right index
//	and node before left = left-1 index 
//	and node after right = right+1 index 
//	now we can maintain these pointer 
//	we can  apply the reversal of list on range and linkked the left.next to the right -1 index pointer after reverse this is the positon of that 
//	end of the reverse part of linked list 
//  after that we can put the left+1 pointer to point at the right part of the linked list 
//	time complexity :O(n)
//	space complexity :O(1)
	        public ListNode reverseBetween(ListNode head, int left, int right) {
	            if(left==right){
	                return head;
	            }
	            ListNode prev=null;// this will be keep tracking of previous node
	            ListNode curr=head;// currenent pointing node
	            ListNode revStart=null;// this is the left index
	            ListNode leftside=null;// this is the left-1 index node
	            int idx=0;
	            while(curr!=null){
	                if(idx==left-1){// here we initialize it 
	                    leftside=prev;
	                }
	                if(idx==left){
	                    revStart=prev;// this is rev start
	                    
	                    while(curr!=null && idx<right){// we can keep going right untll we reach right-1
	                        ListNode next=curr.next;//
	                        curr.next=prev;// here we reverse the list pointers
	                        prev=curr;
	                        curr=next;
	                        idx++;
	                    }
	                    revStart.next=curr;// at the end we pput the revStart which will be now end of the list so we will
//	                    know that abve loop end at right so the current curr will be at the right index that the right part 
//	                    we attach the revStart to rigth part
	                    if(leftside!=null){// here if the head is also reverse the inital node will be null
	                        leftside.next=prev;// if its not null means the leftside exists and we can attach it 
	                    }else{// the left side will only be null when the head is also going to be reversed 
	                    // in this case we can just return the prev cause it have the new head currenlty 
	                        return prev;
	                    }
	                }
	                idx++;
	                if(curr!=null){
	                prev=curr;
	                curr=curr.next;
	                }
	            }
	            return head;
	        }
	    
	

	public static void main(String[] args) {
		//Example 1:

		MyList head1 = new MyList(1,2,3,4,5);
		int  left1 = 2, right1 = 4;
		MyList output1 = new MyList(1,4,3,2,5);
		
		//Example 2:
		
		MyList head2 = new MyList(5);
		int  left2 = 1, right2 = 1;
		MyList output2 = new MyList(1,4,3,2,5);
		
		//Example 2:
		
		MyList head3 = new MyList(5,3);
		int  left3 = 1, right3 = 2;
		MyList output3 = new MyList(3,5);


	}

}
