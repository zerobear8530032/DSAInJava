package LinkedList.Learning;
 public class ListNode {
		int val;
		ListNode next;
		
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
			 while(temp.next!=null) {
				 res.append(temp.val).append(",");
				 temp=temp.next;
			 }
			 res.append(temp.val);
			 res.append("]");
			 return res.toString();
		 }
		 
		
	}