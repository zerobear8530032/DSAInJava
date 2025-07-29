//100. Same Tree
//Solved
//Easy
//Topics
//premium lock icon
//Companies
//Given the roots of two binary trees p and q, write a function to check if they are the same or not.
//
//Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
//Example 1:
//
//
//Input: p = [1,2,3], q = [1,2,3]
//Output: true
//Example 2:
//
//
//Input: p = [1,2], q = [1,null,2]
//Output: false
//Example 3:
//
//
//Input: p = [1,2,1], q = [1,1,2]
//Output: false
// 
//
//Constraints:
//
//The number of nodes in both trees is in the range [0, 100].
//-104 <= Node.val <= 104

package TreeUtil;

import java.util.List;

public class SameTree_100 {
//	approch :
//	first we will check p and q both are null means its equal
//	other wise we will check if p or q any one of them is null then its false
//	after that we will check value of p and q are equal or not it not then false
//	at the end we will do this for each side left of both node and right of both node
//	if both return true then answer is true of any of it return false answer is false
//	time complexity :O(n)
//	space complexity :O(n)
	public static boolean isSameTree(TreeNode p, TreeNode q) {
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

	public static void main(String[] args) {
		
		//Example 1:

		TreeNode p1= new TreeNode(1);
		p1.left=new TreeNode(2);
		p1.right=new TreeNode(2);
		
		TreeNode q1= new TreeNode(1);
		q1.left=new TreeNode(2);
		q1.right=new TreeNode(2);
		
		boolean output1= true;
		
		//Example 2:

		TreeNode p2= new TreeNode(1);
		p2.left=new TreeNode(2);
		
		TreeNode q2= new TreeNode(1);
		q2.right=new TreeNode(2);		
		boolean output2= false;
		
		//Example 3:
		
		TreeNode p3= new TreeNode(1);
		p3.left=new TreeNode(2);
		p3.right=new TreeNode(1);
		
		TreeNode q3= new TreeNode(1);
		q3.left=new TreeNode(1);		
		q3.right=new TreeNode(2);				
		boolean output3= false;
		
		
    	boolean ans1 =isSameTree(p1,q1);
    	boolean ans2 =isSameTree(p2,q2);
    	boolean ans3 =isSameTree(p3,q3);
   

		
		
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
    	
		if(ans3==output3) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Actual Output :"+output3 );
			System.out.println("Your Output :"+ans3);
		}
		




	}

}
