//31. Next Permutation
//Medium
//Topics
//Companies
//A permutation of an array of integers is an arrangement of its members into a sequence or linear order.
//
//For example, for arr = [1,2,3], the following are all the permutations of arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
//The next permutation of an array of integers is the next lexicographically greater permutation of its integer. More formally, if all the permutations of the array are sorted in one container according to their lexicographical order, then the next permutation of that array is the permutation that follows it in the sorted container. If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).
//
//For example, the next permutation of arr = [1,2,3] is [1,3,2].
//Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
//While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.
//Given an array of integers nums, find the next permutation of nums.
//
//The replacement must be in place and use only constant extra memory.
//
// 
//
//Example 1:
//
//Input: nums = [1,2,3]
//Output: [1,3,2]
//Example 2:
//
//Input: nums = [3,2,1]
//Output: [1,2,3]
//Example 3:
//
//Input: nums = [1,1,5]
//Output: [1,5,1]
// 
//
//Constraints:
//
//1 <= nums.length <= 100
//0 <= nums[i] <= 100



package Arrays;

import java.util.Arrays;

public class NextPermutation_31 {
//	approch :
//	find the first non  decreasing element from right to left
//	if no  found reverse entire array 
//	if found then on right hand side of that ffind the first greater number then number at break point
//	swap each other 
//	and reverse the array from break point-1 till end
//	time complexity :O(n)
//	space complexity :O(1)
	 public static void nextPermutation(int[] nums) {
		 int n = nums.length;
		 int r=n-1;
		 while(r>0) {
			 if(nums[r-1]<nums[r]) {
				 break;
			 }
			 r--;
		 }
		 if(r==0) {
			 reverse(nums, 0, n-1);
			 return ;
		 }
		 int index =Search(nums, r, n-1, nums[r-1]);
		 swap(nums, r-1, index);
		 reverse(nums, r, n-1);
	 }
	 
	 public static int Search(int [] nums, int s, int e, int t) {
		 while(s<=e) {
			 int m= s+(e-s)/2;
			 if(t<nums[m]) {
				 s=m+1;
			 }else {
				 e=m-1;
			 }
		 }
		 return e;
		 
	 }
	 
	 public static void reverse(int [] nums,int l,int r) {
		 while(l<r) {
			 swap(nums,l,r);
			 l++;
			 r--;
		 }
	 }
	 public static void swap(int [] nums,int l , int r) {
		 int t= nums[l];
		 nums[l]=nums[r];
		 nums[r]=t;
	 }
	        	    

	public static void main(String[] args) {
		
		//Example 1:

		int [] nums1 = {3, 1 ,5 ,1};
		int [] output1= {1,3,2};
		
		//Example 2:

		int [] nums2 = {3,2,1};
		int [] output2= {1,2,3};
		
		//Example 3:
		
		int [] nums3 = {1,1,5};
		int [] output3 = {1,5,1};
		
		
		nextPermutation(nums1);
		nextPermutation(nums2);
		nextPermutation(nums3);
		
		if(Arrays.equals(nums1, output1)) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Expected Ouput :"+ Arrays.toString(output1));
			System.out.println("Your Answer :"+ Arrays.toString(nums1));
		}
		if(Arrays.equals(nums2, output2)) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Expected Ouput :"+ Arrays.toString(output2));
			System.out.println("Your Answer :"+ Arrays.toString(nums2));
		}
		if(Arrays.equals(nums3, output3)) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Expected Ouput :"+ Arrays.toString(output3));
			System.out.println("Your Answer :"+ Arrays.toString(nums3));	
			}
		
	}
}
