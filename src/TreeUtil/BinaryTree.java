package TreeUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

    public TreeNode getNode(int val){
        return getNode(root,val);
    }
    private TreeNode getNode(TreeNode node, int val){
        if(node==null){return null;}
        if(node.val==val){return node;}
        TreeNode left= getNode(node.left,val);
        if(left!=null){
            return left;
        }else{
            return getNode(node.right,val);
        }
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
	
}
