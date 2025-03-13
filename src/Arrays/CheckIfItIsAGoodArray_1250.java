//1250. Check If It Is a Good Array
//Solved
//Hard
//Topics
//Companies
//Hint
//Given an array nums of positive integers. Your task is to select some subset of nums, multiply each element by an integer and add all these numbers. The array is said to be good if you can obtain a sum of 1 from the array by any possible subset and multiplicand.
//
//Return True if the array is good otherwise return False.
//
// 
//
//Example 1:
//
//Input: nums = [12,5,7,23]
//Output: true
//Explanation: Pick numbers 5 and 7.
//5*3 + 7*(-2) = 1
//Example 2:
//
//Input: nums = [29,6,10]
//Output: true
//Explanation: Pick numbers 29, 6 and 10.
//29*1 + 6*(-3) + 10*(-1) = 1
//Example 3:
//
//Input: nums = [3,6]
//Output: false
// 
//
//Constraints:
//
//1 <= nums.length <= 10^5
//1 <= nums[i] <= 10^9



package Arrays;

import java.util.Arrays;

public class CheckIfItIsAGoodArray_1250 {
	
	
	public static int gcd(int a,int b) {
		while (b != 0) {  
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
	}
	public static boolean isGoodArray(int[] nums) {

		int res= nums[0];
		for(int i =1;i<nums.length;i++) {
			res= gcd(res,nums[i]);
			if(res==1) return true;
		}
		return false;
    }
	

	public static void main(String[] args) {
		
		//Example 1:
		//
		int []nums1 = {12,5,7,23};
		boolean output1=true;
		

		//Example 2:
		
		int []nums2 = {29,6,10};
		boolean output2=true;

		//Example 3:

		int []nums3 = {3,6};
		boolean output3=false;
		
		
		boolean ans1=isGoodArray(nums1);
		boolean ans2=isGoodArray(nums2);
		boolean ans3=isGoodArray(nums3);
		
		
		if(output1== ans1) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Expected Ouput :"+ (output1));
			System.out.println("Your Answer :"+ (ans1));
		}
		if(output2== ans2) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Expected Ouput :"+ (output2));
			System.out.println("Your Answer :"+ (ans2));
		}
		if(output3==ans3) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Expected Ouput :"+ (output3));
			System.out.println("Your Answer :"+ (ans3));
		}

	}

}
