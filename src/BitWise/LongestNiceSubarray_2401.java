//2401. Longest Nice Subarray
//Medium
//Topics
//Companies
//Hint
//You are given an array nums consisting of positive integers.
//
//We call a subarray of nums nice if the bitwise AND of every pair of elements that are in different positions in the subarray is equal to 0.
//
//Return the length of the longest nice subarray.
//
//A subarray is a contiguous part of an array.
//
//Note that subarrays of length 1 are always considered nice.
//
// 
//
//Example 1:
//
//Input: nums = [1,3,8,48,10]
//Output: 3
//Explanation: The longest nice subarray is [3,8,48]. This subarray satisfies the conditions:
//- 3 AND 8 = 0.
//- 3 AND 48 = 0.
//- 8 AND 48 = 0.
//It can be proven that no longer nice subarray can be obtained, so we return 3.
//Example 2:
//
//Input: nums = [3,1,5,11,13]
//Output: 1
//Explanation: The length of the longest nice subarray is 1. Any subarray of length 1 can be chosen.

package BitWise;

public class LongestNiceSubarray_2401 {
//	brute force approch :
// use sliding window with bit mapping
//	time complexity :O(n)
//	space complexity :O(1)
	  public static int longestNiceSubarray(int[] nums) {
		  int res =0;
		  long bitmask=0;
		  int l=0;
		  for(int r =0;r<nums.length;r++) {
			  while((bitmask & nums[r]) !=0) {
				  bitmask^=nums[l];
				  l++;
			  }
			  res= Math.max(res, r-l+1);
			  bitmask^= nums[r];
			  
		  }
		  
		  
		  return res;
		  

	  }
	  

	public static void main(String[] args) {

		//Example 1:

		int [] nums1 = {1,3,8,48,10};
		int output1=3;
		

		//Example 2:

		int [] nums2 = {3,1,5,11,13};
		int output2=1;
		
		//Example 3:
		
		int [] nums3 = {135745088,609245787,16,2048,2097152};
		int output3=3;
		
		
   		int ans1=longestNiceSubarray(nums1);
   		int ans2=longestNiceSubarray(nums2);
   		int ans3=longestNiceSubarray(nums3);
		
		System.out.println("brute Force Approch :");
		
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
		if(output3==ans3) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Actual Output :"+output3);
			System.out.println("Your Output :"+ans3);
		}
			

	}

}
