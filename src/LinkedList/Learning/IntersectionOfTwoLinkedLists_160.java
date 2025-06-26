//160. Intersection of Two Linked Lists
//Solved
//Easy
//Topics
//premium lock icon
//Companies
//Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null.
//
//For example, the following two linked lists begin to intersect at node c1:
//
//
//The test cases are generated such that there are no cycles anywhere in the entire linked structure.
//
//Note that the linked lists must retain their original structure after the function returns.
//
//Custom Judge:
//
//The inputs to the judge are given as follows (your program is not given these inputs):
//
//intersectVal - The value of the node where the intersection occurs. This is 0 if there is no intersected node.
//listA - The first linked list.
//listB - The second linked list.
//skipA - The number of nodes to skip ahead in listA (starting from the head) to get to the intersected node.
//skipB - The number of nodes to skip ahead in listB (starting from the head) to get to the intersected node.
//The judge will then create the linked structure based on these inputs and pass the two heads, headA and headB to your program. If you correctly return the intersected node, then your solution will be accepted.
//
// 
//
//Example 1:
//
//
//Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
//Output: Intersected at '8'
//Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect).
//From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,6,1,8,4,5]. There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.
//- Note that the intersected node's value is not 1 because the nodes with value 1 in A and B (2nd node in A and 3rd node in B) are different node references. In other words, they point to two different locations in memory, while the nodes with value 8 in A and B (3rd node in A and 4th node in B) point to the same location in memory.
//Example 2:
//
//
//Input: intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
//Output: Intersected at '2'
//Explanation: The intersected node's value is 2 (note that this must not be 0 if the two lists intersect).
//From the head of A, it reads as [1,9,1,2,4]. From the head of B, it reads as [3,2,4]. There are 3 nodes before the intersected node in A; There are 1 node before the intersected node in B.
//Example 3:
//
//
//Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
//Output: No intersection
//Explanation: From the head of A, it reads as [2,6,4]. From the head of B, it reads as [1,5]. Since the two lists do not intersect, intersectVal must be 0, while skipA and skipB can be arbitrary values.
//Explanation: The two lists do not intersect, so return null.
// 
//
//Constraints:
//
//The number of nodes of listA is in the m.
//The number of nodes of listB is in the n.
//1 <= m, n <= 3 * 104
//1 <= Node.val <= 105
//0 <= skipA <= m
//0 <= skipB <= n
//intersectVal is 0 if listA and listB do not intersect.
//intersectVal == listA[skipA] == listB[skipB] if listA and listB intersect.
// 
//
//Follow up: Could you write a solution that runs in O(m + n) time and use only O(1) memory?


package LinkedList.Learning;

import java.util.HashSet;

public class IntersectionOfTwoLinkedLists_160 {


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
// brute force approch
// approch check every element of list 1 to eniter list 2 and find where both node are equal if 
// found the node is the intersection otherwise return null
// time complexity :O(n*m)
// space complexity :O(1)
    public static ListNode getIntersectionNodeBruteForce(ListNode headA, ListNode headB) {
        ListNode l1=headA;
        while(l1!=null){
            ListNode l2=headB;
            while(l2!=null){
                if(l1==l2){
                    return l1;
                }
                l2=l2.next;
            }
            l1=l1.next;
        }
        return null;

    }

// better approch
// we can reduce the check time wheater a list node exists in other list by using a hashmap
// with hashset we can put all node of list1 to the set and then iterate on list 2 and check it
//    exists in the set if yes return it because thats the first node of intersection
// time complexity :O(n+m)
// space complexity :O(n) 
       public static ListNode getIntersectionNodeBetter(ListNode headA, ListNode headB) {
         HashSet<ListNode> set = new HashSet();
         ListNode l1= headA;
         while(l1!=null){
            set.add(l1);
            l1=l1.next;
         }   
         ListNode l2=headB;
         while(l2!=null){
            if(set.contains(l2)){
                return l2;
            }
            l2=l2.next;
         }
         return null;
        }
// best approch
// we can find the intersection point if both list are of equal size by going from left 
// to right in a list and checking each node but both list are not equal size
// so how can we make them equal size :
// we can first iterate over both list and get there node counts 
// now we can go till the last node aand check weather the last node is equal in both list
// if yes then there is a intersection in nodes if not that means there is not intersection and we can return early nnull
// if the nodes are equal then we will get counts and
// find the longer list and then skip abs value of l1node-l2nodes
// now we can just move ahead with both nodes and find intersection whre both nodes are equal       
// time complexity :O(n+m)
// space complexity :O(1) 
        public static ListNode getIntersectionNodeBest(ListNode headA, ListNode headB) {
               ListNode l1= headA;
               ListNode l2= headB;
               int l1nodes= 1;
               int l2nodes= 1;
               while(l1.next!=null){
                   l1=l1.next;
                   l1nodes++;
               }
               while(l2.next!=null){
                   l2=l2.next;
                   l2nodes++;
               }
               if(l1!=l2){// if the last node of the lists are not equal there is not intersection btw them 
                   return null;
               }
               l1=headA;
               l2=headB;
               if(l1nodes<l2nodes){
                   int skip= l2nodes-l1nodes;
                   for(int i = 0;i<skip;i++){
                       l2=l2.next;
                   }
               }else if(l2nodes<l1nodes){
                   int skip= l1nodes-l2nodes;
                   for(int i = 0;i<skip;i++){
                       l1=l1.next;
                   }
               }

               while(l1!=l2){
                   l1=l1.next;
                   l2=l2.next;
               }
               return l1;
           }
        
        
        
       

	public static void main(String[] args) {
		
		
		//Example 1:

		MyList listA1= new MyList();
		MyList listB1= new MyList();
		int skipA1=2;
		listA1.addAll(4,1,8,4,5);
		listB1.addAll(5,6,1);
		ListNode tail1= listB1.getTail().next=listA1.get(skipA1);
		int outputinterval1=8;

		//Example 2:
		
		MyList listA2= new MyList();
		MyList listB2= new MyList();
		int skipA2=3;
		listA2.addAll(1,9,1,2,4);
		listB2.addAll(3,2,4);
		ListNode tail2= listB2.getTail().next=listA2.get(skipA2);
		int outputinterval2=2;
		

		//Example 3:

		MyList listA3= new MyList();
		MyList listB3= new MyList();
		int skipA3=3;
		listA3.addAll(2,6,4);
		listB3.addAll(1,5);
		ListNode tail3= listB3.getTail().next=listA3.get(skipA2);
		int outputinterval3=0;
		
		
		System.out.println("Brute Force Approch :");
		
		ListNode ans1=getIntersectionNodeBruteForce(listA1.getHead(),listB1.getHead());		
		ListNode ans2=getIntersectionNodeBruteForce(listA2.getHead(),listB2.getHead());		
		ListNode ans3=getIntersectionNodeBruteForce(listA3.getHead(),listB3.getHead());		
		
//		if the null values comes we cannot compare so thats given in question if null values comes 
//		its answer = 0
		if(ans1==null) {
			ans1= new ListNode(0);
		}
		if(ans2==null) {
			ans2= new ListNode(0);
		}
		if(ans3==null) {
			ans3= new ListNode(0);
		}
		
		if(outputinterval1==ans1.val) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Actual Output :"+outputinterval1);
			System.out.println("Your Output :"+ans1);
		}
		if(outputinterval2==ans2.val) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Actual Output :"+outputinterval2 );
			System.out.println("Your Output :"+ans2);
		}
		if(outputinterval3== ans3.val) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Actual Output :"+outputinterval3);
			System.out.println("Your Output :"+ans3);
		}

		
		
		System.out.println("Better Approch :");
		
		ans1=getIntersectionNodeBetter(listA1.getHead(),listB1.getHead());		
		ans2=getIntersectionNodeBetter(listA2.getHead(),listB2.getHead());		
		ans3=getIntersectionNodeBetter(listA3.getHead(),listB3.getHead());		
//		if the null values comes we cannot compare so thats given in question if null values comes 
//		its answer = 0
		if(ans1==null) {
			ans1= new ListNode(0);
		}
		if(ans2==null) {
			ans2= new ListNode(0);
		}
		if(ans3==null) {
			ans3= new ListNode(0);
		}
		
		if(outputinterval1==ans1.val) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Actual Output :"+outputinterval1);
			System.out.println("Your Output :"+ans1);
		}
		if(outputinterval2==ans2.val) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Actual Output :"+outputinterval2 );
			System.out.println("Your Output :"+ans2);
		}
		if(outputinterval3== ans3.val) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Actual Output :"+outputinterval3);
			System.out.println("Your Output :"+ans3);
		}
		
		
		
		System.out.println("Best Approch :");
		
		ans1=getIntersectionNodeBest(listA1.getHead(),listB1.getHead());		
		ans2=getIntersectionNodeBest(listA2.getHead(),listB2.getHead());		
		ans3=getIntersectionNodeBest(listA3.getHead(),listB3.getHead());		
		
//		if the null values comes we cannot compare so thats given in question if null values comes 
//		its answer = 0
		if(ans1==null) {
			ans1= new ListNode(0);
		}
		if(ans2==null) {
			ans2= new ListNode(0);
		}
		if(ans3==null) {
			ans3= new ListNode(0);
		}
		
		if(outputinterval1==ans1.val) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Actual Output :"+outputinterval1);
			System.out.println("Your Output :"+ans1);
		}
		if(outputinterval2==ans2.val) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Actual Output :"+outputinterval2 );
			System.out.println("Your Output :"+ans2);
		}
		if(outputinterval3== ans3.val) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Actual Output :"+outputinterval3);
			System.out.println("Your Output :"+ans3);
		}
		
		
		


	}

}
