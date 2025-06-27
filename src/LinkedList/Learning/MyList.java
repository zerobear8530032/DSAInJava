package LinkedList.Learning;

import java.util.List;

import LinkedList.Learning.DLL.InvalidIndexException;

public class MyList {
	
	ListNode head;
	ListNode tail;
	int size;
	 
	class InvalidIndexException extends RuntimeException{
		public InvalidIndexException() {
			super();
		}
		public InvalidIndexException(String msg) {
			super(msg);
		}
	}
	class EmptyListException extends RuntimeException{
		public EmptyListException() {
			super();
		}
		public EmptyListException(String msg) {
			super(msg);
		}
	}
	 
	  
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
		 size++;
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
			 size++;
			 add(X);
		 }
	 }
	 
	 
	 public void addAll(int ... list) {
		 for(int X:list) {
			 size++;
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
	public ListNode get(int idx) {
		if(idx<0 || idx>size) {
			throw new InvalidIndexException("Invalid index :"+idx+" does not exists in size :"+size);	
		}
		ListNode temp = head;
		for(int i =0;i<idx;i++) {
			temp=temp.next;	
		}
		return temp;
		
	}
	
	public MyList(int ...elements) {
		for(int e:elements) {
			this.add(e);
		}
	}
	
	public  boolean equals(ListNode lst) {
		ListNode l1=head;
		ListNode l2=lst;
		
		while(l1 != null && l2!= null) {
			if(l1.val!=l2.val) {
				return false;
			}
			l1=l1.next;
			l2=l2.next;
		}
		
		return l1==null && l2 ==null;
	}
	public static  boolean equals(ListNode lst1,ListNode lst2) {
		ListNode l1=lst1;
		ListNode l2=lst2;
		
		while(l1 != null && l2!= null) {
			if(l1.val!=l2.val) {
				return false;
			}
			l1=l1.next;
			l2=l2.next;
		}
		
		return l1==null && l2 ==null;
	}
}
