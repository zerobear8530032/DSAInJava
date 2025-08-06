package TreeUtil;

public class SegmentTree {
	
	class Node {
		Node left;
		Node right;
		int val;
		int startInterval;
		int endInterval;
		
		public Node() {
		}
		
		
		
		public Node(int val, int startInterval, int endInterval) {
			this.val = val;
			this.startInterval = startInterval;
			this.endInterval = endInterval;
		}



		public Node(Node left, Node right, int val, int startInterval, int endInterval) {
			
			this.left = left;
			this.right = right;
			this.val = val;
			this.startInterval = startInterval;
			this.endInterval = endInterval;
		}



		public Node getLeft() {
			return left;
		}
		public void setLeft(Node left) {
			this.left = left;
		}
		public Node getRight() {
			return right;
		}
		public void setRight(Node right) {
			this.right = right;
		}
		public int getVal() {
			return val;
		}
		public void setVal(int val) {
			this.val = val;
		}
		public int getStartInterval() {
			return startInterval;
		}
		public void setStartInterval(int startInterval) {
			this.startInterval = startInterval;
		}
		public int getEndInterval() {
			return endInterval;
		}
		public void setEndInterval(int endInterval) {
			this.endInterval = endInterval;
		}
	}
	
	
	Node root;
	
	public SegmentTree(int [] arr) {
		root= constructTree(arr, 0, arr.length-1);
	}
	
	public Node constructTree(int [] arr,int startIdx, int endIdx) {
		if(startIdx==endIdx) {
			return new Node(arr[startIdx],startIdx,endIdx);
		}
		int mid = startIdx+(endIdx-startIdx)/2;
		
		Node left=constructTree(arr,startIdx,mid);
		Node right=constructTree(arr,mid+1,endIdx);
		Node node = new Node(left,right,left.val+right.val,startIdx,endIdx);
		return node;
	}
	
	public void display() {
		display(root);
	}
	
	private void display(Node node) {
		if(node==null) {
			return ;
		}
		
		String str = "";
		if(node.left!=null) {
			str=  str+"Inteval =["+node.left.startInterval+", "+node.left.endInterval+"] , Data = "+node.left.val+" -> ";
		}else {
			str= str+"No Left Child";
		}
//		current node
		str=  str+"Inteval =["+node.startInterval+", "+node.endInterval+"] , Data = "+node.val+" -> ";
		
		if(node.right!=null) {
			str=  str+"<- Inteval =["+node.right.startInterval+", "+node.right.endInterval+"] , Data = "+node.right.val;
		}else {
			str= str+"No rightChild";
		}
		System.out.println(str+"\n");
		
		if(node.left!=null) {
			display(node.left);
		}
		if(node.right!=null) {
			display(node.right);
		}
	}
	
	
	public int query(int start, int end) {
		return query(root,start,end);
	}
	
	private int query(Node node, int queryStartInteval, int queryEndInteval) {
		if(node.startInterval>=queryStartInteval && node.endInterval <=  queryEndInteval){ 
				// node is completely inside the query ;
			return node.val;
		}else if(node.startInterval>queryEndInteval || node.endInterval < queryStartInteval) {
//			completely outside of the query 
			return 0;
		}else {
			return query(node.left, queryStartInteval, queryEndInteval)+query(node.right,queryStartInteval,queryEndInteval);
		}
	}
	
	
	public void update(int idx, int val) {
		int updateans = update(this.root,idx ,val);
		this.root.setVal(updateans);
	}
	
	private int update(Node node ,int idx, int val) {
		if(idx>=node.startInterval && idx<=node.endInterval) {
//			idx is in range check its left and rigth child ;
			if(idx==node.startInterval &&  idx==node.endInterval) {
				node.setVal(val);
				return node.val;
			}else {
				int leftAns = update(node.left,idx,val);
				int rightAns= update(node.right,idx,val);
				node.setVal(leftAns+rightAns);
				return node.getVal();
			}
		}
		return node.getVal();
		
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		int [] arr1= {3,8,6,7,-2,-8,4,9};
		int [] arr2= {3,4,7,9,2};
		SegmentTree tree1= new SegmentTree(arr1);
		SegmentTree tree2= new SegmentTree(arr2);
		
//		tree1.display();
//		tree2.display();
		
		System.out.println(tree1.query(1, 6));
		
	}
}
