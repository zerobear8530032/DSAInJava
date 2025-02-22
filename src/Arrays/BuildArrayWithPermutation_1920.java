//1920. Build Array from Permutation
//Solved
//Easy
//Topics
//Companies
//Hint
//Given a zero-based permutation nums (0-indexed), build an array ans of the same length where ans[i] = nums[nums[i]] for each 0 <= i < nums.length and return it.
//
//A zero-based permutation nums is an array of distinct integers from 0 to nums.length - 1 (inclusive).
//
// 
//
//Example 1:
//
//Input: nums = [0,2,1,5,3,4]
//Output: [0,1,2,4,5,3]
//Explanation: The array ans is built as follows: 
//ans = [nums[nums[0]], nums[nums[1]], nums[nums[2]], nums[nums[3]], nums[nums[4]], nums[nums[5]]]
//    = [nums[0], nums[2], nums[1], nums[5], nums[3], nums[4]]
//    = [0,1,2,4,5,3]
//Example 2:
//
//Input: nums = [5,0,1,2,3,4]
//Output: [4,5,0,1,2,3]
//Explanation: The array ans is built as follows:
//ans = [nums[nums[0]], nums[nums[1]], nums[nums[2]], nums[nums[3]], nums[nums[4]], nums[nums[5]]]
//    = [nums[5], nums[0], nums[1], nums[2], nums[3], nums[4]]
//    = [4,5,0,1,2,3]
// 
//
//Constraints:
//
//1 <= nums.length <= 1000
//0 <= nums[i] < nums.length
//The elements in nums are distinct.
// 
//
//Follow-up: Can you solve it without using an extra space (i.e., O(1) memory)?

package Arrays;

import java.util.Arrays;

public class BuildArrayWithPermutation_1920 {
// brute Force Approch :
//	allocate a new array and  where ans [i]= nums[nums[i]];
//	this is not getting array out of bound because the test case only contain  element btw 0 till n-1
//	time complexity O(n) : iterate over loop
//	space complexity O(n) : ans array 
	public static int [] buildArray(int [] nums) {
		int ans [] = new int [nums.length];
//		iterate over the input nums and put value of ans [i]=nums[nums[i]];
		for(int i =0;i<nums.length;i++) {
			ans[i]=nums[nums[i]];
		}
		return ans;
	}
	
// Optimize Approch :
//	follow Up question using a formula : space complexity O(1)
//	nums[i]=nums[i]+(nums[nums[i]]%n)*n
//	use this formula to encode value at the 

//	time complexity O( n): O(2n) : iterate over loop 2 tiimes
//	space complexity O(1) : no array 
	public static int [] buildArrayOptimize(int [] nums) {
		int n = nums.length;
//		iterate over the input nums and put value of ans [i]=nums[nums[i]];
		for(int i =0;i<nums.length;i++) {
//			this is a modular mathematic formula :
//			heere we encode both original value and new value at once how ?
//			 by formula of a +b *n 
//			here 
//			a = original value 
//			b = nums[nums[i]]
//			how we extract each other if we do a+b*n 
//			then we can use nums[i]%n to get original value or a
//			and nums[i]/n to get nums[nums[i]] b
			int a = nums[i];
			int b= nums[nums[i]];
			nums[i]= a+(b%n)*n;//			-> here a+b *n is given in different way why ?
//			because we need to extract original value out of them in order to store in the array so we will use 
//			
			
		}
//		by mod we can get the original arr number 
//		for(int i =0;i<nums.length;i++) {
//			nums[i]= nums[i]%n;
//		}
//		by floor dividing we can get the nums[nums[i]] value 
		for(int i =0;i<nums.length;i++) {
			nums[i]= nums[i]/n;
		}
		return nums;
	}
	

	
	public static boolean check(int [] arr1, int [] arr2) {
		if(arr1.length!=arr2.length) {
			return false;
		}
		for(int i =0;i<arr1.length;i++) {
			if(arr1[i]!=arr2[i]) {
				return false;
			}
		}
		
		for(int i =0;i<arr1.length;i++) {
			if(arr1[i]!=arr2[i]) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {		
		//Example 1:
		int nums1 []= {0,2,1,5,3,4};
		int output1[] ={0,1,2,4,5,3};
		//Example 2:
		int nums2 []= {5,0,1,2,3,4};
		int output2[] ={4,5,0,1,2,3};
		
		int [] ans1 = buildArray(nums1);
		int [] ans2 = buildArray(nums2);
    	System.out.println("Brute Force Approch :");
		if(check(ans1,output1)) {
			System.out.println("Case 1 Passed ");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Excepted Output : "+ Arrays.toString(output1));
			System.out.println("Your Output : "+ Arrays.toString(ans1));
		}
		if(check(ans2,output2)) {
			System.out.println("Case 2 Passed ");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Excepted Output : "+ Arrays.toString(output2));
			System.out.println("Your Output : "+ Arrays.toString(ans2));
		}
		
		ans1 = buildArrayOptimize(nums1);
		ans2 = buildArrayOptimize(nums2);
		
		
		if(check(ans1,output1)) {
			System.out.println("Case 1 Passed ");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Excepted Output : "+ Arrays.toString(output1));
			System.out.println("Your Output : "+ Arrays.toString(ans1));
		}
		if(check(ans2,output2)) {
			System.out.println("Case 2 Passed ");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Excepted Output : "+ Arrays.toString(output2));
			System.out.println("Your Output : "+ Arrays.toString(ans2));
		}
		
		

		
	}

}
