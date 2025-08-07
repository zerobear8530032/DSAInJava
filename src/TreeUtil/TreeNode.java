package TreeUtil;

import java.util.List;

public class TreeNode {
	public int val;
	public  TreeNode left, right;
	
	  
	public TreeNode() {}
	
	public TreeNode(int val) {
		  this.val=val;
	}
	

	

	@Override
	public String toString() {
		
		return " [ Val : "+val+" L : "+left+" R : "+right+" ] ";
	}
	
	public boolean equals(TreeNode p) {
		return isSameTree(p,this);
	}
	  public boolean isSameTree(TreeNode p, TreeNode q) {
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
