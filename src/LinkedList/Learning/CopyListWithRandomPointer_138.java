//138. Copy List with Random Pointer

//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//A linked list of length n is given such that each node contains an additional random pointer, which could point to any node in the list, or null.
//
//Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, where each new node has its value set to the value of its corresponding original node. Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the pointers in the original list and copied list represent the same list state. None of the pointers in the new list should point to nodes in the original list.
//
//For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for the corresponding two nodes x and y in the copied list, x.random --> y.
//
//Return the head of the copied linked list.
//
//The linked list is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:
//
//val: an integer representing Node.val
//random_index: the index of the node (range from 0 to n-1) that the random pointer points to, or null if it does not point to any node.
//Your code will only be given the head of the original linked list.
//
// 
//
//Example 1:
//
//
//Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
//Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
//Example 2:
//
//
//Input: head = [[1,1],[2,1]]
//Output: [[1,1],[2,1]]
//Example 3:
//
//
//
//Input: head = [[3,null],[3,0],[3,null]]
//Output: [[3,null],[3,0],[3,null]]
// 
//
//Constraints:
//
//0 <= n <= 1000
//-104 <= Node.val <= 104
//Node.random is null or is pointing to some node in the linked list.



package LinkedList.Learning;

import java.util.HashMap;

public class CopyListWithRandomPointer_138 {
	

	static class Node {
	    int val;
	    Node next;
	    Node random;

	    public Node(int val) {
	        this.val = val;
	        this.next = null;
	        this.random = null;
	    }
	}
//	here we use  the approch : using hash map we can create a 
//	original node as key and the value as copy node then we can go through entire list again and check 
//	random ptr and connect there copy ptr to the copy random nodes 
//	this will be done effeciently using hashmap
//	time complexity :O(n)
//	time complexity :O(n)

	    public Node copyRandomListBruteForce(Node head) {
	        HashMap<Node, Node> map = new HashMap();
	        Node temp = head;
	        Node dummy = new Node(-1);
	        Node copyhead = dummy;
	        while (temp != null) {
	            Node node = new Node(temp.val);
	            copyhead.next = node;
	            copyhead = copyhead.next;
	            map.put(temp, node);
	            temp = temp.next;
	        }
	        temp = head;
	        while (temp != null) {
	            Node copyNode = map.get(temp);
	            Node ranOriginal = temp.random;
	            if (ranOriginal == null) {
	                temp = temp.next;
	                continue;
	            }
	            Node ranCopy = map.get(ranOriginal);
	            copyNode.random = ranCopy;
	            temp = temp.next;
	        }
	        return dummy.next;
	    }

	    
//	 approch :
//	 here we use a trick where we create a copy of a node in linked list and we add the node
//	 just next of original node so original node .next = copy node 
//	 by that we can get each node and its copy right next to each other
//	 now we will retierate the list check random pointer and attack random pointer in the same
//	 way in copy list
//	    in the end we can just rebuild both list by taking removing copy nodes and store as a result
//	    list and attaching the original node back :
//	time complexity :O(n)    
//	space complexity :O(1): here the extra space is our result space other then that no extra space get used     
	    public static Node copyRandomListBest(Node head) {
	        Node temp =head;
	        while(temp!=null){
	            Node tnext= temp.next;
	            Node node= new Node(temp.val);
	            temp.next= node;
	            node.next=tnext;
	            temp=tnext;
	        }
	        temp=head;
	        while(temp!=null){
	            Node tnext= temp.next.next;
	            Node originalRandom = temp.random;
	            if(originalRandom==null){
	                temp=tnext;
	                continue;
	            }
	            Node copyNode = temp.next;
	            Node copyRandom = originalRandom.next;
	            copyNode.random=copyRandom;
	            temp=tnext;
	        }
	        temp=head;
	        Node dummy= new  Node(-1);        
	        Node copyhead= dummy;
	        // extracting the intermediate nodes and recreating the originall lists:
	        while(temp!=null){
	            Node tnext= temp.next.next;
	            copyhead.next= temp.next;
	            copyhead=copyhead.next;
	            temp.next=tnext;
	            temp=tnext;
	        }
	        // display(head);
	        // display(dummy.next);
	        return dummy.next;
	    }

	

	public static void main(String[] args) {
		
		
	}

}
