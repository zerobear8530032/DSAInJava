//704. Binary Search
//Solved
//Easy
//Topics
//Companies
//Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.
//
//You must write an algorithm with O(log n) runtime complexity.
//
// 
//
//Example 1:
//
//Input: nums = [-1,0,3,5,9,12], target = 9
//Output: 4
//Explanation: 9 exists in nums and its index is 4
//Example 2:
//
//Input: nums = [-1,0,3,5,9,12], target = 2
//Output: -1
//Explanation: 2 does not exist in nums so return -1
// 
//
//Constraints:
//
//1 <= nums.length <= 104
//-104 < nums[i], target < 104
//All the integers in nums are unique.
//nums is sorted in ascending order.

package Recursion;

public class BinarySearch_704 {
	
//	simple binary search using iterative approch 
	public static int searchIterative(int[] nums, int target) {
		int start=0;
		int end = nums.length-1;
		while(start<end) {
			int mid =start+(end-start)/2;
			if(target <nums[mid]) {
				end= mid-1;
			}else if(target>nums[mid]){
				start=mid+1;
			}else {
				return mid;
			}
		}
		return -1;
        
    }
	
//	simple binary search using iterative approch 
	public static int searchRec(int[] nums, int target) {
		int start =0;
		int end = nums.length-1;
		
		return binarySearchHelper(nums,target,start,end);	
	}
	
	
	private  static int binarySearchHelper(int[] nums, int target, int start, int end) {
//		if(start<end){}// this condition will not let the search proceed because the search will exit initally 
		if (start>end) {
			return -1;
		}
		int mid = start+(end-start)/2;
		if(target==nums[mid]) {
			return mid;
		}else if(target<nums[mid]) {
			return binarySearchHelper(nums, target, start, mid-1);
		}
		else {
			return binarySearchHelper(nums, target,mid+1, end);
		}
		
		
		
	}

	public static void main(String[] args) {
		
		
		//Example 1:
		//
		int []nums1 = {-1,0,3,5,9,12};
		int target1 = 9;
		int output1=4;
		
		//Example 2:
		
		int [] nums2 = {-1,0,3,5,9,12};
		int target2 = 2;
		int output2=  -1;
		
    	int ans1=searchIterative(nums1,target1);
    	int ans2=searchIterative(nums2,target2);
    	
    	System.out.println("Iterative Approch :");
    	
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

    	ans1=searchRec(nums1,target1);
    	ans2=searchRec(nums2,target2);
    	
    	System.out.println("Recursive Approch :");
    	
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
