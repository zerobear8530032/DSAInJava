package TreeUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class CustomeTree {
private Node root;
	
	public Node getRoot() {
		return root;
	}
	
	public void setRoot(Node root) {
		this.root = root;
	}
	
	public CustomeTree() {
		// TODO Auto-generated constructor stub
	}
	
	public CustomeTree(List<Integer> arr) {
		if(arr==null) {
			return ;
		}
		if(arr.size()==0) {
			return ;
		}
		Queue<Node> queue = new LinkedList<Node>();
		int idx =0;
		this.root= new Node(arr.get(idx));
		idx++;
		queue.add(root);
		while(!queue.isEmpty() ) {
			Node currNode=queue.remove();
			if(idx <arr.size() && arr.get(idx)!=null) {
				int left = arr.get(idx);
				currNode.left= new Node(left);
				queue.add(currNode.left);
			}
			idx++;			
			if(idx <arr.size() && arr.get(idx)!=null ) {
				int right = arr.get(idx);
				currNode.right= new Node(right);
				queue.add(currNode.right);
			}
			idx++;
		}
		
	}
	public CustomeTree(Integer... values) {
		this(Arrays.asList(values));
	}
	
	public boolean equals(Node obj) {
		if(obj==null && root==null) {return true;}
		if(obj==null && root!=null) {return false;}
		if(obj!=null && root==null) {return false;}
		
		return isSameTree(this.root,obj);
	}
	
	public boolean equals(CustomeTree obj) {
		return isSameTree(this.root,obj.getRoot());
	}
	
	public void connect() {
		root= connect(this.root);
	}
	
	 private Node connect(Node root) {
	        if (root == null) {
	            return null;
	        }
	        Queue<Node> queue = new LinkedList();
	        queue.add(root);
	        while (!queue.isEmpty()) {
	            int levelSize = queue.size();//  give the number of node at current level
	            // here we will start from currentnode and move left 
	            if (levelSize == 1) {
	                Node curr = queue.remove();
	                if (curr.left != null) {
	                    queue.add(curr.left);
	                }
	                if (curr.right != null) {
	                    queue.add(curr.right);
	                }
	            } else {
	                // here we already poped the first node so we will
	                // iterate levelsize-1 nodes so loop will start from 1
	                Node curr = queue.remove();
	                for (int i = 1; i < levelSize; i++) {
	                    Node next = queue.remove();
	                    curr.next = next;
	                    if (curr.left != null) {
	                        queue.add(curr.left);
	                    }
	                    if (curr.right != null) {
	                        queue.add(curr.right);
	                    }
	                    curr = next;
	                }
	                // at the end of loop last node will not get process so we will process it here 
	                if (curr.left != null) {
	                    queue.add(curr.left);
	                }
	                if (curr.right != null) {
	                    queue.add(curr.right);
	                }

	            }

	        }
	        return root;
	    }
	
	private boolean isSameTree(Node p, Node q) {
        if(p==null && q==null){
            return true;
        }
        if((p==null && q!=null) ||(q==null && p!=null) ){
            return false;
        }
        if(p.val!=q.val){
            return false;
        }
        boolean left =isSameTree(p.left,q.left);
        boolean right =  isSameTree(p.right,q.right);
        boolean next =  isSameTree(p.next,q.next);
        return  left && right && next;
        
    }
}
