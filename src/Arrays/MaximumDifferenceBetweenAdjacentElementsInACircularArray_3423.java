//3423. Maximum Difference Between Adjacent Elements in a Circular Array
//Solved
//Easy
//Topics
//premium lock icon
//Companies
//Hint
//Given a circular array nums, find the maximum absolute difference between adjacent elements.
//
//Note: In a circular array, the first and last elements are adjacent.
//
// 
//
//Example 1:
//
//Input: nums = [1,2,4]
//
//Output: 3
//
//Explanation:
//
//Because nums is circular, nums[0] and nums[2] are adjacent. They have the maximum absolute difference of |4 - 1| = 3.
//
//Example 2:
//
//Input: nums = [-5,-10,-5]
//
//Output: 5
//
//Explanation:
//
//The adjacent elements nums[0] and nums[1] have the maximum absolute difference of |-5 - (-10)| = 5.
//
// 
//
//Constraints:
//
//2 <= nums.length <= 100
//-100 <= nums[i] <= 100
package Arrays;

public class MaximumDifferenceBetweenAdjacentElementsInACircularArray_3423 {
	
//approch just check each adejecent element from start to end and at last we cann check
//	first and last as its circular array 
//	time ceomplxity : O(n)
//	space ceomplxity : O(1)
    public static int maxAdjacentDistance(int[] nums) {
	        int n= nums.length;
	        int absdiff =Math.abs(nums[0]-nums[n-1]); 
	        for(int i =1;i<nums.length;i++){
	            int diff = Math.abs(nums[i]-nums[i-1]);
	            absdiff=Math.max(absdiff,diff);
	        }
	        return absdiff;
	    }
	
	public static void main(String[] args) {
		//Example 1:
		int [] nums1 = {1,2,4};
		int output1=3;

		//Example 2:

		int [] nums2 = {-5,-10,-5};
		int output2=5;
		
		
		
		System.out.println("Iterative Approch :");
    	int ans1= maxAdjacentDistance(nums1);
    	int ans2= maxAdjacentDistance(nums2);
		
    	if(output1==ans1) {
    		System.out.println("Case 1 Passed");
    	}else {
    		System.out.println("Case 1 Failed");
    		System.out.println("Expected Ouput :"+ output1);
			System.out.println("Your Answer :"+ ans1);  		
    	}
    	if(output2==ans2) {
    		System.out.println("Case 2 Passed");
    	}else {
    		System.out.println("Case 2 Failed");
    		System.out.println("Expected Ouput :"+ output2);
    		System.out.println("Your Answer :"+ ans2);  		
    	}
	}
}

