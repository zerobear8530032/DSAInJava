//1929. Concatenation of Array
//Solved
//Easy
//Topics
//Companies
//Hint
//Given an integer array nums of length n, you want to create an array ans of length 2n where ans[i] == nums[i] and ans[i + n] == nums[i] for 0 <= i < n (0-indexed).
//
//Specifically, ans is the concatenation of two nums arrays.
//
//Return the array ans.
//
// 
//
//Example 1:
//
//Input: nums = [1,2,1]
//Output: [1,2,1,1,2,1]
//Explanation: The array ans is formed as follows:
//- ans = [nums[0],nums[1],nums[2],nums[0],nums[1],nums[2]]
//- ans = [1,2,1,1,2,1]
//Example 2:
//
//Input: nums = [1,3,2,1]
//Output: [1,3,2,1,1,3,2,1]
//Explanation: The array ans is formed as follows:
//- ans = [nums[0],nums[1],nums[2],nums[3],nums[0],nums[1],nums[2],nums[3]]
//- ans = [1,3,2,1,1,3,2,1]
// 
//
//Constraints:
//
//n == nums.length
//1 <= n <= 1000
//1 <= nums[i] <= 1000
//

package Arrays;

import java.util.Arrays;

public class ConcatenationofArray_1929 {
// approch :
//	create a new array of 2 time the size of input array 
//	now fill array 0 till input array length and repeat it in second half of the array 
//	time complexity : O(n)
//	space complexity : O(1) : the output is the 2 * array exceptfor that we does not use any extra space 
	public static int[] getConcatenation(int [] arr) {
		int l = arr.length;
//		allocate answer array
		int ans[] = new int [l*2];
//		iterate over the input array 
//	because array is of 2 times size we can use 2 pointer to fill 2 half at once 
		for(int i =0;i<arr.length;i++) {
//			filling array from starting till half
			ans[i]= arr[i];
//			filling array from the half till end
			ans[i+l]=arr[i];
		}

		
		return ans;
		
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
		
		return true;
	}
	public static void main(String[] args) {
		//Example 1:
		//
		int [] nums1 = {1,2,1};
		int [] output1= {1,2,1,1,2,1};		
		//Example 2:
		
		int [] nums2 = {1,3,2,1};
		int [] output2= {1,3,2,1,1,3,2,1};		
		
		int [] ans1= getConcatenation(nums1);
		int [] ans2= getConcatenation(nums2);
		
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
