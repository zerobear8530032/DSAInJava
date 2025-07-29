package TreeUtil;

import java.util.ArrayList;
import java.util.List;

public class Tree {
	
	TreeNode root ;
	
	
	public boolean equals(TreeNode p, TreeNode q) {
        if(p==null && q==null){
            return true;
        }
        if((p==null && q!=null) ||(q==null && p!=null) ){
            return false;
        }
        if(p.val!=q.val){
            return false;
        }
        boolean left =equals(p.left,q.left);
        boolean right =  equals(p.right,q.right);
        return  left && right ;
    }
	
	public TreeNode getRoot() {
		return root;
	}
	
	public void setRoot(TreeNode root) {
		this.root = root;
	}
	
	public List<Integer> inorder(){
		List<Integer> res= new ArrayList();
		inorder(root,res);
		return res;
	}
	public List<Integer> preorder(){
		List<Integer> res= new ArrayList();
		preorder(root,res);
		return res;
	}
	public List<Integer> postorder(){
		List<Integer> res= new ArrayList();
		postorder(root,res);
		return res;
	}
	
	private void preorder(TreeNode root, List<Integer> res) {
		if(root==null) {
			return ;
		}
		res.add(root.val);
		preorder(root.left,res);
		preorder(root.right,res);
	}
	private void inorder(TreeNode root, List<Integer> res) {
		if(root==null) {
			return ;
		}
		inorder(root.left,res);
		res.add(root.val);
		inorder(root.right,res);
	}
	
	
	private void postorder(TreeNode root, List<Integer> res) {
		if(root==null) {
			return ;
		}
		postorder(root.left,res);
		postorder(root.right,res);
		res.add(root.val);
	}
}
