////Two Integer Sum II
//Solved 
//Given an array of integers numbers that is sorted in non-decreasing order.
//
//Return the indices (1-indexed) of two numbers, [index1, index2], such that they add up to a given target number target and index1 < index2. Note that index1 and index2 cannot be equal, therefore you may not use the same element twice.
//
//There will always be exactly one valid solution.
//
//Your solution must use 
//O(1) additional space.
//
//Example 1:
//
//Input: numbers = [1,2,3,4], target = 3
//
//Output: [1,2]
//Explanation:
//The sum of 1 and 2 is 3. Since we are assuming a 1-indexed array, index1 = 1, index2 = 2. We return [1, 2].
//
//Constraints:
//
//2 <= numbers.length <= 1000
//-1000 <= numbers[i] <= 1000
//-1000 <= target <= 1000


package TwoPointers;

import java.util.Arrays;

public class TwoIntegerSumII_NEETCODE {
	
//	brute force approch :
//	use 2 nested loop and check every single pairs :
//	time complexity :O(n*n)
//	space complexity : O( 1)
	public static int [] twoSumBrute(int [] nums, int target) {
		
		for(int i =0;i<nums.length;i++) {
			for(int j =0;j<nums.length;j++) {
				if((nums[i]+nums[j])==target) {
					return new int [] {i+1,j+1};
				}
			}
		}
		
		return new int [] {-1,-1};
	}
	
//	Better force approch :
//	use 2 nested loop and check every single pairs :
//	time complexity :O(n log n)
//	space complexity : O( 1)
	public static int [] twoSumBetter(int [] nums, int target) {
		for(int i =0;i<nums.length;i++) {
			int findnum= target-nums[i];
			int idx2= search(nums, findnum);
			if(idx2!=-1) {
				return new int [] {i+1,idx2+1};
			}
		}
		return new int [] {-1,-1};
	}
	public static int search(int [] nums, int target) {
		int s=0;
		int e=nums.length-1;
		while(s<=e) {
			int m= s+(e-s)/2;
			if(nums[m]<target) {
				s=m+1;
			}else if(nums[m]>target) {
				e=m-1;
			}else {
				return m;
			}
		}
		return -1;
	}
	

//	Best approch :
//	use 2 pointer and find sum if sum is smaller decrease right pointer if sum is greater then increase left pointer:
//	time complexity :O(n)
//	space complexity : O(1)
	public static int [] twoSumBest(int [] nums, int target) {
		int l=0;
		int r=nums.length-1;
		while(l<=r) {
			
			int sum = nums[l]+nums[r];
			if(sum<target) l++;
			else if(sum>target) r--;
			else return new int[] {l+1,r+1};
		}
		return new int [] {-1,1};
	}
	public static void main(String[] args) {

		
		//Example 1:
		
		int [] nums1 = {1,2,3,4};
		int target1= 3;
		int []output1= {1,2};
		
		//Example 2:
		
		int [] nums2 = {-10,-5,0,3,7};
		int target2= -2;
		int []output2= {2,4};
		
		
		System.out.println("Brute Force Approch ");
		
		
		int []ans1 = twoSumBrute(nums1,target1);
		int []ans2 = twoSumBrute(nums2,target2);
	
		
		if(Arrays.equals(ans1, output1)) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Expected Ouput :"+ Arrays.toString(output1));
			System.out.println("Your Answer :"+ Arrays.toString(ans1));
		}
		if(Arrays.equals(ans2, output2)) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Expected Ouput :"+ Arrays.toString(output2));
			System.out.println("Your Answer :"+ Arrays.toString(ans2));
		}
		
		
		System.out.println("Optimize Approch :");
		
		ans1 = twoSumBetter(nums1,target1);
		ans2 = twoSumBetter(nums2,target2);
		
		if(Arrays.equals(output1, ans1)) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Expected Ouput :"+ Arrays.toString(output1));
			System.out.println("Your Answer :"+ Arrays.toString(ans1));
		}
		if(Arrays.equals(output2, ans2)) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Expected Ouput :"+ Arrays.toString(output2));
			System.out.println("Your Answer :"+ Arrays.toString(ans2));
		}
		
		System.out.println("Best Approch :");
		
		ans1 = twoSumBest(nums1,target1);
		ans2 = twoSumBest(nums2,target2);
		
		if(Arrays.equals(output1, ans1)) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Expected Ouput :"+ Arrays.toString(output1));
			System.out.println("Your Answer :"+ Arrays.toString(ans1));
		}
		if(Arrays.equals(output2, ans2)) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Expected Ouput :"+ Arrays.toString(output2));
			System.out.println("Your Answer :"+ Arrays.toString(ans2));
		}
		
	}

}
