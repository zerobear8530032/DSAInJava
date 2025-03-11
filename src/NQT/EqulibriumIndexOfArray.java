//https://takeuforward.org/data-structure/finding-equilibrium-index-in-an-array/
//Finding Equilibrium index in an array
//Problem Statement: Finding Equilibrium index in an array
//
//Given a 0-indexed integer array nums, find the leftmost equilibrium Index.
//
//An equilibrium Index is an index at which sum of elements on its left is equal to the sum of element on its right. That is, nums[0] + nums[1] + ... + nums[equilibriumIndex-1] == nums[equilibriumIndex+1] + nums[equilibriumIndex+2] + ... + nums[nums.length-1]. If equilibriumIndex == 0, the left side sum is considered to be 0. Similarly, if equilibriumIndex == nums.length - 1, the right side sum is considered to be 0.
//
//Return the leftmost equilibrium Index that satisfies the condition, or -1 if there is no such index.
//
//Examples:
//
//Example 1:
//Input: nums = [2,3,-1,8,4]
//Output: 3
//Explanation: The sum of the numbers before index 3 is: 2 + 3 + -1 = 4
//The sum of the numbers after index 3 is: 4 = 4
//
//Example 2:
//Input: nums = [1,-1,4]
//Output: 2
//Explanation: The sum of the numbers before index 2 is: 1 + -1 = 0
//The sum of the numbers after index 2 is: 0
package NQT;

public class EqulibriumIndexOfArray {
//	brute force approch:
//	check at each index calculate the left and right side sum and check if its equal:
//	time complexity :O(n*n)
//	space complexity :O(1)
	
	public static  int equalibriumIndexBruteForce(int [] nums) {
		
		for(int i =0;i<nums.length;i++) {
			int leftsum=0;
			for(int left=0;left<i;left++) {// get left sum
				leftsum+=nums[left];
			}
			int rightsum=0;
			for(int right=i+1;right<nums.length;right++) {// get right sum
				rightsum+=nums[right];
			}
			if(leftsum==rightsum) return i;
		}
		return -1;
	}
//	better approch:
//	check at each index calculate the left and right side sum and check if its equal:
 	
	public static  int equalibriumIndexBetter(int [] nums) {
		int leftsum=0;
		int rightsum=0;
		for (int x: nums) {rightsum+=x;}// sum of all number as right sum
		for(int i=0;i<nums.length;i++) {
			rightsum= rightsum-nums[i];
			if(leftsum==rightsum) return i;
			leftsum=leftsum+nums[i];
		}
		return -1;
	}
	

	
	
	public static void main(String args[]) {
		
//		Example 1:
		int [] nums1 = {2,3,-1,8,4};
		int output1=3;

//		Example 2:
		
		int [] nums2 = {1,-1,4};
		int output2=2;
		
		System.out.println("Brute Force Approch :");
		
		int ans1=equalibriumIndexBruteForce(nums1);
		int ans2=equalibriumIndexBruteForce(nums2);
		
		if(output1==ans1) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Actual Output :"+output1 );
			System.out.println("Your Output :"+ans1);
		}
		if(output2==ans2) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Actual Output :"+output2 );
			System.out.println("Your Output :"+ans2);
		}
		
		System.out.println("Better Approch :");
		
		ans1=equalibriumIndexBetter(nums1);
		ans2=equalibriumIndexBetter(nums2);
		
		if(output1==ans1) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Actual Output :"+output1 );
			System.out.println("Your Output :"+ans1);
		}
		if(output2==ans2) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Actual Output :"+output2 );
			System.out.println("Your Output :"+ans2);
		}
	
		
	}

}
