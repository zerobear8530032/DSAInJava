//3375. Minimum Operations to Make Array Values Equal to K
//Easy
//Topics
//Companies
//Hint
//You are given an integer array nums and an integer k.
//
//An integer h is called valid if all values in the array that are strictly greater than h are identical.
//
//For example, if nums = [10, 8, 10, 8], a valid integer is h = 9 because all nums[i] > 9 are equal to 10, but 5 is not a valid integer.
//
//You are allowed to perform the following operation on nums:
//
//Select an integer h that is valid for the current values in nums.
//For each index i where nums[i] > h, set nums[i] to h.
//Return the minimum number of operations required to make every element in nums equal to k. If it is impossible to make all elements equal to k, return -1.
//
// 
//
//Example 1:
//
//Input: nums = [5,2,5,4,5], k = 2
//
//Output: 2
//
//Explanation:
//
//The operations can be performed in order using valid integers 4 and then 2.
//
//Example 2:
//
//Input: nums = [2,1,2], k = 2
//
//Output: -1
//
//Explanation:
//
//It is impossible to make all the values equal to 2.
//
//Example 3:
//
//Input: nums = [9,7,5,3], k = 1
//
//Output: 4
//
//Explanation:
//
//The operations can be performed using valid integers in the order 7, 5, 3, and 1.
//
// 
//
//Constraints:
//
//1 <= nums.length <= 100 
//1 <= nums[i] <= 100
//1 <= k <= 100
package HashSet;

import java.util.HashSet;

public class MinimumOperationsToMakeArrayValuesEqualToK_3375 {

//	approch :
//	one observation we cannot do any thing to the elements which are smaller then k
//	means we need to return -1 if any element is smaller then k
//	next we need to make every element in array which is greater then k equal to k
//	so we can say to choose h as k so that we make it equal to h in 1 operation
//	to keep count of operation we can just count distinct greater element then k 
//	and that the number of operations we required
	   public static  int minOperations(int[] nums, int k) {
	        HashSet<Integer> numset= new HashSet();
	        for(int i =0;i<nums.length;i++){
	            if(nums[i]<k) return -1;
	            if(nums[i]>k) numset.add(nums[i]); 
	        }
	        return numset.size();
	    }
	public static void main(String[] args) {
		
		
		//Example 1:

		int [] nums1 = {5,2,5,4,5};
		int k1=2;
		int output1=2;
		
		//Example 2:
		
		int [] nums2 = {2,1,2};
		int k2=2;
		int output2=-1;
		
		//Example 3:

		int []nums3 = {9,7,5,3};
		int k3= 1;
		int output3=4;

		int ans1=minOperations(nums1,k1);
		int ans2=minOperations(nums2,k2);
		int ans3=minOperations(nums3,k3);
		
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
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Actual Output :"+output3);
			System.out.println("Your Output :"+ans3);
		}

	}

}
