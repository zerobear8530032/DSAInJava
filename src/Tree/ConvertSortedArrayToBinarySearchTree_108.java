//108. Convert Sorted Array to Binary Search Tree
//Attempted
//Easy
//Topics
//premium lock icon
//Companies
//Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.
//
// 
//
//Example 1:
//
//
//Input: nums = [-10,-3,0,5,9]
//Output: [0,-3,9,-10,null,5]
//Explanation: [0,-10,5,null,-3,null,9] is also accepted:
//
//Example 2:
//
//
//Input: nums = [1,3]
//Output: [3,1]
//Explanation: [1,null,3] and [3,1] are both height-balanced BSTs.
// 
//
//Constraints:
//
//1 <= nums.length <= 104
//-104 <= nums[i] <= 104
//nums is sorted in a strictly increasing order.
package Tree;

import TreeUtil.TreeNode;

public class ConvertSortedArrayToBinarySearchTree_108 {
	
	public static TreeNode sortedArrayToBST(int[] nums) {
        TreeNode dummy = new TreeNode();
        insert(nums,dummy,0,nums.length-1);
        return dummy.left;
    }

    public static void insert(int [] arr, TreeNode node, int s , int e){
        if(s>e){
            return ;
        }
        int mid = (e+s)/2;
        int val= arr[mid];
        insert(val,node);
        insert(arr,node,s,mid-1);
        insert(arr,node,mid+1,e);
    }
    public static void insert(int val,TreeNode node){
        node.left=insertRec(val,node.left);
    }

    public static TreeNode insertRec(int val, TreeNode root){
        if(root==null){
            return new TreeNode(val);
        }
        if(val<root.val){
            root.left = insertRec(val,root.left);
        }else{
            root.right= insertRec(val,root.right);
        }
        return root;
    }
	
    
    public static boolean isBalancedBetter(TreeNode root) {
        return checkBalanced(root)!=-1;
    }
    public static int checkBalanced(TreeNode node){
        if(node==null){
            return 0;
        }

        int lh= checkBalanced(node.left);
        int lr= checkBalanced(node.right);
        boolean notbalance = Math.abs(lh-lr)>1;
        if(lh==-1 || lr==-1 || notbalance){
            return -1;
        }

        return Math.max(lh,lr)+1;
    }
    
	public static void main(String[] args) {
		
		int [] nums1 =  {-10,-3,0,5,9};
		
		int [] nums2 =  {1,3};
		
		TreeNode ans1 =sortedArrayToBST(nums1);
		TreeNode ans2 =sortedArrayToBST(nums2);
		
		
		if(isBalancedBetter(ans1)) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Your Tree is not Balanced Binary Tree "  );
		}
		if(isBalancedBetter(ans2)) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Your Tree is not Balanced Binary Tree "  );
		}


		
		
		
		
	}

}
