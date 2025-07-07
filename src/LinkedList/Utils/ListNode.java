package LinkedList.Utils;

import java.util.HashSet;

public class ListNode {
		public int val;
		public ListNode next;
		
		public ListNode() {
		}
		public ListNode(int val ) {
			this.val=val;
		}
		public ListNode(int val, ListNode next) {
			this.val=val;
			this.next=next;
		}
		
		 public String toString() {
			 StringBuilder res= new StringBuilder("[");
			 ListNode temp = this;
			 HashSet<ListNode> set= new HashSet();
			 boolean addlast=true;
			 while(temp.next!=null) {
				 if(set.contains(temp)) {
					 addlast=false;
					 break;
				 }else {
					 set.add(temp);
				 }
				 res.append(temp.val).append(",");
				 temp=temp.next;
			 }
			 if(addlast) {
				 
			 res.append(temp.val);
			 res.append("]");
			 }else {
				 res.setCharAt(res.length()-1, ']');
			 }
			 return res.toString();
		 }
		 
		public boolean equals(ListNode node) {
			 
			 ListNode ptr= this;
			 while(ptr!=null && node!=null) {
				 if(ptr.val!=node.val) {
					 return false;
				 }
				 ptr=ptr.next;
				 node=node.next;
				 
			 }
			 return ptr==null && node==null;
		}
		 
		 
		 
		 
		
	}