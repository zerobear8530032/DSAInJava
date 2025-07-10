package LinkedList.Utils;

import java.util.HashSet;

public class NodeRandom {
	    int val;
	    NodeRandom next;
	    NodeRandom random;

	    public NodeRandom(int val) {
	        this.val = val;
	        this.next = null;
	        this.random = null;
	    }
	    
	    
		 public String toString() {
			 StringBuilder res= new StringBuilder("[");
			 NodeRandom temp = this;
			 HashSet<NodeRandom> set= new HashSet();
			 boolean addlast=true;
			 while(temp.next!=null) {
				 if(set.contains(temp)) {
					 addlast=false;
					 break;
				 }else {
					 set.add(temp);
				 }
				 res.append('[').append(temp.val).append(",").append(temp.random).append(']');
				 temp=temp.next;
			 }
			 if(addlast) {
				 
			 res.append('[').append(temp.val).append(",").append(temp.random).append(']');
			 res.append("]");
			 }else {
				 res.setCharAt(res.length()-1, ']');
			 }
			 return res.toString();
		 }
		 
		public boolean equals(NodeRandom node) {
			 
			NodeRandom ptr= this;
			 while(ptr!=null && node!=null) {
				 if(ptr.val!=node.val && ptr.random==node.random ) {
					 return false;
				 }
				 ptr=ptr.next;
				 node=node.next;
				 
			 }
			 return ptr==null && node==null;
		}
		 
		 
	
}
