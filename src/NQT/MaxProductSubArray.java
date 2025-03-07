//Maximum Product Subarray in an Array
//
//
//253
//
//16
//Problem Statement: Given an array that contains both negative and positive integers, find the maximum product subarray.
//
//Examples
//Example 1:
//Input:
//
// Nums = [1,2,3,4,5,0]
//Output:
//
// 120
//Explanation:
//
// In the given array, we can see 1×2×3×4×5 gives maximum product value.
//
//
//Example 2:
//Input:
// Nums = [1,2,-3,0,-4,-5]
//Output:
//
// 20
//Explanation:
//
// In the given array, we can see (-4)×(-5) gives maximum product value.


package NQT;

import java.util.Arrays;

public class MaxProductSubArray {
//	find every single sub array :
	public static int  maxProdSubArray(int [] arr) {
		int maxProd=Integer.MIN_VALUE;
		for(int i =0;i<arr.length;i++) {
			for(int j=i;j<arr.length;j++) {
				int prod = 1;
				for(int k=i;k<=j;k++) {
					prod=prod*arr[k];
				}
			maxProd= Math.max(maxProd, prod);
			}
		}
		return maxProd;
	}
	
	
//	Better approch remove one loop do sub array while iterating
//	find every single sub array :
	public static int  maxProdSubArrayBetter(int [] arr) {
		int maxProd=Integer.MIN_VALUE;
		for(int i =0;i<arr.length;i++) {
			int prod = 1;
			for(int j=i;j<arr.length;j++) {
				prod*=arr[j];
				maxProd= Math.max(maxProd, prod);
			}
		}
		return maxProd;
	}
	

//	use kadans algorithm remove one loop do sub array while iterating
//	find every single sub array :
	public static int  maxProdSubArrayBest(int [] arr) {
		int prefix=1;
		int suffix=1;
		int n = arr.length;
		int ans = Integer.MIN_VALUE;
		for(int i =0;i<n;i++) {
			if (prefix==0) prefix=1;
			if (suffix==0) suffix=1;
			
			prefix*=arr[i];
			suffix*=arr[n-i-1];
			ans= Math.max(ans, Math.max(suffix,prefix));
		}
		return ans;
	}
	
	
	public static void main(String[] args) {
		//Example 1:
		int [] nums1= {1,2,3,4,5,0};
		int output1=120;
		
		//Example 2:
		
		int [] nums2 = {1,2,-3,0,-4,-5};
		int output2=20;
		System.out.println("Brute Force Approch :");
		int ans1= maxProdSubArray(nums1);
		int ans2= maxProdSubArray(nums2);
		
		if(ans1== output1) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Expected Ouput :"+(output1));
			System.out.println("Your Answer :"+ (ans1));
		}
		if(ans2== output2) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Expected Ouput :"+ (output2));
			System.out.println("Your Answer :"+ (ans2));
		}
		
		System.out.println("Better Approch :");
		
		ans1= maxProdSubArrayBetter(nums1);
		ans2= maxProdSubArrayBetter(nums2);
		
		if(ans1== output1) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Expected Ouput :"+(output1));
			System.out.println("Your Answer :"+ (ans1));
		}
		if(ans2== output2) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Expected Ouput :"+ (output2));
			System.out.println("Your Answer :"+ (ans2));
		}
		System.out.println("Better Approch :");
		
		ans1= maxProdSubArrayBest(nums1);
		ans2= maxProdSubArrayBest(nums2);
		
		if(ans1== output1) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Expected Ouput :"+(output1));
			System.out.println("Your Answer :"+ (ans1));
		}
		if(ans2== output2) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Expected Ouput :"+ (output2));
			System.out.println("Your Answer :"+ (ans2));
		}
	}

}
