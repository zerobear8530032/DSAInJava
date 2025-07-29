package TreeUtil;

public class BSTNode {
	int val;
	int height;
	BSTNode left;
	BSTNode right;
	
	public BSTNode() {
		// TODO Auto-generated constructor stub
	}
	public BSTNode(int val , int h) {
		this.val=val;
		this.height=h;
	}
	public BSTNode(int val ) {
		this.val=val;
	}
	public int getVal() {
		return val;
	}
	public void setVal(int val) {
		this.val = val;
	}
	 @Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}
