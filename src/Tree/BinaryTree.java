package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import TreeUtil.Tree;
import TreeUtil.TreeNode;

public class BinaryTree {
	
	private TreeNode root;
	
	public TreeNode getRoot() {
		return root;
	}
	
	public void setRoot(TreeNode root) {
		this.root = root;
	}
	
	public BinaryTree() {
		// TODO Auto-generated constructor stub
	}
	
	public BinaryTree(List<Integer> arr) {
		if(arr==null) {
			return ;
		}
		if(arr.size()==0) {
			return ;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		int idx =0;
		this.root= new TreeNode(arr.get(idx));
		idx++;
		queue.add(root);
		while(!queue.isEmpty() ) {
			TreeNode currNode=queue.remove();
			if(idx <arr.size() && arr.get(idx)!=null) {
				int left = arr.get(idx);
				currNode.left= new TreeNode(left);
				queue.add(currNode.left);
			}
			idx++;			
			if(idx <arr.size() && arr.get(idx)!=null ) {
				int right = arr.get(idx);
				currNode.right= new TreeNode(right);
				queue.add(currNode.right);
			}
			idx++;
		}
		
	}
	public BinaryTree(Integer... values) {
		this(java.util.Arrays.asList(values));
	}
	
	public boolean equals(TreeNode obj) {
		return isSameTree(this.root,obj);
	}
	
	public boolean equals(BinaryTree obj) {
		return isSameTree(this.root,obj.getRoot());
	}
	public boolean equals(Tree obj) {
		return isSameTree(this.root,obj.getRoot());
	}
	
	private boolean isSameTree(TreeNode p, TreeNode q) {
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
        return  left && right ;
    }
	
	
	@Override
	public String toString() {
		StringBuilder  res = new StringBuilder("[");
		TreeNode node = root;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while(!queue.isEmpty()) {
			int levelSize = queue.size();
			for(int i =0;i<levelSize;i++) {
				TreeNode poped = queue.remove();
				if(poped==null) {
					res.append(poped+",");
				}else {
					res.append(poped.val+",");
					queue.add(poped.left);
					queue.add(poped.right);
				}
			}
			
		}
		res.setCharAt(res.length()-1, ']');
		return res.toString();
		
	}
	
}
