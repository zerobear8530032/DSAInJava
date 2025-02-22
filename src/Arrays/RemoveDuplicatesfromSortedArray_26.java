//	26. Remove Duplicates from Sorted Array
//	Solved
//	Easy
//	Topics
//	Companies
//	Hint
//	Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. Then return the number of unique elements in nums.
//	
//	Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:
//	
//	Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially. The remaining elements of nums are not important as well as the size of nums.
//	Return k.
//	Custom Judge:
//	
//	The judge will test your solution with the following code:
//	
//	int[] nums = [...]; // Input array
//	int[] expectedNums = [...]; // The expected answer with correct length
//	
//	int k = removeDuplicates(nums); // Calls your implementation
//	
//	assert k == expectedNums.length;
//	for (int i = 0; i < k; i++) {
//	    assert nums[i] == expectedNums[i];
//	}
//	If all assertions pass, then your solution will be accepted.
//	
//	 
//	
//	Example 1:
//	
//	Input: nums = [1,1,2]
//	Output: 2, nums = [1,2,_]
//	Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
//	It does not matter what you leave beyond the returned k (hence they are underscores).
//	Example 2:
//	
//	Input: nums = [0,0,1,1,1,2,2,3,3,4]
//	Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
//	Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
//	It does not matter what you leave beyond the returned k (hence they are underscores).
//	 
//	
//	Constraints:
//	
//	1 <= nums.length <= 3 * 104
//	-100 <= nums[i] <= 100
//	nums is sorted in non-decreasing order.

package Arrays;

import java.util.Arrays;

public class RemoveDuplicatesfromSortedArray_26 {
//	approch :
//	use 2 pointer left , right start at 0,1
//	left will keep track of how many numbers are unique and right will keep track of next number
//	so we increament right until nums[l] != nums[r] if is is 
//	means we find a new number so we increment l by 1 and put nums[l]=nums[r]
//	keep repeating untill r reached the end 
//	Time complexity :O(n)
//	Space complexity :O(1)
	
	 public static int removeDuplicates(int[] nums) {
	        int l=nums.length;
	        int left=0;// left
	        int right=1;// right
	        while(right<l){ //until l reached end it will loop
	        if(nums[right]!=nums[left]){// check the number
	            left++;// l+1
	            nums[left]=nums[right];// put the new number 
	        }
	           right++; 
	        }       
	 return left+1;     // return l+1  
	    }
	
	 public static boolean check(int ans[], int l) {
		 for(int i =0;i<l-1;i++) {
			 if(ans[i]>ans[i+1] || ans[i]==ans[i+1]) {
				 return false;
			 }
		 }
		 return true;
	 }
	public static void main(String[] args) {
	//		Example 1:
			
			int[] nums1 = {1,1,2};
			int output1= 2;
			

	//		Example 2:
		
			int[] nums2 = {0,0,1,1,1,2,2,3,3,4};
			int output2=5;
			int ans1=removeDuplicates(nums1);
			int ans2=removeDuplicates(nums2);
			
			if(check(nums1,ans1)) {
				System.out.println("Case 1 Passed ");
			}else {
				System.out.println("Case 1 Failed");
			}
			if(check(nums2,ans2)) {
				System.out.println("Case 2 Passed ");
			}else {
				System.out.println("Case 2 Failed");
			}		
		}
	
}

