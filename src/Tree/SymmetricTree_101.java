package Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import TreeUtil.TreeNode;

public class SymmetricTree_101 {

//	approch :
//	we will first divide tree in 2 substring from root one will be 
//	left and second right
//	now we will check from left we will go left and right will go right side
//	and check each value is equal we just check opposite side nodes at each level
//	if all are equal we will return true
//	oother wise false
//	one edge case there is possibility left is smaller or right is smaller 
//	so we will check if left is having node or right is having node and other does not
//	then also we return false;
//	time complexity :O(n)
//	space complexity :O(n)
	public static boolean isSymmetricIterative(TreeNode root) {
        Stack<TreeNode []>  stk = new Stack();
        TreeNode left= root.left;
        TreeNode right= root.right;
        while(!stk.isEmpty() || (left!=null || right!=null) ){
            while(left!=null && right!=null){
                stk.push(new TreeNode []{left,right});
                left=left.left;
                right=right.right;
            }
            if((left!=null  && right==null) || (left==null && right!=null)){
                return false;
            }
            if(!stk.isEmpty()){
            TreeNode []poped = stk.pop();
            TreeNode popLeft= poped[0];
            TreeNode popRight= poped[1];
            if(popLeft.val!=popRight.val){return false;}
            left=popLeft.right;
            right=popRight.left;
            }
        }
        return true;
    }
	
	
//	approch is completely same just we use recursion stakc here 
//	time complexity :O(n)
//	space complexity :O(n)
	
	 public static boolean isSymmetric_Recursion(TreeNode root) {
	        return DFS(root.left,root.right);
	    }
	    public static boolean DFS(TreeNode left,TreeNode right){
	        if(left==null && right==null){
	            return true;
	        }
	        if((left!=null && right==null) ||(left==null && right!=null)){
	            return false;
	        }
	        if(left.val!=right.val){
	            return false;
	        }
	        boolean checkLeft= DFS(left.left,right.right);
	        boolean checkRight= DFS(left.right,right.left);
	        return checkLeft && checkRight;
	    }
	    
//	approch : we will use BFS traversal here we can use the approch where first we divide
//	tree in 2 parts from root  left , right  then we can just 
//	follow this where on left side we first take left node and 
//	put it in queue and then take rightside right node in queue
//	and after that the other side this will make sure the node which should be equal are one after another
//	then we can just check if both are equal or not and return true
//	one edge cases we cannot keep track of left and right side node in queue so we will
//	also append null so that if the left node is null we will consider it as entry for comparison 
	    
	public static boolean isSymmetricBFS(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root.left);
		queue.add(root.right);
		while(!queue.isEmpty()) {
			int levelSize = queue.size();
			for(int i =0;i<levelSize;i+=2) {
				TreeNode left = queue.remove();
				TreeNode right = queue.remove();
				if((left==null && right!=null) ||(left!=null && right==null)  || ((left!=null && right!=null) && (left.val != right.val))) {
					return false;
				}
				if(left!=null) {
					queue.add(left.left);
				}
				if(right!=null) {
					queue.add(right.right);
				}
				if(left!=null) {
					queue.add(left.right);
				}
				if(right!=null) {
					queue.add(right.left);
				}
			}
		}
		return true;
	}
	public static void main(String[] args) {
			
		//		Example 1 :

		TreeNode t1= new TreeNode(1);
		t1.left=new TreeNode(2);
		t1.right=new TreeNode(2);		
		t1.left.left=new TreeNode(3);
		t1.left.right=new TreeNode(4);
		t1.right.right=new TreeNode(3);
		t1.right.left=new TreeNode(4);
		boolean output1= true;
		
		//		Example 2 :
		
		TreeNode t2= new TreeNode(1);
		t2.left=new TreeNode(2);
		t2.right=new TreeNode(2);		
		t2.left.right=new TreeNode(3);
		t2.right.right=new TreeNode(3);
		boolean output2= false;
		
		System.out.println("Iterative Approch : ");
		
    	boolean ans1 =isSymmetricIterative(t1);
    	boolean ans2 =isSymmetricIterative(t2);

		if(ans1==output1) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Actual Output :"+output1 );
			System.out.println("Your Output :"+ans1);
		}
		if(ans2==output2) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Actual Output :"+output2 );
			System.out.println("Your Output :"+ans2);
		}
		
		System.out.println("Recursion Approch : ");
		
		ans1 =isSymmetric_Recursion(t1);
		ans2 =isSymmetric_Recursion(t2);
		
		if(ans1==output1) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Actual Output :"+output1 );
			System.out.println("Your Output :"+ans1);
		}
		if(ans2==output2) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Actual Output :"+output2 );
			System.out.println("Your Output :"+ans2);
		}	
		
		System.out.println("BFS  Approch : ");
		
		ans1 =isSymmetricBFS(t1);
		ans2 =isSymmetricBFS(t2);
		
		if(ans1==output1) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Actual Output :"+output1 );
			System.out.println("Your Output :"+ans1);
		}
		if(ans2==output2) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Actual Output :"+output2 );
			System.out.println("Your Output :"+ans2);
		}		

		
		
		
		
	}

}
