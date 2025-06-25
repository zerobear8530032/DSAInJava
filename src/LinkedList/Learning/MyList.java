package LinkedList.Learning;

import java.util.List;

public class MyList {
	
	ListNode head;
	ListNode tail;
	
	 
	 
	  
	 public ListNode getHead() {
		return head;
	}

	public ListNode getTail() {
		return tail;
	}

	public void add(int val) {
		 ListNode node = new ListNode(val);
		 if(head== null) {
			 head=node;
			 tail=node;
			 return ;
		 }
		 tail.next=node;
		 tail=node;
	 }
	 
	 public String toString() {
		 StringBuilder res= new StringBuilder("[");
		 ListNode temp = head;
		 while(temp.next!=null) {
			 res.append(temp.val).append(",");
			 temp=temp.next;
		 }
		 res.append(temp.val);
		 res.append("]");
		 return res.toString();
	 }
	 
	 public void addAll(List<Integer> list) {
		 for(int X:list) {
			 add(X);
		 }
	 }

	public ListNode getVal(int val) {
		ListNode temp = head;
		ListNode node=null;
		while(temp!=null) {
			if(temp.val==val) {
				node=temp;
				break;
			}
			temp = temp.next;
		}
		return node;
	}
	 
	
	
}
