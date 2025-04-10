//560. Subarray Sum Equals K
//Medium
//Topics
//Companies
//Hint
//Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
//
//A subarray is a contiguous non-empty sequence of elements within an array.
//
// 
//
//Example 1:
//
//Input: nums = [1,1,1], k = 2
//Output: 2
//Example 2:
//
//Input: nums = [1,2,3], k = 3
//Output: 2
// 
//
//Constraints:
//
//1 <= nums.length <= 2 * 10^4
//-1000 <= nums[i] <= 1000
//-10^7 <= k <= 10^7
package Arrays;



public class SubarraySumEqualsK_560 {
	
//	brute force:find every single subarray and check sum equals to k
//	time complexity :O(n^3)
//	space complexity :O(1)
	 public static  int subarraySumBruteFroce(int[] nums, int k) {
		 int ans=0;
		 for(int i =0;i<nums.length;i++) {
			 for(int j =i;j<nums.length;j++) {
				 int sum =0;
				 for(int l=i;l<=j;l++) {
					 sum+=nums[l];
				 }
				 if(sum==k) {
					 ans++;
				 }
			 }
		 }
		 return ans;
	    }
	 
//	Better force:find every single subarray and check sum equals to k but we can optimize the sub array 
//	finding by remoing the
//	time complexity :O(n^2)
//	space complexity :O(1)
	 public static  int subarraySumBetter(int[] nums, int k) {
		 int ans=0;
		 for(int i =0;i<nums.length;i++) {
			 int sum =0;
			 for(int j =i;j<nums.length;j++) {
				 sum+=nums[j];
				 if(sum==k) {
					 ans++;
				 }
			 }
		 }
		 return ans;
	 }
	 
	 
//	Best force:
//	 
//	time complexity :O(n^2)
//	space complexity :O(1)
	 
	public static void main(String[] args) {
		
		
		
		//Example 1:

		int [] nums1 = {1,1,1};
		int k1 = 2;
		int output1=2;
		
		//Example 2:
		
		int [] nums2 = {1,2,3};
		int k2 = 3;
		int output2=2;
		
		System.out.println("Brute Force Approch :");
		
		int ans1=subarraySumBruteFroce(nums1,k1);
		int ans2=subarraySumBruteFroce(nums2,k2);
    	
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
		
		ans1=subarraySumBetter(nums1,k1);
		ans2=subarraySumBetter(nums2,k2);
		
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
