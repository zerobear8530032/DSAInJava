//19. Remove Nth Node From End of List
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//Given the head of a linked list, remove the nth node from the end of the list and return its head.
//
// 
//
//Example 1:
//
//
//Input: head = [1,2,3,4,5], n = 2
//Output: [1,2,3,5]
//Example 2:
//
//Input: head = [1], n = 1
//Output: []
//Example 3:
//
//Input: head = [1,2], n = 1
//Output: [1]
// 
//
//Constraints:
//
//The number of nodes in the list is sz.
//1 <= sz <= 30
//0 <= Node.val <= 100
//1 <= n <= sz
// 
//
//Follow up: Could you do this in one pass?

package LinkedList.Learning;

public class RemoveNthNodeFromEndOfList_19 {
// approch : 
//	here we first get the length
//	and then get the index we wana delete node of
//	then get the prev node of that index
//	and remove the node
//	time complexity :O(n)
//	space complexity :O(1)
	  public static ListNode removeNthFromEndBruteForce(ListNode head, int n) {
	        if(head==null) {
	            return null;
	        }
	        int len =getLength(head);
	        int nodenum = len-n;
	        if(nodenum==0){// here we remove the first node 
	            return head.next;
	        }
	        ListNode prev= getNode(head,nodenum);
	        ListNode next= prev.next.next;
	        // System.out.println(prev.val);
	        prev.next=next;
	        return head;
	    }
	    public static int getLength(ListNode head){
	        int c=0;
	        while(head!=null){
	            c++;
	            head=head.next;
	        }

	        return c;
	    }
	    public static ListNode getNode(ListNode head, int nodenum){
	       int count =1;
	       while(head!=null){
	        if(nodenum==count){
	            break;
	        }
	        head=head.next;
	        count++;
	       }
	       return head;
	    }


	public static void main(String[] args) {
		//Example 1:

		MyList head1 = new MyList(1,2,3,4,5);
		int n1 = 2;
		MyList output1 = new MyList(1,2,3,5);

		//Example 2:
		
		MyList head2 = new MyList(1);
		int n2 = 1;
		MyList output2 = new MyList();

		//Example 3:

		MyList head3 = new MyList(1,2);
		int n3 = 1;
		MyList output3 = new MyList(1);
		System.out.println("Brute Force Approch :");
		
		ListNode ans1= removeNthFromEndBruteForce(head1.getHead(), n1);
		ListNode ans2= removeNthFromEndBruteForce(head2.getHead(), n2);
		ListNode ans3= removeNthFromEndBruteForce(head3.getHead(), n3);
	    		    	
    	if(output1.equals(ans1)) {
    		System.out.println("Case 1 Passed");
    	}else {
    		System.out.println("Case 1 Failed");
    		System.out.println("Expected Ouput :"+ output1);
			System.out.println("Your Answer :"+ ans1);  		
    	}
    	if(output2.equals(ans2)) {
    		System.out.println("Case 2 Passed");
    	}else {
    		System.out.println("Case 2 Failed");
    		System.out.println("Expected Ouput :"+ output2);
    		System.out.println("Your Answer :"+ ans2);  		
    	}
    	if(output3.equals(ans3)) {
    		System.out.println("Case 2 Passed");
    	}else {
    		System.out.println("Case 2 Failed");
    		System.out.println("Expected Ouput :"+ output3);
    		System.out.println("Your Answer :"+ ans3);  		
    	}
    	
//		    System.out.println("Better Approch :");
//		    ans1=findDisappearedNumbersBest(nums1);
//		    ans2=findDisappearedNumbersBest(nums2);
//		    
//		    if(output1.equals(ans1)) {
//		    	System.out.println("Case 1 Passed");
//		    }else {
//		    	System.out.println("Case 1 Failed");
//		    	System.out.println("Expected Ouput :"+ output1);
//		    	System.out.println("Your Answer :"+ ans1);  		
//		    }
//		    if(output2.equals(ans2)) {
//		    	System.out.println("Case 2 Passed");
//		    }else {
//		    	System.out.println("Case 2 Failed");
//		    	System.out.println("Expected Ouput :"+ output2);
//		    	System.out.println("Your Answer :"+ ans2);  		
//		    }
//
		

	}

}
