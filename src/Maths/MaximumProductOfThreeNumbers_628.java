//628. Maximum Product of Three Numbers
//Solved
//Easy
//Topics
//Companies
//Given an integer array nums, find three numbers whose product is maximum and return the maximum product.
//
// 
//
//Example 1:
//
//Input: nums = [1,2,3]
//Output: 6
//Example 2:
//
//Input: nums = [1,2,3,4]
//Output: 24
//Example 3:
//
//Input: nums = [-1,-2,-3]
//Output: -6
// 
//
//Constraints:
//
//3 <= nums.length <= 104
//-1000 <= nums[i] <= 1000

package Maths;

import java.util.Arrays;

class MaximumProductOfThreeNumbers_628 {

//	better approch:
//	after sorting : we can multiply 3 number all greatest number are at last 3 index
//	and the last 2 index are negative but are greater then the positive once 
//	then we can take multiplication of these 2negative will become positive and last index is the highest nubmer
	public static int maximumProductBruteForce(int[] nums) {
		        int n=nums.length;
		        int max=Integer.MIN_VALUE;
		        for(int i =0;i<n-2;i++){
		            for(int j=i+1;j<n-1;j++){
		                for(int k=j+1;k<n;k++){
		                    int prod= nums[i]*nums[j]*nums[k];
		                    max=Math.max(max,prod);
		                }
		            }
		        }
		        return max;
		    }
    
    public static int maximumProductBest(int[] nums) {
    	Arrays.sort(nums);
    	int n = nums.length;
    	return Math.max((nums[n-1]*nums[n-2]*nums[n-3]),(nums[0]*nums[1]*nums[n-1]));
    }
    public static void main(String[] args) {
    	//Example 1:

    	int [] nums1 = {1,2,3};
    	int output1=6;

    	//Example 2:

    	int [] nums2 = {1,2,3,4};
    	int output2=24;

    	//Example 3:

    	int [] nums3 = {-1,-2,-3};
    	int output3=-6;
    	

    	System.out.println("Brute Force Approch ");
    	int ans1=maximumProductBruteForce(nums1);
    	int ans2=maximumProductBruteForce(nums2);
    	int ans3=maximumProductBruteForce(nums3);
		
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
			System.out.println("Actual Output :"+output3 );
			System.out.println("Your Output :"+ans3);
		}
		
		System.out.println("Best Approch ");
		ans1=maximumProductBest(nums1);
		ans2=maximumProductBest(nums2);
		ans3=maximumProductBest(nums3);
		
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
			System.out.println("Actual Output :"+output3 );
			System.out.println("Your Output :"+ans3);
		}
		
	}
}