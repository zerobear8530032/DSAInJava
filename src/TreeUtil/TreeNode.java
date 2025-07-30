package TreeUtil;

public class TreeNode {
	public int val;
	public  TreeNode left, right;
	
	  
	public TreeNode() {}
	
	public TreeNode(int val) {
		  this.val=val;
	}
	
	@Override
	public String toString() {
		
		return "[Val :"+val+"L : "+left+"R : "+right+"]";
	}
}
